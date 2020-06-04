/**
 */
package setools.risk.util;

import org.eclipse.emf.common.util.URI;

import org.eclipse.emf.ecore.resource.Resource;

import org.eclipse.emf.ecore.resource.impl.ResourceFactoryImpl;

/**
 * <!-- begin-user-doc --> The <b>Resource Factory</b> associated with the
 * package. <!-- end-user-doc -->
 * 
 * @see setools.risk.util.RiskResourceImpl
 * @generated
 */
public class RiskResourceFactoryImpl extends ResourceFactoryImpl implements RiskResource.Factory {
	/**
	 * Creates an instance of the resource factory. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 */
	public RiskResourceFactoryImpl() {
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
		RiskResource result = new RiskResourceImpl(uri);
		result.setEncoding(RiskResource.DEFAULT_ENCODING);
		return result;
	}

} // RiskResourceFactoryImpl
