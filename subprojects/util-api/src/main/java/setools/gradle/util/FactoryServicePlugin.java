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
package setools.gradle.util;

import java.util.HashMap;
import java.util.Map;

import org.gradle.api.Action;

import groovy.lang.Closure;

/**
 * TODO:
 */
public class FactoryServicePlugin<K,T> extends ServicePlugin {

	/**
	 * TODO:
	 */
	protected final Map<K,Factory<T>> factories =
			new HashMap<K,Factory<T>>();

	/**
	 * TODO:
	 * @param id
	 * @param factory
	 */
	public Factory<T> register(K id, Factory<T> factory) {
		return factories.put(id,factory);
	}
	
	/**
	 * TODO:
	 * @param id
	 * @return
	 */
	public Factory<T> unregister(K id) {
		return factories.remove(id);
	}

	/**
	 * TODO:
	 * @param id
	 * @return
	 */
	public T build(K id) {
		Factory<T> factory = factories.get(id);
		if(factory!=null) {
			return factory.build();
		} else {
			//TODO:throw exception???
			return null;
		}
	}
	
	/**
	 * TODO:
	 * @param id
	 * @param closure
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	public T build(K id,Closure closure) {
		Factory<T> factory = factories.get(id);
		if(factory!=null) {
			return factory.build(closure);
		} else {
			//TODO:throw exception???
			return null;
		}
	}
	
	/**
	 * TODO:
	 * @param id
	 * @param action
	 * @return
	 */
	public T build(K id,Action<T> action) {
		Factory<T> factory = factories.get(id);
		if(factory!=null) {
			return factory.build(action);
		} else {
			//TODO:throw exception???
			return null;
		}
	}

	/**
	 * TODO:
	 * @param key
	 * @return
	 */
	public boolean contains(K key) {
		return factories.containsKey(key);
	}
}
