/**
 * TODO:license...
 */
package setools.gradle.meetings.service.agenda.providers;

import org.gradle.util.ConfigureUtil;

import groovy.lang.Closure;
import setools.gradle.meetings.dsl.AgendaHandler;
import setools.gradle.meetings.dsl.AgendaItem;
import setools.gradle.meetings.dsl.internal.DefaultAgendaHandler;
import setools.gradle.meetings.dsl.internal.DefaultAgendaItem;
import setools.gradle.meetings.service.Provided;
import setools.gradle.meetings.service.ProvidedInterface;
import setools.gradle.meetings.service.Provider;
import setools.gradle.meetings.service.agenda.AgendaProvider;

/**
 * TODO:documentation...
 */
public class TitleAndContentProvider implements AgendaProvider {

	
	/**
	 * TODO:documentation...
	 */
	@ProvidedInterface
	public static interface ProviderInterface {
		/**
		 * TODO:documentation...
		 * @return
		 */
		@Provided
		public TitleAndContent titleAndContentSlide();
		
		/**
		 * TODO:documentation...
		 * @param closure
		 * @return
		 */
		@SuppressWarnings("rawtypes")
		@Provided
		public TitleAndContent titleAndContentSlide(Closure closure);
		
	}
	
	/**
	 * TODO:documentation...
	 */
	@Provider
	public static class ProviderImplementation implements ProviderInterface {

		@Override
		public TitleAndContent titleAndContentSlide() {
			return new DefaultTitleAndContent();
		}

		@SuppressWarnings("rawtypes")
		@Override
		public TitleAndContent titleAndContentSlide(Closure closure) {
			DefaultTitleAndContent slide = new DefaultTitleAndContent();
			ConfigureUtil.configure(closure, slide);
			return slide;
		}
	}
	
	public static interface Content {
		
		/**
		 * TODO:documentation...
		 * @return
		 */
		public String getContentText();
		
		/**
		 * TODO:documentation...
		 * @param text
		 */
		public void setContentType(String text);
		
		/**
		 * TODO:documentation...
		 * @return
		 */
		public AgendaHandler bullets();
		
		/**
		 * TODO:documentation...
		 * @param closure
		 * @return
		 */
		@SuppressWarnings("rawtypes")
		public AgendaHandler bullets(Closure closure);
		
		//TODO:add methods for image content
		
	}
	
	public static class DefaultContent implements Content {
		
		/**
		 * TODO:documentation...
		 */
		protected final AgendaHandler bullets;
		
		public DefaultContent() {
			this.bullets = new DefaultAgendaHandler();
		}
		
		/**
		 * TODO:documentation...
		 * @param bullets
		 */
		public DefaultContent(AgendaHandler bullets) {
			this.bullets = bullets;
			
		}
		/**
		 * TODO:documentation...
		 */
		protected String text = null;
		
		@Override
		public String getContentText() {
			return text;
		}

		@Override
		public void setContentType(String text) {
			this.text = text;
		}

		@Override
		public AgendaHandler bullets() {
			return bullets;
		}

		@SuppressWarnings("rawtypes")
		@Override
		public AgendaHandler bullets(Closure closure) {
			ConfigureUtil.configure(closure, bullets);
			return bullets;
		}

	}
	
	public static interface TitleAndContent extends AgendaItem {
		public Content content();
	}
	
	/**
	 * TODO:documentation...
	 */
	public static class DefaultTitleAndContent extends DefaultAgendaItem implements TitleAndContent {
		
		/**
		 * TODO:documentation...
		 */
		protected final Content content;

		/**
		 * TODO:documentation...
		 */
		public DefaultTitleAndContent() {
			this.content = new DefaultContent(this.subTopics);
		}
		
		@Override
		public Content content() {
			return content;
		}
		
	}
}
