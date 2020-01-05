/**
 */
package setools.mbpe.impl;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.util.EObjectResolvingEList;

import setools.mbpe.CreationProcedure;
import setools.mbpe.ManufacturedMaterial;
import setools.mbpe.MbpePackage;

/**
 * <!-- begin-user-doc --> An implementation of the model object
 * '<em><b>Creation Procedure</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 * <li>{@link setools.mbpe.impl.CreationProcedureImpl#getEnd_item <em>End
 * item</em>}</li>
 * </ul>
 *
 * @generated
 */
public abstract class CreationProcedureImpl extends ProcedureImpl implements CreationProcedure {
	/**
	 * The cached value of the '{@link #getEnd_item() <em>End item</em>}' reference
	 * list. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getEnd_item()
	 * @generated
	 * @ordered
	 */
	protected EList<ManufacturedMaterial> end_item;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected CreationProcedureImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return MbpePackage.Literals.CREATION_PROCEDURE;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EList<ManufacturedMaterial> getEnd_item() {
		if (end_item == null) {
			end_item = new EObjectResolvingEList<ManufacturedMaterial>(ManufacturedMaterial.class, this,
					MbpePackage.CREATION_PROCEDURE__END_ITEM);
		}
		return end_item;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
		case MbpePackage.CREATION_PROCEDURE__END_ITEM:
			return getEnd_item();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
		case MbpePackage.CREATION_PROCEDURE__END_ITEM:
			return end_item != null && !end_item.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} // CreationProcedureImpl
