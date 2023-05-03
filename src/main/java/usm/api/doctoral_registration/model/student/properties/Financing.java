package usm.api.doctoral_registration.model.student.properties;

import java.util.Arrays;

public enum Financing {

    BUDGET,

    CONTRACT;

    public static Financing toFinancing(String s) {
        return Arrays.stream(Financing.values())
                .filter(financing -> financing.toString().equals(s))
                .findFirst().orElseThrow();
    }
}
