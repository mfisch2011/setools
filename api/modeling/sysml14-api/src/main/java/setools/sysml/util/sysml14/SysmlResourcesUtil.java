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
package setools.sysml.util.sysml14;

import java.net.URL;
import java.util.Map;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.ContentHandler;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.URIConverter;
import org.eclipse.papyrus.sysml14.sysmlPackage;
import org.eclipse.papyrus.sysml14.util.SysMLResource;
import org.eclipse.uml2.common.util.UML2Util;
import org.eclipse.uml2.uml.UMLPlugin;
import org.eclipse.uml2.uml.resource.UMLResource;
import org.eclipse.uml2.uml.resources.ResourcesPlugin;
import org.eclipse.uml2.uml.resources.util.UMLResourcesUtil;


/**
 * TODO:
 */
public class SysmlResourcesUtil extends UML2Util {

	/** TODO: link to {@link UMLResourcesUtil#initGlobalRegistries()
	 * 
	 * Adds registrations to EMF's and UML2's global registries that enable
	 * working with UML models. To apply the same registrations only locally on
	 * a resource set (e.g., for isolation from other EMF-based code in the same
	 * class loader), use the {@link #initLocalRegistries(ResourceSet)} method,
	 * instead.
	 * 
	 * @see #initLocalRegistries(ResourceSet)

	 */
	public static void initGlobalRegistries() {
		initPackageRegistry(EPackage.Registry.INSTANCE);
		initEPackageNsURIToProfileLocationMap(UMLPlugin
			.getEPackageNsURIToProfileLocationMap());
		initURIConverterURIMap(URIConverter.URI_MAP);
		initContentHandlerRegistry(ContentHandler.Registry.INSTANCE);
		initResourceFactoryRegistry(Resource.Factory.Registry.INSTANCE);
	}

	/** TODO: {@link UMLResourcesUtil#initLocalRegistries(ResourceSet)}
	 * 
	 * Adds registrations to a resource set's local registries that enable
	 * working with UML models in that resource set.
	 * 
	 * @see #initPackageRegistry(org.eclipse.emf.ecore.EPackage.Registry)
	 * @see #initResourceFactoryRegistry(org.eclipse.emf.ecore.resource.Resource.Factory.Registry)
	 * @see #initContentHandlerRegistry(org.eclipse.emf.ecore.resource.ContentHandler.Registry)
	 * @see #initURIConverterURIMap(Map)
	 * @see #initEPackageNsURIToProfileLocationMap(Map)
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

	/** TODO: @link UMLResourcesUtil#init(ResourceSet)
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
	 * @see #initLocalRegistries(ResourceSet)
	 * @see #initGlobalRegistries()
	 */
	public static ResourceSet init(ResourceSet resourceSet) {
		UMLResourcesUtil.init(resourceSet);
		initGlobalRegistries();
		return resourceSet;
	}

	/** TODO: {@link UMLResourcesUtil#initPackageRegistry(org.eclipse.emf.ecore.EPackage.Registry)}
	 * 
	 * Adds packages required for working with UML models to the specified
	 * registry.
	 * 
	 * @param packageRegistry
	 *            a package registry, perhaps local to a resource set or perhaps
	 *            the global registry
	 * 
	 * @return the same {@code packageRegistry}
	 * 
	 */
	public static EPackage.Registry initPackageRegistry(
			EPackage.Registry packageRegistry) {
		packageRegistry.put(sysmlPackage.eNS_URI,sysmlPackage.eINSTANCE);
		return packageRegistry;
	}

	/** TODO: {@link UMLResourcesUtil#initResourceFactoryRegistry(org.eclipse.emf.ecore.resource.Resource.Factory.Registry)}
	 * 
	 * Adds resource factories required for working with UML models to the
	 * specified registry.
	 * 
	 * @param resourceFactoryRegistry
	 *            a resource-factory registry, perhaps local to a resource set
	 *            or perhaps the global registry
	 * 
	 * @return the same {@code resourceFactoryRegistry}
	 * 
	 */
	public static Resource.Factory.Registry initResourceFactoryRegistry(
			Resource.Factory.Registry resourceFactoryRegistry) {
		Map<String, Object> extensionToFactoryMap = resourceFactoryRegistry
			.getExtensionToFactoryMap();
		extensionToFactoryMap.put(UMLResource.FILE_EXTENSION,
			UMLResource.Factory.INSTANCE);

		Map<String, Object> contentTypeToFactoryMap = resourceFactoryRegistry
			.getContentTypeToFactoryMap();
		contentTypeToFactoryMap.put(UMLResource.UML_CONTENT_TYPE_IDENTIFIER,
			UMLResource.Factory.INSTANCE);

		return resourceFactoryRegistry;
	}

	/** TODO: {@link UMLResourcesUtil#initContentHandlerRegistry(org.eclipse.emf.ecore.resource.ContentHandler.Registry)}
	 * Adds content-type handlers required for working with UML models to the
	 * specified registry.
	 * 
	 * @param contentHandlerRegistry
	 *            a content-type handler registry, perhaps local to a resource
	 *            set or perhaps the global registry
	 * 
	 * @return the same {@code contentHandlerRegistry}
	 * 
	 */
	public static ContentHandler.Registry initContentHandlerRegistry(
			ContentHandler.Registry contentHandlerRegistry) {
		//TODO:???
		return contentHandlerRegistry;
	}

	/** TODO: {@link UMLResourcesUtil#initURIConverterURIMap(Map)}
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
	 */
	public static Map<URI, URI> initURIConverterURIMap(Map<URI, URI> uriMap) {
		URI umlURI = getBaseSysMLURI();
		mapURIs(uriMap, SysMLResource.PROFILES_PATHMAP,
				umlURI.appendSegment("profile"), //$NON-NLS-1$
			ResourcesPlugin.PLUGIN_ID);
		return uriMap;
	}

	/** TODO: {@link UMLResourcesUtil#initEPackageNsURIToProfileLocationMap(Map)}
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
	 */
	public static Map<String, URI> initEPackageNsURIToProfileLocationMap(
			Map<String, URI> ePackageNsURIToProfileLocationMap) {
		ePackageNsURIToProfileLocationMap.put(SysMLResource.PROFILE_URI,
			URI.createURI(SysMLResource.PROFILE_PATH + "#SysML")); //$NON-NLS-1$
		return ePackageNsURIToProfileLocationMap;
	}

	private static URI getBaseSysMLURI() {
		String url = String.format("resources/profile/%s", "sysml.ecore");
		URL resultURL = SysMLResource.class.getClassLoader()
			.getResource(url); //$NON-NLS-1$ //$NON-NLS-2$
		URI result;

		if (resultURL != null) {
			// remove the /model/RiskML.ecore segments of the resource
			// we found
			result = URI.createURI(resultURL.toExternalForm(), true)
				.trimSegments(2);
		} else {
			// probably, we're not running with JARs, so assume the source
			// project folder layout
			resultURL = SysmlResourcesUtil.class.getResource("SysMLResource.class"); //$NON-NLS-1$

			String baseURL = resultURL.toExternalForm();

			int index = baseURL.lastIndexOf("/bin/"); //$NON-NLS-1$

			if (index != -1) {
				baseURL = baseURL.substring(0, index);
			}

			result = URI.createURI(baseURL, true);
		}

		return result;
	}

	private static URI getBaseSysMLResourcesURI() {
		URI umlMetamodel = URI.createURI(SysMLResource.PROFILE_PATH);
		URL resultURL = UMLResourcesUtil.class.getClassLoader().getResource(
			String.format("resources/profile/%s", umlMetamodel.lastSegment())); //$NON-NLS-1$
		
		URI result;

		if (resultURL != null) {
			// remove the /metamodel/RiskML.profile.uml segments of the resource
			// we found
			result = URI.createURI(resultURL.toExternalForm(), true)
				.trimSegments(2);
		} else {
			// probably, we're not running with JARs, so assume the source
			// project folder layout
			
			resultURL = SysmlResourcesUtil.class
				.getResource("SysMLResource.class"); //$NON-NLS-1$
			
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
