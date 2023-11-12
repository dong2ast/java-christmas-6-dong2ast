package christmas.util.interact;

import camp.nextstep.edu.missionutils.Console;
import christmas.Enum.common.ErrorStatus;
import christmas.util.ExceptionModule;
import java.util.Arrays;
import java.util.List;

public class SplitModule {

    private final List<String> menuType = List.of(
            "양송이수프", "타파스", "시저샐러드", "티본스테이크", "바비큐립", "해산물파스타", "크리스마스파스타", "초코케이크", "아이스크림", "제로콜라", "레드와인", "샴페인"
    );

    public List<String> splitOrder() throws IllegalArgumentException {
        return Arrays.stream(Console.readLine().split(",")).toList();
    }

    public void checkMenuName(List<String> menu, String text) throws IllegalArgumentException{
        if (!menuType.contains(text)){
            throw new IllegalArgumentException(ErrorStatus.NO_MENU_ERROR.getMessage());
        }
        if (menu.contains(text)) {
            throw new IllegalArgumentException(ErrorStatus.MENU_DUP_ERROR.getMessage());
        }
        menu.add(text);
    }

    public int checkCount(List<Integer> count, String text) throws IllegalArgumentException{
        Integer parseCount = ExceptionModule.checkOrderParseIntException(text);
        ExceptionModule.checkOrderCount(parseCount);
        count.add(parseCount);
        return parseCount;
    }
}
