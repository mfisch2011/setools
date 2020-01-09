/**
 */
package setools.mbpe;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc --> A representation of the model object
 * '<em><b>Manufactured Material</b></em>'. <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 * <li>{@link setools.mbpe.ManufacturedMaterial#getBase_Class <em>Base
 * Class</em>}</li>
 * <li>{@link setools.mbpe.ManufacturedMaterial#getManfacturer
 * <em>Manfacturer</em>}</li>
 * <li>{@link setools.mbpe.ManufacturedMaterial#getPart_number <em>Part
 * number</em>}</li>
 * </ul>
 *
 * @see setools.mbpe.MbpePackage#getManufacturedMaterial()
 * @model abstract="true" annotation="http://www.eclipse.org/uml2/2.0.0/UML
 *        originalName='Manufactured Material'"
 * @generated
 */
public interface ManufacturedMaterial extends EObject {
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
	 * @see setools.mbpe.MbpePackage#getManufacturedMaterial_Base_Class()
	 * @model ordered="false"
	 * @generated
	 */
	org.eclipse.uml2.uml.Class getBase_Class();

	/**
	 * Sets the value of the '{@link setools.mbpe.ManufacturedMaterial#getBase_Class
	 * <em>Base Class</em>}' reference. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @param value the new value of the '<em>Base Class</em>' reference.
	 * @see #getBase_Class()
	 * @generated
	 */
	void setBase_Class(org.eclipse.uml2.uml.Class value);

	/**
	 * Returns the value of the '<em><b>Manfacturer</b></em>' attribute. <!--
	 * begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Manfacturer</em>' attribute isn't clear, there
	 * really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Manfacturer</em>' attribute.
	 * @see #setManfacturer(String)
	 * @see setools.mbpe.MbpePackage#getManufacturedMaterial_Manfacturer()
	 * @model dataType="org.eclipse.uml2.types.String" required="true"
	 *        ordered="false"
	 * @generated
	 */
	String getManfacturer();

	/**
	 * Sets the value of the
	 * '{@link setools.mbpe.ManufacturedMaterial#getManfacturer
	 * <em>Manfacturer</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @param value the new value of the '<em>Manfacturer</em>' attribute.
	 * @see #getManfacturer()
	 * @generated
	 */
	void setManfacturer(String value);

	/**
	 * Returns the value of the '<em><b>Part number</b></em>' attribute. <!--
	 * begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Part number</em>' attribute isn't clear, there
	 * really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Part number</em>' attribute.
	 * @see #setPart_number(String)
	 * @see setools.mbpe.MbpePackage#getManufacturedMaterial_Part_number()
	 * @model dataType="org.eclipse.uml2.types.String" required="true"
	 *        ordered="false"
	 * @generated
	 */
	String getPart_number();

	/**
	 * Sets the value of the
	 * '{@link setools.mbpe.ManufacturedMaterial#getPart_number <em>Part
	 * number</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param value the new value of the '<em>Part number</em>' attribute.
	 * @see #getPart_number()
	 * @generated
	 */
	void setPart_number(String value);

} // ManufacturedMaterial
