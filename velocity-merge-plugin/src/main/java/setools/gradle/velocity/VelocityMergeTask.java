/**
 * 
 */
package setools.gradle.velocity;

import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.Map.Entry;
import java.util.Properties;

import javax.inject.Inject;

import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;
import org.gradle.api.DefaultTask;
import org.gradle.api.Task;
import org.gradle.api.internal.project.ProjectInternal;
import org.gradle.api.model.ObjectFactory;
import org.gradle.api.tasks.TaskAction;

/**
 * @author matt
 *
 */
public class VelocityMergeTask extends DefaultTask {

	/** TODO:
	 */
	public static final String TASK_NAME = "velocityMerge";

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
	 */
	protected final VelocityMergeTaskExtension taskExtension;
	
	/** TODO:
	 * @param project
	 * @param objectFactory
	 * @param pluginExtension
	 * @param taskExtension
	 */
	@Inject
	public VelocityMergeTask(ProjectInternal project,ObjectFactory objectFactory,VelocityMergePluginExtension pluginExtension,VelocityMergeTaskExtension taskExtension) {
		this.project = project;
		this.objectFactory = objectFactory;
		this.pluginExtension = pluginExtension;
		this.taskExtension = taskExtension;
	}
	
	/** TODO:
	 * @param project
	 * @param parent
	 * @param objectFactory
	 * @param pluginExtension
	 * @return
	 */
	public static VelocityMergeTask configureTask(ProjectInternal project,Task parent,ObjectFactory objectFactory,VelocityMergePluginExtension pluginExtension) {
		VelocityMergeTaskExtension taskExtension = project.getExtensions().create(TASK_NAME, DefaultVelocityMergeTaskExtension.class,project,objectFactory,pluginExtension);
		VelocityMergeTask task = project.getTasks().create(TASK_NAME,VelocityMergeTask.class,project,objectFactory,pluginExtension,taskExtension);
		if(parent!=null) {
			parent.getDependsOn().add(task);
		}
		return task;
	}
	
	/** TODO:
	 */
	@TaskAction
	public void run() {
		VelocityEngine engine = getEngine()
		VelocityContext context = getContext();
		VelocityMergeThread thread = new VelocityMergeThread(taskExtension.getTemplate(),taskExtension.getOutput(),context,engine);
	}

	/** TODO:
	 * @return
	 */
	protected VelocityContext getContext() {
		VelocityContext context = new VelocityContext();
		for(String input : taskExtension.getInputFiles())
			VelocityContextLoaderService.load(context,input);
		for(String input : taskExtension.getInputValues())
			VelocityContextLoaderService.load(context,input);
		return context;
	}

	/** TODO:
	 * @return
	 */
	protected VelocityEngine getEngine() {
		Properties properties = mergeProperties(pluginExtension.getEngineProperties(),taskExtension.getEngineProperties());
		return new VelocityEngine(properties);
	}

	protected Properties mergeProperties(Properties pluginProperties, Properties taskProperties) {
		Properties results = (Properties) pluginProperties.clone();
		for(Entry<Object, Object> entry : taskProperties.entrySet())
			results.put(entry.getKey(), entry.getValue());
		return results;
	}
}
