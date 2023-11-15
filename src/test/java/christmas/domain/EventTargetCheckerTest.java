package christmas.domain;

import christmas.Enum.Event;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

/**
 * 크리스마스 포함 이전 날 : 크리스마스 할인
 * 일~목 : 평일 할인
 * 금-토 : 주말 할인
 * 매주 일요일 + 크리스마스 : 특별 할인
 * 할인 전 총 금액 >= 120000 : 증정 이벤트
 * 10000원 이하 : 이벤트 x
 */
public class EventTargetCheckerTest {

    @AfterEach
    void beforeEach() {
        for (Event e : Event.values()) {
            e.check(false);
        }
    }

    @DisplayName("혜택 확인 테스트")
    @ParameterizedTest(name = "{index} : 이벤트 내용 = {3}")
    @MethodSource("argumentsForCheckEvent")
    public void Check_Event(int visitDate, int discountBeforePrice, List<Boolean> expected, String text) {
        //given&when
        new EventTargetChecker(visitDate, discountBeforePrice);
        List<Boolean> checkedEvent = Arrays.stream(Event.values()).map(Event::getCheck).toList();

        //then
        Assertions.assertThat(checkedEvent).usingRecursiveComparison().isEqualTo(expected);
    }
    private static Stream<Arguments> argumentsForCheckEvent() {
        return Stream.of(
                Arguments.of(3, 9000, List.of(
                        false, false, false, false, false, false
                ), "총주문 금액 10000원 이하"),
                Arguments.of(3, 10000, List.of(
                        false, true, true, false, true, false
                ), "크리스마스, 평일, 특별 이벤트"),
                Arguments.of(25, 10000, List.of(
                        false, true, true, false, true, false
                ), "크리스마스 날 체크"),
                Arguments.of(26, 10000, List.of(
                        false, false, true, false, false, false
                ), "평일 이벤트"),
                Arguments.of(4, 10000, List.of(
                        false, true, true, false, false, false
                ), "크리스마스, 평일 이벤트"),
                Arguments.of(8, 10000, List.of(
                        false, true, false, true, false, false
                ), "크리스마스, 주말 이벤트"),
                Arguments.of(28, 120000, List.of(
                        false, false, true, false, false, true
                ), "평일, 증정품 이벤트")
        );
    }
}
