/**
 * 
 */
package setools.gradle.project.tasks;

import java.io.File;
import java.util.Date;

import org.gradle.api.Project;
import org.gradle.api.Task;
import org.gradle.api.specs.Spec;
import org.gradle.api.tasks.Input;
import org.gradle.api.tasks.OutputFile;
import org.gradle.api.tasks.SourceTask;
import org.gradle.api.tasks.TaskAction;

import setools.project.util.ProjectMonteCarlo;

/**
 * TODO:documentation...
 */
public class ProjectMonteCarloTask extends SourceTask {
	
	public static String TASK_NAME = "simulateProject";
	
	public static ProjectMonteCarloTask configure(Project project) {
		return project.getTasks().create(TASK_NAME,
				ProjectMonteCarloTask.class);
	}
	
	protected final ProjectMonteCarlo application;

	public ProjectMonteCarloTask() {
		setSource("src/project"); //TODO:get this from the project source set...
		include("*.mpp","*.pod"); //TODO:add other types supported by MXJP...
		application = new ProjectMonteCarlo(); //TODO:how to link into Gradle Logger???
		
		/*
		 * since this is a random simulation the output could change 
		 * even if the inputs do not, so force the task to always 
		 * be out of date...
		 */
		getOutputs().upToDateWhen(new Spec<Task>() {
			@Override
			public boolean isSatisfiedBy(Task task) {
				return false; //force to always run
			}
		});
	}
	
	@Input
	public int getNumThreads() {
		return application.getNumThreads();
	}
	
	public void setNumThreads(int threads) {
		application.setNumThreads(threads);
	}
	
	@Input
	public int getNumTrials() {
		return application.getNumTrials();
	}
	
	public void setNumTrials(int trials) {
		application.setNumTrials(trials);
	}
	
	@OutputFile
	public File getOutput() {
		return application.getOutput();
	}
	
	public void setOutput(Object object) {
		application.setOutput(getProject().file(object));
	}
	
	@Input
	public int getStep() {
		return application.getStep();
	}
	
	public void setStep(int step) {
		application.setStep(step);
	}
	
	@Input
	public Date getStart() {
		return application.getStart();
	}
	
	public void setStart(Date date) {
		application.setStart(date);
	}
	
	@Input
	public Date getEnd() {
		return application.getEnd();
	}
	
	public void setEnd(Date date) {
		application.setEnd(date);
	}
	
	@TaskAction
	public void simulate() {
		getUserInputs();
		for(File file : getSource())
			application.getInputs().add(file);
		application.run();
	}
	
	protected void getUserInputs() {
		//TODO:
	}
}
