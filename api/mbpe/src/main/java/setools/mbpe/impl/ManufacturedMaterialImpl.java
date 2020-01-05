/**
 */
package setools.mbpe.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EcoreUtil;

import setools.mbpe.ManufacturedMaterial;
import setools.mbpe.MbpePackage;

/**
 * <!-- begin-user-doc --> An implementation of the model object
 * '<em><b>Manufactured Material</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 * <li>{@link setools.mbpe.impl.ManufacturedMaterialImpl#getBase_Class <em>Base
 * Class</em>}</li>
 * <li>{@link setools.mbpe.impl.ManufacturedMaterialImpl#getManfacturer
 * <em>Manfacturer</em>}</li>
 * <li>{@link setools.mbpe.impl.ManufacturedMaterialImpl#getPart_number <em>Part
 * number</em>}</li>
 * </ul>
 *
 * @generated
 */
public abstract class ManufacturedMaterialImpl extends MinimalEObjectImpl.Container implements ManufacturedMaterial {
	/**
	 * The cached value of the '{@link #getBase_Class() <em>Base Class</em>}'
	 * reference. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getBase_Class()
	 * @generated
	 * @ordered
	 */
	protected org.eclipse.uml2.uml.Class base_Class;

	/**
	 * The default value of the '{@link #getManfacturer() <em>Manfacturer</em>}'
	 * attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getManfacturer()
	 * @generated
	 * @ordered
	 */
	protected static final String MANFACTURER_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getManfacturer() <em>Manfacturer</em>}'
	 * attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getManfacturer()
	 * @generated
	 * @ordered
	 */
	protected String manfacturer = MANFACTURER_EDEFAULT;

	/**
	 * The default value of the '{@link #getPart_number() <em>Part number</em>}'
	 * attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getPart_number()
	 * @generated
	 * @ordered
	 */
	protected static final String PART_NUMBER_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getPart_number() <em>Part number</em>}'
	 * attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getPart_number()
	 * @generated
	 * @ordered
	 */
	protected String part_number = PART_NUMBER_EDEFAULT;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected ManufacturedMaterialImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return MbpePackage.Literals.MANUFACTURED_MATERIAL;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public org.eclipse.uml2.uml.Class getBase_Class() {
		if (base_Class != null && base_Class.eIsProxy()) {
			InternalEObject oldBase_Class = (InternalEObject) base_Class;
			base_Class = (org.eclipse.uml2.uml.Class) eResolveProxy(oldBase_Class);
			if (base_Class != oldBase_Class) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE,
							MbpePackage.MANUFACTURED_MATERIAL__BASE_CLASS, oldBase_Class, base_Class));
			}
		}
		return base_Class;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public org.eclipse.uml2.uml.Class basicGetBase_Class() {
		return base_Class;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public void setBase_Class(org.eclipse.uml2.uml.Class newBase_Class) {
		org.eclipse.uml2.uml.Class oldBase_Class = base_Class;
		base_Class = newBase_Class;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MbpePackage.MANUFACTURED_MATERIAL__BASE_CLASS,
					oldBase_Class, base_Class));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public String getManfacturer() {
		return manfacturer;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public void setManfacturer(String newManfacturer) {
		String oldManfacturer = manfacturer;
		manfacturer = newManfacturer;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MbpePackage.MANUFACTURED_MATERIAL__MANFACTURER,
					oldManfacturer, manfacturer));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public String getPart_number() {
		return part_number;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public void setPart_number(String newPart_number) {
		String oldPart_number = part_number;
		part_number = newPart_number;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MbpePackage.MANUFACTURED_MATERIAL__PART_NUMBER,
					oldPart_number, part_number));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
		case MbpePackage.MANUFACTURED_MATERIAL__BASE_CLASS:
			if (resolve)
				return getBase_Class();
			return basicGetBase_Class();
		case MbpePackage.MANUFACTURED_MATERIAL__MANFACTURER:
			return getManfacturer();
		case MbpePackage.MANUFACTURED_MATERIAL__PART_NUMBER:
			return getPart_number();
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
		case MbpePackage.MANUFACTURED_MATERIAL__BASE_CLASS:
			setBase_Class((org.eclipse.uml2.uml.Class) newValue);
			return;
		case MbpePackage.MANUFACTURED_MATERIAL__MANFACTURER:
			setManfacturer((String) newValue);
			return;
		case MbpePackage.MANUFACTURED_MATERIAL__PART_NUMBER:
			setPart_number((String) newValue);
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
		case MbpePackage.MANUFACTURED_MATERIAL__BASE_CLASS:
			setBase_Class((org.eclipse.uml2.uml.Class) null);
			return;
		case MbpePackage.MANUFACTURED_MATERIAL__MANFACTURER:
			setManfacturer(MANFACTURER_EDEFAULT);
			return;
		case MbpePackage.MANUFACTURED_MATERIAL__PART_NUMBER:
			setPart_number(PART_NUMBER_EDEFAULT);
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
		case MbpePackage.MANUFACTURED_MATERIAL__BASE_CLASS:
			return base_Class != null;
		case MbpePackage.MANUFACTURED_MATERIAL__MANFACTURER:
			return MANFACTURER_EDEFAULT == null ? manfacturer != null : !MANFACTURER_EDEFAULT.equals(manfacturer);
		case MbpePackage.MANUFACTURED_MATERIAL__PART_NUMBER:
			return PART_NUMBER_EDEFAULT == null ? part_number != null : !PART_NUMBER_EDEFAULT.equals(part_number);
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy())
			return super.toString();

		StringBuilder result = new StringBuilder(super.toString());
		result.append(" (manfacturer: ");
		result.append(manfacturer);
		result.append(", part_number: ");
		result.append(part_number);
		result.append(')');
		return result.toString();
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

} // ManufacturedMaterialImpl
