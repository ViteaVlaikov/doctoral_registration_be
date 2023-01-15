package usm.api.doctoral_registration.model.student;

public enum Financing {

    BUDGET("Buget"),

    CONTRACT("Taxă");

    private final String localTitle;

    Financing(String localTitle) {
        this.localTitle = localTitle;
    }

    public String toDTO() {
        return localTitle;
    }
}
