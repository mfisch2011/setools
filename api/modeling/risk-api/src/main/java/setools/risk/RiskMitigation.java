/**
 */
package setools.risk;

import java.util.Collection;
import java.util.Date;
import java.util.TreeSet;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc --> A representation of the model object
 * '<em><b>Mitigation</b></em>'. <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 * <li>{@link setools.risk.RiskMitigation#getPlanned <em>Planned</em>}</li>
 * <li>{@link setools.risk.RiskMitigation#getBase_Class <em>Base
 * Class</em>}</li>
 * <li>{@link setools.risk.RiskMitigation#getId <em>Id</em>}</li>
 * <li>{@link setools.risk.RiskMitigation#getStatement <em>Statement</em>}</li>
 * <li>{@link setools.risk.RiskMitigation#getLikelihood
 * <em>Likelihood</em>}</li>
 * <li>{@link setools.risk.RiskMitigation#getConsequence
 * <em>Consequence</em>}</li>
 * <li>{@link setools.risk.RiskMitigation#getRisk <em>Risk</em>}</li>
 * </ul>
 *
 * @see setools.risk.RiskPackage#getRiskMitigation()
 * @model annotation="http://www.eclipse.org/uml2/2.0.0/UML originalName='Risk
 *        Mitigation'"
 * @generated
 */
public interface RiskMitigation extends EObject {
	/**
	 * Returns the value of the '<em><b>Planned</b></em>' attribute. <!--
	 * begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Planned</em>' attribute isn't clear, there really
	 * should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Planned</em>' attribute.
	 * @see #setPlanned(Date)
	 * @see setools.risk.RiskPackage#getRiskMitigation_Planned()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	Date getPlanned();

	/**
	 * Sets the value of the '{@link setools.risk.RiskMitigation#getPlanned
	 * <em>Planned</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param value the new value of the '<em>Planned</em>' attribute.
	 * @see #getPlanned()
	 * @generated
	 */
	void setPlanned(Date value);

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
	 * @see setools.risk.RiskPackage#getRiskMitigation_Base_Class()
	 * @model ordered="false"
	 * @generated
	 */
	org.eclipse.uml2.uml.Class getBase_Class();

	/**
	 * Sets the value of the '{@link setools.risk.RiskMitigation#getBase_Class
	 * <em>Base Class</em>}' reference. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @param value the new value of the '<em>Base Class</em>' reference.
	 * @see #getBase_Class()
	 * @generated
	 */
	void setBase_Class(org.eclipse.uml2.uml.Class value);

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
	 * @see setools.risk.RiskPackage#getRiskMitigation_Id()
	 * @model dataType="org.eclipse.uml2.types.String" required="true"
	 *        ordered="false"
	 * @generated
	 */
	String getId();

	/**
	 * Sets the value of the '{@link setools.risk.RiskMitigation#getId <em>Id</em>}'
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
	 * @see setools.risk.RiskPackage#getRiskMitigation_Statement()
	 * @model dataType="org.eclipse.uml2.types.String" required="true"
	 *        ordered="false"
	 * @generated
	 */
	String getStatement();

	/**
	 * Sets the value of the '{@link setools.risk.RiskMitigation#getStatement
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
	 * @see setools.risk.RiskPackage#getRiskMitigation_Likelihood()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	Likelihood getLikelihood();

	/**
	 * Sets the value of the '{@link setools.risk.RiskMitigation#getLikelihood
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
	 * @see setools.risk.RiskPackage#getRiskMitigation_Consequence()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	Consequence getConsequence();

	/**
	 * Sets the value of the '{@link setools.risk.RiskMitigation#getConsequence
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
	 * @see setools.risk.RiskPackage#getRiskMitigation_Risk()
	 * @model required="true" transient="true" changeable="false" volatile="true"
	 *        derived="true" ordered="false"
	 * @generated
	 */
	RiskLevel getRisk();
	
	/**
	 * Returns the associated status updates.  The list contents are of type 
	 * {@link setools.risk.StatusUpdate}. <!--begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>status updates</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the set of associated status updates
	 * @generated false
	 */
	Collection<StatusUpdate> getStatusUpdates();

} // RiskMitigation
