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
package setools.risk.util;

import org.eclipse.emf.ecore.resource.Resource;

import org.eclipse.emf.ecore.xmi.XMIResource;

/**
 * <!-- begin-user-doc --> The resource associated with the
 * '<em><b>risk</b></em>' package. <!-- end-user-doc -->
 * 
 * @generated
 */
public interface RiskResource extends XMIResource {
	/**
	 * <!-- begin-user-doc --> The factory for '<em><b>risk</b></em>' resources.
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
		public static final Factory INSTANCE = new RiskResourceFactoryImpl();

	}

	/**
	 * <!-- begin-user-doc --> The file extension for '<em><b>risk</b></em>'
	 * resources. <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public static final String FILE_EXTENSION = "uml";

	/**
	 * <!-- begin-user-doc --> The default encoding for '<em><b>risk</b></em>'
	 * resources. <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public static final String DEFAULT_ENCODING = "UTF-8";

	public static final String PROFILES_PATHMAP = "pathmap://RISK_PROFILES/"; //$NON-NLS-1$

	public static final String PROFILE_PATH = PROFILES_PATHMAP + "risk.profile.uml"; //$NON-NLS-1$

	public static final String PROFILE_URI = "http://setools/setools/risk/0.0.6/RiskML"; //$NON-NLS-1$

	// public static final String LIBRARIES_PATHMAP = "pathmap://RISK_LIBRARIES/";
	// //$NON-NLS-1$

	// public static final String LIBRARY_PATH = LIBRARIES_PATHMAP +
	// "RiskML-Standard-Library.uml"; //$NON-NLS-1$

	// public static final String LIBRARY_ROOT_ID =
	// "SysML.package_packagedElement_Libraries"; //$NON-NLS-1$

	// public static final String QUDV_LIBRARY_PATH = LIBRARIES_PATHMAP +
	// "QUDV.uml"; //$NON-NLS-1$

	// public static final String QUDV_LIBRARY_ROOT_ID = "QUDV"; //$NON-NLS-1$

	// private static final String UNNAMED = "unnamed"; //$NON-NLS-1$

} // RiskResource