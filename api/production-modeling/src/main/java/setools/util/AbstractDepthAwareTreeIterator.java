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
package setools.util;

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

	protected int depth = 0;
	
	public AbstractDepthAwareTreeIterator(Object object, boolean includeRoot) {
		super(object, includeRoot);
	}

	@Override
	public int getDepth() {
		return depth;
	}

	public T next()
	{
		// If we are still on the root mapping itself...
		//
		if(data == null)
		{
	      // Yield that mapping, create a stack, record it as the next one to prune, and add it to the stack.
	      //
	      nextPruneIterator = getChildren(object);
	      add(nextPruneIterator);
	      if (includeRoot)
	      {
	        @SuppressWarnings("unchecked") T result = (T)object;
	        depth = 0;
	        return result;
	      }
	    }
	    
	    // Get the top iterator, retrieve it's result, and record it as the one to which remove will be delegated.
	    //
	    @SuppressWarnings("unchecked") Iterator<? extends T> currentIterator = (Iterator<? extends T>)data[size - 1];
	    T result = currentIterator.next();
	    depth = size;
	    nextRemoveIterator = currentIterator;

	    // If the result about to be returned has children...
	    //
	    Iterator<? extends T> iterator = getChildren(result);
	    if (iterator.hasNext())
	    {
	      // Record the iterator as the next one to prune, and add it to the stack.
	      //
	      nextPruneIterator = iterator;
	      add(iterator);
	    }
	    else
	    {
	      // There will be no iterator to prune.
	      //
	      nextPruneIterator = null;

	      // While the current iterator has no next...
	      //
	      while (!currentIterator.hasNext())
	      {
	        // Pop it from the stack.
	        //
	        data[--size] = null;

	        // If the stack is empty, we're done.
	        //
	        if (isEmpty())
	        {
	          break;
	        }

	        // Get the next one down and then test it for has next.
	        //
	        @SuppressWarnings("unchecked") Iterator<? extends T> nextIterator = (Iterator<? extends T>)data[size - 1];
	        currentIterator = nextIterator;
	      }
	    }
	    return result;
	  }
}
