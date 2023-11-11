package christmas.Enum;

public enum Main {
    T_BORN_STEAK("티본스테이크", 55000, 0),
    RIB("바베큐립", 54000, 0),
    SEAFOOD_PASTA("해산물파스타", 35000, 0),
    CHRISTMAS_PASTA("해산물파스타", 25000, 0)
    ;

    private final String name;
    private final Integer price;
    private Integer orderCount;

    Main(String name, Integer price, Integer orderCount) {
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

    public static Main nameOf(String name) {
        for (Main main : Main.values()) {
            if (main.getName().equals(name)) {
                return main;
            }
        }
        return null;
    }
}
