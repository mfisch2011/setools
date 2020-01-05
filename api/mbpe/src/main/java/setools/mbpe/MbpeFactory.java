/**
 */
package setools.mbpe;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc --> The <b>Factory</b> for the model. It provides a
 * create method for each non-abstract class of the model. <!-- end-user-doc -->
 * 
 * @see setools.mbpe.MbpePackage
 * @generated
 */
public interface MbpeFactory extends EFactory {
	/**
	 * The singleton instance of the factory. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 */
	MbpeFactory eINSTANCE = setools.mbpe.impl.MbpeFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Support Equipment</em>'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return a new object of class '<em>Support Equipment</em>'.
	 * @generated
	 */
	SupportEquipment createSupportEquipment();

	/**
	 * Returns a new object of class '<em>Equipment</em>'. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return a new object of class '<em>Equipment</em>'.
	 * @generated
	 */
	Equipment createEquipment();

	/**
	 * Returns a new object of class '<em>Operating Procedure</em>'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return a new object of class '<em>Operating Procedure</em>'.
	 * @generated
	 */
	OperatingProcedure createOperatingProcedure();

	/**
	 * Returns a new object of class '<em>Material</em>'. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return a new object of class '<em>Material</em>'.
	 * @generated
	 */
	Material createMaterial();

	/**
	 * Returns a new object of class '<em>Maintenance Procedure</em>'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return a new object of class '<em>Maintenance Procedure</em>'.
	 * @generated
	 */
	MaintenanceProcedure createMaintenanceProcedure();

	/**
	 * Returns a new object of class '<em>Assembly Procedure</em>'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return a new object of class '<em>Assembly Procedure</em>'.
	 * @generated
	 */
	AssemblyProcedure createAssemblyProcedure();

	/**
	 * Returns a new object of class '<em>Fabrication Procedure</em>'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return a new object of class '<em>Fabrication Procedure</em>'.
	 * @generated
	 */
	FabricationProcedure createFabricationProcedure();

	/**
	 * Returns a new object of class '<em>Installation Procedure</em>'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return a new object of class '<em>Installation Procedure</em>'.
	 * @generated
	 */
	InstallationProcedure createInstallationProcedure();

	/**
	 * Returns a new object of class '<em>Calibration Procedure</em>'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return a new object of class '<em>Calibration Procedure</em>'.
	 * @generated
	 */
	CalibrationProcedure createCalibrationProcedure();

	/**
	 * Returns the package supported by this factory. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @return the package supported by this factory.
	 * @generated
	 */
	MbpePackage getMbpePackage();

} // MbpeFactory
