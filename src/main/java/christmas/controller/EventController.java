package christmas.controller;

import christmas.domain.EventTargetChecker;
import christmas.domain.EventPlaner;
import christmas.domain.Order;
import christmas.service.InputService;
import christmas.util.interact.OutputView;

public class EventController {
    private final InputService inputService;
    private final OutputView outputView;

    public EventController() {
        this.inputService = new InputService();
        this.outputView = new OutputView();
    }

    public void run() {
        outputView.startMessage();

        int visitDate = inputService.getVisitDate();
        Order order = inputService.getOrder();

        new EventTargetChecker(visitDate, order.calculateDiscountBeforePrice());
        new EventPlaner(order, visitDate);

        outputView.printOrder(order, visitDate);
    }
}
