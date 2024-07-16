package chain_of_responsibility_pattern.logger;

public class ConsoleLogger extends Logger{
    public ConsoleLogger(int level, String className) {
        super(level, className);
    }

    @Override
    protected void write(String message) {
        System.out.println("Console log: " + "["+className+"]"  + message);
    }
}
