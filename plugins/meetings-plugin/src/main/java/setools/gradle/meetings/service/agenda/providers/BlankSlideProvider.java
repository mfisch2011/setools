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
public class BlankSlideProvider implements AgendaProvider {

	
	/**
	 * TODO:documentation...
	 */
	@ProvidedInterface
	public static interface BlankSlideInterface {
		/**
		 * TODO:documentation...
		 * @return
		 */
		@Provided
		public BlankSlide blankSlide();
		
		/**
		 * TODO:documentation...
		 * @param closure
		 * @return
		 */
		@SuppressWarnings("rawtypes")
		@Provided
		public BlankSlide blankSlide(Closure closure);
		
	}
	
	/**
	 * TODO:documentation...
	 */
	@Provider
	public static class DefaultBlankSlideProvider implements BlankSlideInterface {

		@Override
		public BlankSlide blankSlide() {
			return new DefaultBlankSlide();
		}

		@SuppressWarnings("rawtypes")
		@Override
		public BlankSlide blankSlide(Closure closure) {
			DefaultBlankSlide topic = new DefaultBlankSlide();
			ConfigureUtil.configure(closure, topic);
			return topic;
		}
	}
	
	/**
	 * TODO:documentation...
	 */
	public static interface BlankSlide extends AgendaItem {
		
	}
	
	/**
	 * TODO:documentation...
	 */
	public static class DefaultBlankSlide extends DefaultAgendaItem implements BlankSlide {
		
	}
}
