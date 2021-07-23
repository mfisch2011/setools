/**
 * TODO: add NSWC Crane's license...
 */
package setools.gradle.meetings.plugins;

import static org.junit.Assert.*;

import org.gradle.api.Project;
import org.gradle.testfixtures.ProjectBuilder;
import org.junit.Test;

import setools.gradle.meetings.dsl.Meeting;
import setools.gradle.util.Factory;
import setools.gradle.util.FactoryNotFoundException;

/**
 * TODO:add documentation...
 *
 */
public class MeetingFactoryServiceTest {

	/**
	 * Test registering a factory, creating a meeting without arguments, 
	 * and unregistering a factory.
	 * @throws FactoryNotFoundException 
	 */
	@Test
	public void testBasicObject() throws FactoryNotFoundException {
		System.out.println("\n\nSTARTING testBasicObject");
		Project project = ProjectBuilder.builder()
				//TODO:configure builder
				.build();
		project.getPluginManager().apply(MeetingFactoryService.class);
		MeetingFactoryService tst = project.getPlugins().findPlugin(MeetingFactoryService.class);
		assertNotNull(tst);
		Object factory = new TestMeetingFactory();
		tst.register(factory);
		Meeting meeting = tst.create("testMeeting");
		assertNotNull(meeting);
		tst.unregister(factory);
	}

	/**
	 * Test registering a factory, creating a meeting without arguments, 
	 * and unregistering a factory.
	 * @throws FactoryNotFoundException 
	 */
	@Test
	public void testBasicClass() throws FactoryNotFoundException {
		System.out.println("\n\nSTARTING testBasicClass");
		Project project = ProjectBuilder.builder()
				//TODO:configure builder
				.build();
		project.getPluginManager().apply(MeetingFactoryService.class);
		MeetingFactoryService tst = project.getPlugins().findPlugin(MeetingFactoryService.class);
		assertNotNull(tst);
		tst.register(TestMeetingFactory.class);
		Meeting meeting = tst.create("testMeeting");
		assertNotNull(meeting);
		tst.unregister(TestMeetingFactory.class);
		System.out.println("END testBasicClass\n\n");
	}

	/**
	 * Test registering a factory, creating a meeting with arguments, 
	 * and unregistering a factory.
	 * @throws FactoryNotFoundException 
	 */
	@Test
	public void testParametersObject() throws FactoryNotFoundException {
		System.out.println("\n\nSTARTING testParametersObject");
		Project project = ProjectBuilder.builder()
				//TODO:configure builder
				.build();
		project.getPluginManager().apply(MeetingFactoryService.class);
		MeetingFactoryService tst = project.getPlugins().findPlugin(MeetingFactoryService.class);
		assertNotNull(tst);
		Object factory = new TestMeetingFactory();
		tst.register(factory);
		Meeting meeting = tst.create("altMeeting","Testing 123");
		assertNotNull(meeting);
		tst.unregister(factory);
	}

	public class TestMeetingFactory {
		
		public TestMeetingFactory() {
			
		}
		
		@Factory
		public Meeting testMeeting() {
			return new Meeting() {
				
			};
		}
		
		@Factory(name="altMeeting")
		public Meeting testMeeting2(String argument) {
			return new Meeting() {
				
			};
		}
	}
}
