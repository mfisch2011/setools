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
	 * TODO:
	 * @return
	 */
	public String resources() default "";

	/**
	 * TODO:
	 * @return
	 */
	public String build() default "";
	
	/**
	 * TODO:
	 * @return
	 */
	public String settings() default "";
	
	/**
	 * TODO:
	 * @return
	 */
	public String[] properties() default {};
	
	/**
	 * TODO:
	 * @return
	 */
	public String[] arguments() default {};
}
