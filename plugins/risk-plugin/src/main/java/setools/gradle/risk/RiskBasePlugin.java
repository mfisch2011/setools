/**
 * TODO:license...
 */
package setools.gradle.risk;

import org.gradle.api.Action;
import org.gradle.api.Plugin;
import org.gradle.api.Project;
import org.gradle.api.file.SourceDirectorySet;
import org.gradle.api.internal.plugins.DslObject;
import org.gradle.api.internal.tasks.DefaultSourceSet;
import org.gradle.api.model.ObjectFactory;
import org.gradle.api.plugins.JavaBasePlugin;
import org.gradle.api.plugins.JavaPluginConvention;
import org.gradle.api.tasks.SourceSet;

import setools.gradle.risk.tasks.internal.DefaultRiskSourceSet;

/**
 * TODO:documentation...
 */
public class RiskBasePlugin implements Plugin<Project> {

	@Override
	public void apply(Project project) {
		applyPlugins(project);
		configureSourceSets(project);
	}
	
	/**
	 * Create and configure risk sources...
	 * @param project
	 */
	protected void configureSourceSets(Project project) {
		//TODO:is there a way to abstract and re-use this???
		project.getConvention().getPlugin(JavaPluginConvention.class).getSourceSets().all(new Action<SourceSet>() {

			@Override
			public void execute(SourceSet sourceSet) {
				ObjectFactory objectFactory = project.getObjects();
				String displayName = ((DefaultSourceSet)sourceSet).getDisplayName();
				DefaultRiskSourceSet riskSourceSet = new DefaultRiskSourceSet("risk",displayName, objectFactory);
				new DslObject(sourceSet).getConvention().getPlugins().put("risk", riskSourceSet);
				final SourceDirectorySet riskSource = riskSourceSet.getRisks();
				riskSource.srcDir("src/" + sourceSet.getName() + "/risk"); //TODO:should 'src/' be hardcoded or pulled from sourceSet somehow???
				
				//TODO:source filtering???
				//TODO:tie to sourceSet sources???
				//TODO:tie to risk source tasks???
			}
			
		});
	}

	/**
	 * Apply the plugins required to make this plugin work properly.
	 * @param project
	 */
	protected void applyPlugins(Project project) {
		project.getPluginManager().apply(JavaBasePlugin.class); //required for sourceSets (THANKS !$#? GRADLE DEV TEAM!!!!) 
	}
}
