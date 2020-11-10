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

import net.sf.mpxj.Duration;
import net.sf.mpxj.ProjectFile;
import net.sf.mpxj.Resource;
import net.sf.mpxj.ResourceAssignment;
import net.sf.mpxj.Task;
import net.sf.mpxj.reader.UniversalProjectReader;

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
		initialize();
		for(File input : inputs) {
			UniversalProjectReader reader = new UniversalProjectReader();
			ProjectFile project = reader.read(input);
			randomize(project);
			adjust(project);
			collect(project);
		}
		return report();
	}
	
	protected void collect(ProjectFile project) {
		//TODO:
		for(Resource resource : project.getResources()) {
			collect(resource);
		}
	}
	
	protected void collect(Resource resource) {
		String name = resource.getName();
		Registers registers = resources.get(name);
		if(registers==null) {
			registers = new Registers(start,end,step);
			resources.put(name, registers);
		}
		for(ResourceAssignment assignment : resource.getTaskAssignments()) {
			registers.addBetween(assignment.getWork(),
			assignment.getStart(),assignment.getFinish());
		}
	}
	
	protected void adjust(ProjectFile project) {
		//TODO:
	}
	
	protected void randomize(ProjectFile project) {
		for(Task task : project.getTasks()) {
			recursiveRandomizeTaskStart(task);
			recursiveRandomizeTaskDuration(task);
			recursiveRandomizeTaskCost(task);
		}
	}
	
	protected void recursiveRandomizeTaskStart(Task task) {
		//TODO:enable different RV types...
		Date actualDate = dateBetween(task.getDate(1),task.getDate(2));
		if(actualDate!=null) task.setStart(actualDate);
		for(Task subtask : task.getChildTasks())
			recursiveRandomizeTaskStart(subtask);
	}
	
	protected Date dateBetween(Date start,Date end) {
		if(start!=null && end!=null) {
			long startMillis = start.getTime();
			long endMillis = end.getTime();
			long randomMillis = ThreadLocalRandom.current()
					.nextLong(startMillis, endMillis);
			return new Date(randomMillis);
		} else {
			return null;
		}
	}
	
	protected Duration durationBetween(Duration lower,Duration upper) {
		if(lower!=null && upper!=null) {
			double lowerTime = lower.getDuration();
			double upperTime = upper.getDuration();
			if(upperTime == lowerTime)
				upperTime = lowerTime + 1;
			double randomTime = ThreadLocalRandom.current()
					.nextDouble(lowerTime, upperTime);
			//TODO:how to handle different time units?
			return Duration.getInstance(randomTime, lower.getUnits());
		} else {
			return null;
		}
	}
	
	protected void recursiveRandomizeTaskDuration(Task task) {
		//TODO:modify to use different RVs... task.getText(1);
		Duration actualDuration = durationBetween(
			task.getDuration(1),task.getDuration(2));
		if(actualDuration!=null) task.setDuration(actualDuration);
		for(Task subtask : task.getChildTasks())
			recursiveRandomizeTaskDuration(subtask);
	}
	
	protected void recursiveRandomizeTaskCost(Task task) {
		//TODO: randomize cost...
		for(Task subtask : task.getChildTasks())
			recursiveRandomizeTaskCost(subtask);
	}

	protected void initialize() {
		//TODO:
	}
	
	protected File report() throws IOException {
		//generate header lines
		String header1 = "start";
		String header2 = "end";
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yy");
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(start);
		Date tmp = calendar.getTime();		
		while(tmp.before(end)) {
			header1 += ", " + formatter.format(tmp);
			calendar.add(1, step);
			header2 += ", " + formatter.format(tmp);
		}
		
		//open temp file for writing trial data
		File output = File.createTempFile("tmp", ".cvs");
		FileWriter writer = new FileWriter(output);
		writer.append(header1 + System.lineSeparator());
		writer.append(header2 + System.lineSeparator());
		for(Entry<String,Registers> entry : resources.entrySet()) {
			String line = entry.getKey();
			Registers registers = entry.getValue();
			for(double value : registers.getBuffer()) {
				line += ", " + String.format("%6.2f", value);
			}
			writer.append(line + System.lineSeparator());
		}
		writer.close();
		System.out.printf("Data for trial #%d to %s%n", trial,output);
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
			this.start = start;
			this.end = end;
			this.step = step;
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(start);
			int count=0;
			Date tmp = start;
			while(tmp.before(end)) {
				count++;
				calendar.add(1, step);
				tmp = calendar.getTime();
			}
			buffer = new double[count];
		}

		public void addBetween(Duration work, Date start, Date finish) {
			double value = work.getDuration(); //TODO:how to handle TimeUnits?
			Calendar calendar = Calendar.getInstance();
			
			//cycle through bins until we reach start
			calendar.setTime(this.start);
			int count = 0;
			Date tmp = calendar.getTime();
			while(tmp.before(start)) {
				count++;
				calendar.add(1, step);
				tmp = calendar.getTime();
			}
			
			//cycle through bins from start to finish and add value to each bin
			while(tmp.before(end)) {
				buffer[count] += value;
				count++;
				calendar.add(1, step);
				tmp = calendar.getTime();
			}
		}
		
	}
}
