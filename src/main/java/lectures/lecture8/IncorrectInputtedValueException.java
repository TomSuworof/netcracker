package lectures.lecture8;

public class IncorrectInputtedValueException extends Exception {

    private static final String EXCEPTION_PREFIX = "[UNC Exception]";

    public IncorrectInputtedValueException() {
        super(EXCEPTION_PREFIX);
    }

    public IncorrectInputtedValueException(String message) {
        super(EXCEPTION_PREFIX + " " + message);
    }

    public IncorrectInputtedValueException(String message, Throwable cause) {
        super(EXCEPTION_PREFIX + " " + message, cause);
    }
}
