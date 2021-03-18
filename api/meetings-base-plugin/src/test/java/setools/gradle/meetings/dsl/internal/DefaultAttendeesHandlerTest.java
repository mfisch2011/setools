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

import static org.junit.jupiter.api.Assertions.*;

import java.util.Collection;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import setools.gradle.meetings.dsl.Attendee;
import setools.gradle.meetings.dsl.AttendeesHandlerTest;

/**
 * TODO:documentation...
 */
class DefaultAttendeesHandlerTest extends AttendeesHandlerTest {

	@Override
	protected Attendee newObjectInstance() {
		return new DefaultAttendee();
	}

	@Override
	protected Collection<Attendee> newHandlerInstance() {
		return new DefaultAttendeesHandler();
	}

}
