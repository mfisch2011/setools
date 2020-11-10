/**
 * TODO:license...
 */
package setools.gradle.risk.internal;

import java.net.MalformedURLException;

import javax.inject.Inject;

import org.gradle.api.Project;
import org.gradle.util.ConfigureUtil;

import groovy.lang.Closure;
import setools.gradle.dsl.agenda.TitleAndContent;
import setools.gradle.dsl.agenda.internal.DefaultTitleAndContent;
import setools.gradle.dsl.meeting.internal.DefaultMeeting;
import setools.gradle.risk.ActionItemReview;
import setools.gradle.risk.RiskReviewExtension;
import setools.gradle.risk.dsl.RisksSection;
import setools.gradle.risk.dsl.internal.DefaultRisksSection;

/**
 * TODO:documentation...
 */
public class DefaultRiskReviewExtension extends DefaultMeeting implements RiskReviewExtension {
	
	/**
	 * TODO:documentation...
	 * @param project
	 * @throws MalformedURLException 
	 */
	@Inject
	public DefaultRiskReviewExtension(Project project) throws MalformedURLException {
		super(project);
		setPresentationTemplate("templates/risk-review-template.pptx");
		setName("Risk Review"); 
		this.actionItemReview = new DefaultActionItemReview();
		agenda.add(this.actionItemReview);
		this.newRisks = new DefaultRisksSection();
		agenda.add(this.newRisks);
		this.newRisks.setOverviewSlide(false);
		this.newRisks.setTitle("New Risks");
		this.monitoredRisks = new DefaultRisksSection();
		agenda.add(this.monitoredRisks);
		this.monitoredRisks.setOverviewSlide(true);
		this.monitoredRisks.setTitle("Monitored Risks");
		this.proposedClosures = new DefaultRisksSection();
		agenda.add(this.proposedClosures);
		this.proposedClosures.setOverviewSlide(false);
		this.proposedClosures.setTitle("Risk Closures");
		this.closingComments = new DefaultTitleAndContent();
		this.closingComments.setTitle("Closing Comments");
		agenda.add(this.closingComments);
	}

	/**
	 * TODO:documentation...
	 */
	protected final ActionItemReview actionItemReview;

	@Override
	public ActionItemReview actionItemReview() {
		return actionItemReview;
	}

	@SuppressWarnings("rawtypes")
	@Override
	public ActionItemReview actionItemReview(Closure closure) {
		ConfigureUtil.configure(closure, actionItemReview);
		return actionItemReview;
	}
	
	/**
	 * TODO:documentation...
	 */
	protected final RisksSection newRisks;

	@Override
	public RisksSection newRisks() {
		return newRisks;
	}

	@SuppressWarnings("rawtypes")
	@Override
	public RisksSection newRisks(Closure closure) {
		ConfigureUtil.configure(closure, newRisks);
		return newRisks;
	}

	@Override
	public RisksSection monitoredRisks() {
		return monitoredRisks();
	}
	
	/**
	 * TODO:documentation...
	 */
	protected final RisksSection monitoredRisks;

	@SuppressWarnings("rawtypes")
	@Override
	public RisksSection monitoredRisks(Closure closure) {
		ConfigureUtil.configure(closure, monitoredRisks);
		return monitoredRisks;
	}
	
	/**
	 * TODO:documentation...
	 */
	protected final RisksSection proposedClosures;

	@Override
	public RisksSection proposedClosures() {
		return proposedClosures;
	}

	@SuppressWarnings("rawtypes")
	@Override
	public RisksSection proposedClosures(Closure closure) {
		ConfigureUtil.configure(closure, proposedClosures);
		return proposedClosures;
	}
	
	/**
	 * TODO:documentation...
	 */
	protected final TitleAndContent closingComments;

	@Override
	public TitleAndContent closingComments() {
		return closingComments;
	}

	@SuppressWarnings("rawtypes")
	@Override
	public TitleAndContent closingComments(Closure closure) {
		ConfigureUtil.configure(closure, closingComments);
		return closingComments;
	}
}
