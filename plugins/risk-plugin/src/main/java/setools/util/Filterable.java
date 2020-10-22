/**
 * TODO:license...
 */
package setools.util;

import java.util.Collection;

import org.gradle.api.specs.Spec; //TODO:I don't like this dependency, but do we really want to re-implement?

/**
 * TODO:documentation...
 */
public interface Filterable<T> {

	/**
	 * TODO:documentation...
	 * @return
	 */
	public Collection<T> filter();
	
	/**
	 * TODO:documentation...
	 * @param spec
	 * @return
	 */
	public Collection<T> filter(Spec<T> spec);
	
}
