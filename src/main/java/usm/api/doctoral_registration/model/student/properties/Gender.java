package usm.api.doctoral_registration.model.student.properties;

public enum Gender {

    MASCULINE("M"),

    FEMININE("F");

    private final String code;

    Gender(String code) {
        this.code = code;
    }

//    @Override
//    public String toString() {
//        return code;
//    }
}