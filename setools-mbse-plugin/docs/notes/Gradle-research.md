# Research Notes 2019-09-22
## Keywords: 
Gradle, MBSE, Systems Engineering

# Gradle Build System
Gradle is an open-source build-automation system that builds upon the concepts of Apache Ant and Apache Maven and introduces a Groovy-based domain-specific language (DSL) instead of the XML form used by Apache Maven for declaring the project configuration.[2] Gradle uses a directed acyclic graph ("DAG") to determine the order in which tasks can be run.

Gradle was designed for multi-project builds, which can grow to be quite large. It supports incremental builds by intelligently determining which parts of the build tree are up to date; any task dependent only on those parts does not need to be re-executed.

As of 2016 the initial plugins were primarily focused on Java,[3] Groovy and Scala development and deployment, but more languages and project workflows are on the roadmap.

The Java plugin emulates many of the expected Maven lifecycles as tasks in the directed acyclic graph of dependencies for the inputs and outputs of each task. For this simple case, the build task depends upon the outputs of the check and assemble tasks. Likewise, check depends upon test, and assemble depends upon jar.

For projects that do not follow the Maven conventions, Gradle allows the directory structure to be configured. The following example would support a project that contains source files in src/java rather than the src/main/java convention enforced by Maven.

[Wikopedia page on Gradle](https://en.wikipedia.org/wiki/Gradle)

# Existing Gradle Plugin Support for MBEE and MBSE
The Gradle build system can be extended through the use of plugins.  Much of the Gradle build system is exposed to the plugin.  Plugins can modify settings and add utilities to perform build tasks.  The Gradle build process can also be customized with custom build scripts.

In addition to the ability to develop custom plugins, several plugins already exist that may be useful for performing MBSE.

[MagicDraw plugin (includes DocGen, MMS Sync, and Systems Reasoner)](https://github.com/Open-MBEE/mdk)


# Other Notes
Capella is an another option for open source MBSE.
[Capella for Eclipse](https://www.eclipse.org/community/eclipse_newsletter/2017/december/)

[OMF (Ontological Modeling Framework) Core Functional API] (https://index.scala-lang.org/jpl-imce/gov.nasa.jpl.omf.scala.core/gov.nasa.jpl.omf.scala.core/9.6.1?target=_2.11)

