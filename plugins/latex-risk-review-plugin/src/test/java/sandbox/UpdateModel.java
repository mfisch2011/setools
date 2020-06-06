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
package sandbox;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.uml2.uml.resources.util.UMLResourcesUtil;

import setools.risk.StatusUpdate;
import setools.risk.util.RiskResourcesUtil;
import static setools.util.BaseUtils.toDate;
import static setools.uml.util.UMLUtils.getObject;
import static setools.uml.util.UMLUtils.NULL_MAP;

/**
 * TODO:
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
		
		String pathname = "/home/matt/eclipse-workspace/setools/api/modeling/risk-api/src/test/resources/test-riskml.uml";
		URI uri = URI.createFileURI(pathname);
		Resource resource = resourceSet.getResource(uri,true);
		
		//update model (start simple first...)
		getObject(resource,"_O76N0KdpEeq85JCXTYHCoQ",StatusUpdate.class).setDate(toDate("2019-01-01"));
		getObject(resource,"_RsZYcKdpEeq85JCXTYHCoQ",StatusUpdate.class).setDate(toDate("2019-02-01"));
		getObject(resource,"_WEezAKdpEeq85JCXTYHCoQ",StatusUpdate.class).setDate(toDate("2019-03-01"));
		getObject(resource,"_W0_C4KdpEeq85JCXTYHCoQ",StatusUpdate.class).setDate(toDate("2019-04-01"));
		
		//write updates
		OutputStream stream = new FileOutputStream(pathname);
		resource.save(stream,NULL_MAP);
		stream.close();
	}
}
