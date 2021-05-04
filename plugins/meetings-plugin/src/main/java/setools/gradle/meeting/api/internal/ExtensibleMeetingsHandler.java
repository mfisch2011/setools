/**
 * 
 */
package setools.gradle.meeting.api.internal;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

import org.gradle.api.Project;
import org.gradle.internal.metaobject.DynamicInvokeResult;
import org.gradle.internal.metaobject.MethodAccess;
import org.gradle.internal.metaobject.MethodMixIn;

import groovy.lang.Closure;
import setools.gradle.meeting.api.Meeting;

/**
 * TODO:documentation...
 */
public class ExtensibleMeetingsHandler extends DefaultMeetingHandler implements MethodMixIn {

	/**
	 * TODO:documentation...
	 */
	protected final MethodRegistry methodRegistry;

	public ExtensibleMeetingsHandler(Project project) {
		super(project);
		methodRegistry = new MethodRegistry();
	}
	
	/**
	 * TODO:documentation...
	 * @param function
	 */
	@SuppressWarnings("rawtypes")
	public void register(String name,Function<Closure,Meeting> function) {
		methodRegistry.register(name,function);
	}

	@Override
	public MethodAccess getAdditionalMethods() {
		return methodRegistry;
	}

	/**
	 * TODO:documentation...
	 */
	private class MethodRegistry implements MethodAccess {
		
		/**
		 * TODO:documentation...
		 */
		@SuppressWarnings("rawtypes")
		protected final Map<String,Function<Closure,Meeting>> functions =
			new HashMap<String,Function<Closure,Meeting>>();
		
		@Override
		public boolean hasMethod(String name, Object... arguments) {
			return arguments.length == 1 && functions.containsKey(name);
		}

		/**
		 * TODO:documentation...
		 * @param name
		 * @param function
		 */
		@SuppressWarnings("rawtypes")
		public void register(String name, Function<Closure, Meeting> function) {
			functions.put(name,function);
		}

		@SuppressWarnings("rawtypes")
		@Override
		public DynamicInvokeResult tryInvokeMethod(String name, Object... arguments) {
			if(arguments.length!=1) {
				return DynamicInvokeResult.notFound();
			}
			Function<Closure, Meeting> function = functions.get(name);
			if(function!=null && arguments[0] instanceof Closure) {
				Meeting meeting = function.apply((Closure)arguments[0]);
				add(meeting);
			}
			return DynamicInvokeResult.found();
		}
	}
}
