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

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/**
 * TODO:documentation...
 */
public class AbstractHandler<K> implements Collection<K> {

	/**
	 * TODO:documentation...
	 */
	private ArrayList<K> storage = new ArrayList<K>();
	
	@Override
	public int size() {
		return storage.size();
	}

	@Override
	public boolean isEmpty() {
		return storage.isEmpty();
	}

	@Override
	public boolean contains(Object o) {
		return storage.contains(o);
	}

	@Override
	public Iterator<K> iterator() {
		return storage.iterator();
	}

	@Override
	public Object[] toArray() {
		return storage.toArray();
	}

	@Override
	public <T> T[] toArray(T[] a) {
		return storage.toArray(a);
	}

	@Override
	public boolean add(K e) {
		return storage.add(e);
	}

	@Override
	public boolean remove(Object o) {
		return storage.remove(o);
	}

	@Override
	public boolean containsAll(Collection<?> c) {
		return storage.containsAll(c);
	}

	@Override
	public boolean addAll(Collection<? extends K> c) {
		return storage.addAll(c);
	}

	@Override
	public boolean removeAll(Collection<?> c) {
		return storage.removeAll(c);
	}

	@Override
	public boolean retainAll(Collection<?> c) {
		return storage.retainAll(c);
	}

	@Override
	public void clear() {
		storage.clear();
	}
}
