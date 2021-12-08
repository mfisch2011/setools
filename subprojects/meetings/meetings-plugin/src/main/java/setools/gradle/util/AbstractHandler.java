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

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/**
 * TODO:
 */
public class AbstractHandler<T> implements Collection<T> {

	/**
	 * TODO:
	 */
	protected final Collection<T> collection =
			new ArrayList<T>(); //TODO:how to make this overrideable???

	@Override
	public int size() {
		return collection.size();
	}

	@Override
	public boolean isEmpty() {
		return collection.isEmpty();
	}

	@Override
	public boolean contains(Object o) {
		return collection.contains(o);
	}

	@Override
	public Iterator<T> iterator() {
		return collection.iterator();
	}

	@Override
	public Object[] toArray() {
		return collection.toArray();
	}

	@Override
	public <H> H[] toArray(H[] a) {
		return collection.toArray(a);
	}

	@Override
	public boolean add(T e) {
		return collection.add(e);
	}

	@Override
	public boolean remove(Object o) {
		return collection.remove(o);
	}

	@Override
	public boolean containsAll(Collection<?> c) {
		return collection.containsAll(c);
	}

	@Override
	public boolean addAll(Collection<? extends T> c) {
		return collection.addAll(c);
	}

	@Override
	public boolean removeAll(Collection<?> c) {
		return collection.removeAll(c);
	}

	@Override
	public boolean retainAll(Collection<?> c) {
		return collection.retainAll(c);
	}

	@Override
	public void clear() {
		collection.clear();
	}
		
}
