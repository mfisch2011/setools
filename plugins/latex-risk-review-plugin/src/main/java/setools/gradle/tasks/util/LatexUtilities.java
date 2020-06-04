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
package setools.gradle.tasks.util;

import java.util.Collection;

import setools.risk.Risk;

/**
 * TODO:
 */
public class LatexUtilities {

	/**
	 * TODO:
	 * @param risk
	 * @param likelihood
	 * @param consequence
	 * @return
	 */
	public String getRiskSymbol(Risk risk,int likelihood,int consequence) {
		//TODO: how to handle original value?
		//current value
		int likelihood_value = risk.getLikelihood().getValue() + 1;
		int consequence_value = risk.getConsequence().getValue() +1;
		if(likelihood_value == likelihood && consequence_value == consequence) {
			return "X";
		} else
			return "";
	}
	
	/**
	 * TODO:
	 * @return
	 */
	public String getSummaryIndecies(Collection<Risk> risks,int likelihood,int consequence) {
		String result = "";
		int count = 0;
		for(Risk risk : risks) {
			count++;
			int likelihood_value = risk.getLikelihood().getValue() + 1;
			int consequence_value = risk.getConsequence().getValue() +1;
			if(likelihood_value == likelihood && consequence_value == consequence) {
				result += String.format(",%d",count);
			} 
		}
		if(!result.isEmpty())
			return result.substring(1);
		else
			return "";
	}
}
