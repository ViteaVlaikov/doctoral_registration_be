package usm.api.doctoral_registration.model.student;

public enum Study {

    FREQUENCY("Frecvență"),

    LOW_FREQUENCY("Frecvență redusă");

    final String localTitle;

    Study(String localTitle) {
        this.localTitle = localTitle;
    }
}
