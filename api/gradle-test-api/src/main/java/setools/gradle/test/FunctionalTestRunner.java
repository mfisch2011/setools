/**
 * 
 */
package setools.gradle.test;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.file.Files;
import org.gradle.testkit.runner.BuildResult;
import org.gradle.testkit.runner.GradleRunner;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.Description;
import org.junit.runner.Runner;
import org.junit.runner.notification.Failure;
import org.junit.runner.notification.RunNotifier;

/**
 * TODO:
 */
public class FunctionalTestRunner extends Runner {

	/**
	 * TODO:add documentation...
	 */
	@SuppressWarnings("rawtypes")
	private Class testClass;
	
	/**
	 * TODO:add documentation...
	 * @param testClass
	 */
	@SuppressWarnings("rawtypes")
	public FunctionalTestRunner(Class testClass) {
		this.testClass = testClass;
	}
	
	@Override
	public Description getDescription() {
		return Description.createTestDescription(testClass,
				"Gradle functional test runner.");
	}
	
    @SuppressWarnings("unchecked")
	@Override
    public void run(RunNotifier notifier) {
    	Constructor<?> constructor = null;
    	Object instance = null;
		try {
			constructor = testClass.getConstructor();
	    	instance = constructor.newInstance();
	    	for(Method method : testClass.getMethods()) {
	    		Description description = Description.createTestDescription(testClass, method.getName());
	    		Ignore ignored = method.getAnnotation(Ignore.class);
	    		if(ignored==null) {
	    			FunctionalTest context = method
	    					.getAnnotation(FunctionalTest.class);
	    			if(context!=null) {
	    				try {
							File dir = setupTest(context);
							executeTest(method,instance,context,dir);
						} catch (IOException | AssertionError e) {
							Failure failure = new Failure(description,e);
							notifier.fireTestFailure(failure);
						}
	    				
	    			} else {
	    				Test test = method.getAnnotation(Test.class);
	    				if(test!=null) {
	    					//TODO:pass to Runner???
	    					notifier.fireTestIgnored(description);
	    				}
	    			}
	    		} else {
	    			//TODO:add method to message???
	    			notifier.fireTestIgnored(description);
	    		}
	    	}
		} catch (Throwable e) {
			throw new RuntimeException(e);
		} finally {
			//TODO:clean up???
		}
    }

	/**
	 * Execute the test build and call method on instance to validate 
	 * the results.
	 * 
	 * @param method - {@link java.lang.reflect.Method} to execute to 
	 * validate the test build
	 * @param instance - the test object to use for validation
	 * @param testContext - the {@link setools.gradle.test.FunctionalTest} 
	 * with the test context
	 * @param dir - {@link java.io.File} for the project directory
	 * @throws InvocationTargetException - error running validation method
	 * @throws IllegalArgumentException - illegal arguments passed to method
	 * @throws IllegalAccessException - error running validation method 
	 */
	protected void executeTest(Method method, Object instance, FunctionalTest testContext, File dir) throws
	Throwable {
		BuildResult result = GradleRunner.create()
				.withProjectDir(dir)
				.withPluginClasspath()
				.withArguments(testContext.arguments())
				.build();
		//TODO:make method arguments flexible...
		Object[] args = {result,dir};
		try {
			method.invoke(instance,args);
		} catch(InvocationTargetException e) {
			throw e.getCause();
		}
	}

	/**
	 * Create and configure the test project directory as specified 
	 * by context.
	 * 
	 * @param context - the {@link setools.gradle.test.FunctionalTest} 
	 * with the test context
	 * @return {@link java.io.File}
	 * @throws IOException - error initialing test project directory
	 */
	protected File setupTest(FunctionalTest context) throws IOException {
		File dir = Files.createTempDirectory("tmp").toFile();
		dir.deleteOnExit(); //in case we get interrupted...
		String encoding = System.getProperty("file.encoding");
		if(!isNullOrEmpty(context.resources())) {
			copyResources(dir,context.resources());
		}
		
		if(!isNullOrEmpty(context.build())) {
			File buildGradle = new File(dir,"build.gradle");
			Files.write(buildGradle.toPath(),context.build().getBytes(encoding));
		}
		
		if(!isNullOrEmpty(context.settings())) {
			File buildGradle = new File(dir,"settings.gradle");
			Files.write(buildGradle.toPath(),context.settings().getBytes(encoding));
		}
		
		if(!isNullOrEmpty(context.properties())) {
			File buildGradle = new File(dir,"gradle.properties");
			Files.write(buildGradle.toPath(),context.properties().getBytes(encoding));
		}
		
		return dir;
	}

	/**
	 * Copy file resources from resources to dir.
	 * 
	 * @param dir - destination {@link java.io.File}
	 * @param pathname - {@link java.lang.String} location for source files
	 * @throws IOException - error copying resources
	 */
	protected void copyResources(File dir, String pathname) throws IOException {
		//TODO:copy resources from pathname to dir
	}

	/**
	 * Test if text is null or empty.
	 * 
	 * @param text - {@link String} to test
	 * @return boolean
	 */
	protected static boolean isNullOrEmpty(String text) {
		return text==null || text.isEmpty();
	}
}
