package usm.api.doctoral_registration.exception;

public enum CodeException {

    STUDENT_NOT_FOUND(800),
    SPECIALITY_NOT_FOUND(801),
    SCIENCE_SCHOOL_NOT_FOUND(802),
    SCIENCE_DOMAIN_NOT_FOUND(803),
    SCIENCE_BRANCH_NOT_FOUND(804),

    SUPERVISOR_NOT_FOUND(805),

    UPPER_CRITERIA_NOT_FOUND(820),

    UNEXPECTED_ID_FOR_REQUEST(821);


    final Integer code;

    CodeException(int code) {
        this.code = code;
    }

    @Override
    public String toString() {
        return String.valueOf(code);
    }
}
