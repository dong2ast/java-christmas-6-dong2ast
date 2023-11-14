package christmas.util;

import static christmas.domain.Constant.MAX_DATE;
import static christmas.domain.Constant.MAX_ORDER;
import static christmas.domain.Constant.MIN_DATE;
import static christmas.domain.Constant.MIN_ORDER;

import christmas.Enum.common.ErrorStatus;
import java.util.List;
import java.util.regex.Pattern;

public class ExceptionModule {

    private static final List<String> MENU_EXCEPT_DRINK = List.of(
            "양송이수프", "타파스", "시저샐러드", "티본스테이크", "바비큐립", "해산물파스타", "크리스마스파스타", "초코케이크", "아이스크림"
    );

    private static final List<String> MENU_NAME = List.of(
            "양송이수프", "타파스", "시저샐러드", "티본스테이크", "바비큐립", "해산물파스타", "크리스마스파스타", "초코케이크", "아이스크림", "제로콜라", "레드와인", "샴페인"
    );

    private static final String INPUT_FORMAT = "^([ㄱ-ㅎ|가-힣])+-\\d+([, ][ㄱ-ㅎ|가-힣]+-\\d+)*";

    public static Integer checkDayParseIntException(String consoleRead) {
        try {
            return Integer.parseInt(consoleRead);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorStatus.DAY_PARSE_INT_ERROR.getMessage());
        }
    }

    public static void checkNumBoundary(Integer num) {
        if (num < MIN_DATE || num > MAX_DATE) {
            throw new IllegalArgumentException(ErrorStatus.DATE_BOUNDARY_ERROR.getMessage());
        }
    }

    public static void checkMenuExist(String text) {
        if (!MENU_NAME.contains(text)){
            throw new IllegalArgumentException(ErrorStatus.NO_MENU_ERROR.getMessage());
        }
    }

    public static void checkMenuDub(List<String> menu, String text) {
        if (menu.contains(text)) {
            throw new IllegalArgumentException(ErrorStatus.MENU_DUP_ERROR.getMessage());
        }
    }

    public static void checkOrderCount(Integer parseCount) {
        if (parseCount < MIN_ORDER) {
            throw new IllegalArgumentException(ErrorStatus.ORDER_COUNT_ERROR.getMessage());
        }
    }

    public static void checkMaxOrderCount(List<Integer> count) {
        if (count.stream().mapToInt(i -> i).sum() > MAX_ORDER) {
            throw new IllegalArgumentException(ErrorStatus.OVER_MAX_ORDER_ERROR.getMessage());
        }
    }

    public static void checkOnlyDrink(List<String> menuName) {
        for (String s : menuName) {
            if (MENU_EXCEPT_DRINK.contains(s)) {
                return;
            }
        }
        throw new IllegalArgumentException(ErrorStatus.ONLY_DRINK_ERROR.getMessage());
    }

    public static void checkFormat(String s) {
        if (!Pattern.matches(INPUT_FORMAT, s)) {
            throw new IllegalArgumentException(ErrorStatus.ILLEGAL_FORMAT_ERROR.getMessage());
        }
    }
}
