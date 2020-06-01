/**
   Copyright 2020 Matt Fischer <mfish2011@gmail.com>

   Licensed under the Apache License, Version 2.0 (the "License");
   you may not use this file except in compliance with the License.
   You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

   Unless required by applicable law or agreed to in writing, software
   distributed under the License is distributed on an "AS IS" BASIS,
   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
   See the License for the specific language governing permissions and
   limitations under the License.
*/
package setools.gradle.meeting.api.internal;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Collection;

import javax.inject.Inject;

import org.gradle.api.Project;
import org.gradle.util.ConfigureUtil;

import groovy.lang.Closure;
import setools.gradle.meeting.api.AgendaItem;
import setools.gradle.meeting.api.RiskReview;
import setools.gradle.meeting.api.internal.DefaultMeeting;


/** TODO:
 * @author matt
 *
 */
public class DefaultRiskReview extends DefaultMeeting implements RiskReview {

	/**
	 * TODO:
	 */
	protected final AgendaItem newRisks;
	
	/**
	 * TODO:
	 */
	protected final AgendaItem monitoredRisks;
	
	/**
	 * TODO:
	 */
	protected final AgendaItem riskClosures;
	
	/**
	 * TODO:
	 */
	protected final AgendaItem actionItems;

	/**
	 * TODO:
	 */
	protected final AgendaItem closing;

	@Inject
	public DefaultRiskReview(Project project) throws URISyntaxException {
		super(project);
		this.presentationTemplate = new URI("classpath:///resources/ooxml-risk-review-template.pptx");
		actionItems = new DefaultAgendaItem();
		actionItems.setText("Action Item Review");
		actionItems.setDescription("Review of open action items and action items proposed for closure.");
		agenda.add(actionItems);
		
		newRisks = new DefaultRiskAgendaItem();
		newRisks.setText("New Risks");
		newRisks.setDescription("New risk identified since the last risk review.");
		agenda.add(newRisks);
		
		monitoredRisks = new DefaultRiskAgendaItem();
		monitoredRisks.setText("Monitored Risks");
		monitoredRisks.setDescription("Risk monitored by the risk review board.");
		monitoredRisks.setFormatter("setools.gradle.tasks.DraftRiskOverview");
		agenda.add(monitoredRisks);
		
		riskClosures = new DefaultRiskAgendaItem();
		riskClosures.setText("Risk Closures");
		riskClosures.setDescription("Risks proposed for closure by the risk review board.");
		agenda.add(riskClosures);
		
		closing = new DefaultRiskAgendaItem();
		closing.setText("Closing Comments");
		closing.setDescription("Risk Review closing comments and discussion.");
		agenda.add(closing);
	}

	@Override
	public Collection<AgendaItem> getNewRisks() {
		return newRisks.getSubItems();
	}

	@SuppressWarnings("rawtypes")
	@Override
	public void newRisks(Closure closure) {
		ConfigureUtil.configure(closure, newRisks);
	}

	@Override
	public Collection<AgendaItem> getMonitoredRisks() {
		return monitoredRisks.getSubItems();
	}

	@SuppressWarnings("rawtypes")
	@Override
	public void monitoredRisks(Closure closure) {
		ConfigureUtil.configure(closure, monitoredRisks);
	}

	@Override
	public Collection<AgendaItem> getRiskClosures() {
		return riskClosures.getSubItems();
	}

	@SuppressWarnings("rawtypes")
	@Override
	public void riskClosures(Closure closure) {
		ConfigureUtil.configure(closure, riskClosures);
	}
	
	@Override
	public Collection<AgendaItem> getClosingComments() {
		return closing.getSubItems();
	}
	
	@Override
	@SuppressWarnings("rawtypes")
	public void closingComments(Closure closure) {
		ConfigureUtil.configure(closure, closing);
	}

	@Override
	public String getName() {
		if(name!=null) {
			return name;
		} else {
			return project.getName() + " Risk Review";
		}
	}

}
