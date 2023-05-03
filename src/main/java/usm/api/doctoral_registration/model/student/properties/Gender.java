package usm.api.doctoral_registration.model.student.properties;

import java.util.Arrays;

public enum Gender {

    M,

    F;


    public static Gender toGender(String s) {
        return Arrays.stream(Gender.values())
                .filter(gender -> gender.toString().equals(s))
                .findFirst().orElseThrow();
    }
}