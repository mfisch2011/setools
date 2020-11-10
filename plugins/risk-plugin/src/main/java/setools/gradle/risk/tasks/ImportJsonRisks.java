/**
 * TODO:license...
 */
package setools.gradle.risk.tasks;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.XMIResource;
import org.eclipse.uml2.uml.UMLFactory;
import org.gradle.api.tasks.OutputFile;
import org.gradle.api.tasks.SourceTask;
import org.gradle.api.tasks.TaskAction;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import setools.risk.Consequence;
import setools.risk.Likelihood;
import setools.risk.Risk;
import setools.risk.RiskFactory;
import setools.risk.util.RiskResourcesUtil;

import org.eclipse.uml2.uml.Class;

/**
 * TODO:documentation...
 */
public class ImportJsonRisks extends SourceTask {
	
	public ImportJsonRisks() {
		setSource("src/project/risks"); //TODO:use a risk source set instead...
		
	}


	@TaskAction
	public void importRisks() throws IOException {
		ResourceSet resourceSet = new ResourceSetImpl();
		RiskResourcesUtil.init(resourceSet);
		URI uri = URI.createFileURI(getOutput().getAbsolutePath());
		XMIResource resource = (XMIResource)resourceSet.createResource(uri);
		for(File file : getSource()) {
			addRisks(resource,file);
		}
		OutputStream stream = new FileOutputStream(getOutput());
		Map<?,?> nullMap = new HashMap<Object,Object>();
		resource.save(stream, nullMap);
		stream.close();
	}
	
	protected void addRisks(XMIResource resource,File input) {
		String filename = input.getName();
		int index = filename.lastIndexOf('.');
		String ext = (index>0) ? filename.substring(index) : "";
		ext = ext.toLowerCase();
		if(ext.equals(".json")) {
			try {
				byte[] bytes = Files.readAllBytes(input.toPath());
				String text = new String(bytes);
				JSONParser parser = new JSONParser();
				Object object = parser.parse(text);
				if(object instanceof JSONObject) {
					JSONObject json = (JSONObject)object;
					addRisk(resource,json);					
				} else if(object instanceof JSONArray) {
					JSONArray json = (JSONArray)object;
					int len = json.size();
					for(int x=0;x<len;x++) {
						Object tmp = json.get(x);
						if(tmp instanceof JSONObject) {
							addRisk(resource,(JSONObject)tmp);
						}
					}
				}
			} catch (IOException | ParseException e) {
				getLogger().trace("Error reading json",e);
			}
		}
	}
	
	protected void addRisk(XMIResource resource,JSONObject json) {
		Class baseClass = UMLFactory.eINSTANCE.createClass();
		Risk risk = RiskFactory.eINSTANCE.createRisk();
		risk.setBaseClass(baseClass);
		setId(resource,risk,json);
		setName(risk,json);
		setConsequence(risk,json);
		setLikelihood(risk,json);
	}
	
	protected void setConsequence(Risk risk,JSONObject json) {
		Object object = json.get("consequence");
		if(object==null)
			object = json.get("Consequence");
		if(object instanceof String) {
			String tmp = (String)object;
			switch(tmp.toLowerCase()) {
			case "minimal":
			case "minimal impact":
				risk.setConsequence(Consequence.MINIMAL_IMPACT);
				break;
			case "minor":
			case "minor impact":
				risk.setConsequence(Consequence.MINOR_IMPACT);
				break;
			case "moderate":
			case "moderate impact":
				risk.setConsequence(Consequence.MODERATE_IMPACT);
				break;
			case "significant":
			case "significant impact":
				risk.setConsequence(Consequence.SIGNIFICANT_IMPACT);
				break;
			case "critical":
			case "critical impact":
				risk.setConsequence(Consequence.CRITICAL_IMPACT);
				break;
			default:
				break;
			}
		} else if(object instanceof Number) {
			Number number = (Number)object;
			switch(number.shortValue()) {
			case 1:
				risk.setConsequence(Consequence.MINIMAL_IMPACT);
				break;
			case 2:
				risk.setConsequence(Consequence.MINOR_IMPACT);
				break;
			case 3:
				risk.setConsequence(Consequence.MODERATE_IMPACT);
				break;
			case 4:
				risk.setConsequence(Consequence.SIGNIFICANT_IMPACT);
				break;
			case 5:
				risk.setConsequence(Consequence.CRITICAL_IMPACT);
				break;
			default:
				break;
			}
		}
	}
	
	protected void setLikelihood(Risk risk,JSONObject json) {
		Object object = json.get("likelihood");
		if(object==null)
			object = json.get("Likelihood");
		if(object instanceof String) {
			String tmp = (String)object;
			switch(tmp.toLowerCase()) {
			case "not likely":
				risk.setLikelihood(Likelihood.NOT_LIKELY);
				break;
			case "low":
			case "low likelihood":
				risk.setLikelihood(Likelihood.LOW_LIKELIHOOD);
				break;
			case "likely":
				risk.setLikelihood(Likelihood.LIKELY);
				break;
			case "high":
			case "high likelihood":
			case "highly likely":
				risk.setLikelihood(Likelihood.HIGHLY_LIKELY);
				break;
			case "certain":
			case "nearly certain":
			case "near certainty":
				risk.setLikelihood(Likelihood.NEAR_CERTAIN);
				break;
			default:
				break;
			}
		} else if(object instanceof Number) {
			Number number = (Number)object;
			switch(number.shortValue()) {
			case 1:
				risk.setLikelihood(Likelihood.NOT_LIKELY);
				break;
			case 2:
				risk.setLikelihood(Likelihood.LOW_LIKELIHOOD);
				break;
			case 3:
				risk.setLikelihood(Likelihood.LIKELY);
				break;
			case 4:
				risk.setLikelihood(Likelihood.HIGHLY_LIKELY);
				break;
			case 5:
				risk.setLikelihood(Likelihood.NEAR_CERTAIN);
				break;
			default:
				break;
			}
		}
	}
	
	protected void setId(XMIResource resource,Risk risk,JSONObject json) {
		Object object = json.get("id");
		if(object==null) object = json.get("Id");
		if(object==null) object = json.get("ID");
		if(object instanceof String) {
			resource.setID(risk, encode((String)object));
		} else if(object instanceof Number) {
			resource.setID(risk, ((Number)object).toString());
		}
	}
	
	protected String encode(String text) {
		String result = text;
		result = result.replace(" ", "_");
		return result;
	}
	
	protected void setName(Risk risk,JSONObject json) {
		risk.setName((String)json.get("name"));
	}
	
	protected File output = null;
	
	@OutputFile
	public File getOutput() {
		return output;
	}
	
	public void setOutput(Object object) {
		output = getProject().file(object);
	}
}
