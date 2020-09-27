/**
 * TODO:license...
 */
package setools.gradle.meetings.service.agenda.providers;

import org.gradle.util.ConfigureUtil;

import groovy.lang.Closure;
import setools.gradle.meetings.dsl.AgendaItem;
import setools.gradle.meetings.dsl.internal.DefaultAgendaItem;
import setools.gradle.meetings.service.Provided;
import setools.gradle.meetings.service.ProvidedInterface;
import setools.gradle.meetings.service.Provider;
import setools.gradle.meetings.service.agenda.AgendaProvider;

/**
 * TODO:documentation...
 */
public class TopicProvider implements AgendaProvider {

	
	/**
	 * TODO:documentation...
	 */
	@ProvidedInterface
	public static interface TopicInterface {
		/**
		 * TODO:documentation...
		 * @return
		 */
		@Provided
		public AgendaItem topic();
		
		/**
		 * TODO:documentation...
		 * @param closure
		 * @return
		 */
		@SuppressWarnings("rawtypes")
		@Provided
		public AgendaItem topic(Closure closure);
		
	}
	
	/**
	 * TODO:documentation...
	 */
	@Provider
	public static class DefaultTopicProvider implements TopicInterface {

		@Override
		public AgendaItem topic() {
			return new DefaultAgendaItem();
		}

		@SuppressWarnings("rawtypes")
		@Override
		public AgendaItem topic(Closure closure) {
			DefaultAgendaItem topic = new DefaultAgendaItem();
			ConfigureUtil.configure(closure, topic);
			return topic;
		}
		
	}
}
