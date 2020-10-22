/**
 */
package setools.risk.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EcorePackage;

import org.eclipse.emf.ecore.impl.EPackageImpl;

import org.eclipse.uml2.types.TypesPackage;

import org.eclipse.uml2.uml.UMLPackage;

import setools.risk.Consequence;
import setools.risk.Likelihood;
import setools.risk.Mitigation;
import setools.risk.Risk;
import setools.risk.RiskFactory;
import setools.risk.RiskLevel;
import setools.risk.RiskPackage;

/**
 * <!-- begin-user-doc --> An implementation of the model <b>Package</b>. <!--
 * end-user-doc -->
 * 
 * @generated
 */
public class RiskPackageImpl extends EPackageImpl implements RiskPackage {
	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass riskEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass mitigationEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EEnum likelihoodEEnum = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EEnum consequenceEEnum = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EEnum riskLevelEEnum = null;

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
	 * @see setools.risk.RiskPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private RiskPackageImpl() {
		super(eNS_URI, RiskFactory.eINSTANCE);
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
	 * This method is used to initialize {@link RiskPackage#eINSTANCE} when that
	 * field is accessed. Clients should not invoke it directly. Instead, they
	 * should simply access that field to obtain the package. <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * 
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static RiskPackage init() {
		if (isInited)
			return (RiskPackage) EPackage.Registry.INSTANCE.getEPackage(RiskPackage.eNS_URI);

		// Obtain or create and register package
		Object registeredRiskPackage = EPackage.Registry.INSTANCE.get(eNS_URI);
		RiskPackageImpl theRiskPackage = registeredRiskPackage instanceof RiskPackageImpl
				? (RiskPackageImpl) registeredRiskPackage
				: new RiskPackageImpl();

		isInited = true;

		// Initialize simple dependencies
		EcorePackage.eINSTANCE.eClass();
		TypesPackage.eINSTANCE.eClass();
		UMLPackage.eINSTANCE.eClass();

		// Create package meta-data objects
		theRiskPackage.createPackageContents();

		// Initialize created meta-data
		theRiskPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theRiskPackage.freeze();

		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(RiskPackage.eNS_URI, theRiskPackage);
		return theRiskPackage;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EClass getRisk() {
		return riskEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EReference getRisk_BaseClass() {
		return (EReference) riskEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EAttribute getRisk_Statement() {
		return (EAttribute) riskEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EAttribute getRisk_Text() {
		return (EAttribute) riskEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EAttribute getRisk_Category() {
		return (EAttribute) riskEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EAttribute getRisk_Likelihood() {
		return (EAttribute) riskEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EAttribute getRisk_Consequence() {
		return (EAttribute) riskEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EAttribute getRisk_RiskLevel() {
		return (EAttribute) riskEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EReference getRisk_Mitigations() {
		return (EReference) riskEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EAttribute getRisk_Name() {
		return (EAttribute) riskEClass.getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EClass getMitigation() {
		return mitigationEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EReference getMitigation_BaseClass() {
		return (EReference) mitigationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EAttribute getMitigation_Name() {
		return (EAttribute) mitigationEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EAttribute getMitigation_Text() {
		return (EAttribute) mitigationEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EAttribute getMitigation_Likelihood() {
		return (EAttribute) mitigationEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EAttribute getMitigation_Consequence() {
		return (EAttribute) mitigationEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EAttribute getMitigation_RiskLevel() {
		return (EAttribute) mitigationEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EEnum getLikelihood() {
		return likelihoodEEnum;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EEnum getConsequence() {
		return consequenceEEnum;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EEnum getRiskLevel() {
		return riskLevelEEnum;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public RiskFactory getRiskFactory() {
		return (RiskFactory) getEFactoryInstance();
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
		riskEClass = createEClass(RISK);
		createEReference(riskEClass, RISK__BASE_CLASS);
		createEAttribute(riskEClass, RISK__STATEMENT);
		createEAttribute(riskEClass, RISK__TEXT);
		createEAttribute(riskEClass, RISK__CATEGORY);
		createEAttribute(riskEClass, RISK__LIKELIHOOD);
		createEAttribute(riskEClass, RISK__CONSEQUENCE);
		createEAttribute(riskEClass, RISK__RISK_LEVEL);
		createEReference(riskEClass, RISK__MITIGATIONS);
		createEAttribute(riskEClass, RISK__NAME);

		mitigationEClass = createEClass(MITIGATION);
		createEReference(mitigationEClass, MITIGATION__BASE_CLASS);
		createEAttribute(mitigationEClass, MITIGATION__NAME);
		createEAttribute(mitigationEClass, MITIGATION__TEXT);
		createEAttribute(mitigationEClass, MITIGATION__LIKELIHOOD);
		createEAttribute(mitigationEClass, MITIGATION__CONSEQUENCE);
		createEAttribute(mitigationEClass, MITIGATION__RISK_LEVEL);

		// Create enums
		likelihoodEEnum = createEEnum(LIKELIHOOD);
		consequenceEEnum = createEEnum(CONSEQUENCE);
		riskLevelEEnum = createEEnum(RISK_LEVEL);
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

		// Initialize classes, features, and operations; add parameters
		initEClass(riskEClass, Risk.class, "Risk", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getRisk_BaseClass(), theUMLPackage.getClass_(), null, "baseClass", null, 0, 1, Risk.class,
				!IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE,
				IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getRisk_Statement(), theTypesPackage.getString(), "statement", null, 1, 1, Risk.class,
				!IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED,
				!IS_ORDERED);
		initEAttribute(getRisk_Text(), theTypesPackage.getString(), "text", null, 0, -1, Risk.class, !IS_TRANSIENT,
				!IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getRisk_Category(), theTypesPackage.getString(), "category", null, 1, 1, Risk.class,
				!IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED,
				!IS_ORDERED);
		initEAttribute(getRisk_Likelihood(), this.getLikelihood(), "likelihood", null, 1, 1, Risk.class, !IS_TRANSIENT,
				!IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getRisk_Consequence(), this.getConsequence(), "consequence", null, 1, 1, Risk.class,
				!IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED,
				!IS_ORDERED);
		initEAttribute(getRisk_RiskLevel(), this.getRiskLevel(), "riskLevel", null, 1, 1, Risk.class, IS_TRANSIENT,
				IS_VOLATILE, !IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, IS_DERIVED, !IS_ORDERED);
		initEReference(getRisk_Mitigations(), this.getMitigation(), null, "mitigations", null, 0, -1, Risk.class,
				IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE,
				IS_DERIVED, !IS_ORDERED);
		initEAttribute(getRisk_Name(), theTypesPackage.getString(), "name", null, 1, 1, Risk.class, !IS_TRANSIENT,
				!IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(mitigationEClass, Mitigation.class, "Mitigation", !IS_ABSTRACT, !IS_INTERFACE,
				IS_GENERATED_INSTANCE_CLASS);
		initEReference(getMitigation_BaseClass(), theUMLPackage.getClass_(), null, "baseClass", null, 0, 1,
				Mitigation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES,
				!IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getMitigation_Name(), theTypesPackage.getString(), "name", null, 1, 1, Mitigation.class,
				!IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED,
				!IS_ORDERED);
		initEAttribute(getMitigation_Text(), theTypesPackage.getString(), "text", null, 1, 1, Mitigation.class,
				!IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED,
				!IS_ORDERED);
		initEAttribute(getMitigation_Likelihood(), this.getLikelihood(), "likelihood", null, 1, 1, Mitigation.class,
				!IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED,
				!IS_ORDERED);
		initEAttribute(getMitigation_Consequence(), this.getConsequence(), "consequence", null, 1, 1, Mitigation.class,
				!IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED,
				!IS_ORDERED);
		initEAttribute(getMitigation_RiskLevel(), this.getRiskLevel(), "riskLevel", null, 1, 1, Mitigation.class,
				!IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED,
				!IS_ORDERED);

		// Initialize enums and add enum literals
		initEEnum(likelihoodEEnum, Likelihood.class, "Likelihood");
		addEEnumLiteral(likelihoodEEnum, Likelihood.NOT_LIKELY);
		addEEnumLiteral(likelihoodEEnum, Likelihood.LOW_LIKELIHOOD);
		addEEnumLiteral(likelihoodEEnum, Likelihood.LIKELY);
		addEEnumLiteral(likelihoodEEnum, Likelihood.HIGHLY_LIKELY);
		addEEnumLiteral(likelihoodEEnum, Likelihood.NEAR_CERTAIN);

		initEEnum(consequenceEEnum, Consequence.class, "Consequence");
		addEEnumLiteral(consequenceEEnum, Consequence.MINIMAL_IMPACT);
		addEEnumLiteral(consequenceEEnum, Consequence.MINOR_IMPACT);
		addEEnumLiteral(consequenceEEnum, Consequence.MODERATE_IMPACT);
		addEEnumLiteral(consequenceEEnum, Consequence.SIGNIFICANT_IMPACT);
		addEEnumLiteral(consequenceEEnum, Consequence.CRITICAL_IMPACT);

		initEEnum(riskLevelEEnum, RiskLevel.class, "RiskLevel");
		addEEnumLiteral(riskLevelEEnum, RiskLevel.LOW);
		addEEnumLiteral(riskLevelEEnum, RiskLevel.MEDIUM);
		addEEnumLiteral(riskLevelEEnum, RiskLevel.HIGH);

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
		addAnnotation(getRisk_BaseClass(), source, new String[] { "originalName", "base_Class" });
		addAnnotation(getRisk_Statement(), source, new String[] { "originalName", "Statement" });
		addAnnotation(getRisk_Text(), source, new String[] { "originalName", "Text" });
		addAnnotation(getRisk_Category(), source, new String[] { "originalName", "Category" });
		addAnnotation(getRisk_Likelihood(), source, new String[] { "originalName", "Likelihood" });
		addAnnotation(getRisk_Consequence(), source, new String[] { "originalName", "Consequence" });
		addAnnotation(getRisk_RiskLevel(), source, new String[] { "originalName", "RiskLevel" });
		addAnnotation(getRisk_Mitigations(), source, new String[] { "originalName", "Mitigations" });
		addAnnotation(getRisk_Name(), source, new String[] { "originalName", "Name" });
		addAnnotation(likelihoodEEnum.getELiterals().get(0), source, new String[] { "originalName", "NOT_LIKELY" });
		addAnnotation(likelihoodEEnum.getELiterals().get(1), source, new String[] { "originalName", "LOW_LIKELIHOOD" });
		addAnnotation(likelihoodEEnum.getELiterals().get(2), source, new String[] { "originalName", "LIKELY" });
		addAnnotation(likelihoodEEnum.getELiterals().get(3), source, new String[] { "originalName", "HIGHLY_LIKELY" });
		addAnnotation(likelihoodEEnum.getELiterals().get(4), source, new String[] { "originalName", "NEAR_CERTAIN" });
		addAnnotation(consequenceEEnum.getELiterals().get(0), source,
				new String[] { "originalName", "MINIMAL_IMPACT" });
		addAnnotation(consequenceEEnum.getELiterals().get(1), source, new String[] { "originalName", "MINOR_IMPACT" });
		addAnnotation(consequenceEEnum.getELiterals().get(2), source,
				new String[] { "originalName", "MODERATE_IMPACT" });
		addAnnotation(consequenceEEnum.getELiterals().get(3), source,
				new String[] { "originalName", "SIGNIFICANT_IMPACT" });
		addAnnotation(consequenceEEnum.getELiterals().get(4), source,
				new String[] { "originalName", "CRITICAL_IMPACT" });
		addAnnotation(riskLevelEEnum.getELiterals().get(0), source, new String[] { "originalName", "LOW" });
		addAnnotation(riskLevelEEnum.getELiterals().get(1), source, new String[] { "originalName", "MEDIUM" });
		addAnnotation(riskLevelEEnum.getELiterals().get(2), source, new String[] { "originalName", "HIGH" });
		addAnnotation(getMitigation_BaseClass(), source, new String[] { "originalName", "base_Class" });
		addAnnotation(getMitigation_Name(), source, new String[] { "originalName", "Name" });
		addAnnotation(getMitigation_Text(), source, new String[] { "originalName", "Text" });
		addAnnotation(getMitigation_Likelihood(), source, new String[] { "originalName", "Likelihood" });
		addAnnotation(getMitigation_Consequence(), source, new String[] { "originalName", "Consequence" });
		addAnnotation(getMitigation_RiskLevel(), source, new String[] { "originalName", "RiskLevel" });
	}

	/**
	 * Initializes the annotations for <b>union</b>. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 */
	protected void createUnionAnnotations() {
		String source = "union";
		addAnnotation(getRisk_Mitigations(), source, new String[] {});
	}

} // RiskPackageImpl
