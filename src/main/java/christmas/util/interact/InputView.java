package christmas.util.interact;

import static christmas.util.ExceptionModule.*;

import camp.nextstep.edu.missionutils.Console;
import christmas.Enum.Menu;
import christmas.domain.Order;
import christmas.util.ExceptionModule;
import java.util.ArrayList;
import java.util.List;

public class InputView {

    private final SplitModule splitModule;

    public InputView() {
        this.splitModule = new SplitModule();
    }

    public int readDate() throws IllegalArgumentException{
        System.out.println("12월 중 식당 예상 방문 날짜는 언제인가요? (숫자만 입력해 주세요!)");
        Integer date = checkParseIntException(Console.readLine());
        checkNumBoundary(date);
        return date;
    }

    public Order readOrder() throws IllegalArgumentException{
        System.out.println("주문하실 메뉴를 메뉴와 개수를 알려 주세요. (e.g. 해산물파스타-2,레드와인-1,초코케이크-1)");

        List<String> splitOrder = splitModule.splitOrder();

        return splitMenuAndCount(splitOrder);
    }

    private Order splitMenuAndCount(List<String> splitOrder) throws IllegalArgumentException {
        List<String> menuName = new ArrayList<>();
        List<Integer> count = new ArrayList<>();
        int total = 0;
        for (String s : splitOrder) {
            ExceptionModule.checkHyphen(s);
            String[] split = s.split("-");
            splitModule.checkMenuName(menuName, split[0]);
            total += splitModule.checkCount(count, split[1]);
        }

        ExceptionModule.checkMaxOrderCount(total);
        ExceptionModule.checkOnlyDrink(menuName);

        return makeOrder(menuName, count);
    }

    private Order makeOrder(List<String> menuName, List<Integer> count) {
        Order order = new Order();

        for (int i = 0; i < menuName.size(); i++) {
            Menu menu = Menu.nameOf(menuName.get(i));
            menu.order(count.get(i));
            order.getOrderMenu().add(menu);
        }

        return order;
    }
}
