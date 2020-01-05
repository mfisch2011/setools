/**
 */
package setools.mbpe.util;

import org.eclipse.emf.common.util.URI;

import org.eclipse.emf.ecore.resource.Resource;

import org.eclipse.emf.ecore.resource.impl.ResourceFactoryImpl;

/**
 * <!-- begin-user-doc --> The <b>Resource Factory</b> associated with the
 * package. <!-- end-user-doc -->
 * 
 * @see setools.mbpe.util.MbpeResourceImpl
 * @generated
 */
public class MbpeResourceFactoryImpl extends ResourceFactoryImpl implements MbpeResource.Factory {
	/**
	 * Creates an instance of the resource factory. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 */
	public MbpeResourceFactoryImpl() {
		super();
	}

	/**
	 * Creates an instance of the resource. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public Resource createResource(URI uri) {
		MbpeResource result = new MbpeResourceImpl(uri);
		result.setEncoding(MbpeResource.DEFAULT_ENCODING);
		return result;
	}

} // MbpeResourceFactoryImpl
