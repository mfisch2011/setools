/**
 * 
 */
package setools.velocity.internal;

import static org.junit.Assert.*;

import org.apache.velocity.VelocityContext;
import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.Test;

import setools.velocity.VelocityContextLoaderService;

/**
 * @author matt
 *
 */
public class JsonVelocityContextLoaderTest {

	/**
	 * Test method for {@link setools.velocity.internal.JsonVelocityContextLoader#load(org.apache.velocity.VelocityContext, java.lang.String)}.
	 */
	@Test
	public void testLoadText() {
		VelocityContext context = new VelocityContext();
		assertNotNull(context);
		String json = "{ 'you' : 'World', 'me' : 'Gradle' }";
		VelocityContextLoaderService.load(context, json);
		Object object = context.get("you");
		assertNotNull(object);
		assertTrue(object instanceof String);
		assertEquals("World",(String)object);
		object = context.get("me");
		assertNotNull(object);
		assertTrue(object instanceof String);
		assertEquals("Gradle",(String)object);
	}

	/**
	 * Test method for {@link setools.velocity.internal.JsonVelocityContextLoader#load(org.apache.velocity.VelocityContext, java.lang.String)}.
	 */
	@Test
	public void testLoadFileJsonObject() {
		VelocityContext context = new VelocityContext();
		assertNotNull(context);
		VelocityContextLoaderService.load(context,"src/test/resource/helloWorld.json");
		Object object = context.get("helloWorld");
		assertNotNull(object);
		assertTrue(object instanceof JSONObject);
		JSONObject json = (JSONObject)object;
		object = json.get("you");
		assertNotNull(object);
		assertTrue(object instanceof String);
		assertEquals("World",(String)object);
		object = json.get("me");
		assertNotNull(object);
		assertTrue(object instanceof String);
		assertEquals("Gradle",(String)object);
	}
	
	/**
	 * Test method for {@link setools.velocity.internal.JsonVelocityContextLoader#load(org.apache.velocity.VelocityContext, java.lang.String)}.
	 */
	@Test
	public void testLoadFileJsonArray() {
		VelocityContext context = new VelocityContext();
		assertNotNull(context);
		VelocityContextLoaderService.load(context,"src/test/resource/petList.json");
		Object object = context.get("petList");
		assertNotNull(object);
		assertTrue(object instanceof JSONArray);
		JSONArray array = (JSONArray)object;
		
		//item 1
		object = array.get(0);
		assertNotNull(object);
		assertTrue(object instanceof JSONObject);
		JSONObject json = (JSONObject)object;
		object = json.get("name");
		assertNotNull(object);
		assertTrue(object instanceof String);
		assertEquals("Horse",(String)object);
		object = json.get("price");
		assertNotNull(object);
		assertTrue(object instanceof String);
		assertEquals("$10.00",(String)object);

		//item 2
		object = array.get(1);
		assertNotNull(object);
		assertTrue(object instanceof JSONObject);
		json = (JSONObject)object;
		object = json.get("name");
		assertNotNull(object);
		assertTrue(object instanceof String);
		assertEquals("Dog",(String)object);
		object = json.get("price");
		assertNotNull(object);
		assertTrue(object instanceof String);
		assertEquals("$9.00",(String)object);
		
		//item 3
		object = array.get(2);
		assertNotNull(object);
		assertTrue(object instanceof JSONObject);
		json = (JSONObject)object;
		object = json.get("name");
		assertNotNull(object);
		assertTrue(object instanceof String);
		assertEquals("Bear",(String)object);
		object = json.get("price");
		assertNotNull(object);
		assertTrue(object instanceof String);
		assertEquals("$0.99",(String)object);
	}
}
