package christmas.Enum;

public enum Event {
    NONE("없음", 0),
    CHRISTMAS("크리스마스 디데이 할인", 100),
    WEEKDAY("평일 할인", 2023),
    WEEKEND("주말 할인", 2023),
    SPECIAL("특별 할인", 1000),
    FREEBIE("증정 이벤트", 25000),
    ;

    private final String title;
    private final Integer rate;

    Event(String title, Integer rate) {
        this.title = title;
        this.rate = rate;
    }

    public String getTitle() {
        return title;
    }

    public Integer getRate() {
        return rate;
    }
}
