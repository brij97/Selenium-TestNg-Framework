package example.example.util;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

import example.example.listeners.LogListener;

/**
 * The Class has all Logging related utilities.
 *
 * @author Brijesh
 */
public class LoggerUtil {

	/** The logger. */
	private static final Logger logger = LogManager.getLogger(LogListener.class);

	/**
	 * Log.
	 *
	 * @param message the message
	 */
	public static void log(String message) {
		logger.info(message);
	}

	/**
	 * Gets the logger.
	 *
	 * @return the logger
	 */
	public static Logger getLogger() {
		return logger;
	}
}
