/**
 * TODO: add NSWC Crane's license...
 */
package setools.gradle.meetings.plugins;

import static org.junit.Assert.*;

import org.gradle.api.Project;
import org.gradle.api.tasks.SourceSet;
import org.gradle.api.tasks.SourceSetContainer;
import org.gradle.testfixtures.ProjectBuilder;
import org.junit.Test;

/**
 * TODO:add documentation...
 *
 */
public class MeetingSourceSetPluginTest {

	/**
	 * Test method for {@link setools.gradle.util.AbstractSourceSetPlugin#apply(org.gradle.api.Project)}.
	 */
	@Test
	public void testDefaults() {
		Project project = ProjectBuilder.builder()
				//TODO:configure builder
				.build();
		MeetingsSourceSetPlugin tst = new MeetingsSourceSetPlugin();
		assertNotNull(tst);
		tst.apply(project);
		SourceSetContainer sourceSets = project.getExtensions()
				.getByType(SourceSetContainer.class);
		assertNotNull(sourceSets);
		SourceSet sourceSet = sourceSets.getByName("meetings"); //TODO: do we want to use constant value instead of hard coding???
		assertNotNull(sourceSet);
		//TODO:validate other configuration...
	}

}
