/**
 */
package setools.risk.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import setools.risk.Consequence;
import setools.risk.Likelihood;
import setools.risk.Mitigation;
import setools.risk.RiskLevel;
import setools.risk.RiskPackage;

/**
 * <!-- begin-user-doc --> An implementation of the model object
 * '<em><b>Mitigation</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 * <li>{@link setools.risk.impl.MitigationImpl#getBaseClass <em>Base
 * Class</em>}</li>
 * <li>{@link setools.risk.impl.MitigationImpl#getName <em>Name</em>}</li>
 * <li>{@link setools.risk.impl.MitigationImpl#getText <em>Text</em>}</li>
 * <li>{@link setools.risk.impl.MitigationImpl#getLikelihood
 * <em>Likelihood</em>}</li>
 * <li>{@link setools.risk.impl.MitigationImpl#getConsequence
 * <em>Consequence</em>}</li>
 * <li>{@link setools.risk.impl.MitigationImpl#getRiskLevel <em>Risk
 * Level</em>}</li>
 * </ul>
 *
 * @generated
 */
public class MitigationImpl extends MinimalEObjectImpl.Container implements Mitigation {
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
	 * The default value of the '{@link #getText() <em>Text</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getText()
	 * @generated
	 * @ordered
	 */
	protected static final String TEXT_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getText() <em>Text</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getText()
	 * @generated
	 * @ordered
	 */
	protected String text = TEXT_EDEFAULT;

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
	 * The cached value of the '{@link #getRiskLevel() <em>Risk Level</em>}'
	 * attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getRiskLevel()
	 * @generated
	 * @ordered
	 */
	protected RiskLevel riskLevel = RISK_LEVEL_EDEFAULT;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected MitigationImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return RiskPackage.Literals.MITIGATION;
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
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, RiskPackage.MITIGATION__BASE_CLASS,
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
			eNotify(new ENotificationImpl(this, Notification.SET, RiskPackage.MITIGATION__BASE_CLASS, oldBaseClass,
					baseClass));
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
			eNotify(new ENotificationImpl(this, Notification.SET, RiskPackage.MITIGATION__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public String getText() {
		return text;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public void setText(String newText) {
		String oldText = text;
		text = newText;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RiskPackage.MITIGATION__TEXT, oldText, text));
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
			eNotify(new ENotificationImpl(this, Notification.SET, RiskPackage.MITIGATION__LIKELIHOOD, oldLikelihood,
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
			eNotify(new ENotificationImpl(this, Notification.SET, RiskPackage.MITIGATION__CONSEQUENCE, oldConsequence,
					consequence));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public RiskLevel getRiskLevel() {
		return riskLevel;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public void setRiskLevel(RiskLevel newRiskLevel) {
		RiskLevel oldRiskLevel = riskLevel;
		riskLevel = newRiskLevel == null ? RISK_LEVEL_EDEFAULT : newRiskLevel;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RiskPackage.MITIGATION__RISK_LEVEL, oldRiskLevel,
					riskLevel));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
		case RiskPackage.MITIGATION__BASE_CLASS:
			if (resolve)
				return getBaseClass();
			return basicGetBaseClass();
		case RiskPackage.MITIGATION__NAME:
			return getName();
		case RiskPackage.MITIGATION__TEXT:
			return getText();
		case RiskPackage.MITIGATION__LIKELIHOOD:
			return getLikelihood();
		case RiskPackage.MITIGATION__CONSEQUENCE:
			return getConsequence();
		case RiskPackage.MITIGATION__RISK_LEVEL:
			return getRiskLevel();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
		case RiskPackage.MITIGATION__BASE_CLASS:
			setBaseClass((org.eclipse.uml2.uml.Class) newValue);
			return;
		case RiskPackage.MITIGATION__NAME:
			setName((String) newValue);
			return;
		case RiskPackage.MITIGATION__TEXT:
			setText((String) newValue);
			return;
		case RiskPackage.MITIGATION__LIKELIHOOD:
			setLikelihood((Likelihood) newValue);
			return;
		case RiskPackage.MITIGATION__CONSEQUENCE:
			setConsequence((Consequence) newValue);
			return;
		case RiskPackage.MITIGATION__RISK_LEVEL:
			setRiskLevel((RiskLevel) newValue);
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
		case RiskPackage.MITIGATION__BASE_CLASS:
			setBaseClass((org.eclipse.uml2.uml.Class) null);
			return;
		case RiskPackage.MITIGATION__NAME:
			setName(NAME_EDEFAULT);
			return;
		case RiskPackage.MITIGATION__TEXT:
			setText(TEXT_EDEFAULT);
			return;
		case RiskPackage.MITIGATION__LIKELIHOOD:
			setLikelihood(LIKELIHOOD_EDEFAULT);
			return;
		case RiskPackage.MITIGATION__CONSEQUENCE:
			setConsequence(CONSEQUENCE_EDEFAULT);
			return;
		case RiskPackage.MITIGATION__RISK_LEVEL:
			setRiskLevel(RISK_LEVEL_EDEFAULT);
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
		case RiskPackage.MITIGATION__BASE_CLASS:
			return baseClass != null;
		case RiskPackage.MITIGATION__NAME:
			return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
		case RiskPackage.MITIGATION__TEXT:
			return TEXT_EDEFAULT == null ? text != null : !TEXT_EDEFAULT.equals(text);
		case RiskPackage.MITIGATION__LIKELIHOOD:
			return likelihood != LIKELIHOOD_EDEFAULT;
		case RiskPackage.MITIGATION__CONSEQUENCE:
			return consequence != CONSEQUENCE_EDEFAULT;
		case RiskPackage.MITIGATION__RISK_LEVEL:
			return riskLevel != RISK_LEVEL_EDEFAULT;
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
		result.append(" (name: ");
		result.append(name);
		result.append(", text: ");
		result.append(text);
		result.append(", likelihood: ");
		result.append(likelihood);
		result.append(", consequence: ");
		result.append(consequence);
		result.append(", riskLevel: ");
		result.append(riskLevel);
		result.append(')');
		return result.toString();
	}

} // MitigationImpl
