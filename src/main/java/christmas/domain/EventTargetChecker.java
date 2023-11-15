package christmas.domain;

import static christmas.domain.Constant.CHRISTMAS_DAY;
import static christmas.domain.Constant.EVENT_MONTH;
import static christmas.domain.Constant.EVENT_YEAR;
import static christmas.domain.Constant.FREEBIE_PRICE;
import static christmas.domain.Constant.MIN_EVENT_ORDER_PRICE;

import christmas.Enum.Event;
import christmas.Enum.Menu;
import java.time.DayOfWeek;
import java.time.LocalDate;

public class EventTargetChecker {
    private final LocalDate visitLocalDate;

    public EventTargetChecker(int visitDate, int discountBeforePrice) {
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
            Event.CHRISTMAS.check(true);
        }
    }

    private void checkWeekdayAndWeekendEvent() {
        DayOfWeek dayOfWeek = visitLocalDate.getDayOfWeek();

        if (dayOfWeek == DayOfWeek.FRIDAY || dayOfWeek == DayOfWeek.SATURDAY) {
            Event.WEEKEND.check(true);
        }
        Event.WEEKDAY.check(true);
    }

    private void checkSpecialEvent() {
        DayOfWeek dayOfWeek = visitLocalDate.getDayOfWeek();

        if (visitLocalDate.getDayOfMonth() == CHRISTMAS_DAY || dayOfWeek == DayOfWeek.SUNDAY) {
            Event.SPECIAL.check(true);
        }
    }

    private void checkFreebieEvent(int discountBeforePrice) {
        if (discountBeforePrice >= FREEBIE_PRICE) {
            Event.FREEBIE.check(true);
            Menu.FREEBIE.order(1);
        }
    }
}
