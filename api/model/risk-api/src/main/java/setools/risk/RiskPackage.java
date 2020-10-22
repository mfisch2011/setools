/**
 */
package setools.risk;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
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
 * @see setools.risk.RiskFactory
 * @model kind="package"
 * @generated
 */
public interface RiskPackage extends EPackage {
	/**
	 * The package name. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	String eNAME = "risk";

	/**
	 * The package namespace URI. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	String eNS_URI = "http://SETOOLS/RISK/0.0.2/risk";

	/**
	 * The package namespace name. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	String eNS_PREFIX = "risk";

	/**
	 * The singleton instance of the package. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 */
	RiskPackage eINSTANCE = setools.risk.impl.RiskPackageImpl.init();

	/**
	 * The meta object id for the '{@link setools.risk.impl.RiskImpl <em>Risk</em>}'
	 * class. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see setools.risk.impl.RiskImpl
	 * @see setools.risk.impl.RiskPackageImpl#getRisk()
	 * @generated
	 */
	int RISK = 0;

	/**
	 * The feature id for the '<em><b>Base Class</b></em>' reference. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int RISK__BASE_CLASS = 0;

	/**
	 * The feature id for the '<em><b>Statement</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int RISK__STATEMENT = 1;

	/**
	 * The feature id for the '<em><b>Text</b></em>' attribute list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int RISK__TEXT = 2;

	/**
	 * The feature id for the '<em><b>Category</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int RISK__CATEGORY = 3;

	/**
	 * The feature id for the '<em><b>Likelihood</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int RISK__LIKELIHOOD = 4;

	/**
	 * The feature id for the '<em><b>Consequence</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int RISK__CONSEQUENCE = 5;

	/**
	 * The feature id for the '<em><b>Risk Level</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int RISK__RISK_LEVEL = 6;

	/**
	 * The feature id for the '<em><b>Mitigations</b></em>' reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int RISK__MITIGATIONS = 7;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute. <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int RISK__NAME = 8;

	/**
	 * The number of structural features of the '<em>Risk</em>' class. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int RISK_FEATURE_COUNT = 9;

	/**
	 * The number of operations of the '<em>Risk</em>' class. <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int RISK_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link setools.risk.impl.MitigationImpl
	 * <em>Mitigation</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see setools.risk.impl.MitigationImpl
	 * @see setools.risk.impl.RiskPackageImpl#getMitigation()
	 * @generated
	 */
	int MITIGATION = 1;

	/**
	 * The feature id for the '<em><b>Base Class</b></em>' reference. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int MITIGATION__BASE_CLASS = 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute. <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int MITIGATION__NAME = 1;

	/**
	 * The feature id for the '<em><b>Text</b></em>' attribute. <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int MITIGATION__TEXT = 2;

	/**
	 * The feature id for the '<em><b>Likelihood</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int MITIGATION__LIKELIHOOD = 3;

	/**
	 * The feature id for the '<em><b>Consequence</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int MITIGATION__CONSEQUENCE = 4;

	/**
	 * The feature id for the '<em><b>Risk Level</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int MITIGATION__RISK_LEVEL = 5;

	/**
	 * The number of structural features of the '<em>Mitigation</em>' class. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int MITIGATION_FEATURE_COUNT = 6;

	/**
	 * The number of operations of the '<em>Mitigation</em>' class. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int MITIGATION_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link setools.risk.Likelihood
	 * <em>Likelihood</em>}' enum. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see setools.risk.Likelihood
	 * @see setools.risk.impl.RiskPackageImpl#getLikelihood()
	 * @generated
	 */
	int LIKELIHOOD = 2;

	/**
	 * The meta object id for the '{@link setools.risk.Consequence
	 * <em>Consequence</em>}' enum. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see setools.risk.Consequence
	 * @see setools.risk.impl.RiskPackageImpl#getConsequence()
	 * @generated
	 */
	int CONSEQUENCE = 3;

	/**
	 * The meta object id for the '{@link setools.risk.RiskLevel <em>Level</em>}'
	 * enum. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see setools.risk.RiskLevel
	 * @see setools.risk.impl.RiskPackageImpl#getRiskLevel()
	 * @generated
	 */
	int RISK_LEVEL = 4;

	/**
	 * Returns the meta object for class '{@link setools.risk.Risk <em>Risk</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Risk</em>'.
	 * @see setools.risk.Risk
	 * @generated
	 */
	EClass getRisk();

	/**
	 * Returns the meta object for the reference
	 * '{@link setools.risk.Risk#getBaseClass <em>Base Class</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the reference '<em>Base Class</em>'.
	 * @see setools.risk.Risk#getBaseClass()
	 * @see #getRisk()
	 * @generated
	 */
	EReference getRisk_BaseClass();

	/**
	 * Returns the meta object for the attribute
	 * '{@link setools.risk.Risk#getStatement <em>Statement</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Statement</em>'.
	 * @see setools.risk.Risk#getStatement()
	 * @see #getRisk()
	 * @generated
	 */
	EAttribute getRisk_Statement();

	/**
	 * Returns the meta object for the attribute list
	 * '{@link setools.risk.Risk#getText <em>Text</em>}'. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute list '<em>Text</em>'.
	 * @see setools.risk.Risk#getText()
	 * @see #getRisk()
	 * @generated
	 */
	EAttribute getRisk_Text();

	/**
	 * Returns the meta object for the attribute
	 * '{@link setools.risk.Risk#getCategory <em>Category</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Category</em>'.
	 * @see setools.risk.Risk#getCategory()
	 * @see #getRisk()
	 * @generated
	 */
	EAttribute getRisk_Category();

	/**
	 * Returns the meta object for the attribute
	 * '{@link setools.risk.Risk#getLikelihood <em>Likelihood</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Likelihood</em>'.
	 * @see setools.risk.Risk#getLikelihood()
	 * @see #getRisk()
	 * @generated
	 */
	EAttribute getRisk_Likelihood();

	/**
	 * Returns the meta object for the attribute
	 * '{@link setools.risk.Risk#getConsequence <em>Consequence</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Consequence</em>'.
	 * @see setools.risk.Risk#getConsequence()
	 * @see #getRisk()
	 * @generated
	 */
	EAttribute getRisk_Consequence();

	/**
	 * Returns the meta object for the attribute
	 * '{@link setools.risk.Risk#getRiskLevel <em>Risk Level</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Risk Level</em>'.
	 * @see setools.risk.Risk#getRiskLevel()
	 * @see #getRisk()
	 * @generated
	 */
	EAttribute getRisk_RiskLevel();

	/**
	 * Returns the meta object for the reference list
	 * '{@link setools.risk.Risk#getMitigations <em>Mitigations</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the reference list '<em>Mitigations</em>'.
	 * @see setools.risk.Risk#getMitigations()
	 * @see #getRisk()
	 * @generated
	 */
	EReference getRisk_Mitigations();

	/**
	 * Returns the meta object for the attribute '{@link setools.risk.Risk#getName
	 * <em>Name</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see setools.risk.Risk#getName()
	 * @see #getRisk()
	 * @generated
	 */
	EAttribute getRisk_Name();

	/**
	 * Returns the meta object for class '{@link setools.risk.Mitigation
	 * <em>Mitigation</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Mitigation</em>'.
	 * @see setools.risk.Mitigation
	 * @generated
	 */
	EClass getMitigation();

	/**
	 * Returns the meta object for the reference
	 * '{@link setools.risk.Mitigation#getBaseClass <em>Base Class</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the reference '<em>Base Class</em>'.
	 * @see setools.risk.Mitigation#getBaseClass()
	 * @see #getMitigation()
	 * @generated
	 */
	EReference getMitigation_BaseClass();

	/**
	 * Returns the meta object for the attribute
	 * '{@link setools.risk.Mitigation#getName <em>Name</em>}'. <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see setools.risk.Mitigation#getName()
	 * @see #getMitigation()
	 * @generated
	 */
	EAttribute getMitigation_Name();

	/**
	 * Returns the meta object for the attribute
	 * '{@link setools.risk.Mitigation#getText <em>Text</em>}'. <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Text</em>'.
	 * @see setools.risk.Mitigation#getText()
	 * @see #getMitigation()
	 * @generated
	 */
	EAttribute getMitigation_Text();

	/**
	 * Returns the meta object for the attribute
	 * '{@link setools.risk.Mitigation#getLikelihood <em>Likelihood</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Likelihood</em>'.
	 * @see setools.risk.Mitigation#getLikelihood()
	 * @see #getMitigation()
	 * @generated
	 */
	EAttribute getMitigation_Likelihood();

	/**
	 * Returns the meta object for the attribute
	 * '{@link setools.risk.Mitigation#getConsequence <em>Consequence</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Consequence</em>'.
	 * @see setools.risk.Mitigation#getConsequence()
	 * @see #getMitigation()
	 * @generated
	 */
	EAttribute getMitigation_Consequence();

	/**
	 * Returns the meta object for the attribute
	 * '{@link setools.risk.Mitigation#getRiskLevel <em>Risk Level</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Risk Level</em>'.
	 * @see setools.risk.Mitigation#getRiskLevel()
	 * @see #getMitigation()
	 * @generated
	 */
	EAttribute getMitigation_RiskLevel();

	/**
	 * Returns the meta object for enum '{@link setools.risk.Likelihood
	 * <em>Likelihood</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for enum '<em>Likelihood</em>'.
	 * @see setools.risk.Likelihood
	 * @generated
	 */
	EEnum getLikelihood();

	/**
	 * Returns the meta object for enum '{@link setools.risk.Consequence
	 * <em>Consequence</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for enum '<em>Consequence</em>'.
	 * @see setools.risk.Consequence
	 * @generated
	 */
	EEnum getConsequence();

	/**
	 * Returns the meta object for enum '{@link setools.risk.RiskLevel
	 * <em>Level</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for enum '<em>Level</em>'.
	 * @see setools.risk.RiskLevel
	 * @generated
	 */
	EEnum getRiskLevel();

	/**
	 * Returns the factory that creates the instances of the model. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	RiskFactory getRiskFactory();

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
		 * The meta object literal for the '{@link setools.risk.impl.RiskImpl
		 * <em>Risk</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @see setools.risk.impl.RiskImpl
		 * @see setools.risk.impl.RiskPackageImpl#getRisk()
		 * @generated
		 */
		EClass RISK = eINSTANCE.getRisk();

		/**
		 * The meta object literal for the '<em><b>Base Class</b></em>' reference
		 * feature. <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference RISK__BASE_CLASS = eINSTANCE.getRisk_BaseClass();

		/**
		 * The meta object literal for the '<em><b>Statement</b></em>' attribute
		 * feature. <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute RISK__STATEMENT = eINSTANCE.getRisk_Statement();

		/**
		 * The meta object literal for the '<em><b>Text</b></em>' attribute list
		 * feature. <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute RISK__TEXT = eINSTANCE.getRisk_Text();

		/**
		 * The meta object literal for the '<em><b>Category</b></em>' attribute feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute RISK__CATEGORY = eINSTANCE.getRisk_Category();

		/**
		 * The meta object literal for the '<em><b>Likelihood</b></em>' attribute
		 * feature. <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute RISK__LIKELIHOOD = eINSTANCE.getRisk_Likelihood();

		/**
		 * The meta object literal for the '<em><b>Consequence</b></em>' attribute
		 * feature. <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute RISK__CONSEQUENCE = eINSTANCE.getRisk_Consequence();

		/**
		 * The meta object literal for the '<em><b>Risk Level</b></em>' attribute
		 * feature. <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute RISK__RISK_LEVEL = eINSTANCE.getRisk_RiskLevel();

		/**
		 * The meta object literal for the '<em><b>Mitigations</b></em>' reference list
		 * feature. <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference RISK__MITIGATIONS = eINSTANCE.getRisk_Mitigations();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute RISK__NAME = eINSTANCE.getRisk_Name();

		/**
		 * The meta object literal for the '{@link setools.risk.impl.MitigationImpl
		 * <em>Mitigation</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @see setools.risk.impl.MitigationImpl
		 * @see setools.risk.impl.RiskPackageImpl#getMitigation()
		 * @generated
		 */
		EClass MITIGATION = eINSTANCE.getMitigation();

		/**
		 * The meta object literal for the '<em><b>Base Class</b></em>' reference
		 * feature. <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference MITIGATION__BASE_CLASS = eINSTANCE.getMitigation_BaseClass();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute MITIGATION__NAME = eINSTANCE.getMitigation_Name();

		/**
		 * The meta object literal for the '<em><b>Text</b></em>' attribute feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute MITIGATION__TEXT = eINSTANCE.getMitigation_Text();

		/**
		 * The meta object literal for the '<em><b>Likelihood</b></em>' attribute
		 * feature. <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute MITIGATION__LIKELIHOOD = eINSTANCE.getMitigation_Likelihood();

		/**
		 * The meta object literal for the '<em><b>Consequence</b></em>' attribute
		 * feature. <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute MITIGATION__CONSEQUENCE = eINSTANCE.getMitigation_Consequence();

		/**
		 * The meta object literal for the '<em><b>Risk Level</b></em>' attribute
		 * feature. <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute MITIGATION__RISK_LEVEL = eINSTANCE.getMitigation_RiskLevel();

		/**
		 * The meta object literal for the '{@link setools.risk.Likelihood
		 * <em>Likelihood</em>}' enum. <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @see setools.risk.Likelihood
		 * @see setools.risk.impl.RiskPackageImpl#getLikelihood()
		 * @generated
		 */
		EEnum LIKELIHOOD = eINSTANCE.getLikelihood();

		/**
		 * The meta object literal for the '{@link setools.risk.Consequence
		 * <em>Consequence</em>}' enum. <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @see setools.risk.Consequence
		 * @see setools.risk.impl.RiskPackageImpl#getConsequence()
		 * @generated
		 */
		EEnum CONSEQUENCE = eINSTANCE.getConsequence();

		/**
		 * The meta object literal for the '{@link setools.risk.RiskLevel
		 * <em>Level</em>}' enum. <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @see setools.risk.RiskLevel
		 * @see setools.risk.impl.RiskPackageImpl#getRiskLevel()
		 * @generated
		 */
		EEnum RISK_LEVEL = eINSTANCE.getRiskLevel();

	}

} // RiskPackage
