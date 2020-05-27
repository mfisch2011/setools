/**
   Copyright 2019 Matt Fischer <mfish2011@gmail.com>

   Licensed under the Apache License, Version 2.0 (the "License");
   you may not use this file except in compliance with the License.
   You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

   Unless required by applicable law or agreed to in writing, software
   distributed under the License is distributed on an "AS IS" BASIS,
   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
   See the License for the specific language governing permissions and
   limitations under the License.
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
import setools.risk.Risk;
import setools.risk.RiskFactory;
import setools.risk.RiskLevel;
import setools.risk.RiskMitigation;
import setools.risk.RiskPackage;
import setools.risk.StatusUpdate;

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
	private EClass riskMitigationEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass statusUpdateEClass = null;

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
	public EAttribute getRisk_Id() {
		return (EAttribute) riskEClass.getEStructuralFeatures().get(0);
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
	public EAttribute getRisk_Likelihood() {
		return (EAttribute) riskEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EAttribute getRisk_Consequence() {
		return (EAttribute) riskEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EAttribute getRisk_Risk() {
		return (EAttribute) riskEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EReference getRisk_Base_Class() {
		return (EReference) riskEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EReference getRisk_Mitigations() {
		return (EReference) riskEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EClass getRiskMitigation() {
		return riskMitigationEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EAttribute getRiskMitigation_Planned() {
		return (EAttribute) riskMitigationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EReference getRiskMitigation_Base_Class() {
		return (EReference) riskMitigationEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EAttribute getRiskMitigation_Id() {
		return (EAttribute) riskMitigationEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EAttribute getRiskMitigation_Statement() {
		return (EAttribute) riskMitigationEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EAttribute getRiskMitigation_Likelihood() {
		return (EAttribute) riskMitigationEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EAttribute getRiskMitigation_Consequence() {
		return (EAttribute) riskMitigationEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EAttribute getRiskMitigation_Risk() {
		return (EAttribute) riskMitigationEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EClass getStatusUpdate() {
		return statusUpdateEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EReference getStatusUpdate_Base_Comment() {
		return (EReference) statusUpdateEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EAttribute getStatusUpdate_Date() {
		return (EAttribute) statusUpdateEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EAttribute getStatusUpdate_Source() {
		return (EAttribute) statusUpdateEClass.getEStructuralFeatures().get(2);
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
		createEAttribute(riskEClass, RISK__ID);
		createEAttribute(riskEClass, RISK__STATEMENT);
		createEAttribute(riskEClass, RISK__LIKELIHOOD);
		createEAttribute(riskEClass, RISK__CONSEQUENCE);
		createEAttribute(riskEClass, RISK__RISK);
		createEReference(riskEClass, RISK__BASE_CLASS);
		createEReference(riskEClass, RISK__MITIGATIONS);

		riskMitigationEClass = createEClass(RISK_MITIGATION);
		createEAttribute(riskMitigationEClass, RISK_MITIGATION__PLANNED);
		createEReference(riskMitigationEClass, RISK_MITIGATION__BASE_CLASS);
		createEAttribute(riskMitigationEClass, RISK_MITIGATION__ID);
		createEAttribute(riskMitigationEClass, RISK_MITIGATION__STATEMENT);
		createEAttribute(riskMitigationEClass, RISK_MITIGATION__LIKELIHOOD);
		createEAttribute(riskMitigationEClass, RISK_MITIGATION__CONSEQUENCE);
		createEAttribute(riskMitigationEClass, RISK_MITIGATION__RISK);

		statusUpdateEClass = createEClass(STATUS_UPDATE);
		createEReference(statusUpdateEClass, STATUS_UPDATE__BASE_COMMENT);
		createEAttribute(statusUpdateEClass, STATUS_UPDATE__DATE);
		createEAttribute(statusUpdateEClass, STATUS_UPDATE__SOURCE);

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
		TypesPackage theTypesPackage = (TypesPackage) EPackage.Registry.INSTANCE.getEPackage(TypesPackage.eNS_URI);
		UMLPackage theUMLPackage = (UMLPackage) EPackage.Registry.INSTANCE.getEPackage(UMLPackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes

		// Initialize classes, features, and operations; add parameters
		initEClass(riskEClass, Risk.class, "Risk", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getRisk_Id(), theTypesPackage.getString(), "id", null, 1, 1, Risk.class, !IS_TRANSIENT,
				!IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getRisk_Statement(), theTypesPackage.getString(), "statement", null, 1, 1, Risk.class,
				!IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED,
				!IS_ORDERED);
		initEAttribute(getRisk_Likelihood(), this.getLikelihood(), "likelihood", null, 1, 1, Risk.class, !IS_TRANSIENT,
				!IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getRisk_Consequence(), this.getConsequence(), "consequence", null, 1, 1, Risk.class,
				!IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED,
				!IS_ORDERED);
		initEAttribute(getRisk_Risk(), this.getRiskLevel(), "risk", null, 1, 1, Risk.class, IS_TRANSIENT, IS_VOLATILE,
				!IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, IS_DERIVED, !IS_ORDERED);
		initEReference(getRisk_Base_Class(), theUMLPackage.getClass_(), null, "base_Class", null, 0, 1, Risk.class,
				!IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE,
				IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getRisk_Mitigations(), this.getRiskMitigation(), null, "mitigations", null, 0, -1, Risk.class,
				IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE,
				IS_DERIVED, !IS_ORDERED);

		initEClass(riskMitigationEClass, RiskMitigation.class, "RiskMitigation", !IS_ABSTRACT, !IS_INTERFACE,
				IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getRiskMitigation_Planned(), ecorePackage.getEDate(), "planned", null, 1, 1,
				RiskMitigation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE,
				!IS_DERIVED, !IS_ORDERED);
		initEReference(getRiskMitigation_Base_Class(), theUMLPackage.getClass_(), null, "base_Class", null, 0, 1,
				RiskMitigation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES,
				!IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getRiskMitigation_Id(), theTypesPackage.getString(), "id", null, 1, 1, RiskMitigation.class,
				!IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED,
				!IS_ORDERED);
		initEAttribute(getRiskMitigation_Statement(), theTypesPackage.getString(), "statement", null, 1, 1,
				RiskMitigation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE,
				!IS_DERIVED, !IS_ORDERED);
		initEAttribute(getRiskMitigation_Likelihood(), this.getLikelihood(), "likelihood", null, 1, 1,
				RiskMitigation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE,
				!IS_DERIVED, !IS_ORDERED);
		initEAttribute(getRiskMitigation_Consequence(), this.getConsequence(), "consequence", null, 1, 1,
				RiskMitigation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE,
				!IS_DERIVED, !IS_ORDERED);
		initEAttribute(getRiskMitigation_Risk(), this.getRiskLevel(), "risk", null, 1, 1, RiskMitigation.class,
				IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, IS_DERIVED, !IS_ORDERED);

		initEClass(statusUpdateEClass, StatusUpdate.class, "StatusUpdate", !IS_ABSTRACT, !IS_INTERFACE,
				IS_GENERATED_INSTANCE_CLASS);
		initEReference(getStatusUpdate_Base_Comment(), theUMLPackage.getComment(), null, "base_Comment", null, 0, 1,
				StatusUpdate.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES,
				!IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getStatusUpdate_Date(), ecorePackage.getEDate(), "date", null, 1, 1, StatusUpdate.class,
				!IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED,
				!IS_ORDERED);
		initEAttribute(getStatusUpdate_Source(), theTypesPackage.getString(), "source", null, 1, 1, StatusUpdate.class,
				!IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED,
				!IS_ORDERED);

		// Initialize enums and add enum literals
		initEEnum(likelihoodEEnum, Likelihood.class, "Likelihood");
		addEEnumLiteral(likelihoodEEnum, Likelihood.NOT_LIKELY);
		addEEnumLiteral(likelihoodEEnum, Likelihood.LOW_LIKELIHOOD);
		addEEnumLiteral(likelihoodEEnum, Likelihood.LIKELY);
		addEEnumLiteral(likelihoodEEnum, Likelihood.HIGHLY_LIKELY);
		addEEnumLiteral(likelihoodEEnum, Likelihood.NEAR_CERTAINTY);

		initEEnum(consequenceEEnum, Consequence.class, "Consequence");
		addEEnumLiteral(consequenceEEnum, Consequence.MINIMAL_IMPACT);
		addEEnumLiteral(consequenceEEnum, Consequence.LOW_IMPACT);
		addEEnumLiteral(consequenceEEnum, Consequence.MODERATE_IMPACT);
		addEEnumLiteral(consequenceEEnum, Consequence.SIGNIFIACNT_IMPACT);
		addEEnumLiteral(consequenceEEnum, Consequence.CATASTROPHIC_IMPACT);

		initEEnum(riskLevelEEnum, RiskLevel.class, "RiskLevel");
		addEEnumLiteral(riskLevelEEnum, RiskLevel.LOW);
		addEEnumLiteral(riskLevelEEnum, RiskLevel.MEDIUM);
		addEEnumLiteral(riskLevelEEnum, RiskLevel.HIGH);

		// Create resource
		createResource(eNS_URI);

		// Create annotations
		// http://www.eclipse.org/uml2/2.0.0/UML
		createUMLAnnotations();
	}

	/**
	 * Initializes the annotations for <b>http://www.eclipse.org/uml2/2.0.0/UML</b>.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected void createUMLAnnotations() {
		String source = "http://www.eclipse.org/uml2/2.0.0/UML";
		addAnnotation(riskLevelEEnum, source, new String[] { "originalName", "Risk Level" });
		addAnnotation(riskMitigationEClass, source, new String[] { "originalName", "Risk Mitigation" });
		addAnnotation(statusUpdateEClass, source, new String[] { "originalName", "Status Update" });
	}

} // RiskPackageImpl
