/**
 */
package setools.risk.util;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.notify.impl.AdapterImpl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;

import setools.risk.Risk;
import setools.risk.RiskPackage;

/**
 * <!-- begin-user-doc --> An adapter that propagates notifications for derived
 * unions. <!-- end-user-doc -->
 * 
 * @see setools.risk.RiskPackage
 * @generated
 */
public class RiskDerivedUnionAdapter extends AdapterImpl {
	/**
	 * The cached model package. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected static RiskPackage modelPackage;

	/**
	 * Creates an instance of the adapter. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @generated
	 */
	public RiskDerivedUnionAdapter() {
		if (modelPackage == null) {
			modelPackage = RiskPackage.eINSTANCE;
		}
	}

	/**
	 * Calls <code>notifyChanged</code> with the appropriate model class. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param notification a description of the change.
	 * @generated
	 */
	@Override
	public void notifyChanged(Notification notification) {
		Object notifier = notification.getNotifier();
		if (notifier instanceof EObject) {
			EClass eClass = ((EObject) notifier).eClass();
			if (eClass.eContainer() == modelPackage) {
				notifyChanged(notification, eClass);
			}
		}
	}

	/**
	 * Calls <code>notifyXXXChanged</code> for the corresponding class of the model.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param notification a description of the change.
	 * @param eClass       the Ecore class of the notifier.
	 * @generated
	 */
	protected void notifyChanged(Notification notification, EClass eClass) {
		switch (eClass.getClassifierID()) {
		case RiskPackage.RISK:
			notifyRiskChanged(notification, eClass);
			break;
		}
	}

	/**
	 * Does nothing; clients may override so that it does something. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param notification a description of the change.
	 * @param eClass       the Ecore class of the notifier.
	 * @param derivedUnion the derived union affected by the change.
	 * @generated
	 */
	public void notifyChanged(Notification notification, EClass eClass, EStructuralFeature derivedUnion) {
		// Do nothing.
	}

	/**
	 * Calls <code>notifyChanged</code> for each affected derived union. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param notification a description of the change.
	 * @param eClass       the Ecore class of the notifier.
	 * @generated
	 */
	protected void notifyRiskChanged(Notification notification, EClass eClass) {
		switch (notification.getFeatureID(Risk.class)) {
		}
	}

} // RiskDerivedUnionAdapter
