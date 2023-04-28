package usm.api.doctoral_registration.exception.entity;

import static usm.api.doctoral_registration.exception.CodeException.SCIENCE_SCHOOL_NOT_FOUND;

public class ScienceSchoolNotFoundException extends EntityNotFoundException {

    public ScienceSchoolNotFoundException(Number id) {
        super("ScienceSchool", id, SCIENCE_SCHOOL_NOT_FOUND);
    }
    @Override
    public String toString() {
        return "ScienceSchoolNotFoundException";
    }
}
