/**
 * 
 */
package setools.gradle.test;

import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

@Retention(RUNTIME)
@Target(METHOD)
/**
 * TODO:
 */
public @interface FunctionalTest {

	/**
	 * The pathname for test project resources.
	 * 
	 * @return {@link java.lang.String}
	 */
	public String resources() default "";

	/**
	 * The text for the project build.gradle file.
	 * 
	 * @return {@link java.lang.String}
	 */
	public String build() default "";
	
	/**
	 * The text for the project settings.gradle file.
	 * 
	 * @return {@link java.lang.String}
	 */
	public String settings() default "";
	
	/**
	 * The text for the project gradle.properties file.
	 * 
	 * @return {@link java.lang.String}
	 */
	public String properties() default "";
	
	/**
	 * The command line arguments to pass to the test build.
	 * 
	 * @return {@link java.lang.String}[]
	 */
	public String[] arguments() default {};
}
