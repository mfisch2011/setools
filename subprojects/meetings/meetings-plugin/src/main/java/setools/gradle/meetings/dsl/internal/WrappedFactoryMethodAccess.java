/**
 * Copyright 2021 M. Fischer <mfisch2011@gmail.com>
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
package setools.gradle.meetings.dsl.internal;

import java.util.Collection;

import org.gradle.api.Action;
import org.gradle.internal.metaobject.DynamicInvokeResult;
import org.gradle.internal.metaobject.MethodAccess;

import groovy.lang.Closure;
import setools.gradle.util.FactoryServicePlugin;

/**
 * TODO:
 */
public class WrappedFactoryMethodAccess<T> implements MethodAccess {

	/**
	 * TODO:
	 */
	protected final FactoryServicePlugin<String, T> factories;
	
	/**
	 * TODO:
	 */
	protected final Collection<T> collection;

	/**
	 * TODO: add documentation...
	 * @param factories - {@link FactoryServicePlugin} with factory methods
	 * @param collection - {@link Collection} to add new objects to 
	 */
	public WrappedFactoryMethodAccess(FactoryServicePlugin<String,T> factories,Collection<T> collection) {
		this.factories = factories;
		this.collection = collection;
	}

	@Override
	public boolean hasMethod(String key, Object... args) {
		if(!factories.contains(key)) return false;
		if(args.length==0) {
			return true;
		} else if(args.length==1) {
			Class<?> type = args[0].getClass();
			if(Closure.class.isAssignableFrom(type))
				return true;
			else if(Action.class.isAssignableFrom(type))
				return true;
		}
		return false;
	}

	@SuppressWarnings({ "rawtypes", "unchecked" }) //TODO:how to avoid this...
	@Override
	public DynamicInvokeResult tryInvokeMethod(String key, Object... args) {
		if(!factories.contains(key)) return DynamicInvokeResult.notFound();
		if(args.length==0) {
			T result = factories.build(key);
			collection.add(result);
			return DynamicInvokeResult.found(result);
		} else if(args.length==1) {
			Class<?> type = args[0].getClass();
			if(Closure.class.isAssignableFrom(type)) {
				T result = factories.build(key,(Closure)args[0]);
				collection.add(result);
				return DynamicInvokeResult.found(result);
			} else if(Action.class.isAssignableFrom(type)) {
				T result = factories.build(key,(Action<T>)args[0]);
				collection.add(result);
				return DynamicInvokeResult.found(result);
			}
		}
		return DynamicInvokeResult.notFound();
	}

}
