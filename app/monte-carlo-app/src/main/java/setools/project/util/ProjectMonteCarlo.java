/**
 * 
 */
package setools.project.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import picocli.CommandLine;
import picocli.CommandLine.Command;
import picocli.CommandLine.Option;
import picocli.CommandLine.Parameters;

/**
 * TODO:documentation
 */
@Command(name="simulate",description="Simulate a MS Project plan.")
public class ProjectMonteCarlo implements Runnable {
	
	protected class Registers {
		
		public final float[] max;
		
		public final float[] mean;
		
		public final float[] stdev;
		
		public final float[] sums;
		
		public Registers(int bins) {
			this.sums = new float[bins];
			this.max = new float[bins];
			this.mean = new float[bins];
			this.stdev = new float[bins];
		}
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ProjectMonteCarlo app = new ProjectMonteCarlo();
		CommandLine commandLine = new CommandLine(app);
		int status = -1;
		if(args.length>0) {
			status = commandLine.execute(args);
		} else {
			commandLine.usage(System.out);
		}
		System.exit(status);
	}
	
	protected static void zeroize(float[] array) {
		for(int x=0;x<array.length;x++)
			array[x] = 0.0f;
	}

	@Option(names= {"--end"},description="Set the simulation end date.")
	protected Date endDate = null;

	@Parameters(index="*",description="The MS Project plans to jointly simulate.")
	protected Set<File> inputs = new HashSet<File>();

	@Option(names= {"--threads"},description="Set the number of threads to use.")
	protected int numThreads = 16;
	
	@Option(names= {"-t","--trials"},description="Set the number of trials")
	protected int numTrials = 16; //TODO:set a better default
	
	@Option(names= {"-o","--output"},description="Set output file.")
	protected File output = new File("output.csv");
	
	protected final Map<String,Registers> registers;
	
	private ArrayList<Future<File>> results = new ArrayList<Future<File>>();
	
	@Option(names= {"--start"},description="Set the simulation start date.")
	protected Date startDate = null;
	
	@Option(names= {"--step"},description="Set the simulation step size.")
	protected int stepSize = Calendar.WEEK_OF_YEAR;
	
	@Option(names= {"--timeout"},description=
	"Set the time to wait for simulation completion.")
	protected int timeout = 600; //TODO:what is a good default?
	
	public ProjectMonteCarlo() {
		registers = new HashMap<String,Registers>();
	}
	
	protected void collectPass1(Set<File> inputs) throws IOException {
		
		//collect date bin summations and maximum values
		for(File input : inputs) {
			BufferedReader reader = new BufferedReader(new FileReader(input));
			
			//process header row(s)
			String line = reader.readLine();
			String[] parts = line.split(",");
			int columns = parts.length;
			//TODO:do we want to save any other header column info?
			line = reader.readLine(); //burn the second header row
			Iterator<String> iter = reader.lines().iterator();
			while(iter.hasNext()) {
				line = iter.next();
				parts = line.split(",");
				String resource = parts[0];
				Registers registers = this.registers.get(resource);
				if(registers==null) {
					registers = new Registers(columns-1);
					//TODO:do we need to zeroize registers?
					this.registers.put(resource, registers);
				}
				for(int column=1;column<columns;column++) {
					String text = parts[column];
					Float value = Float.valueOf(text);
					registers.sums[column-1] += value;
					if(registers.max[column-1] < value)
						registers.max[column-1] = value;
				}
			}
			reader.close();
		}
		
		//calculate date bin mean values
		float numTrials = (float)inputs.size();
		for(Registers register : registers.values()) {
			int length = register.sums.length;
			for(int bin=0;bin<length;bin++) {
				register.mean[bin] = register.sums[bin] / numTrials;
			}
		}
	}
	
	protected void collectPass2(Set<File> inputs) throws IOException {
		//zeroize sums
		for(Registers register : registers.values()) {
			zeroize(register.sums);
		}
				
		//collect date bin summations and maximum values
		for(File input : inputs) {
			BufferedReader reader = new BufferedReader(new FileReader(input));
			
			//process header row(s)
			String line = reader.readLine();
			String[] parts = line.split(",");
			int columns = parts.length;
			//TODO:do we want to save any other header column info?
			line = reader.readLine(); //burn the second header row
			Iterator<String> iter = reader.lines().iterator();
			while(iter.hasNext()) {
				line = iter.next();
				parts = line.split(",");
				String resource = parts[0];
				Registers registers = this.registers.get(resource);
				if(registers==null) {
					registers = new Registers(columns-1);
					//TODO:do we need to zeroize registers?
					this.registers.put(resource, registers);
				}
				for(int column=1;column<columns;column++) {
					String text = parts[column];
					Float value = Float.valueOf(text);
					registers.sums[column-1] += Math.pow(value - registers.mean[column-1],2.0);
				}
			}
			reader.close();
		}
		
		//calculate date bin stdev values
		float numTrials = (float)inputs.size();
		for(Registers register : registers.values()) {
			int length = register.sums.length;
			for(int bin=0;bin<length;bin++) {
				register.stdev[bin] = (float)Math.sqrt(register.sums[bin]/numTrials);
			}
		}
	}
	
	protected void collectResults() throws IOException {
		Set<File> trials = new HashSet<File>();
		for(Future<File> result : results) {
			try {
				//TODO:should we test done?
				trials.add(result.get());
			} catch(Exception e) {
				//TODO:how should we handle trial errors? just report or quit?
				e.printStackTrace();
			}
		}
		collectPass1(trials);
		collectPass2(trials);
	}
	
	public Date getEnd() {
		return endDate;
	}
	
	public Set<File> getInputs() {
		return inputs;
	}
	
	public int getNumThreads() {
		return numThreads;
	}
	
	public int getNumTrials() {
		return numTrials;
	}
	
	public File getOutput() {
		return output;
	}
	
	public Date getStart() {
		return startDate;
	}
	
	public int getStep() {
		return stepSize;
	}
	
	public int getTimeout() {
		return timeout;
	}
	
	protected void initialize() {
		//TODO:
	}
	
	protected void reportSimulationResults() throws IOException {
		FileWriter writer = new FileWriter(getOutput());
		//write headers
		String header1 = "start";
		String header2 = "end";
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(getStart());
		Date prev = calendar.getTime();
		Date end = getEnd();
		int step = getStep();
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yy");
		while(prev.compareTo(end)<=0) {
			calendar.add(step, 1);
			Date tmp = calendar.getTime();
			header1 += ", " + formatter.format(prev);
			header2 += ", " + formatter.format(tmp);
			prev = tmp;
		}
		header1 += System.lineSeparator();
		header2 += System.lineSeparator();
		
		for(Entry<String,Registers> entry : registers.entrySet()) {
			String name = entry.getKey();
			Registers register = entry.getValue();
			
			//write headers
			writer.append("Statistics for " + name + System.lineSeparator());
			writer.append(header1);
			writer.append(header2);
			
			//write resource statstics
			String means = "mean";
			String stdevs = "stdev";
			String maximum = "maximum";
			int length = register.sums.length;
			for(int bin=0;bin<length;bin++) {
				means += ", " + String.valueOf(register.mean[bin]);
				stdevs += ", " + String.valueOf(register.stdev[bin]);
				maximum += ", " + String.valueOf(register.max[bin]);
			}
			writer.append(means + System.lineSeparator());
			writer.append(stdevs + System.lineSeparator());
			writer.append(maximum + System.lineSeparator());
			writer.append(System.lineSeparator());
		}
		writer.close();
	}
	
	@Override
	public void run() {
		try {
			initialize();
			simulate();
			collectResults();
			reportSimulationResults();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void setEnd(Date date) {
		//TODO:validate date?
		endDate = date;
	}
	
	public void setNumThreads(int threads) {
		assert(threads>=1 && threads<32); //TODO:what is a realistic upper limit?
		numThreads = threads;
	}
	
	public void setNumTrials(int trials) {
		assert(trials>=1); //TODO:what is an appropriate lowest limit?
		numTrials = trials;
	}
		
	public void setOutput(File output) {
		this.output = output;
	}
	
	public void setStart(Date date) {
		startDate = date;
	}
	
	public void setStep(int step) {
		//TODO:validate step...
		stepSize = step;
	}
	
	public void setTimeout(int seconds) {
		assert(seconds>0); //TODO:should there be an upper limit to wait?
		this.timeout = seconds;
	}
	
	protected void simulate() throws InterruptedException {
		ExecutorService executor = Executors.newFixedThreadPool(getNumThreads());
		Set<File> inputs = getInputs();
		for(int trial=1;trial<getNumTrials();trial++) {
			ProjectMonteCarloTrial task = new ProjectMonteCarloTrial(
					trial,inputs,getStart(),getEnd(),getStep());
			results.add(executor.submit(task));
		}
		executor.shutdown();
		executor.awaitTermination(getTimeout(),TimeUnit.SECONDS);
	}
}
