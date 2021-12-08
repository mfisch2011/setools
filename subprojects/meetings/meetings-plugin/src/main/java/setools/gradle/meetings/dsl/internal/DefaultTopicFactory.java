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
package setools.gradle.meetings.dsl.internal;

import org.gradle.api.Action;
import org.gradle.util.internal.ConfigureUtil;

import groovy.lang.Closure;
import setools.gradle.meetings.dsl.Topic;
import setools.gradle.util.Factory;

/**
 * TODO:
 */
public class DefaultTopicFactory implements Factory<Topic> {

	@Override
	public Topic build() {
		Topic result = new DefaultTopic();
		return result;
	}
	
	@SuppressWarnings("rawtypes")
	@Override
	public Topic build(Closure closure) {
	    Topic result = new DefaultTopic();
	    ConfigureUtil.configure(closure, result);
	    return result;
	}

	@Override
	public Topic build(Action<Topic> action) {
		Topic result = new DefaultTopic();
		action.execute(result);
		return result;
	}

}
