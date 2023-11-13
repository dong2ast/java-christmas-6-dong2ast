package christmas.util.interact;

import christmas.Enum.Event;
import christmas.Enum.Menu;
import christmas.domain.Order;
import java.text.DecimalFormat;

public class OutputView {

    private final DecimalFormat decimalFormat = new DecimalFormat("###,###");

    public void startMessage() {
        System.out.println("안녕하세요! 우테코 식당 12월 이벤트 플래너입니다.");
    }

    public void printOrder(Order order, int date) {
        System.out.println("12월 " + date + "일에 우테코 식당에서 받을 이벤트 혜택 미리 보기!");
        printMenu(order);
        printDiscountBeforePrice(order);
        printFreebie();
        printEvent(order);
        printEventPrice(order);
        printPaymentPrice(order);
        printBadge(order);
    }

    private void printMenu(Order order) {
        System.out.println("\n<주문 메뉴>");

        for (Menu menu : order.getOrderMenu()) {
            System.out.println(menu.getName() + " " + menu.getOrderCount() + "개");
        }
    }

    private void printDiscountBeforePrice(Order order) {
        System.out.println("\n<할인 전 총주문 금액>");

        System.out.println(decimalFormat.format(order.getDiscountBeforePrice()) + "원");
    }

    private void printFreebie() {
        System.out.println("\n<증정 메뉴>");

        if (Event.FREEBIE.getCheck()) {
            System.out.println(Menu.FREEBIE.getName() + " " + Menu.FREEBIE.getOrderCount() + "개");
            return;
        }
        System.out.println(Event.NONE.getTitle());
    }

    private void printEvent(Order order) {
        System.out.println("\n<혜택 내역>");

        if (order.getEvent().size() == 0) {
            System.out.println("없음");
            return;
        }

        for (Event e : order.getEvent()) {
            System.out.println(e.getTitle() + ": -" + decimalFormat.format(e.getRate()) + "원");
        }
    }

    private void printEventPrice(Order order) {
        System.out.println("\n<총혜택 금액>");

        if (order.getEventPrice() == 0) {
            System.out.println("0원");
            return;
        }

        System.out.println("-" + decimalFormat.format(order.getEventPrice()) + "원");
    }

    private void printPaymentPrice(Order order) {
        System.out.println("\n<할인 후 예상 결제 금액>");

        System.out.println(decimalFormat.format(order.getPaymentPrice()) + "원");
    }

    private void printBadge(Order order) {
        System.out.println("\n<12월 이벤트 배지>");

        if (order.getBadge() == null) {
            System.out.println("없음");
            return;
        }

        System.out.println(order.getBadge().getTitle());
    }
}
