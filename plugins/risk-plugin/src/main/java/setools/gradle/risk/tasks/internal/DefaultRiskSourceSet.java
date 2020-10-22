/**
 * TODO:license...
 */
package setools.gradle.risk.tasks.internal;

import javax.inject.Inject;

import org.gradle.api.file.SourceDirectorySet;
import org.gradle.api.model.ObjectFactory;
import org.gradle.api.reflect.HasPublicType;
import org.gradle.api.reflect.TypeOf;
import org.gradle.util.ConfigureUtil;

import groovy.lang.Closure;
import setools.gradle.risk.tasks.RiskSourceSet;

/**
 * TODO:documentation...
 */
public class DefaultRiskSourceSet implements RiskSourceSet,HasPublicType {
	
	/**
	 * TODO:documentation...
	 */
	protected final SourceDirectorySet risks;
	
	/**
	 * TODO:documentation...
	 */
	protected final SourceDirectorySet allRisks;

	@Inject
	public DefaultRiskSourceSet(String name,String displayName,ObjectFactory objectFactory) {
		this.risks = objectFactory.sourceDirectorySet(name,displayName + " risk sources");
		//TODO:filters?
		this.allRisks = objectFactory.sourceDirectorySet("all" + name,displayName + " risk sources");
		//TODO:filters?
		this.allRisks.source(this.risks);
	}
	
	@SuppressWarnings("rawtypes")
	@Override
	public RiskSourceSet risk(Closure closure) {
		ConfigureUtil.configure(closure, risks);
		return this;
	}
	
	@Override
	public SourceDirectorySet getRisks() {
		return risks;
	}
	
	@Override
	public SourceDirectorySet getAllRisks() {
		return allRisks;
	}
	
	@Override
	public TypeOf<?> getPublicType() {
		return TypeOf.typeOf(RiskSourceSet.class);
	}
}
