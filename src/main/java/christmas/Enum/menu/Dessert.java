package christmas.Enum.menu;

public enum Dessert {
    CHOCO_CAKE("초코케이크", 15000, 0),
    ICE_CREAM("아이스크림", 5000, 0),
    ;

    private final String name;
    private final Integer price;
    private Integer orderCount;

    Dessert(String name, Integer price, Integer orderCount) {
        this.name = name;
        this.price = price;
        this.orderCount = orderCount;
    }

    public void order(Integer orderCount) {
        this.orderCount = orderCount;
    }

    public String getName() {
        return name;
    }

    public Integer getPrice() {
        return price;
    }

    public Integer getOrderCount() {
        return orderCount;
    }

    public static Dessert nameOf(String name) {
        for (Dessert dessert : Dessert.values()) {
            if (dessert.getName().equals(name)) {
                return dessert;
            }
        }
        return null;
    }
}
