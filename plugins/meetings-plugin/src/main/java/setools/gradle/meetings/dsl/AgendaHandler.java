/**
 * TODO:license...
 */
package setools.gradle.meetings.dsl;

import java.util.Collection;

import setools.gradle.meetings.service.agenda.providers.TopicProvider.TopicInterface;

/**
 * TODO:documentation...
 */
public interface AgendaHandler extends Collection<AgendaItem> 
/*TODO:remove these when we have a proxy handler*/,
TopicInterface
{
	
}
