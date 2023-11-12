package christmas.Enum;

public enum Event {
    NONE("없음", 0, false),
    CHRISTMAS("크리스마스 디데이 할인", 100, false),
    WEEKDAY("평일 할인", 2023, false),
    WEEKEND("주말 할인", 2023, false),
    SPECIAL("특별 할인", 1000, false),
    FREEBIE("증정 이벤트", 25000, false),
    ;

    private final String title;
    private Integer rate;
    private boolean check;

    Event(String title, Integer rate, boolean check) {
        this.title = title;
        this.rate = rate;
        this.check = check;
    }

    public String getTitle() {
        return title;
    }

    public Integer getRate() {
        return rate;
    }

    public boolean getCheck() { return check; }

    public void check() {
        this.check = true;
    }

    public void changeRate(Integer rate) { this.rate = rate; }
}
