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
	String eNS_URI = "http://setools/setools/risk/0.0.12/RiskML";

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
	 * The feature id for the '<em><b>Id</b></em>' attribute. <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int RISK__ID = 0;

	/**
	 * The feature id for the '<em><b>Statement</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int RISK__STATEMENT = 1;

	/**
	 * The feature id for the '<em><b>Likelihood</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int RISK__LIKELIHOOD = 2;

	/**
	 * The feature id for the '<em><b>Consequence</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int RISK__CONSEQUENCE = 3;

	/**
	 * The feature id for the '<em><b>Risk</b></em>' attribute. <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int RISK__RISK = 4;

	/**
	 * The feature id for the '<em><b>Base Class</b></em>' reference. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int RISK__BASE_CLASS = 5;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int RISK__DESCRIPTION = 6;

	/**
	 * The number of structural features of the '<em>Risk</em>' class. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int RISK_FEATURE_COUNT = 7;

	/**
	 * The number of operations of the '<em>Risk</em>' class. <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int RISK_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link setools.risk.impl.RiskMitigationImpl
	 * <em>Mitigation</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see setools.risk.impl.RiskMitigationImpl
	 * @see setools.risk.impl.RiskPackageImpl#getRiskMitigation()
	 * @generated
	 */
	int RISK_MITIGATION = 1;

	/**
	 * The feature id for the '<em><b>Planned</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int RISK_MITIGATION__PLANNED = 0;

	/**
	 * The feature id for the '<em><b>Base Class</b></em>' reference. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int RISK_MITIGATION__BASE_CLASS = 1;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute. <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int RISK_MITIGATION__ID = 2;

	/**
	 * The feature id for the '<em><b>Statement</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int RISK_MITIGATION__STATEMENT = 3;

	/**
	 * The feature id for the '<em><b>Likelihood</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int RISK_MITIGATION__LIKELIHOOD = 4;

	/**
	 * The feature id for the '<em><b>Consequence</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int RISK_MITIGATION__CONSEQUENCE = 5;

	/**
	 * The feature id for the '<em><b>Risk</b></em>' attribute. <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int RISK_MITIGATION__RISK = 6;

	/**
	 * The number of structural features of the '<em>Mitigation</em>' class. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int RISK_MITIGATION_FEATURE_COUNT = 7;

	/**
	 * The number of operations of the '<em>Mitigation</em>' class. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int RISK_MITIGATION_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link setools.risk.impl.StatusUpdateImpl
	 * <em>Status Update</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see setools.risk.impl.StatusUpdateImpl
	 * @see setools.risk.impl.RiskPackageImpl#getStatusUpdate()
	 * @generated
	 */
	int STATUS_UPDATE = 2;

	/**
	 * The feature id for the '<em><b>Base Comment</b></em>' reference. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int STATUS_UPDATE__BASE_COMMENT = 0;

	/**
	 * The feature id for the '<em><b>Date</b></em>' attribute. <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int STATUS_UPDATE__DATE = 1;

	/**
	 * The feature id for the '<em><b>Source</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int STATUS_UPDATE__SOURCE = 2;

	/**
	 * The number of structural features of the '<em>Status Update</em>' class. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int STATUS_UPDATE_FEATURE_COUNT = 3;

	/**
	 * The number of operations of the '<em>Status Update</em>' class. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int STATUS_UPDATE_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link setools.risk.Likelihood
	 * <em>Likelihood</em>}' enum. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see setools.risk.Likelihood
	 * @see setools.risk.impl.RiskPackageImpl#getLikelihood()
	 * @generated
	 */
	int LIKELIHOOD = 3;

	/**
	 * The meta object id for the '{@link setools.risk.Consequence
	 * <em>Consequence</em>}' enum. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see setools.risk.Consequence
	 * @see setools.risk.impl.RiskPackageImpl#getConsequence()
	 * @generated
	 */
	int CONSEQUENCE = 4;

	/**
	 * The meta object id for the '{@link setools.risk.RiskLevel <em>Level</em>}'
	 * enum. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see setools.risk.RiskLevel
	 * @see setools.risk.impl.RiskPackageImpl#getRiskLevel()
	 * @generated
	 */
	int RISK_LEVEL = 5;

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
	 * Returns the meta object for the attribute '{@link setools.risk.Risk#getId
	 * <em>Id</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Id</em>'.
	 * @see setools.risk.Risk#getId()
	 * @see #getRisk()
	 * @generated
	 */
	EAttribute getRisk_Id();

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
	 * Returns the meta object for the attribute '{@link setools.risk.Risk#getRisk
	 * <em>Risk</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Risk</em>'.
	 * @see setools.risk.Risk#getRisk()
	 * @see #getRisk()
	 * @generated
	 */
	EAttribute getRisk_Risk();

	/**
	 * Returns the meta object for the reference
	 * '{@link setools.risk.Risk#getBase_Class <em>Base Class</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the reference '<em>Base Class</em>'.
	 * @see setools.risk.Risk#getBase_Class()
	 * @see #getRisk()
	 * @generated
	 */
	EReference getRisk_Base_Class();

	/**
	 * Returns the meta object for the attribute
	 * '{@link setools.risk.Risk#getDescription <em>Description</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Description</em>'.
	 * @see setools.risk.Risk#getDescription()
	 * @see #getRisk()
	 * @generated
	 */
	EAttribute getRisk_Description();

	/**
	 * Returns the meta object for class '{@link setools.risk.RiskMitigation
	 * <em>Mitigation</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Mitigation</em>'.
	 * @see setools.risk.RiskMitigation
	 * @generated
	 */
	EClass getRiskMitigation();

	/**
	 * Returns the meta object for the attribute
	 * '{@link setools.risk.RiskMitigation#getPlanned <em>Planned</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Planned</em>'.
	 * @see setools.risk.RiskMitigation#getPlanned()
	 * @see #getRiskMitigation()
	 * @generated
	 */
	EAttribute getRiskMitigation_Planned();

	/**
	 * Returns the meta object for the reference
	 * '{@link setools.risk.RiskMitigation#getBase_Class <em>Base Class</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the reference '<em>Base Class</em>'.
	 * @see setools.risk.RiskMitigation#getBase_Class()
	 * @see #getRiskMitigation()
	 * @generated
	 */
	EReference getRiskMitigation_Base_Class();

	/**
	 * Returns the meta object for the attribute
	 * '{@link setools.risk.RiskMitigation#getId <em>Id</em>}'. <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Id</em>'.
	 * @see setools.risk.RiskMitigation#getId()
	 * @see #getRiskMitigation()
	 * @generated
	 */
	EAttribute getRiskMitigation_Id();

	/**
	 * Returns the meta object for the attribute
	 * '{@link setools.risk.RiskMitigation#getStatement <em>Statement</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Statement</em>'.
	 * @see setools.risk.RiskMitigation#getStatement()
	 * @see #getRiskMitigation()
	 * @generated
	 */
	EAttribute getRiskMitigation_Statement();

	/**
	 * Returns the meta object for the attribute
	 * '{@link setools.risk.RiskMitigation#getLikelihood <em>Likelihood</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Likelihood</em>'.
	 * @see setools.risk.RiskMitigation#getLikelihood()
	 * @see #getRiskMitigation()
	 * @generated
	 */
	EAttribute getRiskMitigation_Likelihood();

	/**
	 * Returns the meta object for the attribute
	 * '{@link setools.risk.RiskMitigation#getConsequence <em>Consequence</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Consequence</em>'.
	 * @see setools.risk.RiskMitigation#getConsequence()
	 * @see #getRiskMitigation()
	 * @generated
	 */
	EAttribute getRiskMitigation_Consequence();

	/**
	 * Returns the meta object for the attribute
	 * '{@link setools.risk.RiskMitigation#getRisk <em>Risk</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Risk</em>'.
	 * @see setools.risk.RiskMitigation#getRisk()
	 * @see #getRiskMitigation()
	 * @generated
	 */
	EAttribute getRiskMitigation_Risk();

	/**
	 * Returns the meta object for class '{@link setools.risk.StatusUpdate
	 * <em>Status Update</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Status Update</em>'.
	 * @see setools.risk.StatusUpdate
	 * @generated
	 */
	EClass getStatusUpdate();

	/**
	 * Returns the meta object for the reference
	 * '{@link setools.risk.StatusUpdate#getBase_Comment <em>Base Comment</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the reference '<em>Base Comment</em>'.
	 * @see setools.risk.StatusUpdate#getBase_Comment()
	 * @see #getStatusUpdate()
	 * @generated
	 */
	EReference getStatusUpdate_Base_Comment();

	/**
	 * Returns the meta object for the attribute
	 * '{@link setools.risk.StatusUpdate#getDate <em>Date</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Date</em>'.
	 * @see setools.risk.StatusUpdate#getDate()
	 * @see #getStatusUpdate()
	 * @generated
	 */
	EAttribute getStatusUpdate_Date();

	/**
	 * Returns the meta object for the attribute
	 * '{@link setools.risk.StatusUpdate#getSource <em>Source</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Source</em>'.
	 * @see setools.risk.StatusUpdate#getSource()
	 * @see #getStatusUpdate()
	 * @generated
	 */
	EAttribute getStatusUpdate_Source();

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
		 * The meta object literal for the '<em><b>Id</b></em>' attribute feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute RISK__ID = eINSTANCE.getRisk_Id();

		/**
		 * The meta object literal for the '<em><b>Statement</b></em>' attribute
		 * feature. <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute RISK__STATEMENT = eINSTANCE.getRisk_Statement();

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
		 * The meta object literal for the '<em><b>Risk</b></em>' attribute feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute RISK__RISK = eINSTANCE.getRisk_Risk();

		/**
		 * The meta object literal for the '<em><b>Base Class</b></em>' reference
		 * feature. <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference RISK__BASE_CLASS = eINSTANCE.getRisk_Base_Class();

		/**
		 * The meta object literal for the '<em><b>Description</b></em>' attribute
		 * feature. <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute RISK__DESCRIPTION = eINSTANCE.getRisk_Description();

		/**
		 * The meta object literal for the '{@link setools.risk.impl.RiskMitigationImpl
		 * <em>Mitigation</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @see setools.risk.impl.RiskMitigationImpl
		 * @see setools.risk.impl.RiskPackageImpl#getRiskMitigation()
		 * @generated
		 */
		EClass RISK_MITIGATION = eINSTANCE.getRiskMitigation();

		/**
		 * The meta object literal for the '<em><b>Planned</b></em>' attribute feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute RISK_MITIGATION__PLANNED = eINSTANCE.getRiskMitigation_Planned();

		/**
		 * The meta object literal for the '<em><b>Base Class</b></em>' reference
		 * feature. <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference RISK_MITIGATION__BASE_CLASS = eINSTANCE.getRiskMitigation_Base_Class();

		/**
		 * The meta object literal for the '<em><b>Id</b></em>' attribute feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute RISK_MITIGATION__ID = eINSTANCE.getRiskMitigation_Id();

		/**
		 * The meta object literal for the '<em><b>Statement</b></em>' attribute
		 * feature. <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute RISK_MITIGATION__STATEMENT = eINSTANCE.getRiskMitigation_Statement();

		/**
		 * The meta object literal for the '<em><b>Likelihood</b></em>' attribute
		 * feature. <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute RISK_MITIGATION__LIKELIHOOD = eINSTANCE.getRiskMitigation_Likelihood();

		/**
		 * The meta object literal for the '<em><b>Consequence</b></em>' attribute
		 * feature. <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute RISK_MITIGATION__CONSEQUENCE = eINSTANCE.getRiskMitigation_Consequence();

		/**
		 * The meta object literal for the '<em><b>Risk</b></em>' attribute feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute RISK_MITIGATION__RISK = eINSTANCE.getRiskMitigation_Risk();

		/**
		 * The meta object literal for the '{@link setools.risk.impl.StatusUpdateImpl
		 * <em>Status Update</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @see setools.risk.impl.StatusUpdateImpl
		 * @see setools.risk.impl.RiskPackageImpl#getStatusUpdate()
		 * @generated
		 */
		EClass STATUS_UPDATE = eINSTANCE.getStatusUpdate();

		/**
		 * The meta object literal for the '<em><b>Base Comment</b></em>' reference
		 * feature. <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference STATUS_UPDATE__BASE_COMMENT = eINSTANCE.getStatusUpdate_Base_Comment();

		/**
		 * The meta object literal for the '<em><b>Date</b></em>' attribute feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute STATUS_UPDATE__DATE = eINSTANCE.getStatusUpdate_Date();

		/**
		 * The meta object literal for the '<em><b>Source</b></em>' attribute feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute STATUS_UPDATE__SOURCE = eINSTANCE.getStatusUpdate_Source();

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
