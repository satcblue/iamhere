package exceptions;

public class UserTokenExpire extends UserException {

    public UserTokenExpire(String msg, Throwable cause) {
        super(msg, cause);
    }
}
