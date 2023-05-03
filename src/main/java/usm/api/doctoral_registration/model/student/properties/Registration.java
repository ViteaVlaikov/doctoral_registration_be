package usm.api.doctoral_registration.model.student.properties;

import java.util.Arrays;

public enum Registration {
    ENROLLED,

    TRANSFERRED,

    REINSTATED;

    public static Registration toRegistration(String s) {
        return Arrays.stream(Registration.values())
                .filter(registration -> registration.toString().equals(s))
                .findFirst().orElseThrow();
    }
}
