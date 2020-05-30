/**
   Copyright 2019 Matt Fischer <mfish2011@gmail.com>

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
package setools.gradle.tasks;

import java.util.ArrayList;
import java.util.Iterator;

import javax.inject.Inject;

import org.apache.poi.xslf.usermodel.XMLSlideShow;
import org.apache.poi.xslf.usermodel.XSLFSlide;
import org.apache.poi.xslf.usermodel.XSLFTextShape;
import org.gradle.api.tasks.Input;

import setools.doc.util.OOXMLException;
import setools.doc.util.OOXMLUtils;
import setools.gradle.meeting.api.AgendaItem;
import setools.gradle.meeting.api.Meeting;

/**
 * @author matt
 *
 */
public class DraftAgendaSlide extends AbstractDraftSlides {

	private int depth;
	
	@Inject
	public DraftAgendaSlide(Meeting meeting,int depth) {
		super(meeting);
		this.depth = depth;
	}

	@Override
	protected ArrayList<XSLFSlide> buildSlides(XMLSlideShow presentation) throws OOXMLException {
		ArrayList<XSLFSlide> slides = new ArrayList<XSLFSlide>();
		XSLFSlide slide = OOXMLUtils.createSlide(presentation, "Title and Content");
		OOXMLUtils.setShapeText(slide, "Title", "Agenda");
		slides.add(slide);
		XSLFTextShape shape = (XSLFTextShape) OOXMLUtils.getShape(slide, "Content");
		shape.clearText();
		Iterator<AgendaItem> iter = meeting.getAgenda().iterator();
		while(iter.hasNext()) {
			AgendaItem topic = iter.next();
			slide = addTopic(presentation,slide,topic,0);
		}
		return slides;
	}

	protected XSLFSlide addTopic(XMLSlideShow presentation,XSLFSlide slide, AgendaItem topic, int level) throws OOXMLException {
		if(depth== -1 || level<depth) {
			try {
				OOXMLUtils.addBullets(slide, "Content",topic.getText(),level);
				for(AgendaItem subTopic : topic.getSubItems())
					slide = addTopic(presentation,slide,subTopic,level+1);
			} catch (OOXMLException e) {
				slide = OOXMLUtils.createSlide(presentation, "Title and Content");
				OOXMLUtils.addBullets(slide, "Content",topic.getText(),level);
				for(AgendaItem subTopic : topic.getSubItems())
					slide = addTopic(presentation,slide,subTopic,level+1);
			}
		}
		return slide;
	}

	@Input
	public int getDepth() {
		return depth;
	}
	
	public void setDepth(int depth) {
		this.depth = depth;
	}
}
