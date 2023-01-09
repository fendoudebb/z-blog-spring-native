package z.note.lite.security.authentication.exception;

import org.springframework.security.core.AuthenticationException;

public class CaptchaMismatchException extends AuthenticationException {

    public CaptchaMismatchException(String msg) {
        super(msg);
    }

}
