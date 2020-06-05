/**
 * 
 */
package sandbox;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.uml2.uml.resources.util.UMLResourcesUtil;

import setools.risk.RiskMitigation;
import setools.risk.util.RiskResourcesUtil;
import setools.uml.util.ResourceSetInitializerService;

/**
 * @author matt
 *
 */
public class UpdateModel {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		//open model
		ResourceSet resourceSet = new ResourceSetImpl();
		//TODO:not working...   ResourceSetInitializerService.initialize(resourceSet);
		UMLResourcesUtil.init(resourceSet);
		RiskResourcesUtil.init(resourceSet);
		
		String pathname = "/home/matt/eclipse-workspace/setools/plugins/latex-risk-review-plugin/src/test/resources/setools/gradle/plugins/test-basic-risk-review/src/project/risk/test-risk.uml";
		URI uri = URI.createFileURI(pathname);
		Resource resource = resourceSet.getResource(uri,true);
		
		//update model (start simple first...)
		//set date for Mitigation A
		RiskMitigation mitigation = (RiskMitigation)resource.getEObject("_VYj4YKXNEeqpydbDhdizKA");
		mitigation.setPlanned(toDate("2020-10-01"));
		
		//set date for Mitigation B
		mitigation = (RiskMitigation)resource.getEObject("_bfjr0KXNEeqpydbDhdizKA");
		mitigation.setPlanned(toDate("2020-12-12"));
		
		//set date for Mitigation C
		mitigation = (RiskMitigation)resource.getEObject("_gdb7EKXNEeqpydbDhdizKA");
		mitigation.setPlanned(toDate("2020-11-11"));
		
		//write updates
		Map<?,?> nullMap = new HashMap<Object,Object>();
		OutputStream stream = new FileOutputStream(pathname);
		resource.save(stream,nullMap);
		stream.close();
	}
	
	public static Date toDate(String date) {
		//TODO:implement other date formats...
		//default, ISO_LOCAL_DATE
        LocalDate localDate = LocalDate.parse(date);
		return java.sql.Date.valueOf(localDate);
	}

}
