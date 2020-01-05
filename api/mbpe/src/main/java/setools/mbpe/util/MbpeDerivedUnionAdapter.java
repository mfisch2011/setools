/**
 */
package setools.mbpe.util;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.notify.impl.AdapterImpl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;

import setools.mbpe.AssemblyProcedure;
import setools.mbpe.CalibrationProcedure;
import setools.mbpe.Equipment;
import setools.mbpe.FabricationProcedure;
import setools.mbpe.InstallationProcedure;
import setools.mbpe.MaintenanceProcedure;
import setools.mbpe.MbpePackage;
import setools.mbpe.OperatingProcedure;
import setools.mbpe.SupportEquipment;

/**
 * <!-- begin-user-doc --> An adapter that propagates notifications for derived
 * unions. <!-- end-user-doc -->
 * 
 * @see setools.mbpe.MbpePackage
 * @generated
 */
public class MbpeDerivedUnionAdapter extends AdapterImpl {
	/**
	 * The cached model package. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected static MbpePackage modelPackage;

	/**
	 * Creates an instance of the adapter. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @generated
	 */
	public MbpeDerivedUnionAdapter() {
		if (modelPackage == null) {
			modelPackage = MbpePackage.eINSTANCE;
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
		case MbpePackage.SUPPORT_EQUIPMENT:
			notifySupportEquipmentChanged(notification, eClass);
			break;
		case MbpePackage.EQUIPMENT:
			notifyEquipmentChanged(notification, eClass);
			break;
		case MbpePackage.OPERATING_PROCEDURE:
			notifyOperatingProcedureChanged(notification, eClass);
			break;
		case MbpePackage.MAINTENANCE_PROCEDURE:
			notifyMaintenanceProcedureChanged(notification, eClass);
			break;
		case MbpePackage.ASSEMBLY_PROCEDURE:
			notifyAssemblyProcedureChanged(notification, eClass);
			break;
		case MbpePackage.FABRICATION_PROCEDURE:
			notifyFabricationProcedureChanged(notification, eClass);
			break;
		case MbpePackage.INSTALLATION_PROCEDURE:
			notifyInstallationProcedureChanged(notification, eClass);
			break;
		case MbpePackage.CALIBRATION_PROCEDURE:
			notifyCalibrationProcedureChanged(notification, eClass);
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
	protected void notifySupportEquipmentChanged(Notification notification, EClass eClass) {
		switch (notification.getFeatureID(SupportEquipment.class)) {
		}
	}

	/**
	 * Calls <code>notifyChanged</code> for each affected derived union. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param notification a description of the change.
	 * @param eClass       the Ecore class of the notifier.
	 * @generated
	 */
	protected void notifyEquipmentChanged(Notification notification, EClass eClass) {
		switch (notification.getFeatureID(Equipment.class)) {
		}
	}

	/**
	 * Calls <code>notifyChanged</code> for each affected derived union. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param notification a description of the change.
	 * @param eClass       the Ecore class of the notifier.
	 * @generated
	 */
	protected void notifyOperatingProcedureChanged(Notification notification, EClass eClass) {
		switch (notification.getFeatureID(OperatingProcedure.class)) {
		}
	}

	/**
	 * Calls <code>notifyChanged</code> for each affected derived union. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param notification a description of the change.
	 * @param eClass       the Ecore class of the notifier.
	 * @generated
	 */
	protected void notifyMaintenanceProcedureChanged(Notification notification, EClass eClass) {
		switch (notification.getFeatureID(MaintenanceProcedure.class)) {
		}
	}

	/**
	 * Calls <code>notifyChanged</code> for each affected derived union. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param notification a description of the change.
	 * @param eClass       the Ecore class of the notifier.
	 * @generated
	 */
	protected void notifyAssemblyProcedureChanged(Notification notification, EClass eClass) {
		switch (notification.getFeatureID(AssemblyProcedure.class)) {
		}
	}

	/**
	 * Calls <code>notifyChanged</code> for each affected derived union. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param notification a description of the change.
	 * @param eClass       the Ecore class of the notifier.
	 * @generated
	 */
	protected void notifyFabricationProcedureChanged(Notification notification, EClass eClass) {
		switch (notification.getFeatureID(FabricationProcedure.class)) {
		}
	}

	/**
	 * Calls <code>notifyChanged</code> for each affected derived union. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param notification a description of the change.
	 * @param eClass       the Ecore class of the notifier.
	 * @generated
	 */
	protected void notifyInstallationProcedureChanged(Notification notification, EClass eClass) {
		switch (notification.getFeatureID(InstallationProcedure.class)) {
		}
	}

	/**
	 * Calls <code>notifyChanged</code> for each affected derived union. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param notification a description of the change.
	 * @param eClass       the Ecore class of the notifier.
	 * @generated
	 */
	protected void notifyCalibrationProcedureChanged(Notification notification, EClass eClass) {
		switch (notification.getFeatureID(CalibrationProcedure.class)) {
		}
	}

} // MbpeDerivedUnionAdapter
