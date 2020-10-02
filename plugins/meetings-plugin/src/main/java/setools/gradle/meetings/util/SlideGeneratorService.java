/**
 * TODO:license...
 */
package setools.gradle.meetings.util;

import java.lang.reflect.Constructor;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import setools.gradle.dsl.agenda.AgendaItem;
import setools.gradle.dsl.meeting.Meeting;
import setools.gradle.meetings.task.pptx.GenerateSectionSlide;
import setools.gradle.meetings.task.pptx.GenerateTitleAndContentSlide;
import setools.gradle.meetings.task.pptx.GenerateTitleOnlySlide;
import setools.gradle.meetings.task.pptx.GenerateTitleSlide;

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
		if(slideGenerators.containsKey(format)) {
			Set<Class<? extends SlideGenerator>> generators = slideGenerators.get(format);
			
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
	private static Map<String, Set<Class<? extends SlideGenerator>>> initializeGenerators() {
		Map<String,Set<Class<? extends SlideGenerator>>> results = 
				new HashMap<String,Set<Class<? extends SlideGenerator>>>();
		
		//pptx format
		Set<Class<? extends SlideGenerator>> generators = 
				new HashSet<Class<? extends SlideGenerator>>();
		results.put(".pptx", generators);
		generators.add(GenerateSectionSlide.class);
		generators.add(GenerateTitleAndContentSlide.class);
		generators.add(GenerateTitleOnlySlide.class);
		generators.add(GenerateTitleSlide.class);
		
		return results;
	}
}
