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
   
   TODO: do we need to reference the license for UMLResourcesUtil 
   since this is based off of/copied from there?
*/
package setools.risk.util;

import java.util.Comparator;

import setools.risk.RiskMitigation;

/**
 * TODO:
 */
public class RiskMitigationComparator implements Comparator<RiskMitigation> {

	@Override
	public int compare(RiskMitigation arg0, RiskMitigation arg1) {
		if(arg0.getPlanned()!=null && arg1.getPlanned()!=null) {
			return arg0.getPlanned().compareTo(arg1.getPlanned());
		}
		else
			return 0; //TODO: how to really compare when one or the other is null?
	}

}
