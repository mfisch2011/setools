/**
 * Copyright 2022 M. Fischer <mfisch2011@gmail.com>
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package setools.gradle.util;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.Collection;
import java.util.Set;
import java.util.TreeSet;

import org.gradle.internal.metaobject.DynamicInvokeResult;
import org.gradle.internal.metaobject.MethodAccess;

/**
 * TODO:
 */
public abstract class ReflectiveMethodAccess implements MethodAccess {
	
	@Override
	public boolean hasMethod(String name, Object...args) {
		System.out.printf("Find handler for method '%s'.%n",name);
		Object handler = getHandler(name);
		if(handler!=null) {
			Class<?> type = handler.getClass();
			Class<?>[] params = getTypes(args);
			Method method = getMethod(type,params);
			if(method!=null) return true;
		}
		return false;
	}

	/**
	 * Get the registered handler to use.
	 * 
	 * @param name - handler to get
	 * @return - {@link Object} handler instance
	 */
	protected abstract Object getHandler(String name);
	
	/**
	 * Process a newly created and configured object.
	 * 
	 * @param result - newly configured object
	 * @throws IllegalArgumentException - incorrect result type
	 * @throws IllegalStateException - MeetingsPluginExt not registered
	 */
	protected abstract void onSuccess(Object result) throws IllegalArgumentException,IllegalStateException;

	@Override
	public DynamicInvokeResult tryInvokeMethod(String name, Object...args) {
		System.out.printf("Find handler for method '%s'.%n",name);
		Object handler = getHandler(name);
		if(handler!=null) {
			Class<?> type = handler.getClass();
			Class<?>[] params = getTypes(args);
			Method method = getMethod(type,params);
			if(method!=null) {
				try {
					Object result = method.invoke(handler,args);
					onSuccess(result);
					return DynamicInvokeResult.found(result);
				} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
					e.printStackTrace(); //TODO:how to log properly ????
				}
			}
		}
		return DynamicInvokeResult.notFound();
	}

	/**
	 * TODO:
	 * @param type
	 * @param params
	 * @return
	 */
	protected Method getMethod(Class<?> handler, Class<?>[] params) {
		for(Method method : getAllMethods(handler)) {
			if(parametersMatch(method.getParameters(),params))
				return method;
		}
		return null;
	}

	/**
	 * TODO:
	 * @param parameters
	 * @param params
	 * @return
	 */
	protected boolean parametersMatch(Parameter[] params1, Class<?>[] params2) {
		if(params1.length != params2.length) return false;
		for(int x=0;x<params1.length;x++) {
			if(!params1[x].getType().isAssignableFrom(params2[x]))
				return false;
		}
		return true;
	}

	/**
	 * TODO:
	 * @param handler
	 * @return
	 */
	protected Collection<Method> getAllMethods(Class<?> handler) {
		Set<Method> results = new TreeSet<Method>();
		getMethods(results,handler);
		return results;
	}

	/**
	 * TODO:
	 * @param results
	 * @param handler
	 */
	protected void getMethods(Set<Method> results, Class<?> handler) {
		//methods in handler
		for(Method method : handler.getMethods()) {
			results.add(method);
		}
		
		//methods in superclass
		if(handler.getSuperclass()!=null) {
			getMethods(results,handler.getSuperclass());
		}
		
		//methods in interfaces  TODO: do we need this since interface don't actually implement anything ???
		if(handler.getInterfaces()!=null) {
			for(Class<?> iface : handler.getInterfaces()) {
				getMethods(results,iface);
			}
		}
	}

	/**
	 * TODO:
	 * @param args
	 * @return
	 */
	protected Class<?>[] getTypes(Object...args) {
		Class<?>[] results = new Class<?>[args.length];
		for(int x=0;x<args.length;x++) {
			results[x] = args[x].getClass();
		}
		return results;
	}
	
}
