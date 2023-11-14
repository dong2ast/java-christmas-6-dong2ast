package christmas.service;

import static christmas.util.ExceptionModule.checkDayParseIntException;
import static christmas.util.ExceptionModule.checkNumBoundary;

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
                Integer date = checkDayParseIntException(inputView.readDate());
                checkNumBoundary(date);
                return date;
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
