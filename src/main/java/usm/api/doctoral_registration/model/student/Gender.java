package usm.api.doctoral_registration.model.student;

public enum Gender {

    MASCULINE("M", "Masculin"),

    FEMININE("F", "Feminin");

    private final String localTitle;

    private final String code;

    Gender(String code, String localTitle) {
        this.code = code;
        this.localTitle = localTitle;
    }

    @Override
    public String toString() {
        return code;
    }

    public String toDTO() {
        return localTitle;
    }
}