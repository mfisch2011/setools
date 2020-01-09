/**
   Copyright 2019 Matt Fischer <mfish2011@gmail.com>

   Licensed under the Apache License, Version 2.0 (the "License");
   you may not use this file except in compliance with the License.
   You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

   Unless required by applicable law or agreed to in writing, software
   distributed under the License is distributed on an "AS IS" BASIS,
   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
   See the License for the specific language governing permissions and
   limitations under the License.
*/
package setools.uml.util;

import java.util.Iterator;

import org.eclipse.emf.common.util.AbstractTreeIterator;

/**
 * @author matt
 *
 */
public abstract class AbstractDepthAwareTreeIterator<T> extends AbstractTreeIterator<T> implements DepthAwareTreeIterator<T> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected int depth;
	
	public AbstractDepthAwareTreeIterator(T object) {
		this(object,false);
	}
	
	public AbstractDepthAwareTreeIterator(Object object, boolean includeRoot) {
		super(object, includeRoot);
		depth = 0;
	}

	@Override
	public int getDepth() {
		return depth;
	}

	@Override
	protected Iterator<? extends T> getChildren(Object object) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public T next() {
		depth = size;
		return super.next();
	}

}
