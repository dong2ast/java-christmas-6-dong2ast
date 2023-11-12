package christmas.service;

import christmas.util.InputView;

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
}
