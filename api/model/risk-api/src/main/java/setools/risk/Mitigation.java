/**
 */
package setools.risk;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc --> A representation of the model object
 * '<em><b>Mitigation</b></em>'. <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 * <li>{@link setools.risk.Mitigation#getBaseClass <em>Base Class</em>}</li>
 * <li>{@link setools.risk.Mitigation#getName <em>Name</em>}</li>
 * <li>{@link setools.risk.Mitigation#getText <em>Text</em>}</li>
 * <li>{@link setools.risk.Mitigation#getLikelihood <em>Likelihood</em>}</li>
 * <li>{@link setools.risk.Mitigation#getConsequence <em>Consequence</em>}</li>
 * <li>{@link setools.risk.Mitigation#getRiskLevel <em>Risk Level</em>}</li>
 * </ul>
 *
 * @see setools.risk.RiskPackage#getMitigation()
 * @model
 * @generated
 */
public interface Mitigation extends EObject {
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
	 * @see setools.risk.RiskPackage#getMitigation_BaseClass()
	 * @model ordered="false" annotation="http://www.eclipse.org/uml2/2.0.0/UML
	 *        originalName='base_Class'"
	 * @generated
	 */
	org.eclipse.uml2.uml.Class getBaseClass();

	/**
	 * Sets the value of the '{@link setools.risk.Mitigation#getBaseClass <em>Base
	 * Class</em>}' reference. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param value the new value of the '<em>Base Class</em>' reference.
	 * @see #getBaseClass()
	 * @generated
	 */
	void setBaseClass(org.eclipse.uml2.uml.Class value);

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
	 * @see setools.risk.RiskPackage#getMitigation_Name()
	 * @model dataType="org.eclipse.uml2.types.String" required="true"
	 *        ordered="false" annotation="http://www.eclipse.org/uml2/2.0.0/UML
	 *        originalName='Name'"
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link setools.risk.Mitigation#getName <em>Name</em>}'
	 * attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Text</b></em>' attribute. <!--
	 * begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Text</em>' attribute isn't clear, there really
	 * should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Text</em>' attribute.
	 * @see #setText(String)
	 * @see setools.risk.RiskPackage#getMitigation_Text()
	 * @model dataType="org.eclipse.uml2.types.String" required="true"
	 *        ordered="false" annotation="http://www.eclipse.org/uml2/2.0.0/UML
	 *        originalName='Text'"
	 * @generated
	 */
	String getText();

	/**
	 * Sets the value of the '{@link setools.risk.Mitigation#getText <em>Text</em>}'
	 * attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param value the new value of the '<em>Text</em>' attribute.
	 * @see #getText()
	 * @generated
	 */
	void setText(String value);

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
	 * @see setools.risk.RiskPackage#getMitigation_Likelihood()
	 * @model required="true" ordered="false"
	 *        annotation="http://www.eclipse.org/uml2/2.0.0/UML
	 *        originalName='Likelihood'"
	 * @generated
	 */
	Likelihood getLikelihood();

	/**
	 * Sets the value of the '{@link setools.risk.Mitigation#getLikelihood
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
	 * @see setools.risk.RiskPackage#getMitigation_Consequence()
	 * @model required="true" ordered="false"
	 *        annotation="http://www.eclipse.org/uml2/2.0.0/UML
	 *        originalName='Consequence'"
	 * @generated
	 */
	Consequence getConsequence();

	/**
	 * Sets the value of the '{@link setools.risk.Mitigation#getConsequence
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
	 * @see #setRiskLevel(RiskLevel)
	 * @see setools.risk.RiskPackage#getMitigation_RiskLevel()
	 * @model required="true" ordered="false"
	 *        annotation="http://www.eclipse.org/uml2/2.0.0/UML
	 *        originalName='RiskLevel'"
	 * @generated
	 */
	RiskLevel getRiskLevel();

	/**
	 * Sets the value of the '{@link setools.risk.Mitigation#getRiskLevel <em>Risk
	 * Level</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param value the new value of the '<em>Risk Level</em>' attribute.
	 * @see setools.risk.RiskLevel
	 * @see #getRiskLevel()
	 * @generated
	 */
	void setRiskLevel(RiskLevel value);

} // Mitigation
