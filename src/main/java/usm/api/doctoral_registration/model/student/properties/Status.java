package usm.api.doctoral_registration.model.student.properties;

import java.util.Arrays;

public enum Status {

    ACTIVE,

    INACTIVE;

    public static Status toStatus(String s) {
        return Arrays.stream(Status.values())
                .filter(status -> status.toString().equals(s))
                .findFirst().orElseThrow();
    }
}
