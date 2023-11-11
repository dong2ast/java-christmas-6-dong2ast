package christmas.Enum;

public enum Drink {
    ZERO_COKE("제로콜라", 3000, 0),
    RED_WINE("레드와인", 60000, 0),
    CHAMPAGNE("샴페인", 25000, 0)
    ;

    private final String name;
    private final Integer price;
    private Integer orderCount;

    Drink(String name, Integer price, Integer orderCount) {
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

    public static Drink nameOf(String name) {
        for (Drink drink : Drink.values()) {
            if (drink.getName().equals(name)) {
                return drink;
            }
        }
        return null;
    }
}
