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
package setools.doc.util;

import java.awt.geom.Rectangle2D;
import java.util.Iterator;

import org.apache.poi.xslf.usermodel.XSLFTextParagraph;
import org.apache.poi.xslf.usermodel.XSLFTextRun;
import org.apache.poi.xslf.usermodel.XMLSlideShow;
import org.apache.poi.xslf.usermodel.XSLFAutoShape;
import org.apache.poi.xslf.usermodel.XSLFShape;
import org.apache.poi.xslf.usermodel.XSLFSlide;
import org.apache.poi.xslf.usermodel.XSLFSlideLayout;
import org.apache.poi.xslf.usermodel.XSLFSlideMaster;
import org.apache.poi.xslf.usermodel.XSLFTextShape;

/** TODO:
 * @author matt
 *
 */
public class OOXMLUtils {

	public static void printSlideLayouts(XMLSlideShow presentation) {
		for(XSLFSlideMaster master : presentation.getSlideMasters()) {
			System.out.printf("Master: %s%n", master);
			for(XSLFSlideLayout layout : master.getSlideLayouts()) {
				System.out.printf("Layout: %s%n", layout.getName());
			}
		}
	}
	
	public static void printShapes(XSLFSlide slide) {
		//shapes first
		for(XSLFShape shape : slide.getShapes()) {
			System.out.printf("Shape: %s%n", shape);
		}
		XSLFSlideLayout layout = slide.getSlideLayout();
		for(XSLFShape shape : layout.getShapes()) {
			System.out.printf("Layout Shape: %s%n:", shape.getShapeName());
		}
	}

	
	/** TODO:
	 * @param presentation
	 * @param name
	 * @return
	 * @throws OOXMLException 
	 */
	public static XSLFSlideLayout getSlideLayout(XMLSlideShow presentation, String name) throws OOXMLException {
		for(XSLFSlideMaster master : presentation.getSlideMasters()) {
			for(XSLFSlideLayout layout : master.getSlideLayouts()) {
				if(layout.getName().equals(name))
					return layout;
			}
		}
		String msg = String.format("Shape layout with name '%s' not found.", name);
		throw new OOXMLException(msg);
	}

	/** TODO:
	 * @param slide
	 * @param string
	 * @param tile
	 * @throws OOXMLException 
	 */
	public static void setShapeText(XSLFSlide slide, String name, String text) throws OOXMLException {
		XSLFShape shape = getShape(slide,name);
		if(shape instanceof XSLFTextShape) {
			XSLFTextShape textShape = (XSLFTextShape)shape;
			textShape.setText(text);
		} else {
			String msg = String.format("Shape '%s' is not an XSLFTextShape.", name);
			throw new OOXMLException(msg);
		}
	}

	/** TODO:
	 * @param slide
	 * @param name
	 * @return
	 * @throws OOXMLException 
	 */
	public static XSLFShape getShape(XSLFSlide slide, String name) throws OOXMLException {
		//try shapes first
		for(XSLFShape shape : slide.getShapes()) {
			if(shape.getShapeName().startsWith(name)) {
				return shape;
			}
		}
		
		//try placeholders next
		XSLFSlideLayout layout = slide.getSlideLayout();
		for(XSLFShape placeholder : layout.getShapes()) {
			if(placeholder.getShapeName().startsWith(name)) {
				Rectangle2D anchor = placeholder.getAnchor();
				for(XSLFShape shape : slide.getShapes()) {
					if(shape.getAnchor().equals(anchor)) {
						return shape;
					}
				}
				//TODO:return placeholder???
				return placeholder;
			}
		}
		String msg = String.format("Shape with name '%s' not found.", name);
		throw new OOXMLException(msg);
	}

	public static void addBullets(XSLFTextShape shape, String text, int level) throws OOXMLException {
		XSLFTextParagraph para = shape.addNewTextParagraph();
		para.setIndentLevel(level);
		para.addNewTextRun().setText(text);
		//TODO:test if text exceeds anchor bounds, revert, and throw OOXMLException
	}

	public static void removeParagraphs(XSLFTextShape content) {
		while(!content.getTextBody().getParagraphs().isEmpty())
			content.getTextBody().removeParagraph(0);
	}

	public static void append(XMLSlideShow presentation, XMLSlideShow tmp) throws OOXMLException {
		for(XSLFSlide slide : tmp.getSlides()) {
			append(presentation,slide);
		}
	}

	public static XSLFSlide append(XMLSlideShow presentation, XSLFSlide srcSlide) throws OOXMLException {
		XSLFSlideLayout srcLayout = srcSlide.getSlideLayout();
		XSLFSlideLayout destLayout = getSlideLayout(presentation,srcLayout);
		if(destLayout==null)
			destLayout = copySlideLayout(presentation,srcLayout);
		XSLFSlide destSlide = presentation.createSlide(destLayout);
		for(XSLFShape shape : srcSlide.getShapes()) {
			try {
				copyShape(destSlide,shape);
			} catch(OOXMLException e) {
				rawCopyShape(destSlide,shape);
			}
		}
		//TODO:what else
		return destSlide;
	}

	protected static void rawCopyShape(XSLFSlide destSlide, XSLFShape shape) {
		if(shape instanceof XSLFAutoShape) {
			XSLFAutoShape destShape = destSlide.createAutoShape();
			Rectangle2D anchor = shape.getAnchor();
			destShape.setAnchor(anchor);
			XSLFAutoShape autoShape = (XSLFAutoShape)shape;
			for(XSLFTextParagraph srcPara : autoShape.getTextParagraphs()) {
				XSLFTextParagraph destPara = destShape.addNewTextParagraph();
				//TODO:there has to be a better way to copy formatting...
				destPara.setBullet(srcPara.isBullet());
				destPara.setTextAlign(srcPara.getTextAlign());
				for(XSLFTextRun srcRun : srcPara.getTextRuns()) {
					XSLFTextRun destRun = destPara.addNewTextRun();
					String text = srcRun.getRawText();
					destRun.setText(text);
					destRun.setFontColor(srcRun.getFontColor());
					destRun.setFontFamily(srcRun.getFontFamily());
					destRun.setBold(srcRun.isBold());
					destRun.setItalic(srcRun.isItalic());
					destRun.setUnderlined(srcRun.isUnderlined());
					destRun.setStrikethrough(srcRun.isStrikethrough());
					destRun.setSubscript(srcRun.isSubscript());
					destRun.setSuperscript(srcRun.isSuperscript());
				}
			}
		}
	}

	public static String getShapeText(XSLFSlide slide, String name) throws OOXMLException {
		XSLFShape shape = getShape(slide,name);
		if(shape instanceof XSLFTextShape) {
			return ((XSLFTextShape)shape).getText();
		}
		String msg = String.format("Shape '%s' is not an XSLFTextShape.", name);
		throw new OOXMLException(msg);
	}

	public static XSLFShape copyShape(XSLFSlide destSlide, XSLFShape shape) throws OOXMLException {
		String name = shape.getShapeName();
		if(name.equals("Title 1")) name = "Title"; //TODO: WTFF IS THIS REQUIRED?
		if(name.equals("Subtitle 2")) name = "Subtitle"; //TODO: WTFF IS THIS REQUIRED?
		if(shape instanceof XSLFAutoShape) {
			XSLFAutoShape srcShape = (XSLFAutoShape)shape;
			String text = srcShape.getText();
			setShapeText(destSlide,name,text);
		}
		return null;
	}

	public static XSLFSlideLayout copySlideLayout(XMLSlideShow presentation, XSLFSlideLayout layout) {
		// TODO Auto-generated method stub
		System.out.printf("copySlideLayout: %s%n", layout);
		return null;
	}

	public static XSLFSlideLayout getSlideLayout(XMLSlideShow presentation, XSLFSlideLayout layout) throws OOXMLException {
		//TODO:this is not nearly robust enough, but it is a start
		return getSlideLayout(presentation,layout.getName());
	}

	public static void addBullets(XSLFSlide slide, String name, String description, int lvl) throws OOXMLException {
		XSLFTextShape shape = (XSLFTextShape) getShape(slide,name);
		addBullets(shape,description,lvl);
	}

	public static XSLFSlide createSlide(XMLSlideShow presentation, String layout) throws OOXMLException {
		XSLFSlideLayout slideLayout = getSlideLayout(presentation,layout);
		return presentation.createSlide(slideLayout);
	}

}
