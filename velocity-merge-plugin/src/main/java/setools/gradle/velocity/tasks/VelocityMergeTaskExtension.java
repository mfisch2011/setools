/**
 * 
 */
package setools.gradle.velocity.tasks;

import java.util.List;
import java.util.Properties;

import org.gradle.api.tasks.Input;
import org.gradle.api.tasks.InputFile;
import org.gradle.api.tasks.InputFiles;
import org.gradle.api.tasks.OutputFile;

/**
 * @author matt
 *
 */
public interface VelocityMergeTaskExtension {

	/** TODO:
	 * @return
	 */
	@InputFile
	public String getTemplate();
	
	/** TODO:
	 * @param object
	 */
	public void setTemplate(Object object);
	
	/** TODO:
	 * @param object
	 */
	public void template(Object object);

	/** TODO:
	 * @return
	 */
	@OutputFile
	public String getOutput();
	
	/** TODO:
	 * @param object
	 */
	public void setOutut(Object object);
	
	/** TODO:
	 * @param object
	 */
	public void outut(Object object);

	/** TODO:
	 * @return
	 */
	@InputFiles
	public List<String> getInputFiles();
	
	/** TODO:
	 * @param objects
	 */
	public void setInputFiles(Object...objects);
	
	/** TODO:
	 * @param objects
	 */
	public void inputFiles(Object...objects);

	/** TODO:
	 * @return
	 */
	@Input
	public List<String> getInputValues();
	
	/** TODO:
	 * @param values
	 */
	public void setInputValues(String...values);
	
	/** TODO:
	 * @param values
	 */
	public void inputValues(String...values);

	/** TODO:
	 * @return
	 */
	@Input
	public Properties getEngineProperties();
	
	//TODO:probably need to look into closure???
}
