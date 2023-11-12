package christmas.Enum;

public enum Menu {
    BUTTON_MUSHROOM_SOUP("양송이수프", 6000, 0, MenuType.APPETIZER),
    TAPAS("타파스", 5500, 0, MenuType.APPETIZER),
    CAESAR_SALAD("시저샐러드", 8000, 0, MenuType.APPETIZER),
    T_BORN_STEAK("티본스테이크", 55000, 0, MenuType.MAIN),
    RIB("바비큐립", 54000, 0, MenuType.MAIN),
    SEAFOOD_PASTA("해산물파스타", 35000, 0, MenuType.MAIN),
    CHRISTMAS_PASTA("크리스마스파스타", 25000, 0, MenuType.MAIN),
    CHOCO_CAKE("초코케이크", 15000, 0, MenuType.DESSERT),
    ICE_CREAM("아이스크림", 5000, 0, MenuType.DESSERT),
    ZERO_COKE("제로콜라", 3000, 0, MenuType.DRINK),
    RED_WINE("레드와인", 60000, 0, MenuType.DRINK),
    CHAMPAGNE("샴페인", 25000, 0, MenuType.DRINK),
    FREEBIE("샴페인", 25000, 0, MenuType.DRINK),
    ;

    private final String name;
    private final Integer price;
    private Integer orderCount;
    private final MenuType menuType;

    Menu(String name, Integer price, Integer orderCount, MenuType menuType) {
        this.name = name;
        this.price = price;
        this.orderCount = orderCount;
        this.menuType = menuType;
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

    public MenuType getMenuType() { return menuType; }

    public static Menu nameOf(String name) {
        for (Menu menu : Menu.values()) {
            if (menu.getName().equals(name)) {
                return menu;
            }
        }
        return null;
    }
}
