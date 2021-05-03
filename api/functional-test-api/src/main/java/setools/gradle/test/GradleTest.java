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
 * TODO:documentation...
 */
public @interface GradleTest {

	/**
	 * TODO:documentation...
	 * @return
	 */
	String build() default "";
	
	/**
	 * TODO:documentation...
	 * @return
	 */
	String settings() default "";
	
	/**
	 * TODO:documentation...
	 * @return
	 */
	String properties() default "";
	
	/**
	 * TODO:documentation...
	 * @return
	 */
	String resources() default "";
	
	/**
	 * TODO:documentation...
	 * @return
	 */
	String[] args() default {};
}
