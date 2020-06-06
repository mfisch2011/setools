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
package setools.util;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.List;

/**
 * TODO:
 */
public class BaseUtils {

	/**
	 * todo:
	 * @param date
	 * @return
	 */
	public static Date toDate(String date) {
		//TODO:implement other date formats...
		//default, ISO_LOCAL_DATE
        LocalDate localDate = LocalDate.parse(date);
		return java.sql.Date.valueOf(localDate);
	}
	
	/**
	 * TODO:
	 * @param collection
	 * @return
	 */
	public static List<Object> reverse(Collection<Object> collection) {
		List<Object> results = new ArrayList<Object>();
		results.addAll(collection);
		Collections.reverse(results);
		return results;
	}
}
