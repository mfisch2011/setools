/**
 * 
 */
package setools.gradle.test;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.URL;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.util.Arrays;

import org.gradle.internal.impldep.org.apache.commons.io.FileUtils;
import org.junit.Ignore;
import org.junit.runner.Description;
import org.junit.runner.Runner;
import org.junit.runner.notification.Failure;
import org.junit.runner.notification.RunNotifier;
import org.gradle.testkit.runner.BuildResult;
import org.gradle.testkit.runner.GradleRunner;

/**
 * TODO:documentation...
 */
public class GradleTestRunner extends Runner {

	/**
	 * TODO:documentation...
	 */
	protected final Class<?> testClass;

	/**
	 * TODO:docuemntation...
	 * @param testClass
	 */
	public GradleTestRunner(Class<?> testClass) {
		this.testClass = testClass;
	}
	
	@Override
	public Description getDescription() {
		return Description.createTestDescription(
			testClass, "Gradle functional test.");
	}

	@Override
	public void run(RunNotifier notifier) {
		System.out.println("Running the GradleTests from: " + testClass);
		for(Method method : testClass.getMethods()) {
			GradleTest annotation = method.getAnnotation(GradleTest.class);
			Ignore ignore = method.getAnnotation(Ignore.class);
			Description desc = Description.createTestDescription(
					testClass, method.getName());
			try {
				if(annotation!=null && ignore==null) {
					executeTest(notifier,method,annotation,desc);
				} else if(annotation!=null && ignore!=null) {
					notifier.fireTestIgnored(desc);
				}
			} catch(Exception e) {
				Failure failure = new Failure(desc,e);
				notifier.fireTestFailure(failure);
			}
		}
	}

	/**
	 * TODO:documentation...
	 * @param notifier
	 * @param method
	 * @param testObject
	 * @param annotation
	 * @param desc
	 */
	protected void executeTest(RunNotifier notifier,
			Method method,
			GradleTest annotation,
			Description desc) throws Exception {
		Object testObject = testClass.getConstructor().newInstance();
		File tmpDir = initializeTest(annotation);
		invokeTest(notifier,method,testObject,tmpDir,annotation);
		tmpDir.delete();
	}

	/**
	 * TODO:documentation...
	 * @param notifier
	 * @param method
	 * @param testObject
	 * @param tmpDir
	 * @param annotation
	 * @throws InvocationTargetException 
	 * @throws IllegalArgumentException 
	 * @throws IllegalAccessException 
	 */
	protected void invokeTest(RunNotifier notifier, Method method,
			Object testObject, File tmpDir,GradleTest annotation) throws
	IllegalAccessException, IllegalArgumentException,
	InvocationTargetException {
		notifier.fireTestStarted(Description
			.createTestDescription(testClass, method.getName()));
		BuildResult result = GradleRunner.create()
				.withProjectDir(tmpDir)
				.withPluginClasspath()
				.withArguments(Arrays.asList(annotation.args()))
				.build();
		//TODO:make this more flexible...
		method.invoke(testObject,result,tmpDir);
		notifier.fireTestFinished(Description
			.createTestDescription(testClass, method.getName()));
	}

	/**
	 * TODO:documentation...
	 * @param annotation
	 * @return
	 * @throws IOException 
	 */
	protected File initializeTest(GradleTest annotation) throws IOException {
		File dir = Files.createTempDirectory("tmp").toFile();
		dir.deleteOnExit(); //mark for removal in case we puke
		
		//copy resources so that we can override from other attributes
		if(!isNullOrEmpty(annotation.resources())) {
			//TODO:add ability to copy from jar location...
			URL url = testClass.getResource(annotation.resources());
			File srcDir = new File(url.getPath());
			FileUtils.copyDirectory(srcDir, dir);
		}
		
		//copy build.gradle text
		if(!isNullOrEmpty(annotation.build())) {
			File buildGradle = new File(dir,"build.gradle");
			FileUtils.write(buildGradle, annotation.build(),
					Charset.forName("utf-8"));
		}
		
		//copy settings.gradle text
		if(!isNullOrEmpty(annotation.settings())) {
			File settingsGradle = new File(dir,"settings.gradle");
			FileUtils.write(settingsGradle, annotation.settings(),
					Charset.forName("utf-8"));
		}
		
		//copy gradle.properties text
		if(!isNullOrEmpty(annotation.properties())) {
			File gradleProperties = new File(dir,"gradle.properties");
			FileUtils.write(gradleProperties, annotation.properties(),
					Charset.forName("utf-8"));
		}
		
		return dir;
	}

	/**
	 * TODO:documentation...
	 * @param text
	 * @return
	 */
	protected static boolean isNullOrEmpty(String text) {
		return text==null || text.isEmpty();
	}
	
	/**
	 * TODO:documentation...
	 * @param dir
	 */
	public static void listFiles(File dir) {
		System.out.println(dir);
		File[] files = dir.listFiles();
		if(files!=null) {
			for(File file : files) {
				if(file.isDirectory())
					listFiles(file);
				else
					System.out.println(file);
			}
		}
	}
}
