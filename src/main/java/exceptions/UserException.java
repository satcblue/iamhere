package exceptions;

public class UserException extends RuntimeException {


    public UserException(String msg, Throwable cause) {
        super(msg, cause, false, false);
    }
}
