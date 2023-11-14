package christmas.util.interact;

import christmas.Enum.Event;
import christmas.Enum.Menu;
import christmas.domain.Order;

public class OutputView {
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

        for (String m : order.printOrderMenu()) {
            System.out.println(m);
        }
    }

    private void printDiscountBeforePrice(Order order) {
        System.out.println("\n<할인 전 총주문 금액>");
        System.out.println(order.printDiscountBeforePrice());
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

        for (String e : order.printEvent()) {
            System.out.println(e);
        }
    }

    private void printEventPrice(Order order) {
        System.out.println("\n<총혜택 금액>");
        System.out.println(order.printEventPrice());
    }

    private void printPaymentPrice(Order order) {
        System.out.println("\n<할인 후 예상 결제 금액>");
        System.out.println(order.printPaymentPrice());
    }

    private void printBadge(Order order) {
        System.out.println("\n<12월 이벤트 배지>");
        System.out.println(order.printBadge());
    }
}
