/**
 * 
 */
package setools.velocity;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;

import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;

/**
 * @author matt
 *
 */
public class VelocityMergeThread implements Runnable {

	/** TODO:
	 */
	protected String template = null;
	
	/**
	 */
	protected final VelocityEngine engine;

	/** TODO:
	 */
	protected final String output;

	/** TODO:
	 */
	protected final VelocityContext context;
	
	/** TODO:
	 * @param template
	 * @param output
	 * @param context
	 */
	public VelocityMergeThread(String template,String output,VelocityContext context) {
		this(template,output,context,new VelocityEngine());
	}
	
	/** TODO:
	 * @param template
	 * @param output
	 * @param context
	 * @param engine
	 */
	public VelocityMergeThread(String template,String output,VelocityContext context,VelocityEngine engine) {
		this.template = template;
		this.output = output;
		this.context = context;
		this.engine = engine;
	}
	
	/** TODO:
	 */
	@Override
	public void run() {
		try {
			VelocityEngine engine = getEngine();
			VelocityContext context = getContext();
			Template template = engine.getTemplate(this.template);
			OutputStream stream = getOutput();
			Writer writer = new OutputStreamWriter(stream);
			template.merge(context,writer);
			writer.close();
		} catch(Throwable t) {
			//TODO:implement logging...
			t.printStackTrace();
		}
	}

	/** TODO:
	 * @return
	 */
	protected VelocityContext getContext() {
		return context;
	}

	/** TODO:
	 * @return
	 */
	protected VelocityEngine getEngine() {
		return engine;
	}

	/** TODO:
	 * @return
	 * @throws IOException
	 */
	protected OutputStream getOutput() throws IOException {
		return new FileOutputStream(output);
	}

}
