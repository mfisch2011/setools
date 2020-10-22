/**
 * TODO:license...
 */
package setools.gradle.risk.tasks;

import org.gradle.api.file.SourceDirectorySet;

import groovy.lang.Closure;

/**
 * TODO:documentation...
 */
public interface RiskSourceSet {

	/**
	 * TODO:documentation...
	 * @param closure
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	public RiskSourceSet risk(Closure closure);

	/**
	 * TODO:documentation...
	 * @return
	 */
	public SourceDirectorySet getRisks();

	/**
	 * TODO:documentation...
	 * @return
	 */
	public SourceDirectorySet getAllRisks();

}
