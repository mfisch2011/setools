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

import javax.inject.Inject;

import org.apache.poi.xslf.usermodel.XMLSlideShow;
import org.apache.poi.xslf.usermodel.XSLFSlide;
import org.apache.poi.xslf.usermodel.XSLFSlideLayout;
import org.gradle.api.tasks.Input;
import org.gradle.api.tasks.Optional;

import setools.doc.util.OOXMLException;
import setools.doc.util.OOXMLUtils;
import setools.gradle.meeting.api.AgendaItem;
import setools.gradle.meeting.api.Meeting;

/**
 * @author matt
 *
 */
public class DraftTitledSlide extends AbstractDraftSlides {

	@Inject
	public DraftTitledSlide(Meeting meeting,AgendaItem topic) {
		super(meeting);
		this.title = topic.getText();
	}

	/**
	 * TODO:
	 */
	protected  String title = null;
	
	/**
	 * TODO:
	 */
	protected String layout = null;

	@Override
	protected ArrayList<XSLFSlide> buildSlides(XMLSlideShow presentation) throws OOXMLException {
		ArrayList<XSLFSlide> slides = new ArrayList<XSLFSlide>();
		String layout = getLayout();
		XSLFSlideLayout slideLayout = (layout!=null) ? 
				OOXMLUtils.getSlideLayout(presentation,getLayout()) : null;
		XSLFSlide slide = (slideLayout!=null) ? presentation.createSlide(slideLayout) :
			presentation.createSlide();
		slides.add(slide);
		OOXMLUtils.setShapeText(slide,"Title",getTitle());
		return slides;
	}

	/** TODO:
	 * @return
	 */
	@Input
	@Optional
	public String getLayout() {
		return layout;
	}
	
	/** TODO:
	 * @param layout
	 */
	public void SetLayout(String layout) {
		this.layout = layout;
	}

	/** TODO:
	 * @return
	 */
	@Input
	public String getTitle() {
		return title;
	}
	
	/** TODO:
	 * @param title
	 */
	public void setTitle(String title) {
		this.title = title;
	}
}
