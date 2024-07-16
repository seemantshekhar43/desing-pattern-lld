package chain_of_responsibility_pattern.logger;

public class ErrorLogger extends Logger{
    ErrorLogger(int level, String className) {
        super(level, className);
    }

    @Override
    protected void write(String message) {
        System.out.println("Error log: " + "["+className+"]"  + message);

    }
}
