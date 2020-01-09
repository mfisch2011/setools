/**
 */
package setools.mbpe.impl;

import java.util.Collection;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.util.EObjectResolvingEList;

import org.eclipse.uml2.common.util.DerivedUnionEObjectEList;

import setools.mbpe.Equipment;
import setools.mbpe.MaintenanceProcedure;
import setools.mbpe.MbpePackage;
import setools.mbpe.OperatingProcedure;

/**
 * <!-- begin-user-doc --> An implementation of the model object
 * '<em><b>Equipment</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 * <li>{@link setools.mbpe.impl.EquipmentImpl#getOperating_procedure
 * <em>Operating procedure</em>}</li>
 * <li>{@link setools.mbpe.impl.EquipmentImpl#getMaintenance_procedure
 * <em>Maintenance procedure</em>}</li>
 * </ul>
 *
 * @generated
 */
public class EquipmentImpl extends ManufacturedMaterialImpl implements Equipment {
	/**
	 * The cached value of the '{@link #getMaintenance_procedure() <em>Maintenance
	 * procedure</em>}' reference list. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @see #getMaintenance_procedure()
	 * @generated
	 * @ordered
	 */
	protected EList<MaintenanceProcedure> maintenance_procedure;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected EquipmentImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return MbpePackage.Literals.EQUIPMENT;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EList<OperatingProcedure> getOperating_procedure() {
		return new DerivedUnionEObjectEList<OperatingProcedure>(OperatingProcedure.class, this,
				MbpePackage.EQUIPMENT__OPERATING_PROCEDURE, null);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EList<MaintenanceProcedure> getMaintenance_procedure() {
		if (maintenance_procedure == null) {
			maintenance_procedure = new EObjectResolvingEList<MaintenanceProcedure>(MaintenanceProcedure.class, this,
					MbpePackage.EQUIPMENT__MAINTENANCE_PROCEDURE);
		}
		return maintenance_procedure;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
		case MbpePackage.EQUIPMENT__OPERATING_PROCEDURE:
			return getOperating_procedure();
		case MbpePackage.EQUIPMENT__MAINTENANCE_PROCEDURE:
			return getMaintenance_procedure();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
		case MbpePackage.EQUIPMENT__MAINTENANCE_PROCEDURE:
			getMaintenance_procedure().clear();
			getMaintenance_procedure().addAll((Collection<? extends MaintenanceProcedure>) newValue);
			return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
		case MbpePackage.EQUIPMENT__MAINTENANCE_PROCEDURE:
			getMaintenance_procedure().clear();
			return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
		case MbpePackage.EQUIPMENT__OPERATING_PROCEDURE:
			return isSetOperating_procedure();
		case MbpePackage.EQUIPMENT__MAINTENANCE_PROCEDURE:
			return maintenance_procedure != null && !maintenance_procedure.isEmpty();
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public boolean isSetOperating_procedure() {
		return false;
	}

} // EquipmentImpl
