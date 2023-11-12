package christmas.util;

import christmas.Enum.common.ErrorStatus;

public class ExceptionModule {

    private static final Integer MIN_ORDER = 1;
    private static final Integer MAX_ORDER = 20;
    private static final Integer MIN_DATE = 1;
    private static final Integer MAX_DATE = 31;
    public static Integer checkParseIntException(String consoleRead) throws IllegalArgumentException{
        try {
            return Integer.parseInt(consoleRead);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorStatus.PARSE_INT_ERROR.getMessage());
        }
    }

    public static void checkNumBoundary(Integer num) throws IllegalArgumentException{
        if (num < MIN_DATE || num > MAX_DATE) {
            throw new IllegalArgumentException(ErrorStatus.DATE_BOUNDARY_ERROR.getMessage());
        }
    }

    public static void checkOrderCount(Integer parseCount) {
        if (parseCount < MIN_ORDER) {
            throw new IllegalArgumentException(ErrorStatus.ORDER_COUNT_ERROR.getMessage());
        }
    }

    public static void checkMaxOrderCount(Integer totalOrderCount) {
        if (totalOrderCount > MAX_ORDER) {
            throw new IllegalArgumentException(ErrorStatus.OVER_MAX_ORDER_ERROR.getMessage());
        }
    }
}
