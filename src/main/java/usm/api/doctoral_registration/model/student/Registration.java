package usm.api.doctoral_registration.model.student;

public enum Registration {
    ENROLLED("Inmatriculat"),

    TRANSFERRED("Transferat"),

    REINSTATED("Restabilit");

    final String localTitle;

    Registration(String localTitle) {
        this.localTitle = localTitle;
    }
}
