/**
 * 
 */
package setools.gradle.velocity.tasks.internal;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import javax.inject.Inject;

import org.gradle.api.internal.project.ProjectInternal;
import org.gradle.api.model.ObjectFactory;

import setools.gradle.velocity.VelocityMergePluginExtension;
import setools.gradle.velocity.tasks.VelocityMergeTaskExtension;

/**
 * @author matt
 *
 */
public class DefaultVelocityMergeTaskExtension implements VelocityMergeTaskExtension {

	/** TODO:
	 */
	protected final ProjectInternal project;
	
	/** TODO:
	 */
	protected final ObjectFactory objectFactory;
	
	/** TODO:
	 */
	protected final VelocityMergePluginExtension pluginExtension;

	/** TODO:
	 * @param project
	 * @param objectFactory
	 * @param pluginExtension
	 */
	@Inject
	public DefaultVelocityMergeTaskExtension(ProjectInternal project,ObjectFactory objectFactory,VelocityMergePluginExtension pluginExtension) {
		this.project = project;
		this.objectFactory = objectFactory;
		this.pluginExtension = pluginExtension;
	}
	
	protected String template = null;

	@Override
	public String getTemplate() {
		return template;
	}

	@Override
	public void setTemplate(Object object) {
		template = setFile(object);
	}

	protected String setFile(Object object) {
		return project.file(object).getPath(); //TODO:how to enable classpaths???
	}

	@Override
	public void template(Object object) {
		template = setFile(object);
	}
	
	/** TODO:
	 */
	protected String output = null;

	@Override
	public String getOutput() {
		return output;
	}

	@Override
	public void setOutut(Object object) {
		output = setFile(object);
	}

	@Override
	public void outut(Object object) {
		output = setFile(object);
	}

	/** TODO:
	 */
	protected List<String> inputFiles = new ArrayList<String>();
	
	@Override
	public List<String> getInputFiles() {
		return inputFiles;
	}

	@Override
	public void setInputFiles(Object... objects) {
		inputFiles.clear();
		for(Object object : objects)
			inputFiles.add(setFile(object));
	}

	@Override
	public void inputFiles(Object... objects) {
		inputFiles.clear();
		for(Object object : objects)
			inputFiles.add(setFile(object));
	}
	
	/** TODO:
	 */
	protected List<String> inputValues = new ArrayList<String>();

	@Override
	public List<String> getInputValues() {
		return inputValues;
	}

	@Override
	public void setInputValues(String... values) {
		inputValues.clear();
		for(String value : values)
			inputValues.add(value);
	}

	@Override
	public void inputValues(String... values) {
		inputValues.clear();
		for(String value : values)
			inputValues.add(value);
	}

	@Override
	public Properties getEngineProperties() {
		// TODO Auto-generated method stub
		return null;
	}
}
