package christmas;

import christmas.service.EventService;

public class Application {
    public static void main(String[] args) {
        EventService eventService = new EventService();
        eventService.run();
    }
}
