package christmas.domain;

import java.time.DayOfWeek;
import java.time.LocalDate;

public class EventChecker {
    private final int EVENT_YEAR = 2023;
    private final int EVENT_MONTH = 12;
    private final int CHRISTMAS_DAY = 25;
    private final int FREEBIE_PRICE = 120000;

    private Boolean christmasEvent = false;
    private Boolean weekdayEvent = false;
    private Boolean weekendEvent = false;
    private Boolean specialEvent = false;
    private Boolean freebieEvent = false;

    private final LocalDate visitLocalDate;

    public EventChecker(int visitDate, int discountBeforePrice) {
        this.visitLocalDate = LocalDate.of(EVENT_YEAR, EVENT_MONTH, visitDate);
        checkChristmasEvent(visitDate);
        checkWeekendEvent();
        checkSpecialEvent();
        checkFreebieEvent(discountBeforePrice);
    }

    private void checkChristmasEvent(int visitDate) {
        if (visitDate <= CHRISTMAS_DAY) {
            this.christmasEvent = true;
        }
    }

    private void checkWeekendEvent() {
        DayOfWeek dayOfWeek = visitLocalDate.getDayOfWeek();
        if (dayOfWeek == DayOfWeek.FRIDAY || dayOfWeek == DayOfWeek.SATURDAY) {
            this.weekendEvent = true;
        }
        this.weekdayEvent = true;
    }

    private void checkSpecialEvent() {
        DayOfWeek dayOfWeek = visitLocalDate.getDayOfWeek();
        if (visitLocalDate.getDayOfMonth() == CHRISTMAS_DAY || dayOfWeek == DayOfWeek.SUNDAY) {
            this.specialEvent = true;
        }
    }

    private void checkFreebieEvent(int discountBeforePrice) {
        if (discountBeforePrice >= FREEBIE_PRICE) {
            this.freebieEvent = true;
        }
    }

    public Boolean getChristmasEvent() {
        return christmasEvent;
    }

    public Boolean getWeekdayEvent() {
        return weekdayEvent;
    }

    public Boolean getWeekendEvent() {
        return weekendEvent;
    }

    public Boolean getSpecialEvent() {
        return specialEvent;
    }

    public Boolean getFreebieEvent() {
        return freebieEvent;
    }
}
