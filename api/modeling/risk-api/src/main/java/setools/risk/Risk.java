/**
 */
package setools.risk;

import java.util.TreeSet;

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
 * <li>{@link setools.risk.Risk#getId <em>Id</em>}</li>
 * <li>{@link setools.risk.Risk#getStatement <em>Statement</em>}</li>
 * <li>{@link setools.risk.Risk#getLikelihood <em>Likelihood</em>}</li>
 * <li>{@link setools.risk.Risk#getConsequence <em>Consequence</em>}</li>
 * <li>{@link setools.risk.Risk#getRisk <em>Risk</em>}</li>
 * <li>{@link setools.risk.Risk#getBase_Class <em>Base Class</em>}</li>
 * <li>{@link setools.risk.Risk#getMitigations <em>Mitigations</em>}</li>
 * </ul>
 *
 * @see setools.risk.RiskPackage#getRisk()
 * @model
 * @generated
 */
public interface Risk extends EObject {
	/**
	 * Returns the value of the '<em><b>Id</b></em>' attribute. <!-- begin-user-doc
	 * -->
	 * <p>
	 * If the meaning of the '<em>Id</em>' attribute isn't clear, there really
	 * should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Id</em>' attribute.
	 * @see #setId(String)
	 * @see setools.risk.RiskPackage#getRisk_Id()
	 * @model dataType="org.eclipse.uml2.types.String" required="true"
	 *        ordered="false"
	 * @generated
	 */
	String getId();

	/**
	 * Sets the value of the '{@link setools.risk.Risk#getId <em>Id</em>}'
	 * attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param value the new value of the '<em>Id</em>' attribute.
	 * @see #getId()
	 * @generated
	 */
	void setId(String value);

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
	 *        ordered="false"
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
	 * Returns the value of the '<em><b>Risk</b></em>' attribute. The literals are
	 * from the enumeration {@link setools.risk.RiskLevel}. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Risk</em>' attribute isn't clear, there really
	 * should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Risk</em>' attribute.
	 * @see setools.risk.RiskLevel
	 * @see setools.risk.RiskPackage#getRisk_Risk()
	 * @model required="true" transient="true" changeable="false" volatile="true"
	 *        derived="true" ordered="false"
	 * @generated
	 */
	RiskLevel getRisk();

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
	 * @see #setBase_Class(org.eclipse.uml2.uml.Class)
	 * @see setools.risk.RiskPackage#getRisk_Base_Class()
	 * @model ordered="false"
	 * @generated
	 */
	org.eclipse.uml2.uml.Class getBase_Class();

	/**
	 * Sets the value of the '{@link setools.risk.Risk#getBase_Class <em>Base
	 * Class</em>}' reference. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param value the new value of the '<em>Base Class</em>' reference.
	 * @see #getBase_Class()
	 * @generated
	 */
	void setBase_Class(org.eclipse.uml2.uml.Class value);

	/**
	 * Returns the value of the '<em><b>Mitigations</b></em>' reference list. The
	 * list contents are of type {@link setools.risk.RiskMitigation}. <!--
	 * begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Mitigations</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Mitigations</em>' reference list.
	 * @see setools.risk.RiskPackage#getRisk_Mitigations()
	 * @model transient="true" changeable="false" volatile="true" derived="true"
	 *        ordered="false"
	 * @generated false
	 */
	TreeSet<RiskMitigation> getMitigations();

} // Risk
