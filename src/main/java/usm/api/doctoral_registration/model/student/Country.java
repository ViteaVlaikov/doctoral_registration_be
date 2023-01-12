package usm.api.doctoral_registration.model.student;

public enum Country {

    REPUBLIC_OF_MOLDOVA("Republica Moldova"),

    ROMANIA("România"),

    GEORGIA("Grecia"),

    GREECE("Grecia"),

    RUSSIAN_FEDERATION("Federația Rusă"),

    ISRAEL("Israel"),

    UKRAINE("Ucraina"),

    POLAND("Polonia");

    final String localTitle;
    Country(String local) {
        this.localTitle = local;
    }
}
