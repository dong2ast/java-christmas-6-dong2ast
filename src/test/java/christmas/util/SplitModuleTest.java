package christmas.util;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;

import camp.nextstep.edu.missionutils.test.NsTest;
import christmas.Application;
import christmas.Enum.common.ErrorStatus;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class SplitModuleTest extends NsTest {

    private final String VISIT_DATE = "14";

    @DisplayName("메뉴 형식이 예시와 다른 경우")
    @ParameterizedTest
    @ValueSource(strings = {
            "해산물파스타-2,초코케이크-1-", "-해산물파스타-2,초코케이크-1", "-해산물파스타-2-", "-", "-,-", "-, ", " "
            , "해산물파스타-2,,,,", "치즈뿌린감자튀김" ,"\n", "1-해산물파스타,2-초코케이크", "1-1", "감-자", "@-@"
    })
    void checkIllegalFormat(String input) {
        assertSimpleTest(() -> {
            runException(
                    VISIT_DATE,
                    input
            );
            assertThat(output()).contains(ErrorStatus.ILLEGAL_FORMAT_ERROR.getMessage());
        });
    }

    @DisplayName("중복된 메뉴를 입력했을 경우")
    @ParameterizedTest
    @ValueSource(strings = {
            "해산물파스타-2,해산물파스타-1", "초코케이크-1,초코케이크-1"
    })
    void checkMenuDub(String input) {
        assertSimpleTest(() -> {
            runException(
                    VISIT_DATE,
                    input
            );
            assertThat(output()).contains(ErrorStatus.MENU_DUP_ERROR.getMessage());
        });
    }

    @DisplayName("메뉴판에 없는 메뉴를 입력했을 경우")
    @ParameterizedTest
    @ValueSource(strings = {
            "감자튀김-2,해산물파스타-1", "초코케이크-1,페퍼로니피자-1"
    })
    void checkMenuExist(String input) {
        assertSimpleTest(() -> {
            runException(
                    VISIT_DATE,
                    input
            );
            assertThat(output()).contains(ErrorStatus.NO_MENU_ERROR.getMessage());
        });
    }

    @DisplayName("주문 개수가 숫자 1 이상이 아닌 경우")
    @ParameterizedTest
    @ValueSource(strings = {
            "해산물파스타-0,초코케이크-1", "해산물파스타-2,초코케이크-00", "해산물파스타-@,초코케이크-1"
    })
    void checkMenuCount(String input) {
        assertSimpleTest(() -> {
            runException(
                    VISIT_DATE,
                    input
            );
            assertThat(output()).contains(ErrorStatus.ORDER_COUNT_ERROR.getMessage());
        });
    }

    @DisplayName("주문 개수의 총 합이 20을 넘어가는 경우")
    @ParameterizedTest
    @ValueSource(strings = {
            "해산물파스타-21", "해산물파스타-1,초코케이크-20", "해산물파스타-15,초코케이크-15"
    })
    void checkMaxOrderCount(String input) {
        assertSimpleTest(() -> {
            runException(
                    VISIT_DATE,
                    input
            );
            assertThat(output()).contains(ErrorStatus.OVER_MAX_ORDER_ERROR.getMessage());
        });
    }

    @Override
    protected void runMain() {
        Application.main(new String[]{});
    }
}
