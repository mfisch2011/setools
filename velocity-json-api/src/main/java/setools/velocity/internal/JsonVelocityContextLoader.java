/**
 * 
 */
package setools.velocity.internal;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.apache.velocity.VelocityContext;
import org.json.JSONArray;
import org.json.JSONObject;

import setools.velocity.VelocityContextLoader;

/**
 * @author matt
 *
 */
public class JsonVelocityContextLoader implements VelocityContextLoader {

	@Override
	public boolean load(VelocityContext context, String input) {
		try {
			if(input.endsWith(".json")) {
				Path path = Paths.get(input);
				String filename = path.getFileName().toString();
				int index = filename.lastIndexOf('.');
				if(index>0) filename = filename.substring(0,index);
				byte[] bytes = Files.readAllBytes(path);
				String text = new String(bytes);
				text = input.strip();
				if(text.startsWith("{")) {
					JSONObject json = new JSONObject(text);
					context.put(filename,json);
					return true;
				} else if(text.startsWith("[")) {
					JSONArray json = new JSONArray(text);
					context.put(filename,json);
					return true;
				}
			} else {
				String text = input.strip();
				if(text.startsWith("{")) {
					JSONObject json = new JSONObject(text);
					for(String name : JSONObject.getNames(json)) {
						context.put(name, json.get(name));
					}
					return true;
				} //TODO:what to do about JSONArrays since there is no name???
			}
		} catch(Throwable t) {
			t.printStackTrace(); //TODO:implement logging...
		}
		return false;
	}

}
