/**
 */
package setools.risk;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;

/**
 * <!-- begin-user-doc --> A representation of the literals of the enumeration
 * '<em><b>Consequence</b></em>', and utility methods for working with them.
 * <!-- end-user-doc -->
 * 
 * @see setools.risk.RiskPackage#getConsequence()
 * @model
 * @generated
 */
public enum Consequence implements Enumerator {
	/**
	 * The '<em><b>MINIMAL IMPACT</b></em>' literal object. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #MINIMAL_IMPACT_VALUE
	 * @generated
	 * @ordered
	 */
	MINIMAL_IMPACT(0, "MINIMAL_IMPACT", "MINIMAL_IMPACT"),

	/**
	 * The '<em><b>LOW IMPACT</b></em>' literal object. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @see #LOW_IMPACT_VALUE
	 * @generated
	 * @ordered
	 */
	LOW_IMPACT(1, "LOW_IMPACT", "LOW_IMPACT"),

	/**
	 * The '<em><b>MODERATE IMPACT</b></em>' literal object. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #MODERATE_IMPACT_VALUE
	 * @generated
	 * @ordered
	 */
	MODERATE_IMPACT(2, "MODERATE_IMPACT", "MODERATE_IMPACT"),

	/**
	 * The '<em><b>SIGNIFICANT IMPACT</b></em>' literal object. <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * 
	 * @see #SIGNIFICANT_IMPACT_VALUE
	 * @generated
	 * @ordered
	 */
	SIGNIFICANT_IMPACT(3, "SIGNIFICANT_IMPACT", "SIGNIFICANT_IMPACT"),
	/**
	 * The '<em><b>CATASTROPHIC IMPACT</b></em>' literal object. <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * 
	 * @see #CATASTROPHIC_IMPACT_VALUE
	 * @generated
	 * @ordered
	 */
	CATASTROPHIC_IMPACT(4, "CATASTROPHIC_IMPACT", "CATASTROPHIC_IMPACT");

	/**
	 * The '<em><b>MINIMAL IMPACT</b></em>' literal value. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #MINIMAL_IMPACT
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int MINIMAL_IMPACT_VALUE = 0;

	/**
	 * The '<em><b>LOW IMPACT</b></em>' literal value. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @see #LOW_IMPACT
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int LOW_IMPACT_VALUE = 1;

	/**
	 * The '<em><b>MODERATE IMPACT</b></em>' literal value. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #MODERATE_IMPACT
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int MODERATE_IMPACT_VALUE = 2;

	/**
	 * The '<em><b>SIGNIFICANT IMPACT</b></em>' literal value. <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * 
	 * @see #SIGNIFICANT_IMPACT
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int SIGNIFICANT_IMPACT_VALUE = 3;

	/**
	 * The '<em><b>CATASTROPHIC IMPACT</b></em>' literal value. <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * 
	 * @see #CATASTROPHIC_IMPACT
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int CATASTROPHIC_IMPACT_VALUE = 4;

	/**
	 * An array of all the '<em><b>Consequence</b></em>' enumerators. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private static final Consequence[] VALUES_ARRAY = new Consequence[] { MINIMAL_IMPACT, LOW_IMPACT, MODERATE_IMPACT,
			SIGNIFICANT_IMPACT, CATASTROPHIC_IMPACT, };

	/**
	 * A public read-only list of all the '<em><b>Consequence</b></em>' enumerators.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public static final List<Consequence> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>Consequence</b></em>' literal with the specified literal
	 * value. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param literal the literal.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static Consequence get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			Consequence result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Consequence</b></em>' literal with the specified name.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param name the name.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static Consequence getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			Consequence result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Consequence</b></em>' literal with the specified integer
	 * value. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param value the integer value.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static Consequence get(int value) {
		switch (value) {
		case MINIMAL_IMPACT_VALUE:
			return MINIMAL_IMPACT;
		case LOW_IMPACT_VALUE:
			return LOW_IMPACT;
		case MODERATE_IMPACT_VALUE:
			return MODERATE_IMPACT;
		case SIGNIFICANT_IMPACT_VALUE:
			return SIGNIFICANT_IMPACT;
		case CATASTROPHIC_IMPACT_VALUE:
			return CATASTROPHIC_IMPACT;
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
	private Consequence(int value, String name, String literal) {
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

} // Consequence
