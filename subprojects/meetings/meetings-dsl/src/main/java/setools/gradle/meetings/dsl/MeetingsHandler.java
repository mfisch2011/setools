/**
 * Copyright 2021 M. Fischer <mfisch2011@gmail.com>
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package setools.gradle.meetings.dsl;

import java.util.Collection;
import java.util.function.Function;

/**
 * TODO:
 */
public interface MeetingsHandler extends Collection<Meeting> {

	/**
	 * TODO:
	 * @return
	 */
	public Object getDefaultAgendaTemplate();
	
	/**
	 * TODO:
	 * @param object
	 */
	public void setDefaultAgendaTemplate(Object object);

	/**
	 * TODO:
	 * @param meeting
	 * @return
	 */
	public String getDefaultAgendaFilename(Meeting meeting);

	/**
	 * TODO:
	 * @param transform
	 */
	public void setDefaultAgendaFilenameTransform(Function<Meeting,String> transform);

	/**
	 * TODO:
	 * @return
	 */
	public Object getDefaultMinutesTemplate();
	
	/**
	 * TODO:
	 * @param object
	 */
	public void setDefaultMinutesTemplate(Object object);

	/**
	 * TODO:
	 * @param meeting
	 * @return
	 */
	public String getDefaultMinutesFilename(Meeting meeting);

	/**
	 * TODO:
	 * @param transform
	 */
	public void setDefaultMinutesFilenameTransform(Function<Meeting,String> transform);

	/**
	 * TODO:
	 * @return
	 */
	public Object getDefaultPresentationTemplate();
	
	/**
	 * TODO:
	 * @param object
	 */
	public void setDefaultPresentationTemplate(Object object);

	/**
	 * TODO:
	 * @param meeting
	 * @return
	 */
	public String getDefaultPresentationFilename(Meeting meeting);

	/**
	 * TODO:
	 * @param transform
	 */
	public void setDefaultPresentationFilenameTransform(Function<Meeting,String> transform);

}
