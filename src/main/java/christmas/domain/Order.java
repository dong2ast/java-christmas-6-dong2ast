package christmas.domain;

import christmas.Enum.Badge;
import christmas.Enum.Event;
import christmas.Enum.Menu;
import christmas.Enum.MenuType;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Order {
    private final DecimalFormat decimalFormat = new DecimalFormat("###,###");
    private final List<Menu> orderMenu = new ArrayList<>();
    private final List<Event> event = new ArrayList<>();
    private int discountBeforePrice;
    private int eventPrice;
    private int paymentPrice;
    private Badge badge = Badge.NONE;

    public Order(List<String> menuName, List<Integer> count) {
        for (int i = 0; i < menuName.size(); i++) {
            Menu menu = Menu.nameOf(menuName.get(i));
            menu.order(count.get(i));
            this.orderMenu.add(menu);
        }
    }

    public int calculateDiscountBeforePrice() {
        for (Menu menu : orderMenu) {
            this.discountBeforePrice += (menu.getPrice() * menu.getOrderCount());
        }
        this.paymentPrice = discountBeforePrice;
        return discountBeforePrice;
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

    public List<String> printOrderMenu() {
        return orderMenu.stream().map(m -> m.getName() + " " + m.getOrderCount() + "개").toList();
    }

    public String printDiscountBeforePrice() {
        return decimalFormat.format(discountBeforePrice) + "원";
    }

    public List<String> printEvent() {
        if (event.size() == 0) {
            return List.of("없음");
        }
        return event.stream().map(e -> e.getTitle() + ": -" + decimalFormat.format(e.getRate()) + "원")
                .collect(Collectors.toList());
    }

    public String printEventPrice() {
        if (eventPrice == 0) {
            return "0원";
        }
        return "-" + decimalFormat.format(eventPrice) + "원";
    }

    public String printPaymentPrice() {
        return decimalFormat.format(paymentPrice) + "원";
    }

    public String printBadge() {
        if (badge == null) {
            return "없음";
        }
        return badge.getTitle();
    }

    public void changeBadge(Badge badge) {
        if (badge.getBenefit() <= this.eventPrice) {
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
