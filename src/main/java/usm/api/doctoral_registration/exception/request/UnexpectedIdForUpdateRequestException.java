package usm.api.doctoral_registration.exception.request;

import usm.api.doctoral_registration.exception.DoctoralRegistrationException;

import static usm.api.doctoral_registration.exception.CodeException.UNEXPECTED_ID_FOR_REQUEST;

public class UnexpectedIdForUpdateRequestException extends DoctoralRegistrationException {
    public UnexpectedIdForUpdateRequestException(Number id) {
        super("Id = " + id + " is unexpected in request body", UNEXPECTED_ID_FOR_REQUEST);
    }

    @Override
    public String toString() {
        return "UnexpectedIdForUpdateRequestException{}";
    }
}
