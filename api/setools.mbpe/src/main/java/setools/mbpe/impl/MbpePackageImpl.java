/**
 */
package setools.mbpe.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EcorePackage;

import org.eclipse.emf.ecore.impl.EPackageImpl;

import org.eclipse.uml2.types.TypesPackage;

import org.eclipse.uml2.uml.UMLPackage;

import setools.mbpe.AssemblyProcedure;
import setools.mbpe.CalibrationProcedure;
import setools.mbpe.CreationProcedure;
import setools.mbpe.Equipment;
import setools.mbpe.FabricationProcedure;
import setools.mbpe.InstallationProcedure;
import setools.mbpe.MaintenanceProcedure;
import setools.mbpe.ManufacturedMaterial;
import setools.mbpe.Material;
import setools.mbpe.MbpeFactory;
import setools.mbpe.MbpePackage;
import setools.mbpe.OperatingProcedure;
import setools.mbpe.Procedure;
import setools.mbpe.SupportEquipment;

/**
 * <!-- begin-user-doc --> An implementation of the model <b>Package</b>. <!--
 * end-user-doc -->
 * 
 * @generated
 */
public class MbpePackageImpl extends EPackageImpl implements MbpePackage {
	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass supportEquipmentEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass equipmentEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass manufacturedMaterialEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass operatingProcedureEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass procedureEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass materialEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass maintenanceProcedureEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass creationProcedureEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass assemblyProcedureEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass fabricationProcedureEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass installationProcedureEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass calibrationProcedureEClass = null;

	/**
	 * Creates an instance of the model <b>Package</b>, registered with
	 * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the
	 * package package URI value.
	 * <p>
	 * Note: the correct way to create the package is via the static factory method
	 * {@link #init init()}, which also performs initialization of the package, or
	 * returns the registered package, if one already exists. <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * 
	 * @see org.eclipse.emf.ecore.EPackage.Registry
	 * @see setools.mbpe.MbpePackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private MbpePackageImpl() {
		super(eNS_URI, MbpeFactory.eINSTANCE);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private static boolean isInited = false;

	/**
	 * Creates, registers, and initializes the <b>Package</b> for this model, and
	 * for any others upon which it depends.
	 *
	 * <p>
	 * This method is used to initialize {@link MbpePackage#eINSTANCE} when that
	 * field is accessed. Clients should not invoke it directly. Instead, they
	 * should simply access that field to obtain the package. <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * 
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static MbpePackage init() {
		if (isInited)
			return (MbpePackage) EPackage.Registry.INSTANCE.getEPackage(MbpePackage.eNS_URI);

		// Obtain or create and register package
		Object registeredMbpePackage = EPackage.Registry.INSTANCE.get(eNS_URI);
		MbpePackageImpl theMbpePackage = registeredMbpePackage instanceof MbpePackageImpl
				? (MbpePackageImpl) registeredMbpePackage
				: new MbpePackageImpl();

		isInited = true;

		// Initialize simple dependencies
		EcorePackage.eINSTANCE.eClass();
		TypesPackage.eINSTANCE.eClass();
		UMLPackage.eINSTANCE.eClass();

		// Create package meta-data objects
		theMbpePackage.createPackageContents();

		// Initialize created meta-data
		theMbpePackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theMbpePackage.freeze();

		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(MbpePackage.eNS_URI, theMbpePackage);
		return theMbpePackage;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EClass getSupportEquipment() {
		return supportEquipmentEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EReference getSupportEquipment_Fabrication_procedure() {
		return (EReference) supportEquipmentEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EClass getEquipment() {
		return equipmentEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EReference getEquipment_Operating_procedure() {
		return (EReference) equipmentEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EReference getEquipment_Maintenance_procedure() {
		return (EReference) equipmentEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EClass getManufacturedMaterial() {
		return manufacturedMaterialEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EReference getManufacturedMaterial_Base_Class() {
		return (EReference) manufacturedMaterialEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EAttribute getManufacturedMaterial_Manfacturer() {
		return (EAttribute) manufacturedMaterialEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EAttribute getManufacturedMaterial_Part_number() {
		return (EAttribute) manufacturedMaterialEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EClass getOperatingProcedure() {
		return operatingProcedureEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EClass getProcedure() {
		return procedureEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EReference getProcedure_Base_Behavior() {
		return (EReference) procedureEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EReference getProcedure_Equipment() {
		return (EReference) procedureEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EReference getProcedure_Material() {
		return (EReference) procedureEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EClass getMaterial() {
		return materialEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EClass getMaintenanceProcedure() {
		return maintenanceProcedureEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EClass getCreationProcedure() {
		return creationProcedureEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EReference getCreationProcedure_End_item() {
		return (EReference) creationProcedureEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EClass getAssemblyProcedure() {
		return assemblyProcedureEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EClass getFabricationProcedure() {
		return fabricationProcedureEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EClass getInstallationProcedure() {
		return installationProcedureEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EClass getCalibrationProcedure() {
		return calibrationProcedureEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public MbpeFactory getMbpeFactory() {
		return (MbpeFactory) getEFactoryInstance();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private boolean isCreated = false;

	/**
	 * Creates the meta-model objects for the package. This method is guarded to
	 * have no affect on any invocation but its first. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 */
	public void createPackageContents() {
		if (isCreated)
			return;
		isCreated = true;

		// Create classes and their features
		supportEquipmentEClass = createEClass(SUPPORT_EQUIPMENT);
		createEReference(supportEquipmentEClass, SUPPORT_EQUIPMENT__FABRICATION_PROCEDURE);

		equipmentEClass = createEClass(EQUIPMENT);
		createEReference(equipmentEClass, EQUIPMENT__OPERATING_PROCEDURE);
		createEReference(equipmentEClass, EQUIPMENT__MAINTENANCE_PROCEDURE);

		manufacturedMaterialEClass = createEClass(MANUFACTURED_MATERIAL);
		createEReference(manufacturedMaterialEClass, MANUFACTURED_MATERIAL__BASE_CLASS);
		createEAttribute(manufacturedMaterialEClass, MANUFACTURED_MATERIAL__MANFACTURER);
		createEAttribute(manufacturedMaterialEClass, MANUFACTURED_MATERIAL__PART_NUMBER);

		operatingProcedureEClass = createEClass(OPERATING_PROCEDURE);

		procedureEClass = createEClass(PROCEDURE);
		createEReference(procedureEClass, PROCEDURE__BASE_BEHAVIOR);
		createEReference(procedureEClass, PROCEDURE__EQUIPMENT);
		createEReference(procedureEClass, PROCEDURE__MATERIAL);

		materialEClass = createEClass(MATERIAL);

		maintenanceProcedureEClass = createEClass(MAINTENANCE_PROCEDURE);

		creationProcedureEClass = createEClass(CREATION_PROCEDURE);
		createEReference(creationProcedureEClass, CREATION_PROCEDURE__END_ITEM);

		assemblyProcedureEClass = createEClass(ASSEMBLY_PROCEDURE);

		fabricationProcedureEClass = createEClass(FABRICATION_PROCEDURE);

		installationProcedureEClass = createEClass(INSTALLATION_PROCEDURE);

		calibrationProcedureEClass = createEClass(CALIBRATION_PROCEDURE);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private boolean isInitialized = false;

	/**
	 * Complete the initialization of the package and its meta-model. This method is
	 * guarded to have no affect on any invocation but its first. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void initializePackageContents() {
		if (isInitialized)
			return;
		isInitialized = true;

		// Initialize package
		setName(eNAME);
		setNsPrefix(eNS_PREFIX);
		setNsURI(eNS_URI);

		// Obtain other dependent packages
		UMLPackage theUMLPackage = (UMLPackage) EPackage.Registry.INSTANCE.getEPackage(UMLPackage.eNS_URI);
		TypesPackage theTypesPackage = (TypesPackage) EPackage.Registry.INSTANCE.getEPackage(TypesPackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		supportEquipmentEClass.getESuperTypes().add(this.getEquipment());
		equipmentEClass.getESuperTypes().add(this.getManufacturedMaterial());
		operatingProcedureEClass.getESuperTypes().add(this.getProcedure());
		materialEClass.getESuperTypes().add(this.getManufacturedMaterial());
		maintenanceProcedureEClass.getESuperTypes().add(this.getOperatingProcedure());
		creationProcedureEClass.getESuperTypes().add(this.getProcedure());
		assemblyProcedureEClass.getESuperTypes().add(this.getCreationProcedure());
		fabricationProcedureEClass.getESuperTypes().add(this.getCreationProcedure());
		installationProcedureEClass.getESuperTypes().add(this.getCreationProcedure());
		calibrationProcedureEClass.getESuperTypes().add(this.getMaintenanceProcedure());

		// Initialize classes, features, and operations; add parameters
		initEClass(supportEquipmentEClass, SupportEquipment.class, "SupportEquipment", !IS_ABSTRACT, !IS_INTERFACE,
				IS_GENERATED_INSTANCE_CLASS);
		initEReference(getSupportEquipment_Fabrication_procedure(), this.getCreationProcedure(), null,
				"fabrication_procedure", null, 0, -1, SupportEquipment.class, !IS_TRANSIENT, !IS_VOLATILE,
				IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(equipmentEClass, Equipment.class, "Equipment", !IS_ABSTRACT, !IS_INTERFACE,
				IS_GENERATED_INSTANCE_CLASS);
		initEReference(getEquipment_Operating_procedure(), this.getOperatingProcedure(), null, "operating_procedure",
				null, 0, -1, Equipment.class, IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, !IS_COMPOSITE,
				IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, !IS_ORDERED);
		initEReference(getEquipment_Maintenance_procedure(), this.getMaintenanceProcedure(), null,
				"maintenance_procedure", null, 0, -1, Equipment.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE,
				!IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(manufacturedMaterialEClass, ManufacturedMaterial.class, "ManufacturedMaterial", IS_ABSTRACT,
				!IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getManufacturedMaterial_Base_Class(), theUMLPackage.getClass_(), null, "base_Class", null, 0, 1,
				ManufacturedMaterial.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE,
				IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getManufacturedMaterial_Manfacturer(), theTypesPackage.getString(), "manfacturer", null, 1, 1,
				ManufacturedMaterial.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID,
				IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getManufacturedMaterial_Part_number(), theTypesPackage.getString(), "part_number", null, 1, 1,
				ManufacturedMaterial.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID,
				IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(operatingProcedureEClass, OperatingProcedure.class, "OperatingProcedure", !IS_ABSTRACT,
				!IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(procedureEClass, Procedure.class, "Procedure", IS_ABSTRACT, !IS_INTERFACE,
				IS_GENERATED_INSTANCE_CLASS);
		initEReference(getProcedure_Base_Behavior(), theUMLPackage.getBehavior(), null, "base_Behavior", null, 0, 1,
				Procedure.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES,
				!IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getProcedure_Equipment(), this.getEquipment(), null, "equipment", null, 0, -1, Procedure.class,
				IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE,
				IS_DERIVED, !IS_ORDERED);
		initEReference(getProcedure_Material(), this.getMaterial(), null, "material", null, 0, -1, Procedure.class,
				IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE,
				IS_DERIVED, !IS_ORDERED);

		initEClass(materialEClass, Material.class, "Material", !IS_ABSTRACT, !IS_INTERFACE,
				IS_GENERATED_INSTANCE_CLASS);

		initEClass(maintenanceProcedureEClass, MaintenanceProcedure.class, "MaintenanceProcedure", !IS_ABSTRACT,
				!IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(creationProcedureEClass, CreationProcedure.class, "CreationProcedure", IS_ABSTRACT, !IS_INTERFACE,
				IS_GENERATED_INSTANCE_CLASS);
		initEReference(getCreationProcedure_End_item(), this.getManufacturedMaterial(), null, "end_item", null, 0, -1,
				CreationProcedure.class, !IS_TRANSIENT, !IS_VOLATILE, !IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES,
				!IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(assemblyProcedureEClass, AssemblyProcedure.class, "AssemblyProcedure", !IS_ABSTRACT, !IS_INTERFACE,
				IS_GENERATED_INSTANCE_CLASS);

		initEClass(fabricationProcedureEClass, FabricationProcedure.class, "FabricationProcedure", !IS_ABSTRACT,
				!IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(installationProcedureEClass, InstallationProcedure.class, "InstallationProcedure", !IS_ABSTRACT,
				!IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(calibrationProcedureEClass, CalibrationProcedure.class, "CalibrationProcedure", !IS_ABSTRACT,
				!IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		// Create resource
		createResource(eNS_URI);

		// Create annotations
		// http://www.eclipse.org/uml2/2.0.0/UML
		createUMLAnnotations();
		// union
		createUnionAnnotations();
	}

	/**
	 * Initializes the annotations for <b>http://www.eclipse.org/uml2/2.0.0/UML</b>.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected void createUMLAnnotations() {
		String source = "http://www.eclipse.org/uml2/2.0.0/UML";
		addAnnotation(supportEquipmentEClass, source, new String[] { "originalName", "Support Equipment" });
		addAnnotation(manufacturedMaterialEClass, source, new String[] { "originalName", "Manufactured Material" });
		addAnnotation(operatingProcedureEClass, source, new String[] { "originalName", "Operating Procedure" });
		addAnnotation(maintenanceProcedureEClass, source, new String[] { "originalName", "Maintenance Procedure" });
		addAnnotation(creationProcedureEClass, source, new String[] { "originalName", "Creation Procedure" });
		addAnnotation(assemblyProcedureEClass, source, new String[] { "originalName", "Assembly Procedure" });
		addAnnotation(fabricationProcedureEClass, source, new String[] { "originalName", "Fabrication Procedure" });
		addAnnotation(installationProcedureEClass, source, new String[] { "originalName", "Installation Procedure" });
		addAnnotation(calibrationProcedureEClass, source, new String[] { "originalName", "Calibration Procedure" });
	}

	/**
	 * Initializes the annotations for <b>union</b>. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 */
	protected void createUnionAnnotations() {
		String source = "union";
		addAnnotation(getEquipment_Operating_procedure(), source, new String[] {});
		addAnnotation(getProcedure_Equipment(), source, new String[] {});
		addAnnotation(getProcedure_Material(), source, new String[] {});
	}

} // MbpePackageImpl
