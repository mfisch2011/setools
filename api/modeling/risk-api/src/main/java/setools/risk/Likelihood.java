/**
   Copyright 2019 Matt Fischer <mfish2011@gmail.com>

   Licensed under the Apache License, Version 2.0 (the "License");
   you may not use this file except in compliance with the License.
   You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

   Unless required by applicable law or agreed to in writing, software
   distributed under the License is distributed on an "AS IS" BASIS,
   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
   See the License for the specific language governing permissions and
   limitations under the License.
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
	 * The '<em><b>NOT LIKELY</b></em>' literal object. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @see #NOT_LIKELY_VALUE
	 * @generated
	 * @ordered
	 */
	NOT_LIKELY(0, "NOT_LIKELY", "NOT_LIKELY"),

	/**
	 * The '<em><b>LOW LIKELIHOOD</b></em>' literal object. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #LOW_LIKELIHOOD_VALUE
	 * @generated
	 * @ordered
	 */
	LOW_LIKELIHOOD(1, "LOW_LIKELIHOOD", "LOW_LIKELIHOOD"),

	/**
	 * The '<em><b>LIKELY</b></em>' literal object. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @see #LIKELY_VALUE
	 * @generated
	 * @ordered
	 */
	LIKELY(2, "LIKELY", "LIKELY"),

	/**
	 * The '<em><b>HIGHLY LIKELY</b></em>' literal object. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #HIGHLY_LIKELY_VALUE
	 * @generated
	 * @ordered
	 */
	HIGHLY_LIKELY(3, "HIGHLY_LIKELY", "HIGHLY_LIKELY"),

	/**
	 * The '<em><b>NEAR CERTAINTY</b></em>' literal object. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #NEAR_CERTAINTY_VALUE
	 * @generated
	 * @ordered
	 */
	NEAR_CERTAINTY(4, "NEAR_CERTAINTY", "NEAR_CERTAINTY");

	/**
	 * The '<em><b>NOT LIKELY</b></em>' literal value. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @see #NOT_LIKELY
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int NOT_LIKELY_VALUE = 0;

	/**
	 * The '<em><b>LOW LIKELIHOOD</b></em>' literal value. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #LOW_LIKELIHOOD
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int LOW_LIKELIHOOD_VALUE = 1;

	/**
	 * The '<em><b>LIKELY</b></em>' literal value. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @see #LIKELY
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int LIKELY_VALUE = 2;

	/**
	 * The '<em><b>HIGHLY LIKELY</b></em>' literal value. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #HIGHLY_LIKELY
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int HIGHLY_LIKELY_VALUE = 3;

	/**
	 * The '<em><b>NEAR CERTAINTY</b></em>' literal value. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #NEAR_CERTAINTY
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int NEAR_CERTAINTY_VALUE = 4;

	/**
	 * An array of all the '<em><b>Likelihood</b></em>' enumerators. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private static final Likelihood[] VALUES_ARRAY = new Likelihood[] { NOT_LIKELY, LOW_LIKELIHOOD, LIKELY,
			HIGHLY_LIKELY, NEAR_CERTAINTY, };

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
		case NEAR_CERTAINTY_VALUE:
			return NEAR_CERTAINTY;
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
