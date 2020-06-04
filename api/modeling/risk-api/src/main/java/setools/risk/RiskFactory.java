/**
 */
package setools.risk;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc --> The <b>Factory</b> for the model. It provides a
 * create method for each non-abstract class of the model. <!-- end-user-doc -->
 * 
 * @see setools.risk.RiskPackage
 * @generated
 */
public interface RiskFactory extends EFactory {
	/**
	 * The singleton instance of the factory. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 */
	RiskFactory eINSTANCE = setools.risk.impl.RiskFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Risk</em>'. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @return a new object of class '<em>Risk</em>'.
	 * @generated
	 */
	Risk createRisk();

	/**
	 * Returns a new object of class '<em>Mitigation</em>'. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return a new object of class '<em>Mitigation</em>'.
	 * @generated
	 */
	RiskMitigation createRiskMitigation();

	/**
	 * Returns a new object of class '<em>Status Update</em>'. <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * 
	 * @return a new object of class '<em>Status Update</em>'.
	 * @generated
	 */
	StatusUpdate createStatusUpdate();

	/**
	 * Returns the package supported by this factory. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @return the package supported by this factory.
	 * @generated
	 */
	RiskPackage getRiskPackage();

} // RiskFactory
