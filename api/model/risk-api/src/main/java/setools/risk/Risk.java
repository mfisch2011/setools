/**
 */
package setools.risk;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc --> A representation of the model object
 * '<em><b>Risk</b></em>'. <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 * <li>{@link setools.risk.Risk#getBaseClass <em>Base Class</em>}</li>
 * <li>{@link setools.risk.Risk#getStatement <em>Statement</em>}</li>
 * <li>{@link setools.risk.Risk#getText <em>Text</em>}</li>
 * <li>{@link setools.risk.Risk#getCategory <em>Category</em>}</li>
 * <li>{@link setools.risk.Risk#getLikelihood <em>Likelihood</em>}</li>
 * <li>{@link setools.risk.Risk#getConsequence <em>Consequence</em>}</li>
 * <li>{@link setools.risk.Risk#getRiskLevel <em>Risk Level</em>}</li>
 * <li>{@link setools.risk.Risk#getMitigations <em>Mitigations</em>}</li>
 * <li>{@link setools.risk.Risk#getName <em>Name</em>}</li>
 * </ul>
 *
 * @see setools.risk.RiskPackage#getRisk()
 * @model
 * @generated
 */
public interface Risk extends EObject {
	/**
	 * Returns the value of the '<em><b>Base Class</b></em>' reference. <!--
	 * begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Base Class</em>' reference isn't clear, there
	 * really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Base Class</em>' reference.
	 * @see #setBaseClass(org.eclipse.uml2.uml.Class)
	 * @see setools.risk.RiskPackage#getRisk_BaseClass()
	 * @model ordered="false" annotation="http://www.eclipse.org/uml2/2.0.0/UML
	 *        originalName='base_Class'"
	 * @generated
	 */
	org.eclipse.uml2.uml.Class getBaseClass();

	/**
	 * Sets the value of the '{@link setools.risk.Risk#getBaseClass <em>Base
	 * Class</em>}' reference. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param value the new value of the '<em>Base Class</em>' reference.
	 * @see #getBaseClass()
	 * @generated
	 */
	void setBaseClass(org.eclipse.uml2.uml.Class value);

	/**
	 * Returns the value of the '<em><b>Statement</b></em>' attribute. <!--
	 * begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Statement</em>' attribute isn't clear, there
	 * really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Statement</em>' attribute.
	 * @see #setStatement(String)
	 * @see setools.risk.RiskPackage#getRisk_Statement()
	 * @model dataType="org.eclipse.uml2.types.String" required="true"
	 *        ordered="false" annotation="http://www.eclipse.org/uml2/2.0.0/UML
	 *        originalName='Statement'"
	 * @generated
	 */
	String getStatement();

	/**
	 * Sets the value of the '{@link setools.risk.Risk#getStatement
	 * <em>Statement</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param value the new value of the '<em>Statement</em>' attribute.
	 * @see #getStatement()
	 * @generated
	 */
	void setStatement(String value);

	/**
	 * Returns the value of the '<em><b>Text</b></em>' attribute list. The list
	 * contents are of type {@link java.lang.String}. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Text</em>' attribute list isn't clear, there
	 * really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Text</em>' attribute list.
	 * @see setools.risk.RiskPackage#getRisk_Text()
	 * @model dataType="org.eclipse.uml2.types.String" ordered="false"
	 *        annotation="http://www.eclipse.org/uml2/2.0.0/UML originalName='Text'"
	 * @generated
	 */
	EList<String> getText();

	/**
	 * Returns the value of the '<em><b>Category</b></em>' attribute. <!--
	 * begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Category</em>' attribute isn't clear, there really
	 * should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Category</em>' attribute.
	 * @see #setCategory(String)
	 * @see setools.risk.RiskPackage#getRisk_Category()
	 * @model dataType="org.eclipse.uml2.types.String" required="true"
	 *        ordered="false" annotation="http://www.eclipse.org/uml2/2.0.0/UML
	 *        originalName='Category'"
	 * @generated
	 */
	String getCategory();

	/**
	 * Sets the value of the '{@link setools.risk.Risk#getCategory
	 * <em>Category</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param value the new value of the '<em>Category</em>' attribute.
	 * @see #getCategory()
	 * @generated
	 */
	void setCategory(String value);

	/**
	 * Returns the value of the '<em><b>Likelihood</b></em>' attribute. The literals
	 * are from the enumeration {@link setools.risk.Likelihood}. <!-- begin-user-doc
	 * -->
	 * <p>
	 * If the meaning of the '<em>Likelihood</em>' attribute isn't clear, there
	 * really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Likelihood</em>' attribute.
	 * @see setools.risk.Likelihood
	 * @see #setLikelihood(Likelihood)
	 * @see setools.risk.RiskPackage#getRisk_Likelihood()
	 * @model required="true" ordered="false"
	 *        annotation="http://www.eclipse.org/uml2/2.0.0/UML
	 *        originalName='Likelihood'"
	 * @generated
	 */
	Likelihood getLikelihood();

	/**
	 * Sets the value of the '{@link setools.risk.Risk#getLikelihood
	 * <em>Likelihood</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @param value the new value of the '<em>Likelihood</em>' attribute.
	 * @see setools.risk.Likelihood
	 * @see #getLikelihood()
	 * @generated
	 */
	void setLikelihood(Likelihood value);

	/**
	 * Returns the value of the '<em><b>Consequence</b></em>' attribute. The
	 * literals are from the enumeration {@link setools.risk.Consequence}. <!--
	 * begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Consequence</em>' attribute isn't clear, there
	 * really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Consequence</em>' attribute.
	 * @see setools.risk.Consequence
	 * @see #setConsequence(Consequence)
	 * @see setools.risk.RiskPackage#getRisk_Consequence()
	 * @model required="true" ordered="false"
	 *        annotation="http://www.eclipse.org/uml2/2.0.0/UML
	 *        originalName='Consequence'"
	 * @generated
	 */
	Consequence getConsequence();

	/**
	 * Sets the value of the '{@link setools.risk.Risk#getConsequence
	 * <em>Consequence</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @param value the new value of the '<em>Consequence</em>' attribute.
	 * @see setools.risk.Consequence
	 * @see #getConsequence()
	 * @generated
	 */
	void setConsequence(Consequence value);

	/**
	 * Returns the value of the '<em><b>Risk Level</b></em>' attribute. The literals
	 * are from the enumeration {@link setools.risk.RiskLevel}. <!-- begin-user-doc
	 * -->
	 * <p>
	 * If the meaning of the '<em>Risk Level</em>' attribute isn't clear, there
	 * really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Risk Level</em>' attribute.
	 * @see setools.risk.RiskLevel
	 * @see setools.risk.RiskPackage#getRisk_RiskLevel()
	 * @model required="true" transient="true" changeable="false" volatile="true"
	 *        derived="true" ordered="false"
	 *        annotation="http://www.eclipse.org/uml2/2.0.0/UML
	 *        originalName='RiskLevel'"
	 * @generated
	 */
	RiskLevel getRiskLevel();

	/**
	 * Returns the value of the '<em><b>Mitigations</b></em>' reference list. The
	 * list contents are of type {@link setools.risk.Mitigation}. This feature is a
	 * derived union. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Mitigations</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Mitigations</em>' reference list.
	 * @see setools.risk.RiskPackage#getRisk_Mitigations()
	 * @model transient="true" changeable="false" volatile="true" derived="true"
	 *        ordered="false" annotation="http://www.eclipse.org/uml2/2.0.0/UML
	 *        originalName='Mitigations'" annotation="union"
	 * @generated
	 */
	EList<Mitigation> getMitigations();

	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute. <!--
	 * begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Name</em>' attribute isn't clear, there really
	 * should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see setools.risk.RiskPackage#getRisk_Name()
	 * @model dataType="org.eclipse.uml2.types.String" required="true"
	 *        ordered="false" annotation="http://www.eclipse.org/uml2/2.0.0/UML
	 *        originalName='Name'"
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link setools.risk.Risk#getName <em>Name</em>}'
	 * attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

} // Risk
