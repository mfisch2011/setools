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

import java.util.Iterator;

import javax.inject.Inject;

import org.apache.poi.xslf.usermodel.XMLSlideShow;
import org.apache.poi.xslf.usermodel.XSLFSlide;
import org.apache.poi.xslf.usermodel.XSLFSlideLayout;
import org.apache.poi.xslf.usermodel.XSLFTextShape;
import setools.doc.util.OOXMLException;
import setools.doc.util.OOXMLUtils;
import setools.gradle.meeting.api.AgendaItem;
import setools.gradle.meeting.api.Meeting;

/**
 * @author matt
 *
 */
public class DraftContentSlide extends AbstractTopicSlides {

	/**
	 * TODO:
	 */
	protected int depth = -1;
	
	protected String layout;
	
	@Inject
	public DraftContentSlide(Meeting meeting,AgendaItem topic) {
		super(topic);
		layout = "Title and Content";
		depth = -1;
	}
	
	@Override
	protected void buildSlides(XMLSlideShow presentation) throws OOXMLException {
		Iterator<AgendaItem> iter = this.topic.getSubItems().iterator();
		String title = this.topic.getText();
		XSLFSlide slide = OOXMLUtils.createSlide(presentation,layout);
		OOXMLUtils.setShapeText(slide, "Title", title);
		XSLFTextShape shape = (XSLFTextShape) OOXMLUtils.getShape(slide, "Content");
		shape.clearText();
		while(iter.hasNext()) {
			AgendaItem topic = iter.next();
			slide = buildSlides(presentation,slide,topic,0);
		}
	}

	protected XSLFSlide buildSlides(XMLSlideShow presentation, XSLFSlide slide, AgendaItem topic, int lvl) throws OOXMLException {
		if(depth!=-1 && lvl<=depth) {
			try {
				OOXMLUtils.addBullets(slide, "Content", topic.getText(), lvl);
				Iterator<AgendaItem> iter = topic.getSubItems().iterator();
				while(iter.hasNext()) {
					AgendaItem subTopic = iter.next();
					slide = buildSlides(presentation,slide,subTopic,lvl+1);
				}
			} catch(OOXMLException e) {
				XSLFSlideLayout layout = slide.getSlideLayout();
				String title = OOXMLUtils.getShapeText(slide, "Title");
				title = title.replace(" (continued)","");
				slide = presentation.createSlide(layout);
				OOXMLUtils.setShapeText(slide, "Title", title + " (continued)");
				XSLFTextShape shape = (XSLFTextShape) OOXMLUtils.getShape(slide, "Content");
				shape.clearText();
				OOXMLUtils.addBullets(slide, "Content", topic.getText(), lvl);
				Iterator<AgendaItem> iter = topic.getSubItems().iterator();
				while(iter.hasNext()) {
					AgendaItem subTopic = iter.next();
					slide = buildSlides(presentation,slide,subTopic,lvl+1);
				}
			}
		}
		return slide;
	}
}
