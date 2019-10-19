/**
 * 
 */
package setools.gradle.mbse;

import javax.inject.Inject;

import org.gradle.api.Plugin;
import org.gradle.api.Task;
import org.gradle.api.internal.project.ProjectInternal;
import org.gradle.api.model.ObjectFactory;

/**
 * @author matt
 *
 */
public class MBSEPlugin implements Plugin<ProjectInternal> {

	/** TODO:
	 */
	public static final String DOCUMENT_TASK_NAME = "document";

	/** TODO:
	 */
	public static final String REPORT_TASK_NAME = "report";

	/** TODO:
	 */
	public static final String SIMULATE_TASK_NAME = "simulate";

	/** TODO:
	 */
	public static final String MODEL_TASK_NAME = "model";

	/** TODO: 
	 */
	protected final ObjectFactory objectFactory;
	
	protected MBSEPluginExtension pluginExtension = null;
	
	/** TODO:
	 */
	protected Task taskModel = null;
	
	/** TODO:
	 */
	protected Task taskSimulate = null;
	
	/** TODO:
	 */
	protected Task taskReport = null;
	
	/** TODO:
	 */
	protected Task taskDocument = null;
	
	@Inject
	public MBSEPlugin(ObjectFactory objectFactory) {
		this.objectFactory = objectFactory;
	}
	
	@Override
	public void apply(ProjectInternal project) {
		configureExtnesion(project);
		configureModel(project);
		configureSimulation(project);
		configureReport(project);
		configureDocument(project);
	}

	protected void configureExtnesion(ProjectInternal project) {
		pluginExtension = project.getExtensions().create("mbse", DefaultMBSEPluginExtension.class, project,objectFactory);
	}

	protected void configureDocument(ProjectInternal project) {
		taskDocument = project.getTasks().create(DOCUMENT_TASK_NAME);
		//TODO:create other document tasks...
	}

	protected void configureReport(ProjectInternal project) {
		taskReport = project.getTasks().create(REPORT_TASK_NAME);
		//TODO:create other report tasks
	}

	protected void configureSimulation(ProjectInternal project) {
		taskSimulate = project.getTasks().create(SIMULATE_TASK_NAME);
		//TODO:create other simulate tasks
	}

	protected void configureModel(ProjectInternal project) {
		taskModel = project.getTasks().findByName(MODEL_TASK_NAME);
		//TODO:how to handle a null model event
	}

}
