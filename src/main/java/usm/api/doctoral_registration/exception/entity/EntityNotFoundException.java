package usm.api.doctoral_registration.exception.entity;

import usm.api.doctoral_registration.exception.CodeException;
import usm.api.doctoral_registration.exception.DoctoralRegistrationException;

public class EntityNotFoundException extends DoctoralRegistrationException {
    public EntityNotFoundException(String entity, Number id, CodeException code) {
        super("Entity: " + entity + " with id = " + id + " not found.", code);
    }
    public EntityNotFoundException(String entity, String fullName, CodeException code) {
        super("Entity: " + entity + " with full name = " + fullName + " not found.", code);
    }
}
