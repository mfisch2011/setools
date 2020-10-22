/**
 * TODO:license...
 */
package setools.risk.util;

import java.net.URL;
import java.util.Map;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.ContentHandler;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.URIConverter;
import org.eclipse.uml2.uml.UMLPlugin;
import org.eclipse.uml2.uml.resource.UMLResource;
import org.eclipse.uml2.uml.resources.ResourcesPlugin;
import org.eclipse.uml2.uml.resources.util.UMLResourcesUtil;
import org.eclipse.uml2.uml.util.UMLUtil;

import setools.risk.RiskPackage;

/**
 * TODO:documentation...
 */
public class RiskResourcesUtil extends UMLUtil {

	/**
	 * Adds registrations to EMF's and UML2's global registries that enable
	 * working with UML models. To apply the same registrations only locally on
	 * a resource set (e.g., for isolation from other EMF-based code in the same
	 * class loader), use the {@link #initLocalRegistries(ResourceSet)} method,
	 * instead.
	 * 
	 * @see #initLocalRegistries(ResourceSet)
	 * 
	 * @since 5.0
	 */
	public static void initGlobalRegistries() {
		initPackageRegistry(EPackage.Registry.INSTANCE);
		initEPackageNsURIToProfileLocationMap(UMLPlugin
			.getEPackageNsURIToProfileLocationMap());
		initURIConverterURIMap(URIConverter.URI_MAP);
		initContentHandlerRegistry(ContentHandler.Registry.INSTANCE);
		initResourceFactoryRegistry(Resource.Factory.Registry.INSTANCE);
	}

	/**
	 * Adds registrations to a resource set's local registries that enable
	 * working with UML models in that resource set.
	 * 
	 * @see #initPackageRegistry(org.eclipse.emf.ecore.EPackage.Registry)
	 * @see #initResourceFactoryRegistry(org.eclipse.emf.ecore.resource.Resource.Factory.Registry)
	 * @see #initContentHandlerRegistry(org.eclipse.emf.ecore.resource.ContentHandler.Registry)
	 * @see #initURIConverterURIMap(Map)
	 * @see #initEPackageNsURIToProfileLocationMap(Map)
	 * 
	 * @since 5.0
	 */
	public static void initLocalRegistries(ResourceSet resourceSet) {
		initPackageRegistry(resourceSet.getPackageRegistry());

		// there is no local registry for this
		initEPackageNsURIToProfileLocationMap(UMLPlugin
			.getEPackageNsURIToProfileLocationMap());

		initURIConverterURIMap(resourceSet.getURIConverter().getURIMap());

		// there is no local registry for this
		initContentHandlerRegistry(ContentHandler.Registry.INSTANCE);

		initResourceFactoryRegistry(resourceSet.getResourceFactoryRegistry());
	}

	/**
	 * <p>
	 * Initializes the global registries and, if provided, the local registries
	 * for the specified resource set, with the registrations needed to work
	 * with UML2 resources in stand-alone mode (i.e., without Eclipse).
	 * </p>
	 * <p>
	 * <string>Note</string> that as of the 5.0 release, clients now have more
	 * fine-grained control over which registries (local or global) are
	 * initialized. Clients are encouraged to use these new APIs to ensure
	 * optimal behaviour and, where necessary, isolation from other code in the
	 * same class loader using the global registries.
	 * </p>
	 * 
	 * @param resourceSet
	 *            The resource set whose local registries to initialize, or
	 *            <code>null</code> to perform only global registrations.
	 * @return The resource set (or <code>null</code>).
	 * 
	 * @since 4.0
	 * 
	 * @see #initLocalRegistries(ResourceSet)
	 * @see #initGlobalRegistries()
	 */
	public static ResourceSet init(ResourceSet resourceSet) {
		initGlobalRegistries();
		return UMLResourcesUtil.init(resourceSet);
	}

	/**
	 * Adds packages required for working with UML models to the specified
	 * registry.
	 * 
	 * @param packageRegistry
	 *            a package registry, perhaps local to a resource set or perhaps
	 *            the global registry
	 * 
	 * @return the same {@code packageRegistry}
	 * 
	 * @since 5.0
	 */
	public static EPackage.Registry initPackageRegistry(
			EPackage.Registry packageRegistry) {

		packageRegistry.put(RiskPackage.eNS_URI, RiskPackage.eINSTANCE);

		return packageRegistry;
	}

	/**
	 * Adds resource factories required for working with UML models to the
	 * specified registry.
	 * 
	 * @param resourceFactoryRegistry
	 *            a resource-factory registry, perhaps local to a resource set
	 *            or perhaps the global registry
	 * 
	 * @return the same {@code resourceFactoryRegistry}
	 * 
	 * @since 5.0
	 */
	public static Resource.Factory.Registry initResourceFactoryRegistry(
			Resource.Factory.Registry resourceFactoryRegistry) {
		Map<String, Object> extensionToFactoryMap = resourceFactoryRegistry
			.getExtensionToFactoryMap();
		
		//TODO:DO WE NEED TO CHANGE ANY OF THIS?
		extensionToFactoryMap.put(UMLResource.FILE_EXTENSION,
			UMLResource.Factory.INSTANCE);

		Map<String, Object> contentTypeToFactoryMap = resourceFactoryRegistry
			.getContentTypeToFactoryMap();
		contentTypeToFactoryMap.put(UMLResource.UML_CONTENT_TYPE_IDENTIFIER,
			UMLResource.Factory.INSTANCE);

		return resourceFactoryRegistry;
	}

	/**
	 * Adds content-type handlers required for working with UML models to the
	 * specified registry.
	 * 
	 * @param contentHandlerRegistry
	 *            a content-type handler registry, perhaps local to a resource
	 *            set or perhaps the global registry
	 * 
	 * @return the same {@code contentHandlerRegistry}
	 * 
	 * @since 5.0
	 */
	public static ContentHandler.Registry initContentHandlerRegistry(
			ContentHandler.Registry contentHandlerRegistry) {
		return contentHandlerRegistry;
	}

	/**
	 * Adds resource URI mappings required for working with UML models to the
	 * specified map. These include at least mappings for the UML2-provided
	 * model libraries, metamodels, and profiles.
	 * 
	 * @param uriMap
	 *            a URI map, perhaps local to a resource set or perhaps the
	 *            global URI map
	 * 
	 * @return the same {@code uriMap}
	 * 
	 * @since 5.0
	 */
	public static Map<URI, URI> initURIConverterURIMap(Map<URI, URI> uriMap) {
		URI umlURI = getBaseRiskURI();
		mapURIs(uriMap, "platform:/plugin/setools.risk/model/", //$NON-NLS-1$
			umlURI.appendSegment("model"), "setools.risk"); //$NON-NLS-1$ //$NON-NLS-2$
		URI umlResourcesURI = getBaseRiskResourcesURI();
		mapURIs(uriMap, RiskResource.PROFILE_PATHMAP,
			umlResourcesURI.appendSegment("profile"), //$NON-NLS-1$
			ResourcesPlugin.PLUGIN_ID);
		return uriMap;
	}

	/**
	 * Adds profile namespace URI mappings required for working with UML models
	 * to the specified map. These include at least mappings for the
	 * UML2-provided profiles.
	 * 
	 * @param ePackageNsURIToProfileLocationMap
	 *            a profile location map, perhaps local to a resource set or
	 *            perhaps the global location map
	 * 
	 * @return the same {@code ePackageNsURIToProfileLocationMap}
	 * 
	 * @since 5.0
	 */
	public static Map<String, URI> initEPackageNsURIToProfileLocationMap(
			Map<String, URI> ePackageNsURIToProfileLocationMap) {
		ePackageNsURIToProfileLocationMap.put(RiskPackage.eNS_URI,
			URI.createURI("pathmap://RISK_PROFILES/risk.profile.uml#_0")); //$NON-NLS-1$
		return ePackageNsURIToProfileLocationMap;
	}

	private static URI getBaseRiskURI() {
		URL resultURL = RiskResource.class.getClassLoader()
			.getResource(String.format("profile/%s", "risk.ecore")); //$NON-NLS-1$ //$NON-NLS-2$

		URI result;

		if (resultURL != null) {
			// remove the /model/UML.ecore segments of the resource
			// we found
			result = URI.createURI(resultURL.toExternalForm(), true)
				.trimSegments(2);
		} else {
			// probably, we're not running with JARs, so assume the source
			// project folder layout
			resultURL = RiskResource.class.getResource("RiskResource.class"); //$NON-NLS-1$

			String baseURL = resultURL.toExternalForm();

			int index = baseURL.lastIndexOf("/bin/"); //$NON-NLS-1$ TODO:how to handle gradle which uses /build/

			if (index != -1) {
				baseURL = baseURL.substring(0, index);
			}

			result = URI.createURI(baseURL, true);
		}

		return result;
	}

	private static URI getBaseRiskResourcesURI() {
		URI umlMetamodel = URI.createURI(RiskResource.RISK_PROFILE_URI);
		URL resultURL = RiskResource.class.getClassLoader().getResource(
			String.format("profile/%s", umlMetamodel.lastSegment())); //$NON-NLS-1$

		URI result;

		if (resultURL != null) {
			// remove the /profile/risl.profile.uml segments of the resource
			// we found
			result = URI.createURI(resultURL.toExternalForm(), true)
				.trimSegments(2);
		} else {
			// probably, we're not running with JARs, so assume the source
			// project folder layout
			resultURL = RiskResource.class
				.getResource("RiskResource.class"); //$NON-NLS-1$

			String baseURL = resultURL.toExternalForm();

			int index = baseURL.lastIndexOf("/bin/"); //$NON-NLS-1$

			if (index != -1) {
				baseURL = baseURL.substring(0, index);
			}

			result = URI.createURI(baseURL, true);
		}

		return result;
	}

	private static void mapURIs(Map<URI, URI> uriMap, String uri, URI location,
			String pluginID) {

		URI prefix = URI.createURI(uri);

		// ensure trailing separator (make it a "URI prefix")
		if (!prefix.hasTrailingPathSeparator()) {
			prefix = prefix.appendSegment(""); //$NON-NLS-1$
		}

		// same with the location
		if (!location.hasTrailingPathSeparator()) {
			location = location.appendSegment(""); //$NON-NLS-1$
		}

		uriMap.put(prefix, location);

		// and platform URIs, too
		String folder = location.segment(location.segmentCount() - 2);
		String platformURI = String.format("%s/%s/", //$NON-NLS-1$
			pluginID, folder);
		uriMap.put(URI.createPlatformPluginURI(platformURI, true), location);
		uriMap.put(URI.createPlatformResourceURI(platformURI, true), location);
	}
}
