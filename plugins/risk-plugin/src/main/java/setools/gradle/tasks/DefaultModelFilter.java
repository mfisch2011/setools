/**
 * TODO:license...
 */
package setools.gradle.tasks;

import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.gradle.api.specs.Spec;

/**
 * TODO:documentation...
 */
public class DefaultModelFilter implements ModelFilter {
	
	/**
	 * TODO:documentation...
	 */
	protected final Set<EObject> elements;
	
	/**
	 * TODO:documentation...
	 * @param resources
	 */
	public DefaultModelFilter(Resource...resources) {
		elements = new HashSet<EObject>();
		for(Resource resource : resources) {
			TreeIterator<EObject> iter = resource.getAllContents();
			while(iter.hasNext()) {
				elements.add(iter.next());
			}
		}
	}
	
	/**
	 * TODO:documentation...
	 * @param objects
	 */
	public DefaultModelFilter(Collection<EObject> objects) {
		elements = new HashSet<EObject>();
		elements.addAll(objects);
	}

	@Override
	public boolean add(EObject object) {
		return elements.add(object); //TODO:should this be disallowed?
	}

	@Override
	public boolean addAll(Collection<? extends EObject> objects) {
		return elements.addAll(objects);
	}

	@Override
	public void clear() {
		elements.clear();
	}

	@Override
	public boolean contains(Object object) {
		return elements.contains(object);
	}

	@Override
	public boolean containsAll(Collection<?> objects) {
		return elements.containsAll(objects);
	}

	@Override
	public boolean isEmpty() {
		return elements.isEmpty();
	}

	@Override
	public Iterator<EObject> iterator() {
		return elements.iterator();
	}

	@Override
	public boolean remove(Object object) {
		return elements.remove(object);
	}

	@Override
	public boolean removeAll(Collection<?> objects) {
		return elements.removeAll(objects);
	}

	@Override
	public boolean retainAll(Collection<?> objects) {
		return elements.retainAll(objects);
	}

	@Override
	public int size() {
		return elements.size();
	}

	@Override
	public Object[] toArray() {
		return elements.toArray();
	}

	@Override
	public <T> T[] toArray(T[] arg0) {
		return elements.toArray(arg0);
	}

	@Override
	public ModelFilter filter(Spec<EObject> spec) {
		Set<EObject> results = new HashSet<EObject>();
		for(EObject object : elements) {
			if(spec.isSatisfiedBy(object))
				results.add(object);
		}
		return new DefaultModelFilter(results);
	}

}
