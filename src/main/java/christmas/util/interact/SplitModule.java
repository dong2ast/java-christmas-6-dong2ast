package christmas.util.interact;

import christmas.domain.Order;
import christmas.util.ExceptionModule;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SplitModule {

    public Order splitMenuAndCount(String readOrder) throws IllegalArgumentException {
        List<String> menuName = new ArrayList<>();
        List<Integer> count = new ArrayList<>();

        ExceptionModule.checkFormat(readOrder);
        List<String> splitOrder = Arrays.stream(readOrder.split(",")).toList();

        for (String s : splitOrder) {
            checkMenu(menuName, count, s);
        }

        ExceptionModule.checkMaxOrderCount(count);
        ExceptionModule.checkOnlyDrink(menuName);

        return new Order(menuName, count);
    }

    private void checkMenu(List<String> menuName, List<Integer> count, String s) {
        String[] split = s.split("-");
        checkMenuDubAndExist(menuName, split[0]);
        checkCount(count, split[1]);
    }

    private void checkMenuDubAndExist(List<String> menu, String text) throws IllegalArgumentException{
        ExceptionModule.checkMenuExist(text);
        ExceptionModule.checkMenuDub(menu, text);
        menu.add(text);
    }

    private void checkCount(List<Integer> count, String text) throws IllegalArgumentException{
        Integer parseCount = ExceptionModule.checkOrderParseIntException(text);
        ExceptionModule.checkOrderCount(parseCount);
        count.add(parseCount);
    }
}
