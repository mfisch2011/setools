/**
 */
package setools.mbpe.util;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.util.Switch;

import setools.mbpe.*;

/**
 * <!-- begin-user-doc --> The <b>Switch</b> for the model's inheritance
 * hierarchy. It supports the call {@link #doSwitch(EObject) doSwitch(object)}
 * to invoke the <code>caseXXX</code> method for each class of the model,
 * starting with the actual class of the object and proceeding up the
 * inheritance hierarchy until a non-null result is returned, which is the
 * result of the switch. <!-- end-user-doc -->
 * 
 * @see setools.mbpe.MbpePackage
 * @generated
 */
public class MbpeSwitch<T> extends Switch<T> {
	/**
	 * The cached model package <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected static MbpePackage modelPackage;

	/**
	 * Creates an instance of the switch. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @generated
	 */
	public MbpeSwitch() {
		if (modelPackage == null) {
			modelPackage = MbpePackage.eINSTANCE;
		}
	}

	/**
	 * Checks whether this is a switch for the given package. <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * 
	 * @param ePackage the package in question.
	 * @return whether this is a switch for the given package.
	 * @generated
	 */
	@Override
	protected boolean isSwitchFor(EPackage ePackage) {
		return ePackage == modelPackage;
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a
	 * non null result; it yields that result. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	@Override
	protected T doSwitch(int classifierID, EObject theEObject) {
		switch (classifierID) {
		case MbpePackage.SUPPORT_EQUIPMENT: {
			SupportEquipment supportEquipment = (SupportEquipment) theEObject;
			T result = caseSupportEquipment(supportEquipment);
			if (result == null)
				result = caseEquipment(supportEquipment);
			if (result == null)
				result = caseManufacturedMaterial(supportEquipment);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case MbpePackage.EQUIPMENT: {
			Equipment equipment = (Equipment) theEObject;
			T result = caseEquipment(equipment);
			if (result == null)
				result = caseManufacturedMaterial(equipment);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case MbpePackage.MANUFACTURED_MATERIAL: {
			ManufacturedMaterial manufacturedMaterial = (ManufacturedMaterial) theEObject;
			T result = caseManufacturedMaterial(manufacturedMaterial);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case MbpePackage.OPERATING_PROCEDURE: {
			OperatingProcedure operatingProcedure = (OperatingProcedure) theEObject;
			T result = caseOperatingProcedure(operatingProcedure);
			if (result == null)
				result = caseProcedure(operatingProcedure);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case MbpePackage.PROCEDURE: {
			Procedure procedure = (Procedure) theEObject;
			T result = caseProcedure(procedure);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case MbpePackage.MATERIAL: {
			Material material = (Material) theEObject;
			T result = caseMaterial(material);
			if (result == null)
				result = caseManufacturedMaterial(material);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case MbpePackage.MAINTENANCE_PROCEDURE: {
			MaintenanceProcedure maintenanceProcedure = (MaintenanceProcedure) theEObject;
			T result = caseMaintenanceProcedure(maintenanceProcedure);
			if (result == null)
				result = caseOperatingProcedure(maintenanceProcedure);
			if (result == null)
				result = caseProcedure(maintenanceProcedure);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case MbpePackage.CREATION_PROCEDURE: {
			CreationProcedure creationProcedure = (CreationProcedure) theEObject;
			T result = caseCreationProcedure(creationProcedure);
			if (result == null)
				result = caseProcedure(creationProcedure);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case MbpePackage.ASSEMBLY_PROCEDURE: {
			AssemblyProcedure assemblyProcedure = (AssemblyProcedure) theEObject;
			T result = caseAssemblyProcedure(assemblyProcedure);
			if (result == null)
				result = caseCreationProcedure(assemblyProcedure);
			if (result == null)
				result = caseProcedure(assemblyProcedure);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case MbpePackage.FABRICATION_PROCEDURE: {
			FabricationProcedure fabricationProcedure = (FabricationProcedure) theEObject;
			T result = caseFabricationProcedure(fabricationProcedure);
			if (result == null)
				result = caseCreationProcedure(fabricationProcedure);
			if (result == null)
				result = caseProcedure(fabricationProcedure);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case MbpePackage.INSTALLATION_PROCEDURE: {
			InstallationProcedure installationProcedure = (InstallationProcedure) theEObject;
			T result = caseInstallationProcedure(installationProcedure);
			if (result == null)
				result = caseCreationProcedure(installationProcedure);
			if (result == null)
				result = caseProcedure(installationProcedure);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case MbpePackage.CALIBRATION_PROCEDURE: {
			CalibrationProcedure calibrationProcedure = (CalibrationProcedure) theEObject;
			T result = caseCalibrationProcedure(calibrationProcedure);
			if (result == null)
				result = caseMaintenanceProcedure(calibrationProcedure);
			if (result == null)
				result = caseOperatingProcedure(calibrationProcedure);
			if (result == null)
				result = caseProcedure(calibrationProcedure);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		default:
			return defaultCase(theEObject);
		}
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Support
	 * Equipment</em>'. <!-- begin-user-doc --> This implementation returns null;
	 * returning a non-null result will terminate the switch. <!-- end-user-doc -->
	 * 
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Support
	 *         Equipment</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSupportEquipment(SupportEquipment object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of
	 * '<em>Equipment</em>'. <!-- begin-user-doc --> This implementation returns
	 * null; returning a non-null result will terminate the switch. <!--
	 * end-user-doc -->
	 * 
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of
	 *         '<em>Equipment</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseEquipment(Equipment object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of
	 * '<em>Manufactured Material</em>'. <!-- begin-user-doc --> This implementation
	 * returns null; returning a non-null result will terminate the switch. <!--
	 * end-user-doc -->
	 * 
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of
	 *         '<em>Manufactured Material</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseManufacturedMaterial(ManufacturedMaterial object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of
	 * '<em>Operating Procedure</em>'. <!-- begin-user-doc --> This implementation
	 * returns null; returning a non-null result will terminate the switch. <!--
	 * end-user-doc -->
	 * 
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of
	 *         '<em>Operating Procedure</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseOperatingProcedure(OperatingProcedure object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of
	 * '<em>Procedure</em>'. <!-- begin-user-doc --> This implementation returns
	 * null; returning a non-null result will terminate the switch. <!--
	 * end-user-doc -->
	 * 
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of
	 *         '<em>Procedure</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseProcedure(Procedure object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of
	 * '<em>Material</em>'. <!-- begin-user-doc --> This implementation returns
	 * null; returning a non-null result will terminate the switch. <!--
	 * end-user-doc -->
	 * 
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of
	 *         '<em>Material</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseMaterial(Material object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of
	 * '<em>Maintenance Procedure</em>'. <!-- begin-user-doc --> This implementation
	 * returns null; returning a non-null result will terminate the switch. <!--
	 * end-user-doc -->
	 * 
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of
	 *         '<em>Maintenance Procedure</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseMaintenanceProcedure(MaintenanceProcedure object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Creation
	 * Procedure</em>'. <!-- begin-user-doc --> This implementation returns null;
	 * returning a non-null result will terminate the switch. <!-- end-user-doc -->
	 * 
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Creation
	 *         Procedure</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCreationProcedure(CreationProcedure object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Assembly
	 * Procedure</em>'. <!-- begin-user-doc --> This implementation returns null;
	 * returning a non-null result will terminate the switch. <!-- end-user-doc -->
	 * 
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Assembly
	 *         Procedure</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAssemblyProcedure(AssemblyProcedure object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of
	 * '<em>Fabrication Procedure</em>'. <!-- begin-user-doc --> This implementation
	 * returns null; returning a non-null result will terminate the switch. <!--
	 * end-user-doc -->
	 * 
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of
	 *         '<em>Fabrication Procedure</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseFabricationProcedure(FabricationProcedure object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of
	 * '<em>Installation Procedure</em>'. <!-- begin-user-doc --> This
	 * implementation returns null; returning a non-null result will terminate the
	 * switch. <!-- end-user-doc -->
	 * 
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of
	 *         '<em>Installation Procedure</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseInstallationProcedure(InstallationProcedure object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of
	 * '<em>Calibration Procedure</em>'. <!-- begin-user-doc --> This implementation
	 * returns null; returning a non-null result will terminate the switch. <!--
	 * end-user-doc -->
	 * 
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of
	 *         '<em>Calibration Procedure</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCalibrationProcedure(CalibrationProcedure object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of
	 * '<em>EObject</em>'. <!-- begin-user-doc --> This implementation returns null;
	 * returning a non-null result will terminate the switch, but this is the last
	 * case anyway. <!-- end-user-doc -->
	 * 
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of
	 *         '<em>EObject</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject)
	 * @generated
	 */
	@Override
	public T defaultCase(EObject object) {
		return null;
	}

} // MbpeSwitch
