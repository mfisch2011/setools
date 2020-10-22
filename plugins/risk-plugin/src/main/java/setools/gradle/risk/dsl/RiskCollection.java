/**
 * TODO:license...
 */
package setools.gradle.risk.dsl;

import java.util.Collection;

import setools.risk.Risk;
import setools.util.Filterable;

/**
 * TODO:documentation...
 */
public interface RiskCollection<T extends Risk> extends Filterable<T>,Collection<Risk> {

}
