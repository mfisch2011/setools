/**
 * TODO: add license...
 */
package setools.gradle.test;

import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

@Retention(RUNTIME)
@Target(METHOD)
/**
 * TODO: add documentation
 */
public @interface FunctionalTest {

	/** TODO:
	 * @return
	 */
	public String[] arguments() default {};
	
	/** TODO: documentation...
	 * @return
	 */
	public String build() default "";
	
	/** TODO: documentation...
	 * @return
	 */
	public String settings() default "";
	
	/** TODO: documentation...
	 * @return
	 */
	public String resources()  default "";
	
	/** TODO: documentation...
	 * @return
	 */
	public String properties() default "";
	
	//TODO:gradle home
}
