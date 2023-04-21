package usm.api.doctoral_registration.model.student.properties;

import java.util.Arrays;

public enum YearStudy {

    I(1),

    II(2),

    III(3),

    IV(4),

    EXTRA_I(5),

    EXTRA_II(6);

    public final int code;

    YearStudy(int code) {
        this.code = code;
    }

    public static YearStudy toYear(String code) {
        return toYear(Integer.parseInt(code));
    }

    public static YearStudy toYear(int code) {
        return Arrays.stream(YearStudy.values())
                .filter(year -> year.code == code)
                .findFirst().orElseThrow();
    }
}
