package christmas.util.interact;

import christmas.domain.Order;
import christmas.util.ExceptionModule;
import java.util.ArrayList;
import java.util.List;

public class SplitModule {

    public Order splitMenuAndCount(List<String> splitOrder) throws IllegalArgumentException {
        List<String> menuName = new ArrayList<>();
        List<Integer> count = new ArrayList<>();

        for (String s : splitOrder) {
            ExceptionModule.checkHyphen(s);
            String[] split = s.split("-");
            checkMenuDubAndExist(menuName, split[0]);
            checkCount(count, split[1]);
        }

        ExceptionModule.checkMaxOrderCount(count);
        ExceptionModule.checkOnlyDrink(menuName);

        return new Order(menuName, count);
    }

    public void checkMenuDubAndExist(List<String> menu, String text) throws IllegalArgumentException{
        ExceptionModule.checkMenuExist(text);
        ExceptionModule.checkMenuDub(menu, text);
        menu.add(text);
    }

    public void checkCount(List<Integer> count, String text) throws IllegalArgumentException{
        Integer parseCount = ExceptionModule.checkOrderParseIntException(text);
        ExceptionModule.checkOrderCount(parseCount);
        count.add(parseCount);
    }
}
