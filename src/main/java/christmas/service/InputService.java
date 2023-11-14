package christmas.service;

import christmas.domain.Order;
import christmas.util.interact.InputView;
import christmas.util.interact.SplitModule;

public class InputService {
    private final InputView inputView;
    private final SplitModule splitModule;

    public InputService() {
        this.inputView = new InputView();
        this.splitModule = new SplitModule();
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
                String readOrder = inputView.readOrder();
                return splitModule.splitMenuAndCount(readOrder);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

}
