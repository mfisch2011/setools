/**
 */
package setools.mbpe;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

import org.eclipse.uml2.uml.Behavior;

/**
 * <!-- begin-user-doc --> A representation of the model object
 * '<em><b>Procedure</b></em>'. <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 * <li>{@link setools.mbpe.Procedure#getBase_Behavior <em>Base
 * Behavior</em>}</li>
 * <li>{@link setools.mbpe.Procedure#getEquipment <em>Equipment</em>}</li>
 * <li>{@link setools.mbpe.Procedure#getMaterial <em>Material</em>}</li>
 * </ul>
 *
 * @see setools.mbpe.MbpePackage#getProcedure()
 * @model abstract="true"
 * @generated
 */
public interface Procedure extends EObject {
	/**
	 * Returns the value of the '<em><b>Base Behavior</b></em>' reference. <!--
	 * begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Base Behavior</em>' reference isn't clear, there
	 * really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Base Behavior</em>' reference.
	 * @see #setBase_Behavior(Behavior)
	 * @see setools.mbpe.MbpePackage#getProcedure_Base_Behavior()
	 * @model ordered="false"
	 * @generated
	 */
	Behavior getBase_Behavior();

	/**
	 * Sets the value of the '{@link setools.mbpe.Procedure#getBase_Behavior
	 * <em>Base Behavior</em>}' reference. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @param value the new value of the '<em>Base Behavior</em>' reference.
	 * @see #getBase_Behavior()
	 * @generated
	 */
	void setBase_Behavior(Behavior value);

	/**
	 * Returns the value of the '<em><b>Equipment</b></em>' reference list. The list
	 * contents are of type {@link setools.mbpe.Equipment}. This feature is a
	 * derived union. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Equipment</em>' reference list isn't clear, there
	 * really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Equipment</em>' reference list.
	 * @see setools.mbpe.MbpePackage#getProcedure_Equipment()
	 * @model transient="true" changeable="false" volatile="true" derived="true"
	 *        ordered="false" annotation="union"
	 * @generated
	 */
	EList<Equipment> getEquipment();

	/**
	 * Returns the value of the '<em><b>Material</b></em>' reference list. The list
	 * contents are of type {@link setools.mbpe.Material}. This feature is a derived
	 * union. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Material</em>' reference list isn't clear, there
	 * really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Material</em>' reference list.
	 * @see setools.mbpe.MbpePackage#getProcedure_Material()
	 * @model transient="true" changeable="false" volatile="true" derived="true"
	 *        ordered="false" annotation="union"
	 * @generated
	 */
	EList<Material> getMaterial();

} // Procedure
