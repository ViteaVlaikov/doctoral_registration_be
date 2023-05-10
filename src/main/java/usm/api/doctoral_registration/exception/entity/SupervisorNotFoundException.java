package usm.api.doctoral_registration.exception.entity;

import static usm.api.doctoral_registration.exception.CodeException.SUPERVISOR_NOT_FOUND;

public class SupervisorNotFoundException extends EntityNotFoundException {
    public SupervisorNotFoundException(Number id) {
        super("Supervisor", id, SUPERVISOR_NOT_FOUND);
    }

    @Override
    public String toString() {
        return "SupervisorNotFoundException";
    }
}
