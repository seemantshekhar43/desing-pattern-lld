package chain_of_responsibility_pattern.logger;

public class LoggerFactory {
    public static Logger getLogger(Class<?> clazz){
        ErrorLogger errorLogger = new ErrorLogger(Logger.ERROR, clazz.getName());
        FileLogger fileLogger = new FileLogger(Logger.DEBUG, clazz.getName());
        ConsoleLogger consoleLogger = new ConsoleLogger(Logger.INFO, clazz.getName());

        errorLogger.setNextLogger(fileLogger);
        fileLogger.setNextLogger(consoleLogger);
        consoleLogger.setNextLogger(null);

        return errorLogger;
    }
}
