package chain_of_responsibility_pattern;

import chain_of_responsibility_pattern.logger.Logger;
import chain_of_responsibility_pattern.logger.LoggerFactory;

public class Main {
    public static void main(String[] args) {
        Logger LOGGER = LoggerFactory.getLogger(Main.class);

        LOGGER.logMessage(Logger.INFO, "This is an info level log!");
        System.out.println("----------------------------------------------");
        LOGGER.logMessage(Logger.DEBUG, "This is an debug level log!");
        System.out.println("----------------------------------------------");
        LOGGER.logMessage(Logger.ERROR, "This is an error level log!");
    }
}
