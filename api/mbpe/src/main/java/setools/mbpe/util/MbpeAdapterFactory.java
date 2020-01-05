/**
 */
package setools.mbpe.util;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;

import org.eclipse.emf.ecore.EObject;

import setools.mbpe.*;

/**
 * <!-- begin-user-doc --> The <b>Adapter Factory</b> for the model. It provides
 * an adapter <code>createXXX</code> method for each class of the model. <!--
 * end-user-doc -->
 * 
 * @see setools.mbpe.MbpePackage
 * @generated
 */
public class MbpeAdapterFactory extends AdapterFactoryImpl {
	/**
	 * The cached model package. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected static MbpePackage modelPackage;

	/**
	 * Creates an instance of the adapter factory. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 */
	public MbpeAdapterFactory() {
		if (modelPackage == null) {
			modelPackage = MbpePackage.eINSTANCE;
		}
	}

	/**
	 * Returns whether this factory is applicable for the type of the object. <!--
	 * begin-user-doc --> This implementation returns <code>true</code> if the
	 * object is either the model's package or is an instance object of the model.
	 * <!-- end-user-doc -->
	 * 
	 * @return whether this factory is applicable for the type of the object.
	 * @generated
	 */
	@Override
	public boolean isFactoryForType(Object object) {
		if (object == modelPackage) {
			return true;
		}
		if (object instanceof EObject) {
			return ((EObject) object).eClass().getEPackage() == modelPackage;
		}
		return false;
	}

	/**
	 * The switch that delegates to the <code>createXXX</code> methods. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected MbpeSwitch<Adapter> modelSwitch = new MbpeSwitch<Adapter>() {
		@Override
		public Adapter caseSupportEquipment(SupportEquipment object) {
			return createSupportEquipmentAdapter();
		}

		@Override
		public Adapter caseEquipment(Equipment object) {
			return createEquipmentAdapter();
		}

		@Override
		public Adapter caseManufacturedMaterial(ManufacturedMaterial object) {
			return createManufacturedMaterialAdapter();
		}

		@Override
		public Adapter caseOperatingProcedure(OperatingProcedure object) {
			return createOperatingProcedureAdapter();
		}

		@Override
		public Adapter caseProcedure(Procedure object) {
			return createProcedureAdapter();
		}

		@Override
		public Adapter caseMaterial(Material object) {
			return createMaterialAdapter();
		}

		@Override
		public Adapter caseMaintenanceProcedure(MaintenanceProcedure object) {
			return createMaintenanceProcedureAdapter();
		}

		@Override
		public Adapter caseCreationProcedure(CreationProcedure object) {
			return createCreationProcedureAdapter();
		}

		@Override
		public Adapter caseAssemblyProcedure(AssemblyProcedure object) {
			return createAssemblyProcedureAdapter();
		}

		@Override
		public Adapter caseFabricationProcedure(FabricationProcedure object) {
			return createFabricationProcedureAdapter();
		}

		@Override
		public Adapter caseInstallationProcedure(InstallationProcedure object) {
			return createInstallationProcedureAdapter();
		}

		@Override
		public Adapter caseCalibrationProcedure(CalibrationProcedure object) {
			return createCalibrationProcedureAdapter();
		}

		@Override
		public Adapter defaultCase(EObject object) {
			return createEObjectAdapter();
		}
	};

	/**
	 * Creates an adapter for the <code>target</code>. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @param target the object to adapt.
	 * @return the adapter for the <code>target</code>.
	 * @generated
	 */
	@Override
	public Adapter createAdapter(Notifier target) {
		return modelSwitch.doSwitch((EObject) target);
	}

	/**
	 * Creates a new adapter for an object of class
	 * '{@link setools.mbpe.SupportEquipment <em>Support Equipment</em>}'. <!--
	 * begin-user-doc --> This default implementation returns null so that we can
	 * easily ignore cases; it's useful to ignore a case when inheritance will catch
	 * all the cases anyway. <!-- end-user-doc -->
	 * 
	 * @return the new adapter.
	 * @see setools.mbpe.SupportEquipment
	 * @generated
	 */
	public Adapter createSupportEquipmentAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link setools.mbpe.Equipment
	 * <em>Equipment</em>}'. <!-- begin-user-doc --> This default implementation
	 * returns null so that we can easily ignore cases; it's useful to ignore a case
	 * when inheritance will catch all the cases anyway. <!-- end-user-doc -->
	 * 
	 * @return the new adapter.
	 * @see setools.mbpe.Equipment
	 * @generated
	 */
	public Adapter createEquipmentAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class
	 * '{@link setools.mbpe.ManufacturedMaterial <em>Manufactured Material</em>}'.
	 * <!-- begin-user-doc --> This default implementation returns null so that we
	 * can easily ignore cases; it's useful to ignore a case when inheritance will
	 * catch all the cases anyway. <!-- end-user-doc -->
	 * 
	 * @return the new adapter.
	 * @see setools.mbpe.ManufacturedMaterial
	 * @generated
	 */
	public Adapter createManufacturedMaterialAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class
	 * '{@link setools.mbpe.OperatingProcedure <em>Operating Procedure</em>}'. <!--
	 * begin-user-doc --> This default implementation returns null so that we can
	 * easily ignore cases; it's useful to ignore a case when inheritance will catch
	 * all the cases anyway. <!-- end-user-doc -->
	 * 
	 * @return the new adapter.
	 * @see setools.mbpe.OperatingProcedure
	 * @generated
	 */
	public Adapter createOperatingProcedureAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link setools.mbpe.Procedure
	 * <em>Procedure</em>}'. <!-- begin-user-doc --> This default implementation
	 * returns null so that we can easily ignore cases; it's useful to ignore a case
	 * when inheritance will catch all the cases anyway. <!-- end-user-doc -->
	 * 
	 * @return the new adapter.
	 * @see setools.mbpe.Procedure
	 * @generated
	 */
	public Adapter createProcedureAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link setools.mbpe.Material
	 * <em>Material</em>}'. <!-- begin-user-doc --> This default implementation
	 * returns null so that we can easily ignore cases; it's useful to ignore a case
	 * when inheritance will catch all the cases anyway. <!-- end-user-doc -->
	 * 
	 * @return the new adapter.
	 * @see setools.mbpe.Material
	 * @generated
	 */
	public Adapter createMaterialAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class
	 * '{@link setools.mbpe.MaintenanceProcedure <em>Maintenance Procedure</em>}'.
	 * <!-- begin-user-doc --> This default implementation returns null so that we
	 * can easily ignore cases; it's useful to ignore a case when inheritance will
	 * catch all the cases anyway. <!-- end-user-doc -->
	 * 
	 * @return the new adapter.
	 * @see setools.mbpe.MaintenanceProcedure
	 * @generated
	 */
	public Adapter createMaintenanceProcedureAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class
	 * '{@link setools.mbpe.CreationProcedure <em>Creation Procedure</em>}'. <!--
	 * begin-user-doc --> This default implementation returns null so that we can
	 * easily ignore cases; it's useful to ignore a case when inheritance will catch
	 * all the cases anyway. <!-- end-user-doc -->
	 * 
	 * @return the new adapter.
	 * @see setools.mbpe.CreationProcedure
	 * @generated
	 */
	public Adapter createCreationProcedureAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class
	 * '{@link setools.mbpe.AssemblyProcedure <em>Assembly Procedure</em>}'. <!--
	 * begin-user-doc --> This default implementation returns null so that we can
	 * easily ignore cases; it's useful to ignore a case when inheritance will catch
	 * all the cases anyway. <!-- end-user-doc -->
	 * 
	 * @return the new adapter.
	 * @see setools.mbpe.AssemblyProcedure
	 * @generated
	 */
	public Adapter createAssemblyProcedureAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class
	 * '{@link setools.mbpe.FabricationProcedure <em>Fabrication Procedure</em>}'.
	 * <!-- begin-user-doc --> This default implementation returns null so that we
	 * can easily ignore cases; it's useful to ignore a case when inheritance will
	 * catch all the cases anyway. <!-- end-user-doc -->
	 * 
	 * @return the new adapter.
	 * @see setools.mbpe.FabricationProcedure
	 * @generated
	 */
	public Adapter createFabricationProcedureAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class
	 * '{@link setools.mbpe.InstallationProcedure <em>Installation Procedure</em>}'.
	 * <!-- begin-user-doc --> This default implementation returns null so that we
	 * can easily ignore cases; it's useful to ignore a case when inheritance will
	 * catch all the cases anyway. <!-- end-user-doc -->
	 * 
	 * @return the new adapter.
	 * @see setools.mbpe.InstallationProcedure
	 * @generated
	 */
	public Adapter createInstallationProcedureAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class
	 * '{@link setools.mbpe.CalibrationProcedure <em>Calibration Procedure</em>}'.
	 * <!-- begin-user-doc --> This default implementation returns null so that we
	 * can easily ignore cases; it's useful to ignore a case when inheritance will
	 * catch all the cases anyway. <!-- end-user-doc -->
	 * 
	 * @return the new adapter.
	 * @see setools.mbpe.CalibrationProcedure
	 * @generated
	 */
	public Adapter createCalibrationProcedureAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for the default case. <!-- begin-user-doc --> This
	 * default implementation returns null. <!-- end-user-doc -->
	 * 
	 * @return the new adapter.
	 * @generated
	 */
	public Adapter createEObjectAdapter() {
		return null;
	}

} // MbpeAdapterFactory
