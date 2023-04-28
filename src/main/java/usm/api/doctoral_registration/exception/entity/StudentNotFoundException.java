package usm.api.doctoral_registration.exception.entity;

import static usm.api.doctoral_registration.exception.CodeException.STUDENT_NOT_FOUND;

public class StudentNotFoundException extends EntityNotFoundException {


    public StudentNotFoundException(Number id) {
        super("Student", id, STUDENT_NOT_FOUND);
    }
    @Override
    public String toString() {
        return "StudentNotFoundException";
    }
}
