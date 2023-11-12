package christmas.service;

import christmas.domain.EventChecker;
import christmas.domain.EventPlaner;
import christmas.domain.Order;
import christmas.util.interact.OutputView;

public class EventService {
    private final InputService inputService;
    private final OutputView outputView;

    public EventService() {
        this.inputService = new InputService();
        this.outputView = new OutputView();
    }

    public void run() {
        outputView.startMessage();

        int visitDate = inputService.getVisitDate();
        Order order = inputService.getOrder();
        order.calculateDiscountBeforePrice();

        EventChecker eventChecker = new EventChecker(visitDate, order.getDiscountBeforePrice());
        new EventPlaner(order, eventChecker);

        outputView.printOrder(order, visitDate);
    }
}
