/**
 * TODO: add NSWC Crane's license...
 */
package setools.gradle.util;

/**
 * TODO:add documentation...
 *
 */
public interface FactoryService<T> {

	/**
	 * TODO:add documentation...
	 * @param name
	 * @param factory
	 * @return
	 */
	public void register(Object factory);
	
	/**
	 * TODO:add documentation...
	 * @param factory
	 */
	public void unregister(Object factory);
	
	/**
	 * TODO:add documentation...
	 * @param name
	 * @param arguments
	 * @return
	 * @throws FactoryNotFoundException 
	 */
	public T create(String name,Object...arguments) throws FactoryNotFoundException;
	
}
