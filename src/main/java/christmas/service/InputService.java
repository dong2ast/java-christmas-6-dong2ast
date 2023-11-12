package christmas.service;

import christmas.domain.Order;
import christmas.util.interact.InputView;

public class InputService {
    private final InputView inputView;

    public InputService() {
        this.inputView = new InputView();
    }

    public int getVisitDate() {
        while (true) {
            try {
                return inputView.readDate();
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public Order getOrder() {
        while (true) {
            try {
                return inputView.readOrder();
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

}
