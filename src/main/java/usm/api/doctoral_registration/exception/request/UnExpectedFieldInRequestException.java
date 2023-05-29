package usm.api.doctoral_registration.exception.request;

import usm.api.doctoral_registration.exception.DoctoralRegistrationException;

import static usm.api.doctoral_registration.exception.CodeException.UNEXPECTED_FIELD_IN_REQUEST;

public class UnExpectedFieldInRequestException extends DoctoralRegistrationException {
    public UnExpectedFieldInRequestException(String message) {
        super("Field " + message + " is unexpected for this request", UNEXPECTED_FIELD_IN_REQUEST);
    }
}
