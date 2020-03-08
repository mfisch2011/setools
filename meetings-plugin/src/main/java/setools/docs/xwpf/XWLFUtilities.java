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
package setools.docs.xwpf;

import java.awt.geom.Rectangle2D;

import org.apache.poi.xslf.usermodel.XMLSlideShow;
import org.apache.poi.xslf.usermodel.XSLFShape;
import org.apache.poi.xslf.usermodel.XSLFSlide;
import org.apache.poi.xslf.usermodel.XSLFSlideLayout;
import org.apache.poi.xslf.usermodel.XSLFSlideMaster;
import org.apache.poi.xslf.usermodel.XSLFTextShape;

/**
 * @author matt
 *
 */
public class XWLFUtilities {

	public static XSLFShape getShape(XSLFSlide slide,String id) {
		//try shapes first
		for(XSLFShape shape : slide.getShapes()) {
			if(shape.getShapeName().equals(id))
				return shape;
		}
		
		//try placeholders then find matching shape
		for(XSLFTextShape placeholder : slide.getPlaceholders()) {
			if(placeholder.getShapeName().equals(id)) {
				Rectangle2D anchor = placeholder.getAnchor();
				for(XSLFShape shape : slide.getShapes()) {
					if(shape.getAnchor().equals(anchor))
						return shape;
				}
			}
		}
		return null;
	}
	
	public static void setShapeText(XSLFSlide slide, String id, String text) {
		XSLFTextShape shape = (XSLFTextShape)getShape(slide,id);
		shape.setText(text);
	}

	public static XSLFSlideLayout getSlideLayout(XMLSlideShow presentation, String id) {
		for(XSLFSlideMaster master : presentation.getSlideMasters()) {
			XSLFSlideLayout layout = master.getLayout(id);
			if(layout!=null)
				return layout;
		}
		return null;
	}
}
