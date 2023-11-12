package christmas.domain;

import christmas.Enum.Menu;
import java.util.ArrayList;
import java.util.List;

public class Order {
    private final List<Menu> menu = new ArrayList<>();

    public List<Menu> getOrderMenu() {
        return orderMenu;
    }
}
