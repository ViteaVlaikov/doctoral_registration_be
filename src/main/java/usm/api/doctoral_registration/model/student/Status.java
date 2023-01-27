package usm.api.doctoral_registration.model.student;

public enum Status {

    ACTIVE("Activ"),

    INACTIVE("Inactiv");

    final String localeName;

    Status(String localeName) {
        this.localeName = localeName;
    }
}
