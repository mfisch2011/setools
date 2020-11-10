/**
 * TODO:license...
 */
package setools.gradle.risk;

import groovy.lang.Closure;
import setools.gradle.dsl.agenda.TitleAndContent;
import setools.gradle.dsl.meeting.Meeting;
import setools.gradle.risk.dsl.RisksSection;

/**
 * TODO:documentation...
 */
public interface RiskReviewExtension extends Meeting {

	/**
	 * TODO:documentation...
	 * @return
	 */
	public ActionItemReview actionItemReview();

	/**
	 * TODO:documentation...
	 * @param closure
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	public ActionItemReview actionItemReview(Closure closure);

	/**
	 * TODO:documentation...
	 * @return
	 */
	public RisksSection newRisks();

	/**
	 * TODO:documentation...
	 * @param closure
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	public RisksSection newRisks(Closure closure);

	/**
	 * TODO:documentation...
	 * @return
	 */
	public RisksSection monitoredRisks();

	/**
	 * TODO:documentation...
	 * @param closure
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	public RisksSection monitoredRisks(Closure closure);

	/**
	 * TODO:documentation...
	 * @return
	 */
	public RisksSection proposedClosures();

	/**
	 * TODO:documentation...
	 * @param closure
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	public RisksSection proposedClosures(Closure closure);

	/**
	 * TODO:documentation...
	 * @return
	 */
	public TitleAndContent closingComments();

	/**
	 * TODO:documentation...
	 * @param closure
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	public TitleAndContent closingComments(Closure closure);

}
