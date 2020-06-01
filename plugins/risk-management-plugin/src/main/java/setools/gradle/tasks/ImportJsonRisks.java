/**
   Copyright 2019 Matt Fischer <mfish2011@gmail.com>

   Licensed under the Apache License, Version 2.0 (the "License");
   you may not use this file except in compliance with the License.
   You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

   Unless required by applicable law or agreed to in writing, software
   distributed under the License is distributed on an "AS IS" BASIS,
   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
   See the License for the specific language governing permissions and
   limitations under the License.
*/
package setools.gradle.tasks;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import javax.inject.Inject;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.Comment;
import org.eclipse.uml2.uml.Model;
import org.eclipse.uml2.uml.UMLFactory;
import org.gradle.api.internal.file.FileResolver;
import org.gradle.api.tasks.OutputFile;
import org.gradle.api.tasks.SourceTask;
import org.gradle.api.tasks.TaskAction;
import org.json.JSONArray;
import org.json.JSONObject;
import setools.risk.Consequence;
import setools.risk.Likelihood;
import setools.risk.Risk;
import setools.risk.RiskFactory;
import setools.risk.RiskMitigation;
import setools.risk.StatusUpdate;
import setools.uml.util.ResourceSetInitializerService;

/**
 * TODO:
 */
public class ImportJsonRisks extends SourceTask {

	public ImportJsonRisks() {
		super();
		this.setSource("src/project/risk"); //TODO:more gradle way using sourceSets...
		this.include("**/*.json");
	}
	
	@TaskAction
	public void importRisks() throws Exception {
		ResourceSet resourceSet = new ResourceSetImpl();
		ResourceSetInitializerService.initialize(resourceSet);
		File destination = getDestination();
		URI uri = URI.createFileURI(destination.getAbsolutePath());
		Resource resource = resourceSet.createResource(uri);
		Model model = UMLFactory.eINSTANCE.createModel();
		resource.getContents().add(model);
		for(File file : getSource()) {
			importRisks(resource,model,file);
		}
		OutputStream stream = new FileOutputStream(getDestination());
		Map<?, ?> nullMap = new HashMap<Object,Object>();
		resource.save(stream, nullMap);
		stream.close();
	}
	
	protected void importRisks(Resource resource, Model model, File file) throws Exception {
		byte[] bytes = Files.readAllBytes(file.toPath());
		String text = new String(bytes);
		text = text.strip();
		if(text.startsWith("[")) {
			JSONArray jsonArray = new JSONArray(text);
			Iterator<Object> iter = jsonArray.iterator();
			while(iter.hasNext()) {
				Object object = iter.next();
				if(object instanceof JSONObject) {
					JSONObject jsonRisk = (JSONObject)object;
					importRisk(resource,model,jsonRisk);
				}
			}
		} else if(text.startsWith("{")) {
			JSONObject jsonRisk = new JSONObject(text);
			importRisk(resource,model,jsonRisk);
		} else {
			throw new Exception("Missing JSON object.");
		}
	}

	protected void importRisk(Resource resource, Model model, JSONObject jsonRisk) throws ParseException {
		Risk umlRisk = RiskFactory.eINSTANCE.createRisk();
		resource.getContents().add(umlRisk);
		addRiskBaseClass(model,umlRisk,jsonRisk);
		setRiskId(umlRisk,jsonRisk);
		setRiskLikelihood(umlRisk,jsonRisk);
		setRiskConsequences(umlRisk,jsonRisk);
		setRiskStatement(umlRisk,jsonRisk);
		
		//add mitigations
		if(jsonRisk.has("mitigations")) {
			JSONArray jsonMitigations = jsonRisk.getJSONArray("mitigations");
			if(jsonMitigations!=null) {
				Iterator<Object> iter = jsonMitigations.iterator();
				while(iter.hasNext()) {
					Object object = iter.next();
					if(object instanceof JSONObject) {
						JSONObject jsonMitigation = (JSONObject)object;
						importMitigation(resource,model,umlRisk,jsonMitigation);
					}
				}
			}
		}
		
		//add status updates
		if(jsonRisk.has("status")) {
			JSONArray jsonStatus = jsonRisk.getJSONArray("status");
			if(jsonStatus!=null) {
				Iterator<Object> iter = jsonStatus.iterator();
				while(iter.hasNext()) {
					Object object = iter.next();
					if(object instanceof JSONObject) {
						JSONObject jsonUpdate = (JSONObject)object;
						importStatusUpdate(resource,model,umlRisk,jsonUpdate);
					}
				}
			}
		}
	}
	
	protected void setRiskStatement(Risk umlRisk, JSONObject jsonRisk) {
		String statement = jsonRisk.getString("statement");
		if(statement!=null)
			umlRisk.setStatement(statement);
	}

	protected void importStatusUpdate(Resource resource, Model model, Risk umlRisk, JSONObject jsonUpdate) throws ParseException {
		StatusUpdate umlUpdate = RiskFactory.eINSTANCE.createStatusUpdate();
		resource.getContents().add(umlUpdate);
		Comment umlComment = addRiskMitigationBaseComment(model,umlUpdate,jsonUpdate);
		setUpdateText(umlComment,jsonUpdate);
		setDate(umlUpdate,jsonUpdate);
		setSource(umlUpdate,jsonUpdate);
		umlComment.getAnnotatedElements().add(umlRisk.getBase_Class());
	}

	protected void setSource(StatusUpdate umlUpdate, JSONObject jsonUpdate) {
		String source = jsonUpdate.getString("source");
		if(source!=null)
			umlUpdate.setSource(source);
	}

	protected void setDate(StatusUpdate umlUpdate, JSONObject jsonUpdate) throws ParseException {
		Object object = jsonUpdate.get("date");
		if(object instanceof Date) {
			umlUpdate.setDate((Date)object);
		} else if(object instanceof String) {
			//TODO:there has to be a more robust way to do this...
			SimpleDateFormat formatter = new SimpleDateFormat("M/d/yyyy");
			Date date = formatter.parse((String)object);
			umlUpdate.setDate(date);
		}
		//TODO:what other types to support...
	}

	protected void setUpdateText(Comment umlComment, JSONObject jsonUpdate) {
		String text = jsonUpdate.getString("update");
		if(text!=null)
			umlComment.setBody(text);
	}

	protected Comment addRiskMitigationBaseComment(Model model, StatusUpdate umlUpdate, JSONObject jsonUpdate) {
		return model.createOwnedComment();
	}

	protected void importMitigation(Resource resource, Model model, Risk umlRisk, JSONObject jsonMitigation) {
		RiskMitigation umlMitigation = RiskFactory.eINSTANCE.createRiskMitigation();
		resource.getContents().add(umlMitigation);
		Class umlClass = addRiskMitigationBaseClass(model,umlMitigation,jsonMitigation);
		setMitigationId(umlMitigation,jsonMitigation);
		setMitigationLikelihood(umlMitigation,jsonMitigation);
		setMitigationConsequences(umlMitigation,jsonMitigation);
		
		umlClass.createDependency(umlRisk.getBase_Class());
		//TODO: allow status updates to mitigations?
	}

	protected Class addRiskMitigationBaseClass(Model model, RiskMitigation umlMitigation, JSONObject jsonMitigation) {
		String name = jsonMitigation.getString("name");
		Class umlClass = model.createOwnedClass(name, false);
		umlMitigation.setBase_Class(umlClass);
		return umlClass;
	}
	
	protected void setMitigationConsequences(RiskMitigation umlMitigation, JSONObject jsonMitigation) {
		Object object = jsonMitigation.get("consequence");
		if(object !=null) {
			if(object instanceof String) {
				Consequence consequence = Consequence.valueOf((String)object);
				umlMitigation.setConsequence(consequence);
			} else if(object instanceof Integer) {
				Consequence consequence = Consequence.get((Integer)object);
				umlMitigation.setConsequence(consequence);
			}
		}
	}

	protected void setMitigationLikelihood(RiskMitigation umlMitigation, JSONObject jsonMitigation) {
		Object object = jsonMitigation.get("likelihood");
		if(object !=null) {
			if(object instanceof String) {
				Likelihood likelihood = Likelihood.valueOf((String)object);
				umlMitigation.setLikelihood(likelihood);
			} else if(object instanceof Integer) {
				Likelihood likelihood = Likelihood.get(((Integer)object)-1);
				umlMitigation.setLikelihood(likelihood);
			}
		}
	}

	protected void setMitigationId(RiskMitigation umlMitigation, JSONObject jsonMitigation) {
		String id = jsonMitigation.getString("id");
		umlMitigation.setId(id);
	}

	protected void setRiskConsequences(Risk umlRisk, JSONObject jsonRisk) {
		Object object = jsonRisk.get("consequence");
		if(object !=null) {
			if(object instanceof String) {
				Consequence consequence = Consequence.valueOf((String)object);
				umlRisk.setConsequence(consequence);
			} else if(object instanceof Integer) {
				Consequence consequence = Consequence.get((Integer)object);
				umlRisk.setConsequence(consequence);
			}
		}
	}

	protected void setRiskLikelihood(Risk umlRisk, JSONObject jsonRisk) {
		Object object = jsonRisk.get("likelihood");
		if(object !=null) {
			if(object instanceof String) {
				Likelihood likelihood = Likelihood.valueOf((String)object);
				umlRisk.setLikelihood(likelihood);
			} else if(object instanceof Integer) {
				Likelihood likelihood = Likelihood.get(((Integer)object)-1);
				umlRisk.setLikelihood(likelihood);
			}
		}
	}

	protected void setRiskId(Risk umlRisk, JSONObject jsonRisk) {
		String id = jsonRisk.getString("id");
		umlRisk.setId(id);
	}

	protected void addRiskBaseClass(Model model,Risk umlRisk, JSONObject jsonRisk) {
		String name = jsonRisk.getString("name");
		Class umlClass = model.createOwnedClass(name, false);
		umlRisk.setBase_Class(umlClass);
	}

	private File destination;

	@Inject
	protected FileResolver getFileResolver() {
		throw new UnsupportedOperationException();
	}

	@OutputFile
	public File getDestination() {
		if(destination!=null) {
			return destination;
		} else {
			File dir = getProject().getBuildDir();
			return getFileResolver().newResolver(dir).
					resolve("uml/json.risks.uml");
		}
	}

	public void setDestination(Object object) {
		destination = getProject().file(object);
	}
}
