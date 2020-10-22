/**
 * TODO:license...
 */
package setools.gradle.meetings.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Constructor;
import java.net.URL;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import setools.gradle.dsl.agenda.AgendaItem;
import setools.gradle.dsl.meeting.Meeting;

/**
 * TODO:documentation...
 */
public class SlideGeneratorService {
	
	/**
	 * TODO:documentation...
	 */
	private static Map<String,Set<Class<? extends SlideGenerator>>> 
		slideGenerators = initializeGenerators();

	/**
	 * TODO:documentation...
	 * @param format
	 * @param topic
	 * @return
	 */
	public static Class<? extends SlideGenerator> getTaskType(String format,AgendaItem topic) {
		String fmt = format.toLowerCase();
		if(slideGenerators.containsKey(fmt)) {
			Set<Class<? extends SlideGenerator>> generators = slideGenerators.get(fmt);
			
			//try classes first
			Class<?> type = topic.getClass();
			Class<? extends SlideGenerator> result = getGenerator(type,generators);
			if(result!=null) return result;
			
			//next try interfaces
			for(Class<?> iface : type.getInterfaces()) {
				result = getGenerator(iface,generators);
				if(result!=null) return result;
			}
		}
		return null;
	}

	/**
	 * TODO:documentation...
	 * @param type
	 * @param generators
	 * @return
	 */
	private static Class<? extends SlideGenerator> getGenerator(Class<?> type,
			Set<Class<? extends SlideGenerator>> generators) {
		if(type==null) return null;
		
		//try type first
		for(Class<? extends SlideGenerator> generator : generators) {
			try {
				Constructor<?> constructor = generator.getConstructor(Meeting.class,type);
				if(constructor!=null) return generator;
			} catch (NoSuchMethodException | SecurityException e) {
				//quietly ignore and keep searching...
			}
		}
		//now try super type
		return getGenerator(type.getSuperclass(),generators);
	}

	/**
	 * TODO:documentation...
	 * 
	 * TODO: HOW TO MAKE THIS DYNAMIC AND EXTENSIBLE SINCE THE GRADLE 
	 * DEVELOPMENT TEAM SUCKS AND HAS MADE GRADLE IN SUCH A WAY THAT 
	 * IT IS INCOMPATIBLE WITH ServiceLoader!!!!!!
	 * 
	 * @return
	 */
	@SuppressWarnings("unchecked")
	private static Map<String, Set<Class<? extends SlideGenerator>>> initializeGenerators() {
		Map<String,Set<Class<? extends SlideGenerator>>> results = 
				new HashMap<String,Set<Class<? extends SlideGenerator>>>();
		
		//TODO:HOW TO MAKE THIS WORK SINCE GRADLE FUCKS UP CLASS LOADING!!!!!!!
		
		try {
			Enumeration<URL> resources = ClassLoader.getSystemResources(
				"META-INF/services/setools.gradle.meetings.util.SlideGenerator");
			Iterator<URL> iter = resources.asIterator();
			while(iter.hasNext()) {
				URL url = iter.next();
				System.out.printf("READING: %s%n", url);
				InputStream stream = url.openStream();
				BufferedReader reader = new BufferedReader(new InputStreamReader(stream));
				Iterator<String> lines = reader.lines().iterator();
				while(lines.hasNext()) {
					String line = lines.next();
					String[] parts = line.split(",");
					if(parts.length==2) {
						String format = parts[0].trim();
						String name = parts[1].trim();
						try {
							Class<?> type = Class.forName(name);
							Set<Class<? extends SlideGenerator>> generators;
							if(results.containsKey(format))
								generators = results.get(format);
							else {
								generators = new HashSet<Class<? extends SlideGenerator>>();
								results.put(format, generators);
							}
							System.out.printf("ADDING GENERATOR: %s - %s%n", format,type.getName());
							generators.add((Class<? extends SlideGenerator>) type);
						} catch (ClassNotFoundException e) {
							e.printStackTrace();
						}
					}
				}
				stream.close();
			}
		} catch(IOException e) {
			e.printStackTrace();
		}
		return results;
	}
	
	@SuppressWarnings("unchecked")
	public static void reinitialize(ClassLoader classloader) {
		try {
			slideGenerators.clear();
			Enumeration<URL> resources = classloader.getResources(
				"META-INF/services/setools.gradle.meetings.util.SlideGenerator");
			Iterator<URL> iter = resources.asIterator();
			while(iter.hasNext()) {
				URL url = iter.next();
				InputStream stream = url.openStream();
				BufferedReader reader = new BufferedReader(new InputStreamReader(stream));
				Iterator<String> lines = reader.lines().iterator();
				while(lines.hasNext()) {
					String line = lines.next();
					String[] parts = line.split(",");
					if(parts.length==2) {
						String format = parts[0].trim();
						String name = parts[1].trim();
						try {
							Class<?> type = Class.forName(name);
							Set<Class<? extends SlideGenerator>> generators;
							if(slideGenerators.containsKey(format))
								generators = slideGenerators.get(format);
							else {
								generators = new HashSet<Class<? extends SlideGenerator>>();
								slideGenerators.put(format, generators);
							}
							generators.add((Class<? extends SlideGenerator>) type);
						} catch (ClassNotFoundException e) {
							e.printStackTrace();
						}
					}
				}
				stream.close();
			}
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
}
