/**
 * TODO:license...
 */
package setools.gradle.meetings.util.internal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Constructor;
import java.net.URL;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import org.gradle.api.DefaultTask;
import org.gradle.api.Project;
import org.gradle.api.internal.project.ProjectInternal;

import setools.gradle.meetings.util.SlideGenerator;

/**
 * TODO:documentation...
 */
public class DefaultSlideGeneratorService implements setools.gradle.meetings.util.SlideGeneratorService {
	
	/**
	 * TODO:documentation...
	 */
	protected final Map<String,Set<Class<? extends DefaultTask>>> generators;
	
	/**
	 * TODO:documentation...
	 */
	protected final Project project;
	
	public DefaultSlideGeneratorService(Project project) {
		this.project = project;
		this.generators = new HashMap<String,Set<Class<? extends DefaultTask>>>();
		initialize((ProjectInternal)project);
	}
	
	/**
	 * TODO:documentation...
	 * @param format
	 * @return
	 */
	protected Set<Class<? extends DefaultTask>> generators(String format) {
		if(generators.containsKey(format)) {
			return generators.get(format);
		} else {
			Set<Class<? extends DefaultTask>> set = new HashSet<Class<? extends DefaultTask>>();
			generators.put(format, set);
			return set;
		}
	}

	@Override
	public Set<String> getSupportedFormats() {
		return generators.keySet();
	}

	@Override
	public Set<Class<? extends DefaultTask>> getGenerators() {
		Set<Class<? extends DefaultTask>> results = new HashSet<Class<? extends DefaultTask>>();
		for(Set<Class<? extends DefaultTask>> set : generators.values())
			results.addAll(set);
		return results;
	}

	@Override
	public Set<Class<? extends DefaultTask>> getGenerators(String format,Class<?>...types) {
		Set<Class<? extends DefaultTask>> results = new HashSet<Class<? extends DefaultTask>>();
		for(Class<? extends DefaultTask> type : generators(format)) {
			if(matchesArguments(type,types))
				results.add(type);
		}
		return results;
	}
	
	/**
	 * TODO:documentation...
	 * @param type
	 * @param objects
	 * @return
	 */
	protected boolean matchesArguments(Class<? extends DefaultTask> type,Class<?>...types) {
		ArrayList<Class<?>> tmpTypes = new ArrayList<Class<?>>();
		for(Class<?> A : types) tmpTypes.add(A);
		project.getLogger().info("Searching for constructor with: {}",tmpTypes);
		for(Constructor<?> constructor : type.getConstructors()) {
			project.getLogger().info("Constructor for {} has: {}.",
				type.getName(),constructor.getParameterTypes());
		}
		try {
			return type.getConstructor(types)!=null;
		} catch (NoSuchMethodException | SecurityException e) { }
		return false;
	}

	@SuppressWarnings("unchecked")
	public void initialize(ProjectInternal project) {
		String pathname = "META-INF/services/setools.gradle.meetings.util.SlideGenerator";
		Enumeration<URL> enumeration;
		try {
			project.getLogger().info("Collecting resources for {}.",pathname);
			enumeration = project.getClassLoaderScope()
					.getLocalClassLoader().getResources(pathname);
			while(enumeration.hasMoreElements()) {
				try {
					URL resource = enumeration.nextElement();
					project.getLogger().info("Loading slide generators from {}",resource);
					InputStream iStream = resource.openStream();
					BufferedReader reader = new BufferedReader(new InputStreamReader(iStream));
					Iterator<String> lines = reader.lines().iterator();
					while(lines.hasNext()) {
						String line = lines.next();
						String[] parts = line.split(",");
						String format = parts[0];
						String classname = parts[1].trim();
						Class<? extends DefaultTask> type;
						try {
							type = (Class<? extends DefaultTask>) Class.forName(classname);
							project.getLogger().info("Adding {} for {}.",
								type.getName(),format);
							generators(format).add(type);
						} catch (ClassNotFoundException e) {
							project.getLogger().warn("Error adding '{}'.",classname);
							project.getLogger().trace("Error adding slide generator.", e);
						}
					}
				} catch(IOException e) {
					project.getLogger().trace("Error loading slide generators.",e);
				}
			}
		} catch (IOException e) {
			project.getLogger().trace("Error collecting slide generator resources.",e);
		}
	}
}
