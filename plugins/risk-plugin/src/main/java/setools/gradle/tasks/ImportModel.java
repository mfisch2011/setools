/**
 * TODO:license...
 */
package setools.gradle.tasks;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.uml2.uml.resources.util.UMLResourcesUtil;
import org.gradle.api.tasks.OutputDirectory;
import org.gradle.api.tasks.SourceTask;
import org.gradle.api.tasks.TaskAction;

/**
 * TODO:documentation...
 */
public abstract class ImportModel extends SourceTask {

	/**
	 * TODO:documentation...
	 * @throws IOException
	 */
	@TaskAction
	public void importModels() throws IOException {
		//create UML models
		ResourceSet resourceSet = initialize();
		for(File source : getSource()) {
			URI uri = getOutputUri(source);
			Resource resource = resourceSet.createResource(uri);
			importModel(resource,source);
		}
		saveResources(resourceSet);
	}
	
	/**
	 * TODO:documentation...
	 * @param resourceSet
	 * @throws IOException
	 */
	protected void saveResources(ResourceSet resourceSet) throws IOException {
		for(Resource resource : resourceSet.getResources()) {
			URI uri = resource.getURI();
			String path = uri.path();
			Map<?, ?> emptyMap = new HashMap<Object,Object>();
			if(path!=null && !path.isEmpty()) {
				OutputStream stream = new FileOutputStream(path);
				resource.save(stream, emptyMap);
				stream.close();
			}
		}
	}
	
	/**
	 * TODO:documentation...
	 * @param source
	 * @return
	 */
	protected URI getOutputUri(File source) {
		File dir = getOutputDir();
		int index = source.getName().lastIndexOf('.');
		String name = (index>0) ? source.getName().substring(0,index) 
				: source.getName();
		File file = new File(dir,name + ".uml");
		return URI.createFileURI(file.getAbsolutePath());
	}
	
	/**
	 * TODO:documentation...
	 * @param resource
	 * @param source
	 */
	protected abstract void importModel(Resource resource,File source);
	
	/**
	 * TODO:documentation...
	 */
	protected File output = null;
	
	/**
	 * TODO:documentation...
	 * @return
	 */
	@OutputDirectory
	public File getOutputDir() {
		//TODO:change this to use uml sourceSet output?
		if(output!=null)
			return output;
		else {
			File build = getProject().getBuildDir();
			return new File(build,"uml/main");
		}
	}
	
	/**
	 * TODO:documentation...
	 * @return
	 */
	protected ResourceSet initialize() {
		ResourceSet resourceSet = new ResourceSetImpl();
		UMLResourcesUtil.init(resourceSet);
		return resourceSet;
	}
}
