package usm.api.doctoral_registration.model.student;

public enum Gender {

    MASCULINE("Masculin"),

    FEMININE("Feminin");

    final String localTitle;

    Gender(String localTitle) {
        this.localTitle = localTitle;
    }
}