package usm.api.doctoral_registration.exception.entity;

import usm.api.doctoral_registration.exception.DoctoralRegistrationException;

import static usm.api.doctoral_registration.exception.CodeException.SUPERVISOR_NOT_FOUND_EXCEPTION;

public class SupervisorNotFoundException extends EntityNotFoundException {
    public SupervisorNotFoundException(Number id) {
        super("Supervisor", id, SUPERVISOR_NOT_FOUND_EXCEPTION);
    }

    @Override
    public String toString() {
        return "SupervisorNotFoundException";
    }
}
