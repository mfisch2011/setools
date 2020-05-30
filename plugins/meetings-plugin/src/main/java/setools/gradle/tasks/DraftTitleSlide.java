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
package setools.gradle.tasks;

import java.util.ArrayList;

import javax.inject.Inject;

import org.apache.poi.xslf.usermodel.XMLSlideShow;
import org.apache.poi.xslf.usermodel.XSLFSlide;
import org.gradle.api.tasks.Input;
import org.gradle.api.tasks.Optional;

import setools.doc.util.OOXMLException;
import setools.doc.util.OOXMLUtils;
import setools.gradle.meeting.api.AgendaItem;
import setools.gradle.meeting.api.Meeting;

/** TODO:
 * @author matt
 *
 */
public class DraftTitleSlide extends DraftTitledSlide {
	
	/**
	 * TODO:
	 */
	protected String subtitle;

	@Inject
	public DraftTitleSlide(Meeting meeting,AgendaItem topic) {
		super(meeting,topic);
		layout = "Title Slide";
	}
	
	@Override
	protected ArrayList<XSLFSlide> buildSlides(XMLSlideShow presentation) throws OOXMLException {
		ArrayList<XSLFSlide> slides = super.buildSlides(presentation);
		String subtitle = getSubtitle();
		XSLFSlide slide = (!slides.isEmpty()) ? slides.get(0) : null;
		if(subtitle!=null && slide!=null)
			OOXMLUtils.setShapeText(slide, "Subtitle", subtitle);
		return slides;
	}

	/** TODO:
	 * @return
	 */
	@Input
	@Optional
	public String getSubtitle() {
		return subtitle;
	}
	
	/** TODO:
	 * @param text
	 */
	public void setSubtitle(String text) {
		subtitle = text;
	}
	
}
