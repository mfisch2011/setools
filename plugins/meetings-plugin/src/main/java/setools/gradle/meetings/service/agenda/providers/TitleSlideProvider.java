/**
 * TODO:license...
 */
package setools.gradle.meetings.service.agenda.providers;

import java.util.Collection;

import org.gradle.util.ConfigureUtil;

import groovy.lang.Closure;
import setools.gradle.meetings.dsl.AgendaHandler;
import setools.gradle.meetings.dsl.AgendaItem;
import setools.gradle.meetings.dsl.internal.DefaultAgendaItem;
import setools.gradle.meetings.service.Provided;
import setools.gradle.meetings.service.ProvidedInterface;
import setools.gradle.meetings.service.Provider;
import setools.gradle.meetings.service.agenda.AgendaProvider;

/**
 * TODO:documentation...
 */
public class TitleSlideProvider implements AgendaProvider {

	
	/**
	 * TODO:documentation...
	 */
	@ProvidedInterface
	public static interface TitleSlideProviderInterface {
		/**
		 * TODO:documentation...
		 * @return
		 */
		@Provided
		public AgendaItem titleSlide();
		
		/**
		 * TODO:documentation...
		 * @param closure
		 * @return
		 */
		@SuppressWarnings("rawtypes")
		@Provided
		public AgendaItem titleSlide(Closure closure);
		
	}
	
	/**
	 * TODO:documentation...
	 */
	@Provider
	public static class DefaultTitleSlideProvider implements TitleSlideProviderInterface {

		@Override
		public AgendaItem titleSlide() {
			return new DefaultTitleSlide();
		}

		@SuppressWarnings("rawtypes")
		@Override
		public AgendaItem titleSlide(Closure closure) {
			DefaultTitleSlide slide = new DefaultTitleSlide();
			ConfigureUtil.configure(closure, slide);
			return slide;
		}
	}
	
	public static interface TitleSlide extends AgendaItem {
		
		/**
		 * TODO:documentation...
		 * @return
		 */
		public String getSubTitle();
		
		/**
		 * TODO:documentation...
		 * @param subtitle
		 */
		public void setSubTitle(String subtitle);
		
	}
	
	/**
	 * TODO:documentation...
	 */
	public static class DefaultTitleSlide extends DefaultAgendaItem implements TitleSlide {

		/**
		 * TODO:documentation...
		 */
		protected String subtitle = null;
		
		@Override
		public String getSubTitle() {
			return subtitle;
		}

		@Override
		public void setSubTitle(String subtitle) {
			this.subtitle =  subtitle;
		}
		
	}
}
