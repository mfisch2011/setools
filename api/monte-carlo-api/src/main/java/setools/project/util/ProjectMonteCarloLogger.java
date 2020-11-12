/**
 * 
 */
package setools.project.util;

import java.io.PrintWriter;
import java.io.StringWriter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author matt
 *
 */
public class ProjectMonteCarloLogger {

	/**
	 * The {@link Logger} object to use for logging messages.
	 */
	private static final Logger logger = LoggerFactory.getLogger(ProjectMonteCarloLogger.class);
	
	/**
	 * Returns the Logger object used to log messages.
	 * 
	 * @return {@link Logger}
	 */
	public static Logger logger() {
		return logger;
	}
	
	/**
	 * Logs a formatted message to the information log.
	 * @param format - message format string
	 * @param objects - objects passed to formatter
	 */
	public static void info(String format,Object...objects) {
		logger.info(format,objects);
	}

	/**
	 * Logs a formatted message to the debug log.
	 * @param format - message format string
	 * @param objects - objects passed to formatter
	 */
	public static void debug(String format,Object...objects) {
		logger.debug(format,objects);
	}

	/**
	 * Logs a formatted message to the warning log.
	 * @param format - message format string
	 * @param objects - objects passed to formatter
	 */
	public static void warn(String format,Object...objects) {
		logger.warn(format,objects);
	}

	/**
	 * Logs a formatted message to the error log.
	 * @param format - message format string
	 * @param objects - objects passed to formatter
	 */
	public static void error(String format,Object...objects) {
		logger.error(format,objects);
	}

	/**
	 * Logs a formatted message to the trace log.
	 * @param format - message format string
	 * @param objects - objects passed to formatter
	 */
	public static void trace(String format,Object...objects) {
		logger.trace(format,objects);
	}

	/**
	 * Prints the stack trace of thrown to the trace log.
	 * @param thrown - the {@link Throwable} to print the stack trace for
	 */
	public static void trace(Throwable thrown) {
		StringWriter sw = new StringWriter();
		PrintWriter pw = new PrintWriter(sw);
		thrown.printStackTrace(pw);
		trace(sw.toString());
	}
	
	/**
	 * Prints an entering message to the debug log, containing the class, 
	 * method, line number, and file for the entry point.
	 */
	public static void enter() {
		debug("Entering {}",callsite(1));
	}
	
	/**
	 * Prints an exiting message to the debug log, containing the class, 
	 * method, line number, and file for the return point.
	 */
	public static void exit() {
		debug("Exiting {}",callsite(1));
	}
	
	/**
	 * Returns a string containing the class, method, line number, 
	 * and file where called.
	 * @return {@link String} - calling location
	 */
	public static String callsite() {
		return callsite(0);
	}
	
	/**
	 * Returns a string containing the class, method, line number, 
	 * and file depth levels below where called.
	 * @param depth - the number of levels below calling location
	 * @return {@link String} - location depth levels below calling location
	 */
	public static String callsite(int depth) {
		Thread currentThread = Thread.currentThread();
		if(currentThread!=null) {
			StackTraceElement[] stack = currentThread.getStackTrace();
			if(stack!=null && stack.length > (depth+2)) {
				StackTraceElement elem = stack[depth+2];
				return String.format("%s#%s(line %d in %s)",
						elem.getClassName(),elem.getMethodName(),
						elem.getLineNumber(),elem.getFileName());
			}
		}
		return null;
	}
}
