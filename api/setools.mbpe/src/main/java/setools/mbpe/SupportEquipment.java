/**
 */
package setools.mbpe;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>Support
 * Equipment</b></em>'. <!-- end-user-doc -->
 *
 * <!-- begin-model-doc --> How to indicate that this is NOT procurable, i.e.
 * remove manufacturer/seller??? <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 * <li>{@link setools.mbpe.SupportEquipment#getFabrication_procedure
 * <em>Fabrication procedure</em>}</li>
 * </ul>
 *
 * @see setools.mbpe.MbpePackage#getSupportEquipment()
 * @model annotation="http://www.eclipse.org/uml2/2.0.0/UML
 *        originalName='Support Equipment'"
 * @generated
 */
public interface SupportEquipment extends Equipment {
	/**
	 * Returns the value of the '<em><b>Fabrication procedure</b></em>' reference
	 * list. The list contents are of type {@link setools.mbpe.CreationProcedure}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Fabrication procedure</em>' reference list isn't
	 * clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Fabrication procedure</em>' reference list.
	 * @see setools.mbpe.MbpePackage#getSupportEquipment_Fabrication_procedure()
	 * @model ordered="false"
	 * @generated
	 */
	EList<CreationProcedure> getFabrication_procedure();

} // SupportEquipment
