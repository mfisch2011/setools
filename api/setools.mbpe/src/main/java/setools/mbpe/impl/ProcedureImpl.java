/**
 */
package setools.mbpe.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EcoreUtil;

import org.eclipse.uml2.common.util.DerivedUnionEObjectEList;

import org.eclipse.uml2.uml.Behavior;

import setools.mbpe.Equipment;
import setools.mbpe.Material;
import setools.mbpe.MbpePackage;
import setools.mbpe.Procedure;

/**
 * <!-- begin-user-doc --> An implementation of the model object
 * '<em><b>Procedure</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 * <li>{@link setools.mbpe.impl.ProcedureImpl#getEquipment
 * <em>Equipment</em>}</li>
 * <li>{@link setools.mbpe.impl.ProcedureImpl#getMaterial
 * <em>Material</em>}</li>
 * <li>{@link setools.mbpe.impl.ProcedureImpl#getBase_Behavior <em>Base
 * Behavior</em>}</li>
 * </ul>
 *
 * @generated
 */
public abstract class ProcedureImpl extends MinimalEObjectImpl.Container implements Procedure {
	/**
	 * The cached value of the '{@link #getBase_Behavior() <em>Base Behavior</em>}'
	 * reference. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getBase_Behavior()
	 * @generated
	 * @ordered
	 */
	protected Behavior base_Behavior;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected ProcedureImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return MbpePackage.Literals.PROCEDURE;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EList<Equipment> getEquipment() {
		return new DerivedUnionEObjectEList<Equipment>(Equipment.class, this, MbpePackage.PROCEDURE__EQUIPMENT, null);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EList<Material> getMaterial() {
		return new DerivedUnionEObjectEList<Material>(Material.class, this, MbpePackage.PROCEDURE__MATERIAL, null);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public Behavior getBase_Behavior() {
		if (base_Behavior != null && base_Behavior.eIsProxy()) {
			InternalEObject oldBase_Behavior = (InternalEObject) base_Behavior;
			base_Behavior = (Behavior) eResolveProxy(oldBase_Behavior);
			if (base_Behavior != oldBase_Behavior) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, MbpePackage.PROCEDURE__BASE_BEHAVIOR,
							oldBase_Behavior, base_Behavior));
			}
		}
		return base_Behavior;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public Behavior basicGetBase_Behavior() {
		return base_Behavior;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public void setBase_Behavior(Behavior newBase_Behavior) {
		Behavior oldBase_Behavior = base_Behavior;
		base_Behavior = newBase_Behavior;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MbpePackage.PROCEDURE__BASE_BEHAVIOR,
					oldBase_Behavior, base_Behavior));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
		case MbpePackage.PROCEDURE__EQUIPMENT:
			return getEquipment();
		case MbpePackage.PROCEDURE__MATERIAL:
			return getMaterial();
		case MbpePackage.PROCEDURE__BASE_BEHAVIOR:
			if (resolve)
				return getBase_Behavior();
			return basicGetBase_Behavior();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
		case MbpePackage.PROCEDURE__BASE_BEHAVIOR:
			setBase_Behavior((Behavior) newValue);
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
		case MbpePackage.PROCEDURE__BASE_BEHAVIOR:
			setBase_Behavior((Behavior) null);
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
		case MbpePackage.PROCEDURE__EQUIPMENT:
			return isSetEquipment();
		case MbpePackage.PROCEDURE__MATERIAL:
			return isSetMaterial();
		case MbpePackage.PROCEDURE__BASE_BEHAVIOR:
			return base_Behavior != null;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * Creates a new instance of the specified Ecore class. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @param eClass The Ecore class of the instance to create.
	 * @return The new instance.
	 * @generated
	 */
	protected EObject create(EClass eClass) {
		return EcoreUtil.create(eClass);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public boolean isSetEquipment() {
		return false;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public boolean isSetMaterial() {
		return false;
	}

} // ProcedureImpl
