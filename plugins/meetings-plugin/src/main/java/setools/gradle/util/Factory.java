/**
 * TODO: add NSWC Crane's license...
 */
package setools.gradle.util;

import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

@Retention(RUNTIME)
@Target(METHOD)
/**
 * TODO:add documentation...
 *
 */
public @interface Factory {

	/**
	 * TODO:add documentation...
	 * @return
	 */
	public String name() default "";
	
}
