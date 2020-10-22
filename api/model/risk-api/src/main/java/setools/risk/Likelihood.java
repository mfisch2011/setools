/**
 */
package setools.risk;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;

/**
 * <!-- begin-user-doc --> A representation of the literals of the enumeration
 * '<em><b>Likelihood</b></em>', and utility methods for working with them. <!--
 * end-user-doc -->
 * 
 * @see setools.risk.RiskPackage#getLikelihood()
 * @model
 * @generated
 */
public enum Likelihood implements Enumerator {
	/**
	 * The '<em><b>Not Likely</b></em>' literal object. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @see #NOT_LIKELY_VALUE
	 * @generated
	 * @ordered
	 */
	NOT_LIKELY(0, "notLikely", "notLikely"),

	/**
	 * The '<em><b>Low Likelihood</b></em>' literal object. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #LOW_LIKELIHOOD_VALUE
	 * @generated
	 * @ordered
	 */
	LOW_LIKELIHOOD(1, "lowLikelihood", "lowLikelihood"),

	/**
	 * The '<em><b>Likely</b></em>' literal object. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @see #LIKELY_VALUE
	 * @generated
	 * @ordered
	 */
	LIKELY(2, "likely", "likely"),

	/**
	 * The '<em><b>Highly Likely</b></em>' literal object. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #HIGHLY_LIKELY_VALUE
	 * @generated
	 * @ordered
	 */
	HIGHLY_LIKELY(3, "highlyLikely", "highlyLikely"),

	/**
	 * The '<em><b>Near Certain</b></em>' literal object. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #NEAR_CERTAIN_VALUE
	 * @generated
	 * @ordered
	 */
	NEAR_CERTAIN(4, "nearCertain", "nearCertain");

	/**
	 * The '<em><b>Not Likely</b></em>' literal value. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @see #NOT_LIKELY
	 * @model name="notLikely" annotation="http://www.eclipse.org/uml2/2.0.0/UML
	 *        originalName='NOT_LIKELY'"
	 * @generated
	 * @ordered
	 */
	public static final int NOT_LIKELY_VALUE = 0;

	/**
	 * The '<em><b>Low Likelihood</b></em>' literal value. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #LOW_LIKELIHOOD
	 * @model name="lowLikelihood" annotation="http://www.eclipse.org/uml2/2.0.0/UML
	 *        originalName='LOW_LIKELIHOOD'"
	 * @generated
	 * @ordered
	 */
	public static final int LOW_LIKELIHOOD_VALUE = 1;

	/**
	 * The '<em><b>Likely</b></em>' literal value. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @see #LIKELY
	 * @model name="likely" annotation="http://www.eclipse.org/uml2/2.0.0/UML
	 *        originalName='LIKELY'"
	 * @generated
	 * @ordered
	 */
	public static final int LIKELY_VALUE = 2;

	/**
	 * The '<em><b>Highly Likely</b></em>' literal value. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #HIGHLY_LIKELY
	 * @model name="highlyLikely" annotation="http://www.eclipse.org/uml2/2.0.0/UML
	 *        originalName='HIGHLY_LIKELY'"
	 * @generated
	 * @ordered
	 */
	public static final int HIGHLY_LIKELY_VALUE = 3;

	/**
	 * The '<em><b>Near Certain</b></em>' literal value. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #NEAR_CERTAIN
	 * @model name="nearCertain" annotation="http://www.eclipse.org/uml2/2.0.0/UML
	 *        originalName='NEAR_CERTAIN'"
	 * @generated
	 * @ordered
	 */
	public static final int NEAR_CERTAIN_VALUE = 4;

	/**
	 * An array of all the '<em><b>Likelihood</b></em>' enumerators. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private static final Likelihood[] VALUES_ARRAY = new Likelihood[] { NOT_LIKELY, LOW_LIKELIHOOD, LIKELY,
			HIGHLY_LIKELY, NEAR_CERTAIN, };

	/**
	 * A public read-only list of all the '<em><b>Likelihood</b></em>' enumerators.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public static final List<Likelihood> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>Likelihood</b></em>' literal with the specified literal
	 * value. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param literal the literal.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static Likelihood get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			Likelihood result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Likelihood</b></em>' literal with the specified name.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param name the name.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static Likelihood getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			Likelihood result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Likelihood</b></em>' literal with the specified integer
	 * value. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param value the integer value.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static Likelihood get(int value) {
		switch (value) {
		case NOT_LIKELY_VALUE:
			return NOT_LIKELY;
		case LOW_LIKELIHOOD_VALUE:
			return LOW_LIKELIHOOD;
		case LIKELY_VALUE:
			return LIKELY;
		case HIGHLY_LIKELY_VALUE:
			return HIGHLY_LIKELY;
		case NEAR_CERTAIN_VALUE:
			return NEAR_CERTAIN;
		}
		return null;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private final int value;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private final String name;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private final String literal;

	/**
	 * Only this class can construct instances. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 */
	private Likelihood(int value, String name, String literal) {
		this.value = value;
		this.name = name;
		this.literal = literal;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public int getValue() {
		return value;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public String getName() {
		return name;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public String getLiteral() {
		return literal;
	}

	/**
	 * Returns the literal value of the enumerator, which is its string
	 * representation. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public String toString() {
		return literal;
	}

} // Likelihood
