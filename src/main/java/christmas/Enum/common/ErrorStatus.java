package christmas.Enum.common;

public enum ErrorStatus {
    PARSE_INT_ERROR("[ERROR] 양의 정수를 입력해야 합니다."),
    DATE_BOUNDARY_ERROR("[ERROR] 날짜는 1부터 31 사이의 숫자여야 합니다."),
    ;

    private final String message;

    ErrorStatus(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
