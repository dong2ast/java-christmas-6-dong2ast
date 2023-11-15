package christmas.domain;

import christmas.Enum.Event;
import java.text.DecimalFormat;
import java.util.List;
import java.util.stream.Stream;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class EventPlanerTest {

    List<String> menuName = List.of("크리스마스파스타", "초코케이크", "아이스크림", "레드와인");
    List<Integer> count = List.of(2, 1, 1, 1);
    Order order;
    DecimalFormat decimalFormat = new DecimalFormat();


    @BeforeEach
    void beforeEach() {
        this.order = new Order(menuName, count);
    }

    @DisplayName("이벤트 추가 테스트")
    @ParameterizedTest(name = "{index} : 추가 이벤트 = {0}, 혜택 = {1}")
    @MethodSource("argumentsForAddEvent")
    public void Add_Event(Event event, int price) {
        //given
        String target = event.getTitle() + ": -" + decimalFormat.format(price) + "원";
        order.addEventStatus(event, price);

        //when
        String printEvent = order.printEvent().get(0);

        //then
        Assertions.assertThat(printEvent).isEqualTo(target);
    }
    private static Stream<Arguments> argumentsForAddEvent() {
        return Stream.of(
                Arguments.of(Event.CHRISTMAS, Constant.CHRISTMAS_EVENT_BASE_PRICE + 13 * Event.CHRISTMAS.getRate()),
                Arguments.of(Event.WEEKEND, 2 * Event.WEEKEND.getRate()),
                Arguments.of(Event.WEEKDAY, Event.WEEKDAY.getRate()),
                Arguments.of(Event.WEEKDAY, Event.WEEKDAY.getRate()),
                Arguments.of(Event.SPECIAL, Event.SPECIAL.getRate()),
                Arguments.of(Event.FREEBIE, Event.FREEBIE.getRate())
        );
    }

}
