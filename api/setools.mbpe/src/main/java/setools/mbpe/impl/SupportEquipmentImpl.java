/**
 */
package setools.mbpe.impl;

import java.util.Collection;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.util.EObjectResolvingEList;

import setools.mbpe.CreationProcedure;
import setools.mbpe.MbpePackage;
import setools.mbpe.SupportEquipment;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Support
 * Equipment</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 * <li>{@link setools.mbpe.impl.SupportEquipmentImpl#getFabrication_procedure
 * <em>Fabrication procedure</em>}</li>
 * </ul>
 *
 * @generated
 */
public class SupportEquipmentImpl extends EquipmentImpl implements SupportEquipment {
	/**
	 * The cached value of the '{@link #getFabrication_procedure() <em>Fabrication
	 * procedure</em>}' reference list. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @see #getFabrication_procedure()
	 * @generated
	 * @ordered
	 */
	protected EList<CreationProcedure> fabrication_procedure;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected SupportEquipmentImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return MbpePackage.Literals.SUPPORT_EQUIPMENT;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EList<CreationProcedure> getFabrication_procedure() {
		if (fabrication_procedure == null) {
			fabrication_procedure = new EObjectResolvingEList<CreationProcedure>(CreationProcedure.class, this,
					MbpePackage.SUPPORT_EQUIPMENT__FABRICATION_PROCEDURE);
		}
		return fabrication_procedure;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
		case MbpePackage.SUPPORT_EQUIPMENT__FABRICATION_PROCEDURE:
			return getFabrication_procedure();
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
		case MbpePackage.SUPPORT_EQUIPMENT__FABRICATION_PROCEDURE:
			getFabrication_procedure().clear();
			getFabrication_procedure().addAll((Collection<? extends CreationProcedure>) newValue);
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
		case MbpePackage.SUPPORT_EQUIPMENT__FABRICATION_PROCEDURE:
			getFabrication_procedure().clear();
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
		case MbpePackage.SUPPORT_EQUIPMENT__FABRICATION_PROCEDURE:
			return fabrication_procedure != null && !fabrication_procedure.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} // SupportEquipmentImpl
