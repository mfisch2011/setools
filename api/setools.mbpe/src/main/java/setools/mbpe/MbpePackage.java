/**
 */
package setools.mbpe;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc --> The <b>Package</b> for the model. It contains
 * accessors for the meta objects to represent
 * <ul>
 * <li>each class,</li>
 * <li>each feature of each class,</li>
 * <li>each operation of each class,</li>
 * <li>each enum,</li>
 * <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * 
 * @see setools.mbpe.MbpeFactory
 * @model kind="package"
 * @generated
 */
public interface MbpePackage extends EPackage {
	/**
	 * The package name. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	String eNAME = "mbpe";

	/**
	 * The package namespace URI. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	String eNS_URI = "http://setools/mbpe/0.1";

	/**
	 * The package namespace name. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	String eNS_PREFIX = "mbpe";

	/**
	 * The singleton instance of the package. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 */
	MbpePackage eINSTANCE = setools.mbpe.impl.MbpePackageImpl.init();

	/**
	 * The meta object id for the '{@link setools.mbpe.impl.ManufacturedMaterialImpl
	 * <em>Manufactured Material</em>}' class. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @see setools.mbpe.impl.ManufacturedMaterialImpl
	 * @see setools.mbpe.impl.MbpePackageImpl#getManufacturedMaterial()
	 * @generated
	 */
	int MANUFACTURED_MATERIAL = 2;

	/**
	 * The feature id for the '<em><b>Base Class</b></em>' reference. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int MANUFACTURED_MATERIAL__BASE_CLASS = 0;

	/**
	 * The feature id for the '<em><b>Manfacturer</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int MANUFACTURED_MATERIAL__MANFACTURER = 1;

	/**
	 * The feature id for the '<em><b>Part number</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int MANUFACTURED_MATERIAL__PART_NUMBER = 2;

	/**
	 * The number of structural features of the '<em>Manufactured Material</em>'
	 * class. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int MANUFACTURED_MATERIAL_FEATURE_COUNT = 3;

	/**
	 * The number of operations of the '<em>Manufactured Material</em>' class. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int MANUFACTURED_MATERIAL_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link setools.mbpe.impl.EquipmentImpl
	 * <em>Equipment</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see setools.mbpe.impl.EquipmentImpl
	 * @see setools.mbpe.impl.MbpePackageImpl#getEquipment()
	 * @generated
	 */
	int EQUIPMENT = 1;

	/**
	 * The feature id for the '<em><b>Base Class</b></em>' reference. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int EQUIPMENT__BASE_CLASS = MANUFACTURED_MATERIAL__BASE_CLASS;

	/**
	 * The feature id for the '<em><b>Manfacturer</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int EQUIPMENT__MANFACTURER = MANUFACTURED_MATERIAL__MANFACTURER;

	/**
	 * The feature id for the '<em><b>Part number</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int EQUIPMENT__PART_NUMBER = MANUFACTURED_MATERIAL__PART_NUMBER;

	/**
	 * The feature id for the '<em><b>Operating procedure</b></em>' reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int EQUIPMENT__OPERATING_PROCEDURE = MANUFACTURED_MATERIAL_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Maintenance procedure</b></em>' reference
	 * list. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int EQUIPMENT__MAINTENANCE_PROCEDURE = MANUFACTURED_MATERIAL_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Equipment</em>' class. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int EQUIPMENT_FEATURE_COUNT = MANUFACTURED_MATERIAL_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>Equipment</em>' class. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int EQUIPMENT_OPERATION_COUNT = MANUFACTURED_MATERIAL_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link setools.mbpe.impl.SupportEquipmentImpl
	 * <em>Support Equipment</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @see setools.mbpe.impl.SupportEquipmentImpl
	 * @see setools.mbpe.impl.MbpePackageImpl#getSupportEquipment()
	 * @generated
	 */
	int SUPPORT_EQUIPMENT = 0;

	/**
	 * The feature id for the '<em><b>Base Class</b></em>' reference. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int SUPPORT_EQUIPMENT__BASE_CLASS = EQUIPMENT__BASE_CLASS;

	/**
	 * The feature id for the '<em><b>Manfacturer</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int SUPPORT_EQUIPMENT__MANFACTURER = EQUIPMENT__MANFACTURER;

	/**
	 * The feature id for the '<em><b>Part number</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int SUPPORT_EQUIPMENT__PART_NUMBER = EQUIPMENT__PART_NUMBER;

	/**
	 * The feature id for the '<em><b>Operating procedure</b></em>' reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int SUPPORT_EQUIPMENT__OPERATING_PROCEDURE = EQUIPMENT__OPERATING_PROCEDURE;

	/**
	 * The feature id for the '<em><b>Maintenance procedure</b></em>' reference
	 * list. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int SUPPORT_EQUIPMENT__MAINTENANCE_PROCEDURE = EQUIPMENT__MAINTENANCE_PROCEDURE;

	/**
	 * The feature id for the '<em><b>Fabrication procedure</b></em>' reference
	 * list. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int SUPPORT_EQUIPMENT__FABRICATION_PROCEDURE = EQUIPMENT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Support Equipment</em>' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int SUPPORT_EQUIPMENT_FEATURE_COUNT = EQUIPMENT_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Support Equipment</em>' class. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int SUPPORT_EQUIPMENT_OPERATION_COUNT = EQUIPMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link setools.mbpe.impl.ProcedureImpl
	 * <em>Procedure</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see setools.mbpe.impl.ProcedureImpl
	 * @see setools.mbpe.impl.MbpePackageImpl#getProcedure()
	 * @generated
	 */
	int PROCEDURE = 4;

	/**
	 * The feature id for the '<em><b>Base Behavior</b></em>' reference. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int PROCEDURE__BASE_BEHAVIOR = 0;

	/**
	 * The feature id for the '<em><b>Equipment</b></em>' reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int PROCEDURE__EQUIPMENT = 1;

	/**
	 * The feature id for the '<em><b>Material</b></em>' reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int PROCEDURE__MATERIAL = 2;

	/**
	 * The number of structural features of the '<em>Procedure</em>' class. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int PROCEDURE_FEATURE_COUNT = 3;

	/**
	 * The number of operations of the '<em>Procedure</em>' class. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int PROCEDURE_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link setools.mbpe.impl.OperatingProcedureImpl
	 * <em>Operating Procedure</em>}' class. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @see setools.mbpe.impl.OperatingProcedureImpl
	 * @see setools.mbpe.impl.MbpePackageImpl#getOperatingProcedure()
	 * @generated
	 */
	int OPERATING_PROCEDURE = 3;

	/**
	 * The feature id for the '<em><b>Base Behavior</b></em>' reference. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int OPERATING_PROCEDURE__BASE_BEHAVIOR = PROCEDURE__BASE_BEHAVIOR;

	/**
	 * The feature id for the '<em><b>Equipment</b></em>' reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int OPERATING_PROCEDURE__EQUIPMENT = PROCEDURE__EQUIPMENT;

	/**
	 * The feature id for the '<em><b>Material</b></em>' reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int OPERATING_PROCEDURE__MATERIAL = PROCEDURE__MATERIAL;

	/**
	 * The number of structural features of the '<em>Operating Procedure</em>'
	 * class. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int OPERATING_PROCEDURE_FEATURE_COUNT = PROCEDURE_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Operating Procedure</em>' class. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int OPERATING_PROCEDURE_OPERATION_COUNT = PROCEDURE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link setools.mbpe.impl.MaterialImpl
	 * <em>Material</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see setools.mbpe.impl.MaterialImpl
	 * @see setools.mbpe.impl.MbpePackageImpl#getMaterial()
	 * @generated
	 */
	int MATERIAL = 5;

	/**
	 * The feature id for the '<em><b>Base Class</b></em>' reference. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int MATERIAL__BASE_CLASS = MANUFACTURED_MATERIAL__BASE_CLASS;

	/**
	 * The feature id for the '<em><b>Manfacturer</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int MATERIAL__MANFACTURER = MANUFACTURED_MATERIAL__MANFACTURER;

	/**
	 * The feature id for the '<em><b>Part number</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int MATERIAL__PART_NUMBER = MANUFACTURED_MATERIAL__PART_NUMBER;

	/**
	 * The number of structural features of the '<em>Material</em>' class. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int MATERIAL_FEATURE_COUNT = MANUFACTURED_MATERIAL_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Material</em>' class. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int MATERIAL_OPERATION_COUNT = MANUFACTURED_MATERIAL_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link setools.mbpe.impl.MaintenanceProcedureImpl
	 * <em>Maintenance Procedure</em>}' class. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @see setools.mbpe.impl.MaintenanceProcedureImpl
	 * @see setools.mbpe.impl.MbpePackageImpl#getMaintenanceProcedure()
	 * @generated
	 */
	int MAINTENANCE_PROCEDURE = 6;

	/**
	 * The feature id for the '<em><b>Base Behavior</b></em>' reference. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int MAINTENANCE_PROCEDURE__BASE_BEHAVIOR = OPERATING_PROCEDURE__BASE_BEHAVIOR;

	/**
	 * The feature id for the '<em><b>Equipment</b></em>' reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int MAINTENANCE_PROCEDURE__EQUIPMENT = OPERATING_PROCEDURE__EQUIPMENT;

	/**
	 * The feature id for the '<em><b>Material</b></em>' reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int MAINTENANCE_PROCEDURE__MATERIAL = OPERATING_PROCEDURE__MATERIAL;

	/**
	 * The number of structural features of the '<em>Maintenance Procedure</em>'
	 * class. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int MAINTENANCE_PROCEDURE_FEATURE_COUNT = OPERATING_PROCEDURE_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Maintenance Procedure</em>' class. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int MAINTENANCE_PROCEDURE_OPERATION_COUNT = OPERATING_PROCEDURE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link setools.mbpe.impl.CreationProcedureImpl
	 * <em>Creation Procedure</em>}' class. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @see setools.mbpe.impl.CreationProcedureImpl
	 * @see setools.mbpe.impl.MbpePackageImpl#getCreationProcedure()
	 * @generated
	 */
	int CREATION_PROCEDURE = 7;

	/**
	 * The feature id for the '<em><b>Base Behavior</b></em>' reference. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int CREATION_PROCEDURE__BASE_BEHAVIOR = PROCEDURE__BASE_BEHAVIOR;

	/**
	 * The feature id for the '<em><b>Equipment</b></em>' reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int CREATION_PROCEDURE__EQUIPMENT = PROCEDURE__EQUIPMENT;

	/**
	 * The feature id for the '<em><b>Material</b></em>' reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int CREATION_PROCEDURE__MATERIAL = PROCEDURE__MATERIAL;

	/**
	 * The feature id for the '<em><b>End item</b></em>' reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int CREATION_PROCEDURE__END_ITEM = PROCEDURE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Creation Procedure</em>' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int CREATION_PROCEDURE_FEATURE_COUNT = PROCEDURE_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Creation Procedure</em>' class. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int CREATION_PROCEDURE_OPERATION_COUNT = PROCEDURE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link setools.mbpe.impl.AssemblyProcedureImpl
	 * <em>Assembly Procedure</em>}' class. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @see setools.mbpe.impl.AssemblyProcedureImpl
	 * @see setools.mbpe.impl.MbpePackageImpl#getAssemblyProcedure()
	 * @generated
	 */
	int ASSEMBLY_PROCEDURE = 8;

	/**
	 * The feature id for the '<em><b>Base Behavior</b></em>' reference. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ASSEMBLY_PROCEDURE__BASE_BEHAVIOR = CREATION_PROCEDURE__BASE_BEHAVIOR;

	/**
	 * The feature id for the '<em><b>Equipment</b></em>' reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ASSEMBLY_PROCEDURE__EQUIPMENT = CREATION_PROCEDURE__EQUIPMENT;

	/**
	 * The feature id for the '<em><b>Material</b></em>' reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ASSEMBLY_PROCEDURE__MATERIAL = CREATION_PROCEDURE__MATERIAL;

	/**
	 * The feature id for the '<em><b>End item</b></em>' reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ASSEMBLY_PROCEDURE__END_ITEM = CREATION_PROCEDURE__END_ITEM;

	/**
	 * The number of structural features of the '<em>Assembly Procedure</em>' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ASSEMBLY_PROCEDURE_FEATURE_COUNT = CREATION_PROCEDURE_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Assembly Procedure</em>' class. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ASSEMBLY_PROCEDURE_OPERATION_COUNT = CREATION_PROCEDURE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link setools.mbpe.impl.FabricationProcedureImpl
	 * <em>Fabrication Procedure</em>}' class. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @see setools.mbpe.impl.FabricationProcedureImpl
	 * @see setools.mbpe.impl.MbpePackageImpl#getFabricationProcedure()
	 * @generated
	 */
	int FABRICATION_PROCEDURE = 9;

	/**
	 * The feature id for the '<em><b>Base Behavior</b></em>' reference. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int FABRICATION_PROCEDURE__BASE_BEHAVIOR = CREATION_PROCEDURE__BASE_BEHAVIOR;

	/**
	 * The feature id for the '<em><b>Equipment</b></em>' reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int FABRICATION_PROCEDURE__EQUIPMENT = CREATION_PROCEDURE__EQUIPMENT;

	/**
	 * The feature id for the '<em><b>Material</b></em>' reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int FABRICATION_PROCEDURE__MATERIAL = CREATION_PROCEDURE__MATERIAL;

	/**
	 * The feature id for the '<em><b>End item</b></em>' reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int FABRICATION_PROCEDURE__END_ITEM = CREATION_PROCEDURE__END_ITEM;

	/**
	 * The number of structural features of the '<em>Fabrication Procedure</em>'
	 * class. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int FABRICATION_PROCEDURE_FEATURE_COUNT = CREATION_PROCEDURE_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Fabrication Procedure</em>' class. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int FABRICATION_PROCEDURE_OPERATION_COUNT = CREATION_PROCEDURE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the
	 * '{@link setools.mbpe.impl.InstallationProcedureImpl <em>Installation
	 * Procedure</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see setools.mbpe.impl.InstallationProcedureImpl
	 * @see setools.mbpe.impl.MbpePackageImpl#getInstallationProcedure()
	 * @generated
	 */
	int INSTALLATION_PROCEDURE = 10;

	/**
	 * The feature id for the '<em><b>Base Behavior</b></em>' reference. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int INSTALLATION_PROCEDURE__BASE_BEHAVIOR = CREATION_PROCEDURE__BASE_BEHAVIOR;

	/**
	 * The feature id for the '<em><b>Equipment</b></em>' reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int INSTALLATION_PROCEDURE__EQUIPMENT = CREATION_PROCEDURE__EQUIPMENT;

	/**
	 * The feature id for the '<em><b>Material</b></em>' reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int INSTALLATION_PROCEDURE__MATERIAL = CREATION_PROCEDURE__MATERIAL;

	/**
	 * The feature id for the '<em><b>End item</b></em>' reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int INSTALLATION_PROCEDURE__END_ITEM = CREATION_PROCEDURE__END_ITEM;

	/**
	 * The number of structural features of the '<em>Installation Procedure</em>'
	 * class. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int INSTALLATION_PROCEDURE_FEATURE_COUNT = CREATION_PROCEDURE_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Installation Procedure</em>' class. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int INSTALLATION_PROCEDURE_OPERATION_COUNT = CREATION_PROCEDURE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link setools.mbpe.impl.CalibrationProcedureImpl
	 * <em>Calibration Procedure</em>}' class. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @see setools.mbpe.impl.CalibrationProcedureImpl
	 * @see setools.mbpe.impl.MbpePackageImpl#getCalibrationProcedure()
	 * @generated
	 */
	int CALIBRATION_PROCEDURE = 11;

	/**
	 * The feature id for the '<em><b>Base Behavior</b></em>' reference. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int CALIBRATION_PROCEDURE__BASE_BEHAVIOR = MAINTENANCE_PROCEDURE__BASE_BEHAVIOR;

	/**
	 * The feature id for the '<em><b>Equipment</b></em>' reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int CALIBRATION_PROCEDURE__EQUIPMENT = MAINTENANCE_PROCEDURE__EQUIPMENT;

	/**
	 * The feature id for the '<em><b>Material</b></em>' reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int CALIBRATION_PROCEDURE__MATERIAL = MAINTENANCE_PROCEDURE__MATERIAL;

	/**
	 * The number of structural features of the '<em>Calibration Procedure</em>'
	 * class. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int CALIBRATION_PROCEDURE_FEATURE_COUNT = MAINTENANCE_PROCEDURE_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Calibration Procedure</em>' class. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int CALIBRATION_PROCEDURE_OPERATION_COUNT = MAINTENANCE_PROCEDURE_OPERATION_COUNT + 0;

	/**
	 * Returns the meta object for class '{@link setools.mbpe.SupportEquipment
	 * <em>Support Equipment</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Support Equipment</em>'.
	 * @see setools.mbpe.SupportEquipment
	 * @generated
	 */
	EClass getSupportEquipment();

	/**
	 * Returns the meta object for the reference list
	 * '{@link setools.mbpe.SupportEquipment#getFabrication_procedure
	 * <em>Fabrication procedure</em>}'. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @return the meta object for the reference list '<em>Fabrication
	 *         procedure</em>'.
	 * @see setools.mbpe.SupportEquipment#getFabrication_procedure()
	 * @see #getSupportEquipment()
	 * @generated
	 */
	EReference getSupportEquipment_Fabrication_procedure();

	/**
	 * Returns the meta object for class '{@link setools.mbpe.Equipment
	 * <em>Equipment</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Equipment</em>'.
	 * @see setools.mbpe.Equipment
	 * @generated
	 */
	EClass getEquipment();

	/**
	 * Returns the meta object for the reference list
	 * '{@link setools.mbpe.Equipment#getOperating_procedure <em>Operating
	 * procedure</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the reference list '<em>Operating
	 *         procedure</em>'.
	 * @see setools.mbpe.Equipment#getOperating_procedure()
	 * @see #getEquipment()
	 * @generated
	 */
	EReference getEquipment_Operating_procedure();

	/**
	 * Returns the meta object for the reference list
	 * '{@link setools.mbpe.Equipment#getMaintenance_procedure <em>Maintenance
	 * procedure</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the reference list '<em>Maintenance
	 *         procedure</em>'.
	 * @see setools.mbpe.Equipment#getMaintenance_procedure()
	 * @see #getEquipment()
	 * @generated
	 */
	EReference getEquipment_Maintenance_procedure();

	/**
	 * Returns the meta object for class '{@link setools.mbpe.ManufacturedMaterial
	 * <em>Manufactured Material</em>}'. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @return the meta object for class '<em>Manufactured Material</em>'.
	 * @see setools.mbpe.ManufacturedMaterial
	 * @generated
	 */
	EClass getManufacturedMaterial();

	/**
	 * Returns the meta object for the reference
	 * '{@link setools.mbpe.ManufacturedMaterial#getBase_Class <em>Base
	 * Class</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the reference '<em>Base Class</em>'.
	 * @see setools.mbpe.ManufacturedMaterial#getBase_Class()
	 * @see #getManufacturedMaterial()
	 * @generated
	 */
	EReference getManufacturedMaterial_Base_Class();

	/**
	 * Returns the meta object for the attribute
	 * '{@link setools.mbpe.ManufacturedMaterial#getManfacturer
	 * <em>Manfacturer</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Manfacturer</em>'.
	 * @see setools.mbpe.ManufacturedMaterial#getManfacturer()
	 * @see #getManufacturedMaterial()
	 * @generated
	 */
	EAttribute getManufacturedMaterial_Manfacturer();

	/**
	 * Returns the meta object for the attribute
	 * '{@link setools.mbpe.ManufacturedMaterial#getPart_number <em>Part
	 * number</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Part number</em>'.
	 * @see setools.mbpe.ManufacturedMaterial#getPart_number()
	 * @see #getManufacturedMaterial()
	 * @generated
	 */
	EAttribute getManufacturedMaterial_Part_number();

	/**
	 * Returns the meta object for class '{@link setools.mbpe.OperatingProcedure
	 * <em>Operating Procedure</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Operating Procedure</em>'.
	 * @see setools.mbpe.OperatingProcedure
	 * @generated
	 */
	EClass getOperatingProcedure();

	/**
	 * Returns the meta object for class '{@link setools.mbpe.Procedure
	 * <em>Procedure</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Procedure</em>'.
	 * @see setools.mbpe.Procedure
	 * @generated
	 */
	EClass getProcedure();

	/**
	 * Returns the meta object for the reference
	 * '{@link setools.mbpe.Procedure#getBase_Behavior <em>Base Behavior</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the reference '<em>Base Behavior</em>'.
	 * @see setools.mbpe.Procedure#getBase_Behavior()
	 * @see #getProcedure()
	 * @generated
	 */
	EReference getProcedure_Base_Behavior();

	/**
	 * Returns the meta object for the reference list
	 * '{@link setools.mbpe.Procedure#getEquipment <em>Equipment</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the reference list '<em>Equipment</em>'.
	 * @see setools.mbpe.Procedure#getEquipment()
	 * @see #getProcedure()
	 * @generated
	 */
	EReference getProcedure_Equipment();

	/**
	 * Returns the meta object for the reference list
	 * '{@link setools.mbpe.Procedure#getMaterial <em>Material</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the reference list '<em>Material</em>'.
	 * @see setools.mbpe.Procedure#getMaterial()
	 * @see #getProcedure()
	 * @generated
	 */
	EReference getProcedure_Material();

	/**
	 * Returns the meta object for class '{@link setools.mbpe.Material
	 * <em>Material</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Material</em>'.
	 * @see setools.mbpe.Material
	 * @generated
	 */
	EClass getMaterial();

	/**
	 * Returns the meta object for class '{@link setools.mbpe.MaintenanceProcedure
	 * <em>Maintenance Procedure</em>}'. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @return the meta object for class '<em>Maintenance Procedure</em>'.
	 * @see setools.mbpe.MaintenanceProcedure
	 * @generated
	 */
	EClass getMaintenanceProcedure();

	/**
	 * Returns the meta object for class '{@link setools.mbpe.CreationProcedure
	 * <em>Creation Procedure</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Creation Procedure</em>'.
	 * @see setools.mbpe.CreationProcedure
	 * @generated
	 */
	EClass getCreationProcedure();

	/**
	 * Returns the meta object for the reference list
	 * '{@link setools.mbpe.CreationProcedure#getEnd_item <em>End item</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the reference list '<em>End item</em>'.
	 * @see setools.mbpe.CreationProcedure#getEnd_item()
	 * @see #getCreationProcedure()
	 * @generated
	 */
	EReference getCreationProcedure_End_item();

	/**
	 * Returns the meta object for class '{@link setools.mbpe.AssemblyProcedure
	 * <em>Assembly Procedure</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Assembly Procedure</em>'.
	 * @see setools.mbpe.AssemblyProcedure
	 * @generated
	 */
	EClass getAssemblyProcedure();

	/**
	 * Returns the meta object for class '{@link setools.mbpe.FabricationProcedure
	 * <em>Fabrication Procedure</em>}'. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @return the meta object for class '<em>Fabrication Procedure</em>'.
	 * @see setools.mbpe.FabricationProcedure
	 * @generated
	 */
	EClass getFabricationProcedure();

	/**
	 * Returns the meta object for class '{@link setools.mbpe.InstallationProcedure
	 * <em>Installation Procedure</em>}'. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @return the meta object for class '<em>Installation Procedure</em>'.
	 * @see setools.mbpe.InstallationProcedure
	 * @generated
	 */
	EClass getInstallationProcedure();

	/**
	 * Returns the meta object for class '{@link setools.mbpe.CalibrationProcedure
	 * <em>Calibration Procedure</em>}'. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @return the meta object for class '<em>Calibration Procedure</em>'.
	 * @see setools.mbpe.CalibrationProcedure
	 * @generated
	 */
	EClass getCalibrationProcedure();

	/**
	 * Returns the factory that creates the instances of the model. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	MbpeFactory getMbpeFactory();

	/**
	 * <!-- begin-user-doc --> Defines literals for the meta objects that represent
	 * <ul>
	 * <li>each class,</li>
	 * <li>each feature of each class,</li>
	 * <li>each operation of each class,</li>
	 * <li>each enum,</li>
	 * <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the
		 * '{@link setools.mbpe.impl.SupportEquipmentImpl <em>Support Equipment</em>}'
		 * class. <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @see setools.mbpe.impl.SupportEquipmentImpl
		 * @see setools.mbpe.impl.MbpePackageImpl#getSupportEquipment()
		 * @generated
		 */
		EClass SUPPORT_EQUIPMENT = eINSTANCE.getSupportEquipment();

		/**
		 * The meta object literal for the '<em><b>Fabrication procedure</b></em>'
		 * reference list feature. <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference SUPPORT_EQUIPMENT__FABRICATION_PROCEDURE = eINSTANCE.getSupportEquipment_Fabrication_procedure();

		/**
		 * The meta object literal for the '{@link setools.mbpe.impl.EquipmentImpl
		 * <em>Equipment</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @see setools.mbpe.impl.EquipmentImpl
		 * @see setools.mbpe.impl.MbpePackageImpl#getEquipment()
		 * @generated
		 */
		EClass EQUIPMENT = eINSTANCE.getEquipment();

		/**
		 * The meta object literal for the '<em><b>Operating procedure</b></em>'
		 * reference list feature. <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference EQUIPMENT__OPERATING_PROCEDURE = eINSTANCE.getEquipment_Operating_procedure();

		/**
		 * The meta object literal for the '<em><b>Maintenance procedure</b></em>'
		 * reference list feature. <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference EQUIPMENT__MAINTENANCE_PROCEDURE = eINSTANCE.getEquipment_Maintenance_procedure();

		/**
		 * The meta object literal for the
		 * '{@link setools.mbpe.impl.ManufacturedMaterialImpl <em>Manufactured
		 * Material</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @see setools.mbpe.impl.ManufacturedMaterialImpl
		 * @see setools.mbpe.impl.MbpePackageImpl#getManufacturedMaterial()
		 * @generated
		 */
		EClass MANUFACTURED_MATERIAL = eINSTANCE.getManufacturedMaterial();

		/**
		 * The meta object literal for the '<em><b>Base Class</b></em>' reference
		 * feature. <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference MANUFACTURED_MATERIAL__BASE_CLASS = eINSTANCE.getManufacturedMaterial_Base_Class();

		/**
		 * The meta object literal for the '<em><b>Manfacturer</b></em>' attribute
		 * feature. <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute MANUFACTURED_MATERIAL__MANFACTURER = eINSTANCE.getManufacturedMaterial_Manfacturer();

		/**
		 * The meta object literal for the '<em><b>Part number</b></em>' attribute
		 * feature. <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute MANUFACTURED_MATERIAL__PART_NUMBER = eINSTANCE.getManufacturedMaterial_Part_number();

		/**
		 * The meta object literal for the
		 * '{@link setools.mbpe.impl.OperatingProcedureImpl <em>Operating
		 * Procedure</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @see setools.mbpe.impl.OperatingProcedureImpl
		 * @see setools.mbpe.impl.MbpePackageImpl#getOperatingProcedure()
		 * @generated
		 */
		EClass OPERATING_PROCEDURE = eINSTANCE.getOperatingProcedure();

		/**
		 * The meta object literal for the '{@link setools.mbpe.impl.ProcedureImpl
		 * <em>Procedure</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @see setools.mbpe.impl.ProcedureImpl
		 * @see setools.mbpe.impl.MbpePackageImpl#getProcedure()
		 * @generated
		 */
		EClass PROCEDURE = eINSTANCE.getProcedure();

		/**
		 * The meta object literal for the '<em><b>Base Behavior</b></em>' reference
		 * feature. <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference PROCEDURE__BASE_BEHAVIOR = eINSTANCE.getProcedure_Base_Behavior();

		/**
		 * The meta object literal for the '<em><b>Equipment</b></em>' reference list
		 * feature. <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference PROCEDURE__EQUIPMENT = eINSTANCE.getProcedure_Equipment();

		/**
		 * The meta object literal for the '<em><b>Material</b></em>' reference list
		 * feature. <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference PROCEDURE__MATERIAL = eINSTANCE.getProcedure_Material();

		/**
		 * The meta object literal for the '{@link setools.mbpe.impl.MaterialImpl
		 * <em>Material</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @see setools.mbpe.impl.MaterialImpl
		 * @see setools.mbpe.impl.MbpePackageImpl#getMaterial()
		 * @generated
		 */
		EClass MATERIAL = eINSTANCE.getMaterial();

		/**
		 * The meta object literal for the
		 * '{@link setools.mbpe.impl.MaintenanceProcedureImpl <em>Maintenance
		 * Procedure</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @see setools.mbpe.impl.MaintenanceProcedureImpl
		 * @see setools.mbpe.impl.MbpePackageImpl#getMaintenanceProcedure()
		 * @generated
		 */
		EClass MAINTENANCE_PROCEDURE = eINSTANCE.getMaintenanceProcedure();

		/**
		 * The meta object literal for the
		 * '{@link setools.mbpe.impl.CreationProcedureImpl <em>Creation Procedure</em>}'
		 * class. <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @see setools.mbpe.impl.CreationProcedureImpl
		 * @see setools.mbpe.impl.MbpePackageImpl#getCreationProcedure()
		 * @generated
		 */
		EClass CREATION_PROCEDURE = eINSTANCE.getCreationProcedure();

		/**
		 * The meta object literal for the '<em><b>End item</b></em>' reference list
		 * feature. <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference CREATION_PROCEDURE__END_ITEM = eINSTANCE.getCreationProcedure_End_item();

		/**
		 * The meta object literal for the
		 * '{@link setools.mbpe.impl.AssemblyProcedureImpl <em>Assembly Procedure</em>}'
		 * class. <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @see setools.mbpe.impl.AssemblyProcedureImpl
		 * @see setools.mbpe.impl.MbpePackageImpl#getAssemblyProcedure()
		 * @generated
		 */
		EClass ASSEMBLY_PROCEDURE = eINSTANCE.getAssemblyProcedure();

		/**
		 * The meta object literal for the
		 * '{@link setools.mbpe.impl.FabricationProcedureImpl <em>Fabrication
		 * Procedure</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @see setools.mbpe.impl.FabricationProcedureImpl
		 * @see setools.mbpe.impl.MbpePackageImpl#getFabricationProcedure()
		 * @generated
		 */
		EClass FABRICATION_PROCEDURE = eINSTANCE.getFabricationProcedure();

		/**
		 * The meta object literal for the
		 * '{@link setools.mbpe.impl.InstallationProcedureImpl <em>Installation
		 * Procedure</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @see setools.mbpe.impl.InstallationProcedureImpl
		 * @see setools.mbpe.impl.MbpePackageImpl#getInstallationProcedure()
		 * @generated
		 */
		EClass INSTALLATION_PROCEDURE = eINSTANCE.getInstallationProcedure();

		/**
		 * The meta object literal for the
		 * '{@link setools.mbpe.impl.CalibrationProcedureImpl <em>Calibration
		 * Procedure</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @see setools.mbpe.impl.CalibrationProcedureImpl
		 * @see setools.mbpe.impl.MbpePackageImpl#getCalibrationProcedure()
		 * @generated
		 */
		EClass CALIBRATION_PROCEDURE = eINSTANCE.getCalibrationProcedure();

	}

} // MbpePackage
