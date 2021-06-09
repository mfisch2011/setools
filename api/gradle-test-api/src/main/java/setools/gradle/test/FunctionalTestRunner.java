/**
 * 
 */
package setools.gradle.test;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.file.Files;
import java.util.Optional;

import org.gradle.testkit.runner.BuildResult;
import org.gradle.testkit.runner.GradleRunner;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.InvocationInterceptor;
import org.junit.jupiter.api.extension.ReflectiveInvocationContext;

/**
 * TODO:
 */
public class FunctionalTestRunner implements InvocationInterceptor {

    @Override
    public void interceptTestMethod(Invocation<Void> invocation,
            ReflectiveInvocationContext<Method> invocationContext,
            ExtensionContext extensionContext) throws Throwable {
    	Method method = invocationContext.getExecutable();
    	Optional<Object> instance = invocationContext.getTarget();
    	FunctionalTest testContext = method.getAnnotation(FunctionalTest.class);
    	if(testContext!=null) {
    		File dir = setupTest(testContext);
    		executeTest(method,instance,testContext,dir);
    		if(!dir.delete()) {
    			System.err.printf("Error removing '%s'.%n", dir);
    		}
    	}
    }

	/**
	 * TODO:
	 * @param method
	 * @param instance
	 * @param testContext
	 * @param dir
	 * @throws InvocationTargetException 
	 * @throws IllegalArgumentException 
	 * @throws IllegalAccessException 
	 */
	protected void executeTest(Method method, Optional<Object> instance, FunctionalTest testContext, File dir) throws
	IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		BuildResult result = GradleRunner.create()
				.withProjectDir(dir)
				.withPluginClasspath()
				.withArguments(testContext.arguments())
				.build();
		//TODO:make method arguments flexible...
		Object[] args = {result,dir};
		if(instance.isPresent()) {
			//invoke method using instance
			method.invoke(instance.get(),args);
		} else {
			//invoke method using null instance
			method.invoke(null, args);
		}
	}

	/**
	 * @param context
	 * @return
	 * @throws IOException 
	 */
	protected File setupTest(FunctionalTest context) throws IOException {
		File dir = Files.createTempDirectory("tmp").toFile();
		dir.deleteOnExit(); //in case we get interrupted...
		
		if(!isNullOrEmpty(context.resources())) {
			copyResources(dir,context.resources());
		}
		
		if(!isNullOrEmpty(context.build())) {
			File buildGradle = new File(dir,"build.gradle");
			Files.writeString(buildGradle.toPath(),context.build());
		}
		
		if(!isNullOrEmpty(context.settings())) {
			File buildGradle = new File(dir,"settings.gradle");
			Files.writeString(buildGradle.toPath(),context.settings());
		}
		
		if(context.properties()!=null && context.properties().length>0) {
			File buildGradle = new File(dir,"gradle.properties");
			String text = "";
			for(String property : context.properties()) {
				text += property + System.lineSeparator();
			}
			Files.writeString(buildGradle.toPath(),text);
		}
		
		return dir;
	}

	/**
	 * TODO:
	 * @param dir
	 * @param resources
	 */
	protected void copyResources(File dir, String pathname) {
		//TODO:copy resources from pathname to dir
	}

	/**
	 * Test if text is null or empty.
	 * @param text - {@link String} to test
	 * @return boolean
	 */
	protected static boolean isNullOrEmpty(String text) {
		return text==null || text.isEmpty();
	}
}
