/**
 */
package setools.mbpe.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import setools.mbpe.*;

/**
 * <!-- begin-user-doc --> An implementation of the model <b>Factory</b>. <!--
 * end-user-doc -->
 * 
 * @generated
 */
public class MbpeFactoryImpl extends EFactoryImpl implements MbpeFactory {
	/**
	 * Creates the default factory implementation. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 */
	public static MbpeFactory init() {
		try {
			MbpeFactory theMbpeFactory = (MbpeFactory) EPackage.Registry.INSTANCE.getEFactory(MbpePackage.eNS_URI);
			if (theMbpeFactory != null) {
				return theMbpeFactory;
			}
		} catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new MbpeFactoryImpl();
	}

	/**
	 * Creates an instance of the factory. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @generated
	 */
	public MbpeFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
		case MbpePackage.SUPPORT_EQUIPMENT:
			return createSupportEquipment();
		case MbpePackage.EQUIPMENT:
			return createEquipment();
		case MbpePackage.OPERATING_PROCEDURE:
			return createOperatingProcedure();
		case MbpePackage.MATERIAL:
			return createMaterial();
		case MbpePackage.MAINTENANCE_PROCEDURE:
			return createMaintenanceProcedure();
		case MbpePackage.ASSEMBLY_PROCEDURE:
			return createAssemblyProcedure();
		case MbpePackage.FABRICATION_PROCEDURE:
			return createFabricationProcedure();
		case MbpePackage.INSTALLATION_PROCEDURE:
			return createInstallationProcedure();
		case MbpePackage.CALIBRATION_PROCEDURE:
			return createCalibrationProcedure();
		default:
			throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public SupportEquipment createSupportEquipment() {
		SupportEquipmentImpl supportEquipment = new SupportEquipmentImpl();
		return supportEquipment;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public Equipment createEquipment() {
		EquipmentImpl equipment = new EquipmentImpl();
		return equipment;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public OperatingProcedure createOperatingProcedure() {
		OperatingProcedureImpl operatingProcedure = new OperatingProcedureImpl();
		return operatingProcedure;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public Material createMaterial() {
		MaterialImpl material = new MaterialImpl();
		return material;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public MaintenanceProcedure createMaintenanceProcedure() {
		MaintenanceProcedureImpl maintenanceProcedure = new MaintenanceProcedureImpl();
		return maintenanceProcedure;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public AssemblyProcedure createAssemblyProcedure() {
		AssemblyProcedureImpl assemblyProcedure = new AssemblyProcedureImpl();
		return assemblyProcedure;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public FabricationProcedure createFabricationProcedure() {
		FabricationProcedureImpl fabricationProcedure = new FabricationProcedureImpl();
		return fabricationProcedure;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public InstallationProcedure createInstallationProcedure() {
		InstallationProcedureImpl installationProcedure = new InstallationProcedureImpl();
		return installationProcedure;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public CalibrationProcedure createCalibrationProcedure() {
		CalibrationProcedureImpl calibrationProcedure = new CalibrationProcedureImpl();
		return calibrationProcedure;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public MbpePackage getMbpePackage() {
		return (MbpePackage) getEPackage();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static MbpePackage getPackage() {
		return MbpePackage.eINSTANCE;
	}

} // MbpeFactoryImpl
