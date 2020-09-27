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
import setools.gradle.meetings.service.agenda.providers.TitleAndContentProvider.Content;
import setools.gradle.meetings.service.agenda.providers.TitleAndContentProvider.DefaultContent;

/**
 * TODO:documentation...
 */
public class TitleAndTwoContentProvider implements AgendaProvider {

	
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
		public TitleAndTwoContent titleAndTwoContent();
		
		/**
		 * TODO:documentation...
		 * @param closure
		 * @return
		 */
		@SuppressWarnings("rawtypes")
		@Provided
		public TitleAndTwoContent titleAndTwoContent(Closure closure);
		
	}
	
	/**
	 * TODO:documentation...
	 */
	@Provider
	public static class ProviderImplementation implements ProviderInterface {

		@Override
		public TitleAndTwoContent titleAndTwoContent() {
			return new DefaultTitleAndTwoContent();
		}

		@SuppressWarnings("rawtypes")
		@Override
		public TitleAndTwoContent titleAndTwoContent(Closure closure) {
			DefaultTitleAndTwoContent slide = new DefaultTitleAndTwoContent();
			ConfigureUtil.configure(closure, slide);
			return slide;
		}

	}
	
	/**
	 * TODO:documentation...
	 */
	public static interface TitleAndTwoContent extends AgendaItem {
		
		/**
		 * TODO:documentation...
		 * @return
		 */
		public Content left();
		
		/**
		 * TODO:documentation...
		 * @return
		 */
		public Content right();
		
	}
	
	/**
	 * TODO:documentation...
	 */
	public static class DefaultTitleAndTwoContent extends DefaultAgendaItem implements TitleAndTwoContent {
		
		/**
		 * TODO:documentation...
		 */
		protected final Content left;
		
		/**
		 * TODO:documentation...
		 */
		protected final Content right;
		
		/**
		 * TODO:documentation...
		 */
		public DefaultTitleAndTwoContent() {
			this.left = new DefaultContent(this.subTopics); //reuse subTopics
			this.right = new DefaultContent(); //use new AgendaHandler
		}

		@Override
		public Content left() {
			return left;
		}

		@Override
		public Content right() {
			return right;
		}
		
	}
}
