package chain_of_responsibility_pattern.logger;

public class FileLogger extends Logger{

    public FileLogger(int level, String className) {
        super(level, className);
    }

    @Override
    protected void write(String message) {
        System.out.println("File log: " + "["+className+"]"  + message);
    }
}
