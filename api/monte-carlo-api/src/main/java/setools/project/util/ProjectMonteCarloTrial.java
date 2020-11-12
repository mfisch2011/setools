/**
 * 
 */
package setools.project.util;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.ThreadLocalRandom;

import org.apache.commons.math3.distribution.UniformRealDistribution;

import net.sf.mpxj.Duration;
import net.sf.mpxj.ProjectFile;
import net.sf.mpxj.Relation;
import net.sf.mpxj.Resource;
import net.sf.mpxj.ResourceAssignment;
import net.sf.mpxj.Task;
import net.sf.mpxj.reader.UniversalProjectReader;

import static setools.project.util.ProjectMonteCarloLogger.*;

/**
 * TODO:documentation...
 */
public class ProjectMonteCarloTrial implements Callable<File> {
	
	protected final int trial;
	
	protected final Set<File> inputs;
	
	protected final Date start;
	
	protected final Date end;
	
	protected final int step;
	
	protected final Map<String,Registers> resources;
	
	public ProjectMonteCarloTrial(int trial,Set<File> inputs,Date start,Date end,int step) {
		this.trial = trial;
		this.inputs = Collections.unmodifiableSet(inputs);
		this.start = start;
		this.end = end;
		this.step = step;
		this.resources = new HashMap<String,Registers>();
	}

	@Override
	public File call() throws Exception {
		enter();
		info("Running trial {}.",trial);
		initialize();
		UniversalProjectReader reader = new UniversalProjectReader();
		for(File input : inputs) {
			ProjectFile project = reader.read(input);
			randomize(project);
			adjust(project);
			collect(project);
		}
		info("Trial {} done.",trial);
		exit();
		return report();
	}
	
	protected void collect(ProjectFile project) {
		enter();
		//TODO:
		for(Resource resource : project.getResources()) {
			collect(resource);
		}
		exit();
	}
	
	protected void collect(Resource resource) {
		enter();
		String name = resource.getName();
		Registers registers = resources.get(name);
		if(registers==null) {
			registers = new Registers(start,end,step);
			resources.put(name, registers);
		}
		for(ResourceAssignment assignment : resource.getTaskAssignments()) {
			Date begin = assignment.getTask().getStart();
			Date finish = assignment.getTask().getFinish();
			registers.addBetween(1.0,begin,finish); //TODO:configure to use actual percent utilization or work hours...
		}
		exit();
	}
	
	protected void adjust(ProjectFile project) {
		enter();
		for(Task task : project.getTasks()) {
			if(task.getPredecessors().isEmpty()) {
				adjust(null,task,null);
			}
		}
		exit();
	}
	
	protected void adjust(Task parent,Task task,Relation rel) {
		//adjust task start
		Date parentFinish = (parent!=null) ? calculateFinish(parent.getFinish(),rel) : null;
		Date start = task.getStart();
		if(parentFinish!=null && parentFinish.after(start)) {
			start = parentFinish;
			task.setStart(parentFinish);
		}
		
		//adjust task end
		Date end = add(start,task.getDuration());
		task.setFinish(end);
		for(Relation relation : task.getSuccessors()) {
			adjust(task,relation.getTargetTask(),relation);
		}
	}
	
	protected Date calculateFinish(Date date,Relation rel) {
		if(rel!=null) {
			//TODO:how to handle different lags???
			Duration lag = rel.getLag();
			return add(date,lag);
		} else {
			return date;
		}
	}
	
	protected Date add(Date date,Duration duration) {
		//TODO:how to handle other types of durations...
		int days = (int)Math.round(duration.getDuration() / 100.0);
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(Calendar.DATE, days);
		return calendar.getTime();
	}
	
	protected void randomize(ProjectFile project) {
		enter();
		for(Task task : project.getTasks()) {
			recursiveRandomizeTaskStart(task);
			recursiveRandomizeTaskDuration(task);
			recursiveRandomizeTaskCost(task);
		}
		exit();
	}
	
	protected void recursiveRandomizeTaskStart(Task task) {
		enter();
		//TODO:enable different RV types...
		//Date actualDate = dateBetween(task.getDate(1),task.getDate(2));
		Date actualDate = dateBetween(task.getDate(1),task.getDate(2));
		if(actualDate!=null) task.setStart(actualDate);
		for(Task subtask : task.getChildTasks())
			recursiveRandomizeTaskStart(subtask);
		exit();
	}
	
	@SuppressWarnings("deprecation")
	protected Date dateBetween(Date lower,Date upper) {
		if(lower==null || upper==null)
			return null;
		//UniformRealDistribution dist = new UniformRealDistribution(
		//		(double)lower.getDate(),(double)upper.getDate());
		int lowerDate = lower.getDate();
		int upperDate = upper.getDate();
		if(lowerDate == upperDate)
			upperDate = lowerDate +1;
		int randomDate = ThreadLocalRandom.current().nextInt(lowerDate,upperDate);
		Date result = new Date();
		result.setDate(randomDate);
		return result;
	}
	
	protected Duration durationBetween(Duration lower,Duration upper) {
		enter();
		if(lower!=null && upper!=null) {
			double lowerTime = lower.getDuration();
			double upperTime = upper.getDuration();
			if(upperTime == lowerTime)
				upperTime = lowerTime + 1;
			double randomTime = ThreadLocalRandom.current()
					.nextDouble(lowerTime, upperTime);
			//TODO:how to handle different time units?
			exit();
			return Duration.getInstance(randomTime, lower.getUnits());
		} else {
			exit();
			return null;
		}
	}
	
	protected void recursiveRandomizeTaskDuration(Task task) {
		enter();
		//TODO:modify to use different RVs... task.getText(1);
		Duration actualDuration = durationBetween(
			task.getDuration(1),task.getDuration(2));
		if(actualDuration!=null) task.setDuration(actualDuration);
		for(Task subtask : task.getChildTasks())
			recursiveRandomizeTaskDuration(subtask);
		exit();
	}
	
	protected void recursiveRandomizeTaskCost(Task task) {
		enter();
		//TODO: randomize cost...
		for(Task subtask : task.getChildTasks())
			recursiveRandomizeTaskCost(subtask);
		exit();
	}

	protected void initialize() {
		enter();
		//TODO:
		exit();
	}
	
	protected File report() throws IOException {
		enter();
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yy");
		//generate header lines
		String header1 = String.format("%12s","start");
		String header2 = String.format("%12s","end");
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(start);
		Date tmp = calendar.getTime();
		while(tmp.before(end)) {
			header1 += String.format(", %8s",formatter.format(tmp));
			calendar.add(step,1);
			tmp = calendar.getTime();
			header2 += String.format(", %8s",formatter.format(tmp));
		}
		
		//open temp file for writing trial data
		File output = File.createTempFile("tmp", ".cvs");
		debug("Writing trial {} results to {}.",trial,output);
		FileWriter writer = new FileWriter(output);
		writer.append(header1 + System.lineSeparator());
		debug(header1 + System.lineSeparator());
		writer.append(header2 + System.lineSeparator());
		debug(header2 + System.lineSeparator());
		for(Entry<String,Registers> entry : resources.entrySet()) {
			String line = String.format("%12s",entry.getKey());
			Registers registers = entry.getValue();
			for(double value : registers.getBuffer()) {
				line += ", " + String.format("%8.2f", value);
			}
			writer.append(line + System.lineSeparator());
			debug(line + System.lineSeparator());
		}
		writer.close();
		exit();
		return output;
	}
	
	protected class Registers {
		
		protected double[] buffer;
		
		public double[] getBuffer() {
			return buffer;
		}
		
		protected final Date start;
		
		protected final Date end;
		
		protected int step;
		
		public Registers(Date start,Date end,int step) {
			enter();
			this.start = start;
			this.end = end;
			this.step = step;
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(start);
			int count=0;
			Date tmp = start;
			while(tmp.before(end)) {
				count++;
				calendar.add(step,1);
				tmp = calendar.getTime();
			}
			buffer = new double[count];
			exit();
		}

		protected Date floor(Date date) {
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(date);
			int year = calendar.get(Calendar.YEAR);
			int month = calendar.get(Calendar.MONTH);
			int day = calendar.get(Calendar.DAY_OF_MONTH);
			calendar.set(year, month, day,0,0,0);
			return calendar.getTime();
		}
		
		protected Date ceiling(Date date) {
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(date);
			int year = calendar.get(Calendar.YEAR);
			int month = calendar.get(Calendar.MONTH);
			int day = calendar.get(Calendar.DAY_OF_MONTH);
			calendar.set(year, month, day,23,59,59);
			return calendar.getTime();
		}
		
		public void addBetween(double value, Date begin, Date finish) {
			enter();
			begin = floor(begin);
			finish = ceiling(finish);
			Calendar calendar = Calendar.getInstance();
			
			//cycle through bins until we reach start
			calendar.setTime(this.start);
			int count = 0;
			Date tmp = calendar.getTime();
			while(tmp.before(begin) && count<buffer.length) {
				count++;
				calendar.add(step,1);
				tmp = calendar.getTime();
			}
			
			//cycle through bins from start to finish and add value to each bin
			while(tmp.compareTo(finish)<=0 && count<buffer.length) {
				buffer[count] += value;
				count++;
				calendar.add(step,1);
				tmp = calendar.getTime();
			}
			exit();
		}
	}
}
