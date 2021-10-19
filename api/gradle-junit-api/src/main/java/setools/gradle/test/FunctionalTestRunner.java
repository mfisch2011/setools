/**
 * TODO: add license...
 */
package setools.gradle.test;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.charset.Charset;
import java.nio.file.Files;

import org.gradle.testkit.runner.BuildResult;
import org.gradle.testkit.runner.GradleRunner;

import org.junit.Ignore;
import org.junit.runner.Description;
import org.junit.runner.Runner;
import org.junit.runner.notification.Failure;
import org.junit.runner.notification.RunNotifier;
/**
 * TODO: add documentation...
 */
public class FunctionalTestRunner extends Runner {
	
	/**
	 * TODO:
	 */
	protected Class<?> testClass;

	/** TODO:
	 * @param clazz
	 */
	public FunctionalTestRunner(Class<?> clazz) {
		this.testClass = clazz;
	}

	@Override
	public Description getDescription() {
		return Description
        .createTestDescription(testClass, "My runner description");
	}

	@Override
	public void run(RunNotifier notifier) {
		try {
			Object instance = newInstance();
			for (Method method : testClass.getMethods()) {
				Description description = Description.createTestDescription(testClass, method.getName());
	            FunctionalTest annotation = method.getAnnotation(FunctionalTest.class);
                if(annotation!=null && !method.isAnnotationPresent(Ignore.class)) {
                    notifier.fireTestStarted(description);
                    File dir = setupTest(annotation);
                    try {
                    	BuildResult result = GradleRunner.create()
                    		.withProjectDir(dir)
                    		.withPluginClasspath() //TODO:make configurable????
                    		.withArguments(annotation.arguments())
                    		.build();
                    	//TODO:enable methods without standard params?
                    	//TODO:enable static methods...
                    	method.invoke(instance,dir,result);
                    } catch(AssertionError e) {
                    	Failure failure = new Failure(description,e);
                    	notifier.fireTestFailure(failure);
                    } finally {
                        dir.delete(); //TODO:recursion???
                        notifier.fireTestFinished(Description.createTestDescription(testClass, method.getName()));
                    }
                }
            }
        } catch (Exception e) {
        	throw new RuntimeException(e);
        }
	}

	/** TODO: documentation
	 * @param annotation
	 * @return
	 * @throws IOException 
	 */
	protected File setupTest(FunctionalTest annotation) throws IOException {
		File tmp = Files.createTempDirectory("tmp").toFile();
		tmp.deleteOnExit(); // in case we get interrupted...
		
		//TODO: copy resources first so we can override with other values...
		if(!isNullOrEmpty(annotation.resources())) {
			
		}
		
		//create build.gradle
		if(!isNullOrEmpty(annotation.build())) {
			File build = new File(tmp,"build.gradle");
			String text = annotation.build();
			Files.write(build.toPath(),text.getBytes(Charset.defaultCharset()));
		}
		
		//create settings.gradle
		if(!isNullOrEmpty(annotation.settings())) {
			File build = new File(tmp,"settings.gradle");
			String text = annotation.settings();
			Files.write(build.toPath(),text.getBytes(Charset.defaultCharset()));
		}
		
		//create gradle.properties
		if(!isNullOrEmpty(annotation.properties())) {
			File build = new File(tmp,"gradle.properties");
			String text = annotation.properties();
			Files.write(build.toPath(),text.getBytes(Charset.defaultCharset()));
		}
		
		return tmp;
	}
	
	/** TODO: documentation...
	 * @param text
	 * @return
	 */
	protected static boolean isNullOrEmpty(String text) {
		return text==null || text.isEmpty();
	}

	/** TODO:
	 * @return
	 * @throws SecurityException 
	 * @throws NoSuchMethodException 
	 * @throws InvocationTargetException 
	 * @throws IllegalArgumentException 
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 */
	protected Object newInstance() throws 
	NoSuchMethodException, SecurityException, InstantiationException, 
	IllegalAccessException, IllegalArgumentException, 
	InvocationTargetException {
		//TODO:support non-empty constructors?
		Constructor<?> constructor = testClass.getConstructor(); 
       return constructor.newInstance();
	}

}
