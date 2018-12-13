package ch10;

public class ImaThrowable extends Throwable {
    public ImaThrowable() {
    }

    public ImaThrowable(String message) {
        super(message);
    }

    public ImaThrowable(String message, Throwable cause) {
        super(message, cause);
    }

    public ImaThrowable(Throwable cause) {
        super(cause);
    }

    public ImaThrowable(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
