/**
 * TODO:license...
 */
package setools.gradle.risk.util;

import org.gradle.api.DefaultTask;
import org.gradle.api.Project;
import org.gradle.api.Task;

import setools.gradle.dsl.agenda.AgendaItem;
import setools.gradle.dsl.meeting.Meeting;
import setools.gradle.meetings.util.InitializeMeetingTasks;
import setools.gradle.risk.ActionItemReview;
import setools.gradle.risk.RiskManagementBasePlugin;
import setools.gradle.risk.dsl.RisksSection;
import setools.gradle.risk.tasks.pptx.GenerateActionItemReview;
import setools.gradle.risk.tasks.pptx.GenerateRiskSection;

/**
 * TODO:documentation...
 */
public class InitializeRiskReviewTasks extends InitializeMeetingTasks {

	public InitializeRiskReviewTasks(Project project, Meeting meeting) {
		super(project, meeting);
	}

	@Override
	protected Class<? extends DefaultTask> getTaskType(String format, AgendaItem topic) {
		if(topic instanceof RisksSection)
			return GenerateRiskSection.class;
		else if(topic instanceof ActionItemReview)
			return GenerateActionItemReview.class;
		else
			return super.getTaskType(format, topic);
	}

	@Override
	protected void createDraftSlideTasks() {
		super.createDraftSlideTasks();
		//test if a analyzeRisks task exists.
		Task analyze = project.getTasks().findByName(
				RiskManagementBasePlugin.RISK_ANALYSIS);
		if(analyze!=null) {
			draftSlides.dependsOn(analyze);
		}
	}
}
