package christmas.Enum;

public enum Badge {
    NONE("없음", 0),
    STAR("별", 5000),
    TREE("트리", 10000),
    SANTA("산타", 20000),
    ;

    private final String title;
    private final Integer benefit;

    Badge(String title, Integer benefit) {
        this.title = title;
        this.benefit = benefit;
    }

    public String getTitle() {
        return title;
    }

    public Integer getBenefit() {
        return benefit;
    }
}
