package christmas.Enum.common;

public enum ErrorStatus {
    DAY_PARSE_INT_ERROR("[ERROR] 유효하지 않은 날짜입니다. 다시 입력해 주세요."),
    ORDER_PARSE_INT_ERROR("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요."),
    DATE_BOUNDARY_ERROR("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요."),
    NO_MENU_ERROR("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요."),
    MENU_DUP_ERROR("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요."),
    ORDER_COUNT_ERROR("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요."),
    OVER_MAX_ORDER_ERROR("[ERROR] 메뉴는 한 번에 최대 20개까지만 주문할 수 있습니다."),
    ONLY_DRINK_ERROR("[ERROR] 음료만 주문 시, 주문할 수 없습니다."),
    ILLEGAL_FORMAT_ERROR("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요."),
    ;

    private final String message;

    ErrorStatus(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
