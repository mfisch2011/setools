/**
 */
package setools.risk;

import java.util.Date;
import org.eclipse.emf.ecore.EObject;

import org.eclipse.uml2.uml.Comment;

/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>Status
 * Update</b></em>'. <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 * <li>{@link setools.risk.StatusUpdate#getBase_Comment <em>Base
 * Comment</em>}</li>
 * <li>{@link setools.risk.StatusUpdate#getDate <em>Date</em>}</li>
 * <li>{@link setools.risk.StatusUpdate#getSource <em>Source</em>}</li>
 * </ul>
 *
 * @see setools.risk.RiskPackage#getStatusUpdate()
 * @model annotation="http://www.eclipse.org/uml2/2.0.0/UML originalName='Status
 *        Update'"
 * @generated
 */
public interface StatusUpdate extends EObject {
	/**
	 * Returns the value of the '<em><b>Base Comment</b></em>' reference. <!--
	 * begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Base Comment</em>' reference isn't clear, there
	 * really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Base Comment</em>' reference.
	 * @see #setBase_Comment(Comment)
	 * @see setools.risk.RiskPackage#getStatusUpdate_Base_Comment()
	 * @model ordered="false"
	 * @generated
	 */
	Comment getBase_Comment();

	/**
	 * Sets the value of the '{@link setools.risk.StatusUpdate#getBase_Comment
	 * <em>Base Comment</em>}' reference. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @param value the new value of the '<em>Base Comment</em>' reference.
	 * @see #getBase_Comment()
	 * @generated
	 */
	void setBase_Comment(Comment value);

	/**
	 * Returns the value of the '<em><b>Date</b></em>' attribute. <!--
	 * begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Date</em>' attribute isn't clear, there really
	 * should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Date</em>' attribute.
	 * @see #setDate(Date)
	 * @see setools.risk.RiskPackage#getStatusUpdate_Date()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	Date getDate();

	/**
	 * Sets the value of the '{@link setools.risk.StatusUpdate#getDate
	 * <em>Date</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param value the new value of the '<em>Date</em>' attribute.
	 * @see #getDate()
	 * @generated
	 */
	void setDate(Date value);

	/**
	 * Returns the value of the '<em><b>Source</b></em>' attribute. <!--
	 * begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Source</em>' attribute isn't clear, there really
	 * should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Source</em>' attribute.
	 * @see #setSource(String)
	 * @see setools.risk.RiskPackage#getStatusUpdate_Source()
	 * @model dataType="org.eclipse.uml2.types.String" required="true"
	 *        ordered="false"
	 * @generated
	 */
	String getSource();

	/**
	 * Sets the value of the '{@link setools.risk.StatusUpdate#getSource
	 * <em>Source</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param value the new value of the '<em>Source</em>' attribute.
	 * @see #getSource()
	 * @generated
	 */
	void setSource(String value);

} // StatusUpdate
