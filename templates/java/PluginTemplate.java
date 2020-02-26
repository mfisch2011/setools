/*
   Copyright [YEAR] Matt Fischer <mfish2011@gmail.com>
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
package setools.gradle.plugin;

import gradle.api.Plugin;
import gradle.api.Project;

/** TODO: add documentation...
 */
public class [CLASS_NAME] implements Plugin<Project> {

  @Override
  public void apply(Project project) {
    applyPlugins(project);
    configureExtensions(project);
    configureTasks(project);
  }
  
  /** TODO:documentation
   */
  protected void applyPlugins(Project project) {
    //TODO:apply other plugins using
    //project.getPluginManager().apply([CLASSNAME OR ID);
  }
  
  /** TODO: documentation
   */
  protected void configureExtensions(Project project) {
    //TODO:configure and apply extensions using
    //project.getExtensions().create([EXTENSION NAME],[CLASSNAME],[PARAMS...]);
  }
  
  /** TODO: documentation
   */
  protected void configureTasks(Project project) {
    //TODO:add tasks using
    //project.getTasks().create([TASK_NAME],[CLASSNAME],[PARAMS...]);
    //TODO: other task configuration such as getDependsOn().add(...)
  }
}
