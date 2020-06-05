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
*/
package setools.risk.util;

import java.util.Comparator;

import setools.risk.Risk;

/**
 * Reverse order (i.e. high to low)
 * TODO:
 */
public class RiskComparator implements Comparator<Risk> {

	@Override
	public int compare(Risk risk0, Risk risk1) {
		if(risk0.getRisk()!=null && risk1.getRisk()!=null) {
			return risk1.getRisk().compareTo(risk0.getRisk());
		} else
			return 0; //TODO:how to actually handle null case?
	}

}
