/**
 */
package setools.risk.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EDataTypeUniqueEList;

import org.eclipse.uml2.common.util.DerivedUnionEObjectEList;

import setools.risk.Consequence;
import setools.risk.Likelihood;
import setools.risk.Mitigation;
import setools.risk.Risk;
import setools.risk.RiskLevel;
import setools.risk.RiskPackage;

/**
 * <!-- begin-user-doc --> An implementation of the model object
 * '<em><b>Risk</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 * <li>{@link setools.risk.impl.RiskImpl#getMitigations
 * <em>Mitigations</em>}</li>
 * <li>{@link setools.risk.impl.RiskImpl#getBaseClass <em>Base Class</em>}</li>
 * <li>{@link setools.risk.impl.RiskImpl#getStatement <em>Statement</em>}</li>
 * <li>{@link setools.risk.impl.RiskImpl#getText <em>Text</em>}</li>
 * <li>{@link setools.risk.impl.RiskImpl#getCategory <em>Category</em>}</li>
 * <li>{@link setools.risk.impl.RiskImpl#getLikelihood <em>Likelihood</em>}</li>
 * <li>{@link setools.risk.impl.RiskImpl#getConsequence
 * <em>Consequence</em>}</li>
 * <li>{@link setools.risk.impl.RiskImpl#getRiskLevel <em>Risk Level</em>}</li>
 * <li>{@link setools.risk.impl.RiskImpl#getName <em>Name</em>}</li>
 * </ul>
 *
 * @generated
 */
public class RiskImpl extends MinimalEObjectImpl.Container implements Risk {
	/**
	 * The cached value of the '{@link #getBaseClass() <em>Base Class</em>}'
	 * reference. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getBaseClass()
	 * @generated
	 * @ordered
	 */
	protected org.eclipse.uml2.uml.Class baseClass;

	/**
	 * The default value of the '{@link #getStatement() <em>Statement</em>}'
	 * attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getStatement()
	 * @generated
	 * @ordered
	 */
	protected static final String STATEMENT_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getStatement() <em>Statement</em>}'
	 * attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getStatement()
	 * @generated
	 * @ordered
	 */
	protected String statement = STATEMENT_EDEFAULT;

	/**
	 * The cached value of the '{@link #getText() <em>Text</em>}' attribute list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getText()
	 * @generated
	 * @ordered
	 */
	protected EList<String> text;

	/**
	 * The default value of the '{@link #getCategory() <em>Category</em>}'
	 * attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getCategory()
	 * @generated
	 * @ordered
	 */
	protected static final String CATEGORY_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getCategory() <em>Category</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getCategory()
	 * @generated
	 * @ordered
	 */
	protected String category = CATEGORY_EDEFAULT;

	/**
	 * The default value of the '{@link #getLikelihood() <em>Likelihood</em>}'
	 * attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getLikelihood()
	 * @generated
	 * @ordered
	 */
	protected static final Likelihood LIKELIHOOD_EDEFAULT = Likelihood.NOT_LIKELY;

	/**
	 * The cached value of the '{@link #getLikelihood() <em>Likelihood</em>}'
	 * attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getLikelihood()
	 * @generated
	 * @ordered
	 */
	protected Likelihood likelihood = LIKELIHOOD_EDEFAULT;

	/**
	 * The default value of the '{@link #getConsequence() <em>Consequence</em>}'
	 * attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getConsequence()
	 * @generated
	 * @ordered
	 */
	protected static final Consequence CONSEQUENCE_EDEFAULT = Consequence.MINIMAL_IMPACT;

	/**
	 * The cached value of the '{@link #getConsequence() <em>Consequence</em>}'
	 * attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getConsequence()
	 * @generated
	 * @ordered
	 */
	protected Consequence consequence = CONSEQUENCE_EDEFAULT;

	/**
	 * The default value of the '{@link #getRiskLevel() <em>Risk Level</em>}'
	 * attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getRiskLevel()
	 * @generated
	 * @ordered
	 */
	protected static final RiskLevel RISK_LEVEL_EDEFAULT = RiskLevel.LOW;

	/**
	 * The default value of the '{@link #getName() <em>Name</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected static final String NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getName() <em>Name</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected String name = NAME_EDEFAULT;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected RiskImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return RiskPackage.Literals.RISK;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EList<Mitigation> getMitigations() {
		return new DerivedUnionEObjectEList<Mitigation>(Mitigation.class, this, RiskPackage.RISK__MITIGATIONS, null);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public org.eclipse.uml2.uml.Class getBaseClass() {
		if (baseClass != null && baseClass.eIsProxy()) {
			InternalEObject oldBaseClass = (InternalEObject) baseClass;
			baseClass = (org.eclipse.uml2.uml.Class) eResolveProxy(oldBaseClass);
			if (baseClass != oldBaseClass) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, RiskPackage.RISK__BASE_CLASS,
							oldBaseClass, baseClass));
			}
		}
		return baseClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public org.eclipse.uml2.uml.Class basicGetBaseClass() {
		return baseClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public void setBaseClass(org.eclipse.uml2.uml.Class newBaseClass) {
		org.eclipse.uml2.uml.Class oldBaseClass = baseClass;
		baseClass = newBaseClass;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RiskPackage.RISK__BASE_CLASS, oldBaseClass,
					baseClass));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public String getStatement() {
		return statement;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public void setStatement(String newStatement) {
		String oldStatement = statement;
		statement = newStatement;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RiskPackage.RISK__STATEMENT, oldStatement,
					statement));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EList<String> getText() {
		if (text == null) {
			text = new EDataTypeUniqueEList<String>(String.class, this, RiskPackage.RISK__TEXT);
		}
		return text;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public String getCategory() {
		return category;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public void setCategory(String newCategory) {
		String oldCategory = category;
		category = newCategory;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RiskPackage.RISK__CATEGORY, oldCategory, category));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public Likelihood getLikelihood() {
		return likelihood;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public void setLikelihood(Likelihood newLikelihood) {
		Likelihood oldLikelihood = likelihood;
		likelihood = newLikelihood == null ? LIKELIHOOD_EDEFAULT : newLikelihood;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RiskPackage.RISK__LIKELIHOOD, oldLikelihood,
					likelihood));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public Consequence getConsequence() {
		return consequence;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public void setConsequence(Consequence newConsequence) {
		Consequence oldConsequence = consequence;
		consequence = newConsequence == null ? CONSEQUENCE_EDEFAULT : newConsequence;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RiskPackage.RISK__CONSEQUENCE, oldConsequence,
					consequence));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public RiskLevel getRiskLevel() {
		// TODO: implement this method to return the 'Risk Level' attribute
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
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
	public void setName(String newName) {
		String oldName = name;
		name = newName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RiskPackage.RISK__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
		case RiskPackage.RISK__MITIGATIONS:
			return getMitigations();
		case RiskPackage.RISK__BASE_CLASS:
			if (resolve)
				return getBaseClass();
			return basicGetBaseClass();
		case RiskPackage.RISK__STATEMENT:
			return getStatement();
		case RiskPackage.RISK__TEXT:
			return getText();
		case RiskPackage.RISK__CATEGORY:
			return getCategory();
		case RiskPackage.RISK__LIKELIHOOD:
			return getLikelihood();
		case RiskPackage.RISK__CONSEQUENCE:
			return getConsequence();
		case RiskPackage.RISK__RISK_LEVEL:
			return getRiskLevel();
		case RiskPackage.RISK__NAME:
			return getName();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
		case RiskPackage.RISK__BASE_CLASS:
			setBaseClass((org.eclipse.uml2.uml.Class) newValue);
			return;
		case RiskPackage.RISK__STATEMENT:
			setStatement((String) newValue);
			return;
		case RiskPackage.RISK__TEXT:
			getText().clear();
			getText().addAll((Collection<? extends String>) newValue);
			return;
		case RiskPackage.RISK__CATEGORY:
			setCategory((String) newValue);
			return;
		case RiskPackage.RISK__LIKELIHOOD:
			setLikelihood((Likelihood) newValue);
			return;
		case RiskPackage.RISK__CONSEQUENCE:
			setConsequence((Consequence) newValue);
			return;
		case RiskPackage.RISK__NAME:
			setName((String) newValue);
			return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
		case RiskPackage.RISK__BASE_CLASS:
			setBaseClass((org.eclipse.uml2.uml.Class) null);
			return;
		case RiskPackage.RISK__STATEMENT:
			setStatement(STATEMENT_EDEFAULT);
			return;
		case RiskPackage.RISK__TEXT:
			getText().clear();
			return;
		case RiskPackage.RISK__CATEGORY:
			setCategory(CATEGORY_EDEFAULT);
			return;
		case RiskPackage.RISK__LIKELIHOOD:
			setLikelihood(LIKELIHOOD_EDEFAULT);
			return;
		case RiskPackage.RISK__CONSEQUENCE:
			setConsequence(CONSEQUENCE_EDEFAULT);
			return;
		case RiskPackage.RISK__NAME:
			setName(NAME_EDEFAULT);
			return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
		case RiskPackage.RISK__MITIGATIONS:
			return isSetMitigations();
		case RiskPackage.RISK__BASE_CLASS:
			return baseClass != null;
		case RiskPackage.RISK__STATEMENT:
			return STATEMENT_EDEFAULT == null ? statement != null : !STATEMENT_EDEFAULT.equals(statement);
		case RiskPackage.RISK__TEXT:
			return text != null && !text.isEmpty();
		case RiskPackage.RISK__CATEGORY:
			return CATEGORY_EDEFAULT == null ? category != null : !CATEGORY_EDEFAULT.equals(category);
		case RiskPackage.RISK__LIKELIHOOD:
			return likelihood != LIKELIHOOD_EDEFAULT;
		case RiskPackage.RISK__CONSEQUENCE:
			return consequence != CONSEQUENCE_EDEFAULT;
		case RiskPackage.RISK__RISK_LEVEL:
			return getRiskLevel() != RISK_LEVEL_EDEFAULT;
		case RiskPackage.RISK__NAME:
			return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy())
			return super.toString();

		StringBuilder result = new StringBuilder(super.toString());
		result.append(" (statement: ");
		result.append(statement);
		result.append(", text: ");
		result.append(text);
		result.append(", category: ");
		result.append(category);
		result.append(", likelihood: ");
		result.append(likelihood);
		result.append(", consequence: ");
		result.append(consequence);
		result.append(", name: ");
		result.append(name);
		result.append(')');
		return result.toString();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public boolean isSetMitigations() {
		return false;
	}

} // RiskImpl
