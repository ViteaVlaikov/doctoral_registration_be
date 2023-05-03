package usm.api.doctoral_registration.model.student.properties;

import java.util.Arrays;

public enum StudyType {

    FREQUENCY,

    LOW_FREQUENCY;

    public static StudyType toStudyType(String s) {
        return Arrays.stream(StudyType.values())
                .filter(studyType -> studyType.toString().equals(s))
                .findFirst().orElseThrow();
    }
}
