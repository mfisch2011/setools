/**
 * TODO:license...
 */
package setools.gradle.meetings;

import java.util.Collection;
import java.util.Collections;
import java.util.Properties;

import org.gradle.api.Action;
import org.gradle.api.Plugin;
import org.gradle.api.Project;
import org.gradle.api.internal.plugins.DslObject;
import org.gradle.api.internal.project.ProjectInternal;
import org.gradle.api.model.ObjectFactory;
import org.gradle.api.plugins.JavaBasePlugin;
import org.gradle.api.plugins.JavaPluginConvention;
import org.gradle.api.tasks.SourceSet;
import org.gradle.api.tasks.SourceSetContainer;

import setools.gradle.dsl.meeting.Meeting;
import setools.gradle.dsl.meeting.MeetingsHandler;
import setools.gradle.meetings.internal.DefaultMeetingsSourceExtension;
import setools.util.resources.ClasspathResourceLoader;
import setools.util.resources.FileResourceLoader;
import setools.util.resources.ResourceLoader;

/**
 * TODO:documentation...
 */
public class MeetingsBasePlugin implements Plugin<ProjectInternal> {

	@Override
	public void apply(ProjectInternal project) {
		//needed for sourceSets...
		project.getPluginManager().apply(JavaBasePlugin.class);
		createMeetingsSourceSet(project);
		createTemplatesSourceSet(project);
	}
	
	protected void createTemplatesSourceSet(ProjectInternal project) {
		//TODO:actually make a configurable source set...
		Properties properties = new Properties();
		properties.setProperty("resource.loader", "templates.file,absolute.file,classpath");
		properties.setProperty("classpath.resource.loader.class", ClasspathResourceLoader.class.getName());
		properties.setProperty("templates.file.resource.loader.class",FileResourceLoader.class.getName());
		properties.setProperty("templates.file.resource.loader.path",project.file("src/templates").getAbsolutePath());
		properties.setProperty("absolute.file.resource.loader.class",FileResourceLoader.class.getName());
		properties.setProperty("absolute.file.resource.loader.path", "");
		ResourceLoader.configure(properties);
	}
	
	/**
	 * TODO:documentation...
	 * @param project
	 */
	protected void createMeetingsSourceSet(ProjectInternal project) {
		sourceSets(project).create("meetings", new Action<SourceSet>() {

			@Override
			public void execute(SourceSet sourceSet) {
				ObjectFactory objectFactory = project.getObjects();
				DefaultMeetingsSourceExtension extension = 
					new DefaultMeetingsSourceExtension("meetings"
							,objectFactory,getMeetings(project));
				new DslObject(sourceSet).getConvention().getPlugins()
					.put("meetings", extension);
			}
		});
	}
	
	/**
	 * TODO:documentation...
	 * @param project
	 * @return
	 */
	protected Collection<Meeting> getMeetings(Project project) {
		MeetingsHandler extension = (MeetingsHandler) project
				.getExtensions().findByName("meetings");
		if(extension!=null)
			return extension;
		else
			return Collections.<Meeting>emptyList();
	}

	/**
	 * TODO:documentation...
	 * @param project
	 * @return
	 */
	protected SourceSetContainer sourceSets(ProjectInternal project) {
		return project.getConvention().getPlugin(JavaPluginConvention.class)
		.getSourceSets();
	}
}
