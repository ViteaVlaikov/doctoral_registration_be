package usm.api.doctoral_registration.model.student;

public enum Financing {

    BUDGET("Buget"),

    CONTRACT("Taxă");

    final String localTitle;

    Financing(String localTitle) {
        this.localTitle = localTitle;
    }
}
