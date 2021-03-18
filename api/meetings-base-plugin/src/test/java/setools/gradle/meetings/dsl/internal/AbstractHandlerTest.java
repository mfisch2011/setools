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

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

/**
 * TODO:documentation...
 */
public abstract class AbstractHandlerTest<T> {

	/**
	 * TODO:documentation...
	 * @return
	 */
	protected abstract T newObjectInstance();
	
	/**
	 * TODO:documentation...
	 * @return
	 */
	protected abstract Collection<T> newHandlerInstance();
	
	/**
	 * Test method for {@link setools.gradle.meetings.dsl.internal.AbstractHandler#size()}.
	 */
	@Test
	void testSize() {
		Collection<T> collection = newHandlerInstance();
		assertNotNull(collection);
		assertEquals(0,collection.size());
		collection.add(newObjectInstance());
		collection.add(newObjectInstance());
		collection.add(newObjectInstance());
		assertEquals(3,collection.size());
	}

	/**
	 * Test method for {@link setools.gradle.meetings.dsl.internal.AbstractHandler#isEmpty()}.
	 */
	@Test
	void testIsEmpty() {
		Collection<T> collection = newHandlerInstance();
		assertNotNull(collection);
		assertTrue(collection.isEmpty());
		collection.add(newObjectInstance());
		assertFalse(collection.isEmpty());
		collection.clear();
		assertTrue(collection.isEmpty());
	}

	/**
	 * Test method for {@link setools.gradle.meetings.dsl.internal.AbstractHandler#contains(java.lang.Object)}.
	 */
	@Test
	void testContains() {
		Collection<T> collection = newHandlerInstance();
		assertNotNull(collection);
		T object1 = newObjectInstance();
		T object2 = newObjectInstance();
		assertFalse(collection.contains(object1));
		assertFalse(collection.contains(object2));
		collection.add(object1);
		assertTrue(collection.contains(object1));
		assertFalse(collection.contains(object2));
		collection.add(object2);
		assertTrue(collection.contains(object1));
		assertTrue(collection.contains(object2));
		collection.remove(object1);
		assertFalse(collection.contains(object1));
		assertTrue(collection.contains(object2));
		collection.remove(object2);
		assertFalse(collection.contains(object1));
		assertFalse(collection.contains(object2));
	}

	/**
	 * Test method for {@link setools.gradle.meetings.dsl.internal.AbstractHandler#iterator()}.
	 */
	@Test
	void testIterator() {
		Collection<T> collection = newHandlerInstance();
		assertNotNull(collection);
		T object1 = newObjectInstance();
		collection.add(object1);
		T object2 = newObjectInstance();
		collection.add(object2);
		//TODO:what if the collection is not ordered?
		Iterator<T> iter = collection.iterator();
		assertNotNull(iter);
		assertEquals(object1,iter.next());
		assertTrue(iter.hasNext());
		assertEquals(object2,iter.next());
		assertFalse(iter.hasNext());
	}

	/**
	 * Test method for {@link setools.gradle.meetings.dsl.internal.AbstractHandler#toArray()}.
	 */
	@Test
	void testToArray() {
		Collection<T> collection = newHandlerInstance();
		assertNotNull(collection);
		T object1 = newObjectInstance();
		collection.add(object1);
		T object2 = newObjectInstance();
		collection.add(object2);
		Object[] array = collection.toArray();
		assertNotNull(array);
		assertEquals(2,array.length);
		//TODO:what about an unordered collection?
		assertEquals(object1,array[0]);
		assertEquals(object2,array[1]);
	}

	/**
	 * Test method for {@link setools.gradle.meetings.dsl.internal.AbstractHandler#toArray(T[])}.
	 */
	@Disabled //TODO:how to create empty generic array?
	@Test
	void testToArrayTArray() {
		Collection<T> collection = newHandlerInstance();
		assertNotNull(collection);
		T object1 = newObjectInstance();
		collection.add(object1);
		T object2 = newObjectInstance();
		collection.add(object2);
		//TODO: T[] array = collection.toArray(new T[]{});
		//TODO: assertNotNull(array);
		//TODO: assertEquals(2,array.length);
		//TODO:what about an unordered collection?
		//TODO: assertEquals(object1,array[0]);
		//TODO: assertEquals(object2,array[1]);
	}

	/**
	 * Test method for {@link setools.gradle.meetings.dsl.internal.AbstractHandler#add(java.lang.Object)}.
	 */
	@Test
	void testAdd() {
		Collection<T> collection = newHandlerInstance();
		assertNotNull(collection);
		T object1 = newObjectInstance();
		collection.add(object1);
		assertTrue(collection.contains(object1));
	}

	/**
	 * Test method for {@link setools.gradle.meetings.dsl.internal.AbstractHandler#remove(java.lang.Object)}.
	 */
	@Test
	void testRemove() {
		Collection<T> collection = newHandlerInstance();
		assertNotNull(collection);
		T object1 = newObjectInstance();
		collection.add(object1);
		assertTrue(collection.contains(object1));
		collection.remove(object1);
		assertFalse(collection.contains(object1));
	}

	/**
	 * Test method for {@link setools.gradle.meetings.dsl.internal.AbstractHandler#containsAll(java.util.Collection)}.
	 */
	@Test
	void testContainsAll() {
		Collection<T> collection = newHandlerInstance();
		assertNotNull(collection);
		assertTrue(collection.isEmpty());
		T object1 = newObjectInstance();
		T object2 = newObjectInstance();
		ArrayList<T> tst = new ArrayList<T>();
		tst.add(object1);
		tst.add(object2);
		assertFalse(collection.containsAll(tst));
		collection.add(object1);
		assertFalse(collection.containsAll(tst));
		collection.add(object2);
		assertTrue(collection.containsAll(tst));
		collection.remove(object1);
		assertFalse(collection.containsAll(tst));
		collection.remove(object2);
		assertFalse(collection.containsAll(tst));
	}

	/**
	 * Test method for {@link setools.gradle.meetings.dsl.internal.AbstractHandler#addAll(java.util.Collection)}.
	 */
	@Test
	void testAddAll() {
		Collection<T> collection = newHandlerInstance();
		assertNotNull(collection);
		assertTrue(collection.isEmpty());
		T object1 = newObjectInstance();
		T object2 = newObjectInstance();
		ArrayList<T> tst = new ArrayList<T>();
		tst.add(object1);
		tst.add(object2);
		assertFalse(collection.containsAll(tst));
		collection.addAll(tst);
		assertTrue(collection.containsAll(tst));
		collection.remove(object1);
		assertFalse(collection.containsAll(tst));
		collection.remove(object2);
		assertFalse(collection.containsAll(tst));
	}

	/**
	 * Test method for {@link setools.gradle.meetings.dsl.internal.AbstractHandler#removeAll(java.util.Collection)}.
	 */
	@Test
	void testRemoveAll() {
		Collection<T> collection = newHandlerInstance();
		assertNotNull(collection);
		assertTrue(collection.isEmpty());
		T object1 = newObjectInstance();
		T object2 = newObjectInstance();
		ArrayList<T> tst = new ArrayList<T>();
		tst.add(object1);
		tst.add(object2);
		assertFalse(collection.containsAll(tst));
		collection.addAll(tst);
		assertTrue(collection.containsAll(tst));
		collection.removeAll(tst);
		assertFalse(collection.containsAll(tst));
	}

	/**
	 * Test method for {@link setools.gradle.meetings.dsl.internal.AbstractHandler#retainAll(java.util.Collection)}.
	 */
	@Test
	void testRetainAll() {
		Collection<T> collection = newHandlerInstance();
		assertNotNull(collection);
		assertTrue(collection.isEmpty());
		T object1 = newObjectInstance();
		T object2 = newObjectInstance();
		T object3 = newObjectInstance();
		ArrayList<T> tst = new ArrayList<T>();
		tst.add(object1);
		tst.add(object2);
		collection.add(object1);
		assertTrue(collection.contains(object1));
		collection.add(object2);
		assertTrue(collection.contains(object2));
		collection.add(object3);
		assertTrue(collection.contains(object3));
		collection.retainAll(tst);
		assertTrue(collection.contains(object1));
		assertTrue(collection.contains(object2));
		assertFalse(collection.contains(object3));
		collection.removeAll(tst);
		assertFalse(collection.containsAll(tst));
	}

	/**
	 * Test method for {@link setools.gradle.meetings.dsl.internal.AbstractHandler#clear()}.
	 */
	@Test
	void testClear() {
		Collection<T> collection = newHandlerInstance();
		assertNotNull(collection);
		assertEquals(0,collection.size());
		collection.add(newObjectInstance());
		collection.add(newObjectInstance());
		collection.add(newObjectInstance());
		assertEquals(3,collection.size());
		collection.clear();
		assertTrue(collection.isEmpty());
	}

}
