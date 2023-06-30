package usm.api.doctoral_registration.exception.security;

import usm.api.doctoral_registration.exception.CodeException;
import usm.api.doctoral_registration.exception.DoctoralRegistrationException;

public class TokenInvalidException extends DoctoralRegistrationException {
    public TokenInvalidException(InvalidCause cause, CodeException code) {
        super("Authentication token is invalid by cause: " + cause, code);
    }
}
