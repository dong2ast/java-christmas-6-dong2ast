package christmas.Enum;

public enum Badge {
    NONE("없음", 0),
    STAR("별", 5000),
    TREE("트리", 10000),
    SANTA("산타", 20000),
    ;

    private final String title;
    private final Integer totalPrice;

    Badge(String title, Integer totalPrice) {
        this.title = title;
        this.totalPrice = totalPrice;
    }

    public String getTitle() {
        return title;
    }

    public Integer getTotalPrice() {
        return totalPrice;
    }
}
