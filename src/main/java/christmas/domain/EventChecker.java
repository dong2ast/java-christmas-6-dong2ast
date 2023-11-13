package christmas.domain;

import christmas.Enum.Event;
import christmas.Enum.Menu;
import java.time.DayOfWeek;
import java.time.LocalDate;

public class EventChecker {
    private final int EVENT_YEAR = 2023;
    private final int EVENT_MONTH = 12;
    private final int CHRISTMAS_DAY = 25;
    private final int FREEBIE_PRICE = 120000;
    private final int MIN_EVENT_ORDER_PRICE = 10000;

    private final LocalDate visitLocalDate;

    public EventChecker(int visitDate, int discountBeforePrice) {
        this.visitLocalDate = LocalDate.of(EVENT_YEAR, EVENT_MONTH, visitDate);
        if (checkMinEventOrderPrice(discountBeforePrice)){
            checkChristmasEvent(visitDate);
            checkWeekdayAndWeekendEvent();
            checkSpecialEvent();
            checkFreebieEvent(discountBeforePrice);
        }
    }

    private boolean checkMinEventOrderPrice(int discountBeforePrice) {
        return discountBeforePrice >= MIN_EVENT_ORDER_PRICE;
    }

    private void checkChristmasEvent(int visitDate) {
        if (visitDate <= CHRISTMAS_DAY) {
            Event.CHRISTMAS.check();
        }
    }

    private void checkWeekdayAndWeekendEvent() {
        DayOfWeek dayOfWeek = visitLocalDate.getDayOfWeek();

        if (dayOfWeek == DayOfWeek.FRIDAY || dayOfWeek == DayOfWeek.SATURDAY) {
            Event.WEEKEND.check();
        }
        Event.WEEKDAY.check();
    }

    private void checkSpecialEvent() {
        DayOfWeek dayOfWeek = visitLocalDate.getDayOfWeek();

        if (visitLocalDate.getDayOfMonth() == CHRISTMAS_DAY || dayOfWeek == DayOfWeek.SUNDAY) {
            Event.SPECIAL.check();
        }
    }

    private void checkFreebieEvent(int discountBeforePrice) {
        if (discountBeforePrice >= FREEBIE_PRICE) {
            Event.FREEBIE.check();
            Menu.FREEBIE.order(1);
        }
    }

    public int getDay() {
        return this.visitLocalDate.getDayOfMonth()-1;
    }
}
