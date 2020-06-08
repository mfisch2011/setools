/**
 */
package setools.risk.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;
import org.eclipse.uml2.uml.Comment;
import org.eclipse.uml2.uml.DirectedRelationship;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.util.UMLUtil;

import setools.risk.Consequence;
import setools.risk.Likelihood;
import setools.risk.Risk;
import setools.risk.RiskLevel;
import setools.risk.RiskMitigation;
import setools.risk.RiskPackage;
import setools.risk.StatusUpdate;
import setools.risk.util.StatusUpdateComparator;
import setools.uml.util.UMLUtils;

/**
 * <!-- begin-user-doc --> An implementation of the model object
 * '<em><b>Risk</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 * <li>{@link setools.risk.impl.RiskImpl#getId <em>Id</em>}</li>
 * <li>{@link setools.risk.impl.RiskImpl#getStatement <em>Statement</em>}</li>
 * <li>{@link setools.risk.impl.RiskImpl#getLikelihood <em>Likelihood</em>}</li>
 * <li>{@link setools.risk.impl.RiskImpl#getConsequence
 * <em>Consequence</em>}</li>
 * <li>{@link setools.risk.impl.RiskImpl#getRisk <em>Risk</em>}</li>
 * <li>{@link setools.risk.impl.RiskImpl#getBase_Class <em>Base Class</em>}</li>
 * <li>{@link setools.risk.impl.RiskImpl#getDescription
 * <em>Description</em>}</li>
 * </ul>
 *
 * @generated
 */
public class RiskImpl extends MinimalEObjectImpl.Container implements Risk {
	/**
	 * The default value of the '{@link #getId() <em>Id</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getId()
	 * @generated
	 * @ordered
	 */
	protected static final String ID_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getId() <em>Id</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getId()
	 * @generated
	 * @ordered
	 */
	protected String id = ID_EDEFAULT;

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
	 * The default value of the '{@link #getRisk() <em>Risk</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getRisk()
	 * @generated
	 * @ordered
	 */
	protected static final RiskLevel RISK_EDEFAULT = RiskLevel.LOW;

	/**
	 * The cached value of the '{@link #getBase_Class() <em>Base Class</em>}'
	 * reference. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getBase_Class()
	 * @generated
	 * @ordered
	 */
	protected org.eclipse.uml2.uml.Class base_Class;

	/**
	 * The default value of the '{@link #getDescription() <em>Description</em>}'
	 * attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getDescription()
	 * @generated
	 * @ordered
	 */
	protected static final String DESCRIPTION_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getDescription() <em>Description</em>}'
	 * attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getDescription()
	 * @generated
	 * @ordered
	 */
	protected String description = DESCRIPTION_EDEFAULT;

	protected final RiskLevel[][] risk_matrix;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated false
	 */
	protected RiskImpl() {
		super();
		risk_matrix = new RiskLevel[5][5];
		risk_matrix[4][0] = RiskLevel.LOW;
		risk_matrix[4][1] = RiskLevel.MEDIUM;
		risk_matrix[4][2] = RiskLevel.HIGH;
		risk_matrix[4][3] = RiskLevel.HIGH;
		risk_matrix[4][4] = RiskLevel.HIGH;
		risk_matrix[3][0] = RiskLevel.LOW;
		risk_matrix[3][1] = RiskLevel.MEDIUM;
		risk_matrix[3][2] = RiskLevel.MEDIUM;
		risk_matrix[3][3] = RiskLevel.HIGH;
		risk_matrix[3][4] = RiskLevel.HIGH;
		risk_matrix[2][0] = RiskLevel.LOW;
		risk_matrix[2][1] = RiskLevel.LOW;
		risk_matrix[2][2] = RiskLevel.MEDIUM;
		risk_matrix[2][3] = RiskLevel.MEDIUM;
		risk_matrix[2][4] = RiskLevel.HIGH;
		risk_matrix[1][0] = RiskLevel.LOW;
		risk_matrix[1][1] = RiskLevel.LOW;
		risk_matrix[1][2] = RiskLevel.LOW;
		risk_matrix[1][3] = RiskLevel.MEDIUM;
		risk_matrix[1][4] = RiskLevel.MEDIUM;
		risk_matrix[0][0] = RiskLevel.LOW;
		risk_matrix[0][1] = RiskLevel.LOW;
		risk_matrix[0][2] = RiskLevel.LOW;
		risk_matrix[0][3] = RiskLevel.LOW;
		risk_matrix[0][4] = RiskLevel.MEDIUM;
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
	public String getId() {
		return id;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public void setId(String newId) {
		String oldId = id;
		id = newId;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RiskPackage.RISK__ID, oldId, id));
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
	 * @generated false
	 */
	@Override
	public RiskLevel getRisk() {
		if (getLikelihood() != null && getConsequence() != null) {
			int likelihood = getLikelihood().getValue();
			int consequence = getConsequence().getValue();
			return risk_matrix[likelihood][consequence];
		} else
			return null;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public org.eclipse.uml2.uml.Class getBase_Class() {
		if (base_Class != null && base_Class.eIsProxy()) {
			InternalEObject oldBase_Class = (InternalEObject) base_Class;
			base_Class = (org.eclipse.uml2.uml.Class) eResolveProxy(oldBase_Class);
			if (base_Class != oldBase_Class) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, RiskPackage.RISK__BASE_CLASS,
							oldBase_Class, base_Class));
			}
		}
		return base_Class;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public org.eclipse.uml2.uml.Class basicGetBase_Class() {
		return base_Class;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public void setBase_Class(org.eclipse.uml2.uml.Class newBase_Class) {
		org.eclipse.uml2.uml.Class oldBase_Class = base_Class;
		base_Class = newBase_Class;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RiskPackage.RISK__BASE_CLASS, oldBase_Class,
					base_Class));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public String getDescription() {
		return description;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public void setDescription(String newDescription) {
		String oldDescription = description;
		description = newDescription;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RiskPackage.RISK__DESCRIPTION, oldDescription,
					description));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated false
	 */
	@Override
	public Collection<RiskMitigation> getMitigations() {
		List<RiskMitigation> mitigations = new ArrayList<RiskMitigation>();
		if (getBase_Class() != null) {
			Iterator<DirectedRelationship> iter = getBase_Class().getTargetDirectedRelationships().iterator();
			while (iter.hasNext()) {
				DirectedRelationship rel = iter.next();
				Iterator<Element> sources = rel.getSources().iterator();
				while (sources.hasNext()) {
					Element element = sources.next();
					if (element != null) {
						RiskMitigation mitigation = UMLUtil.getStereotypeApplication(element, RiskMitigation.class);
						if (mitigation != null)
							mitigations.add(mitigation);
					}
				}
			}
		}
		return mitigations;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
		case RiskPackage.RISK__ID:
			return getId();
		case RiskPackage.RISK__STATEMENT:
			return getStatement();
		case RiskPackage.RISK__LIKELIHOOD:
			return getLikelihood();
		case RiskPackage.RISK__CONSEQUENCE:
			return getConsequence();
		case RiskPackage.RISK__RISK:
			return getRisk();
		case RiskPackage.RISK__BASE_CLASS:
			if (resolve)
				return getBase_Class();
			return basicGetBase_Class();
		case RiskPackage.RISK__DESCRIPTION:
			return getDescription();
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
		case RiskPackage.RISK__ID:
			setId((String) newValue);
			return;
		case RiskPackage.RISK__STATEMENT:
			setStatement((String) newValue);
			return;
		case RiskPackage.RISK__LIKELIHOOD:
			setLikelihood((Likelihood) newValue);
			return;
		case RiskPackage.RISK__CONSEQUENCE:
			setConsequence((Consequence) newValue);
			return;
		case RiskPackage.RISK__BASE_CLASS:
			setBase_Class((org.eclipse.uml2.uml.Class) newValue);
			return;
		case RiskPackage.RISK__DESCRIPTION:
			setDescription((String) newValue);
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
		case RiskPackage.RISK__ID:
			setId(ID_EDEFAULT);
			return;
		case RiskPackage.RISK__STATEMENT:
			setStatement(STATEMENT_EDEFAULT);
			return;
		case RiskPackage.RISK__LIKELIHOOD:
			setLikelihood(LIKELIHOOD_EDEFAULT);
			return;
		case RiskPackage.RISK__CONSEQUENCE:
			setConsequence(CONSEQUENCE_EDEFAULT);
			return;
		case RiskPackage.RISK__BASE_CLASS:
			setBase_Class((org.eclipse.uml2.uml.Class) null);
			return;
		case RiskPackage.RISK__DESCRIPTION:
			setDescription(DESCRIPTION_EDEFAULT);
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
		case RiskPackage.RISK__ID:
			return ID_EDEFAULT == null ? id != null : !ID_EDEFAULT.equals(id);
		case RiskPackage.RISK__STATEMENT:
			return STATEMENT_EDEFAULT == null ? statement != null : !STATEMENT_EDEFAULT.equals(statement);
		case RiskPackage.RISK__LIKELIHOOD:
			return likelihood != LIKELIHOOD_EDEFAULT;
		case RiskPackage.RISK__CONSEQUENCE:
			return consequence != CONSEQUENCE_EDEFAULT;
		case RiskPackage.RISK__RISK:
			return getRisk() != RISK_EDEFAULT;
		case RiskPackage.RISK__BASE_CLASS:
			return base_Class != null;
		case RiskPackage.RISK__DESCRIPTION:
			return DESCRIPTION_EDEFAULT == null ? description != null : !DESCRIPTION_EDEFAULT.equals(description);
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
		result.append(" (id: ");
		result.append(id);
		result.append(", statement: ");
		result.append(statement);
		result.append(", likelihood: ");
		result.append(likelihood);
		result.append(", consequence: ");
		result.append(consequence);
		result.append(", description: ");
		result.append(description);
		result.append(')');
		return result.toString();
	}

	@Override
	public Collection<StatusUpdate> getStatusUpdates() {
		List<StatusUpdate> updates = new ArrayList<StatusUpdate>();
		for (Comment comment : UMLUtils.getAppliedComments(getBase_Class())) {
			StatusUpdate update = UMLUtils.getStereotypeApplication(comment, StatusUpdate.class);
			if (update != null)
				updates.add(update);
		}
		for (RiskMitigation mitigation : getMitigations())
			updates.addAll(mitigation.getStatusUpdates());
		Collections.sort(updates, new StatusUpdateComparator());
		return updates;
	}

} // RiskImpl
