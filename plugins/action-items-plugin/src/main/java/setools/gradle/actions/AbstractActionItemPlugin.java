/**
 * TODO:license...
 */
package setools.gradle.actions;

import org.gradle.api.Plugin;
import org.gradle.api.Project;
import org.gradle.api.plugins.JavaBasePlugin;

/**
 * TODO:documentation...
 */
public abstract class AbstractActionItemPlugin implements Plugin<Project> {

	/**
	 * TODO:documentation...
	 */
	public static final String PLUGIN_EXT = "actionItems";
	
	/**
	 * TODO:documentation...
	 */
	protected final Class<? extends ActionItemDatabase> classDatabase;
	
	/**
	 * TODO:documentation...
	 * @param classDatabase
	 */
	public AbstractActionItemPlugin(Class<? extends ActionItemDatabase> classDatabase) {
		this.classDatabase = classDatabase;
	}

	@Override
	public void apply(Project project) {
		applyPlugins(project);
		createExtension(project);
		createTasks(project);
		registerCallbacks(project);
	}
	
	/**
	 * TODO:documentation...
	 * @param project
	 */
	protected void registerCallbacks(Project project) {
		//TODO:callback to create action-item source sets...
	}
	
	/**
	 * TODO:documentation...
	 * @param project
	 */
	protected void createTasks(Project project) {
		//TODO:
	}
	
	/**
	 * TODO:documentation...
	 * @param project
	 */
	protected void createExtension(Project project) {
		project.getExtensions().create(PLUGIN_EXT,classDatabase, project);
	}
	
	
	/**
	 * TODO:documentation...
	 * @param project
	 */
	protected void applyPlugins(Project project) {
		//needed for sourceSets (thanks gradle dev team!)
		project.getPluginManager().apply(JavaBasePlugin.class);
	}
}
