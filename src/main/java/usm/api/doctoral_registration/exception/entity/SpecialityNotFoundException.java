package usm.api.doctoral_registration.exception.entity;

import static usm.api.doctoral_registration.exception.CodeException.SPECIALITY_NOT_FOUND;

public class SpecialityNotFoundException extends EntityNotFoundException {
    public SpecialityNotFoundException(Number id) {
        super("Speciality", id, SPECIALITY_NOT_FOUND);
    }

    @Override
    public String toString() {
        return "SpecialityNotFoundException";
    }
}
