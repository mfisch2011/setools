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
   
   TODO: add note that this was derived from
   https://stackoverflow.com/questions/861500/url-to-load-resources-from-the-classpath-in-java
*/
package setools.util;

import java.net.URLStreamHandler;
import java.util.HashMap;
import java.util.Map;

public class URLStreamHandlerFactory implements  java.net.URLStreamHandlerFactory {
    private final Map<String, URLStreamHandler> protocolHandlers;

    public URLStreamHandlerFactory(String protocol, URLStreamHandler urlHandler) {
        protocolHandlers = new HashMap<String, URLStreamHandler>();
        addHandler(protocol, urlHandler);
    }

    public void addHandler(String protocol, URLStreamHandler urlHandler) {
        protocolHandlers.put(protocol, urlHandler);
    }

    public URLStreamHandler createURLStreamHandler(String protocol) {
        return protocolHandlers.get(protocol);
    }
}