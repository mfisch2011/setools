/**
   Copyright 2020 Matt Fischer <mfish2011@gmail.com>

   Licensed under the Apache License, Version 2.0 (the "License");
   you may not use this file except in compliance with the License.
   You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

   Unless required by applicable law or agreed to in writing, software
   distributed under the License is distributed on an "AS IS" BASIS,
   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
   See the License for the specific language governing permissions and
   limitations under the License.
   
   This file was developed using information from:
   https://stackoverflow.com/questions/861500/url-to-load-resources-from-the-classpath-in-java
   
   Acknowledgments to Stephen (https://stackoverflow.com/users/37193/stephen).
   
*/
package setools.util;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;

/**
 * @author matt
 *
 */
public class URLStreamHandler extends java.net.URLStreamHandler {

    /**
     * TODO:
     */
    private final ClassLoader classLoader;

    public URLStreamHandler() {
        this.classLoader = getClass().getClassLoader();
    }

    public URLStreamHandler(ClassLoader classLoader) {
        this.classLoader = classLoader;
    }

    @Override
    protected URLConnection openConnection(URL u) throws IOException {
        final URL resourceUrl = classLoader.getResource(u.getPath().substring(1));
        if(resourceUrl==null) {
        	String msg = String.format("Missing %s", u.getPath());
        	throw new FileNotFoundException(msg);
        }
        return resourceUrl.openConnection();
    }

}
