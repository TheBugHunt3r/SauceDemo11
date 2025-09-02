package tests;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LogTest {
        protected static final Logger logger = LoggerFactory.getLogger(BaseTest.class);

        protected void logInfo(String message) {
            logger.info(" {}", message);
        }

        protected void logDebug(String message) {
            logger.debug(" {}", message);
        }

        protected void logWarning(String message) {
            logger.warn(" {}", message);
        }

        protected void logError(String message) {
            logger.error(" {}", message);
        }

        protected void logSuccess(String message) {
            logger.info(" {}", message);
        }

        protected void logStep(String stepName) {
            logger.info(" STEP: {}", stepName);
        }
}
