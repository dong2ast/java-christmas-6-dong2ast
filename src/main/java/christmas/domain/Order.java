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
    private Badge badge = Badge.NONE;

    public List<Menu> getOrderMenu() {
        return orderMenu;
    }

    public void calculateDiscountBeforePrice() {
        for (Menu menu : orderMenu) {
            this.discountBeforePrice += (menu.getPrice() * menu.getOrderCount());
        }
        this.paymentPrice = discountBeforePrice;
    }

    public void addEventStatus(Event event, int price) {
        if (price == 0) {
            return;
        }
        this.event.add(event);
        this.eventPrice += price;
        if (event.equals(Event.FREEBIE)) {
            return;
        }
        this.paymentPrice -= price;
        event.changeRate(price);
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

    public void changeBadge(Badge badge) {
        if (badge.getBenefit() < this.eventPrice) {
            this.badge = badge;
        }
    }

    public int getDessertCount() {
        return orderMenu.stream().filter(m -> m.getMenuType().equals(MenuType.DESSERT))
                .map(Menu::getOrderCount).mapToInt(Integer::intValue).sum();
    }

    public int getMainCount() {
        return orderMenu.stream().filter(m -> m.getMenuType().equals(MenuType.MAIN))
                .map(Menu::getOrderCount).mapToInt(Integer::intValue).sum();
    }
}
