/**
 * TODO:license...
 */
package setools.gradle.risk.dsl.internal;

import org.gradle.util.ConfigureUtil;

import groovy.lang.Closure;
import setools.gradle.dsl.agenda.internal.DefaultSectionSlide;
import setools.gradle.risk.dsl.RiskOverviewSlide;
import setools.gradle.risk.dsl.RisksSection;

/**
 * TODO:documentation...
 */
public class DefaultRisksSection extends DefaultSectionSlide implements RisksSection {
	
	public DefaultRisksSection() {
		this.overviewSlide = new DefaultRiskOverviewSlide();
	}

	/**
	 * TODO:documentation...
	 */
	protected boolean hasOverview = false;
	
	@Override
	public boolean hasOverviewSlide() {
		return hasOverview;
	}

	@Override
	public void setOverviewSlide(boolean set) {
		hasOverview = set;
	}
	
	/**
	 * TODO:documentation...
	 */
	protected final RiskOverviewSlide overviewSlide;

	/**
	 * TODO:documentation...
	 * @return
	 */
	public RiskOverviewSlide overview() {
		return overviewSlide;
	}
	
	/**
	 * TODO:documentation...
	 * @param closure
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	public RiskOverviewSlide overview(Closure closure) {
		ConfigureUtil.configure(closure, overviewSlide);
		return overviewSlide;
	}
}
