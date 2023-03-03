package framework.logger;

import static java.lang.String.*;

public class Logger {

    private static final org.apache.log4j.Logger logger = org.apache.log4j.Logger.getLogger(Logger.class);

    private Logger() {
    }

    public static void infoAction(String message) {
        logger.info(message);
    }

    public static void infoElementAction(String element, String action) {
        String message = format("%s %s", action, element);
        logger.info(message);
    }
}
