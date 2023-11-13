package christmas.domain;

import christmas.Enum.Badge;
import christmas.Enum.Event;

public class EventPlaner {

    private final int CHRISTMAS_EVENT_BASE_PRICE = 1000;

    public EventPlaner(Order order, EventTargetChecker eventTargetChecker) {
        calculateChristmasEvent(order, eventTargetChecker);
        calculateWeekdayAndWeekendEvent(order);
        calculateSpecialEvent(order);
        calculateFreebieEvent(order);
        calculateBadge(order);
    }

    private void calculateChristmasEvent(Order order, EventTargetChecker eventTargetChecker) {
        if (!Event.CHRISTMAS.getCheck()) {
            return;
        }
        order.addEventStatus(Event.CHRISTMAS,
                CHRISTMAS_EVENT_BASE_PRICE + eventTargetChecker.getDay() * Event.CHRISTMAS.getRate());
    }

    private void calculateWeekdayAndWeekendEvent(Order order) {
        if (Event.WEEKEND.getCheck()) {
            order.addEventStatus(Event.WEEKEND, order.getMainCount() * Event.WEEKEND.getRate());
            return;
        }
        order.addEventStatus(Event.WEEKDAY, order.getDessertCount() * Event.WEEKDAY.getRate());
    }

    private void calculateSpecialEvent(Order order) {
        if (Event.SPECIAL.getCheck()) {
            order.addEventStatus(Event.SPECIAL, Event.SPECIAL.getRate());
        }
    }

    private void calculateFreebieEvent(Order order) {
        if (Event.FREEBIE.getCheck()) {
            order.addEventStatus(Event.FREEBIE, Event.FREEBIE.getRate());
        }
    }

    private void calculateBadge(Order order) {
        order.changeBadge(Badge.STAR);
        order.changeBadge(Badge.TREE);
        order.changeBadge(Badge.SANTA);
    }
}
