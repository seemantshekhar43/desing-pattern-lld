package chain_of_responsibility_pattern.logger;

public abstract class Logger {
    public static int INFO = 1;
    public static int DEBUG = 2;
    public static int ERROR = 3;

    protected int level;

    protected String className;
    protected Logger nextLogger;

     Logger(int level, String className){
        this.level = level;
        this.className = className;
    }

    protected void setNextLogger(Logger nextLogger){

        this.nextLogger = nextLogger;
    }

    public void logMessage(int logLevel, String message){
        if(logLevel >= this.level){
            write(message);
        }
        if(nextLogger != null){
            nextLogger.logMessage(logLevel, message);
        }
    }

    protected abstract void write(String message);

}
