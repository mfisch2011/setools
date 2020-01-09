/**
 */
package setools.mbpe.util;

import org.eclipse.emf.ecore.resource.Resource;

import org.eclipse.emf.ecore.xmi.XMIResource;

/**
 * <!-- begin-user-doc --> The resource associated with the
 * '<em><b>mbpe</b></em>' package. <!-- end-user-doc -->
 * 
 * @generated
 */
public interface MbpeResource extends XMIResource {
	/**
	 * <!-- begin-user-doc --> The factory for '<em><b>mbpe</b></em>' resources.
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public interface Factory extends Resource.Factory {

		/**
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		public static final Factory INSTANCE = new MbpeResourceFactoryImpl();

	}

	/**
	 * <!-- begin-user-doc --> The file extension for '<em><b>mbpe</b></em>'
	 * resources. <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public static final String FILE_EXTENSION = "uml";

	/**
	 * <!-- begin-user-doc --> The default encoding for '<em><b>mbpe</b></em>'
	 * resources. <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public static final String DEFAULT_ENCODING = "UTF-8";

	/**
	 * TODO:
	 * 
	 * @generated false
	 */
	public static final String PROFILES_PATHMAP = "pathmap://MBPE_PROFILES";

	/**
	 * TODO:
	 * 
	 * @generated false
	 */
	public static final String LIBRARIES_PATHMAP = "pathmap://MBPE_LIBRARIES";

	/**
	 * TODO:
	 * 
	 * @generated false
	 */
	public static final String PROFILE_PATH = PROFILES_PATHMAP + "mbpe.profile.uml";

	/**
	 * TODO:
	 * 
	 * @generated false
	 */
	public static final String PROFILE_URI = "http://setools/mbpe/0.1"; //$NON-NLS-1$

} // MbpeResource