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

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;

import setools.risk.Risk;
import setools.risk.RiskMitigation;

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
	
	/**
	 * TODO:
	 * @param risk
	 * @return
	 */
	public String getFormattedStartDate(Risk risk) {
		Date end = getStartDate(risk);
		Calendar c = Calendar.getInstance(); 
		c.setTime(end); 
		c.add(Calendar.MONTH,-3); //backup for visibility
	    SimpleDateFormat formatter = new SimpleDateFormat("MM/YY");
	    return formatter.format(c.getTime());
	}
	
	/**
	 * TODO: really should go into risk library as utility
	 * @param risk
	 * @return
	 */
	public Date getStartDate(Risk risk) {
		//TODO:how to get the identification date, duh need to add to risk or implement git???
		Date result = new Date();
		result.setYear(result.getYear()-1);
		result.setMonth(10);
		return result;
	}
	
	/**
	 * TODO: really should go into risk library as utility
	 * @param risk
	 * @return
	 */
	public Date getEndDate(Risk risk) {
		//default to a year after identified
		Date result = getStartDate(risk);
		result.setYear(result.getYear()+1);
		
		//check the mitigations plan
		for(RiskMitigation mitigation : risk.getMitigations()) {
			Date date = mitigation.getPlanned();
			if(date!=null && date.after(result)) {
				result = date;
			}
		}
		return result;
	}
	
	/**
	 * TODO:
	 * @param risk
	 * @return
	 */
	public String getFormattedEndDate(Risk risk) {
		Date end = getEndDate(risk);
		Calendar c = Calendar.getInstance(); 
		c.setTime(end); 
		c.add(Calendar.MONTH,+3); //push out 3 months to improve visibility
	    SimpleDateFormat formatter = new SimpleDateFormat("MM/YY");
	    return formatter.format(c.getTime());
	}
	
	/**
	 * TODO:
	 * @param risk
	 * @param mitigation
	 * @return
	 */
	public float getPercentage(Risk risk,RiskMitigation mitigation) {
		Date start = getStartDate(risk);
		Calendar c = Calendar.getInstance(); 
		c.setTime(start); 
		c.add(Calendar.MONTH,- 3); //backup for visibility
		start = c.getTime();
		Date end = getEndDate(risk);
		c.setTime(end); 
		c.add(Calendar.MONTH,+3); //fast forward for visibility
	    end = c.getTime();
	    
		Date planned = (mitigation!=null && mitigation.getPlanned()!=null) ?
				mitigation.getPlanned() : new Date();
		long total = end.getTime() - start.getTime();
		long width = planned.getTime() - start.getTime();
		return (float)width / (float)total;
	}
}
