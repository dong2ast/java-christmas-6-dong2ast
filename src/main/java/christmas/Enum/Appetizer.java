package christmas.Enum;

public enum Appetizer {
    BUTTON_MUSHROOM_SOUP("양송이수프", 6000, 0),
    TAPAS("바베큐립", 5500, 0),
    CAESAR_SALAD("시저샐러드", 8000, 0),
    ;

    private final String name;
    private final Integer price;
    private Integer orderCount;

    Appetizer(String name, Integer price, Integer orderCount) {
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

    public static Appetizer nameOf(String name) {
        for (Appetizer appetizer : Appetizer.values()) {
            if (appetizer.getName().equals(name)) {
                return appetizer;
            }
        }
        return null;
    }
}
