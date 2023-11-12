package christmas.domain;

import christmas.Enum.Badge;
import christmas.Enum.Event;
import christmas.Enum.Menu;
import christmas.Enum.MenuType;
import java.util.ArrayList;
import java.util.List;

public class Order {
    private final List<Menu> orderMenu = new ArrayList<>();
    private final List<Event> event = new ArrayList<>();
    private int discountBeforePrice;
    private int eventPrice;
    private int paymentPrice;
    private Badge badge;

    public List<Menu> getOrderMenu() {
        return orderMenu;
    }

    public void calculateDiscountBeforePrice() {
        for (Menu menu : orderMenu) {
            this.discountBeforePrice += (menu.getPrice() * menu.getOrderCount());
        }
    }

    public int getDiscountBeforePrice() {
        return discountBeforePrice;
    }

    public List<Event> getEvent() {
        return event;
    }

    public int getEventPrice() {
        return eventPrice;
    }

    public int getPaymentPrice() {
        return paymentPrice;
    }

    public Badge getBadge() {
        return badge;
    }
}
