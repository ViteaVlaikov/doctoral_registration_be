package usm.api.doctoral_registration.exception;

public enum CodeException {

    STUDENT_NOT_FOUND(2000),

    SPECIALITY_NOT_FOUND(2001),

    SCIENCE_SCHOOL_NOT_FOUND(2002),

    SCIENCE_DOMAIN_NOT_FOUND(2003),

    SCIENCE_BRANCH_NOT_FOUND(2004),

    SUPERVISOR_NOT_FOUND_EXCEPTION(2005),

    COUNTRY_NOT_FOUND_EXCEPTION(2006),

    UPPER_CRITERIA_NOT_FOUND(2500),

    UNEXPECTED_FIELD_IN_REQUEST(2501),

    UNEXPECTED_ID_FOR_REQUEST(2502);
    final Integer code;

    CodeException(int code) {
        this.code = code;
    }

    @Override
    public String toString() {
        return String.valueOf(code);
    }
}
