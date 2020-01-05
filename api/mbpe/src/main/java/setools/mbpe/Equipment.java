/**
 */
package setools.mbpe;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc --> A representation of the model object
 * '<em><b>Equipment</b></em>'. <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 * <li>{@link setools.mbpe.Equipment#getOperating_procedure <em>Operating
 * procedure</em>}</li>
 * <li>{@link setools.mbpe.Equipment#getMaintenance_procedure <em>Maintenance
 * procedure</em>}</li>
 * </ul>
 *
 * @see setools.mbpe.MbpePackage#getEquipment()
 * @model
 * @generated
 */
public interface Equipment extends ManufacturedMaterial {
	/**
	 * Returns the value of the '<em><b>Operating procedure</b></em>' reference
	 * list. The list contents are of type {@link setools.mbpe.OperatingProcedure}.
	 * This feature is a derived union. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Operating procedure</em>' reference list isn't
	 * clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Operating procedure</em>' reference list.
	 * @see setools.mbpe.MbpePackage#getEquipment_Operating_procedure()
	 * @model transient="true" changeable="false" volatile="true" derived="true"
	 *        ordered="false" annotation="union"
	 * @generated
	 */
	EList<OperatingProcedure> getOperating_procedure();

	/**
	 * Returns the value of the '<em><b>Maintenance procedure</b></em>' reference
	 * list. The list contents are of type
	 * {@link setools.mbpe.MaintenanceProcedure}. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Maintenance procedure</em>' reference list isn't
	 * clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Maintenance procedure</em>' reference list.
	 * @see setools.mbpe.MbpePackage#getEquipment_Maintenance_procedure()
	 * @model ordered="false"
	 * @generated
	 */
	EList<MaintenanceProcedure> getMaintenance_procedure();

} // Equipment
