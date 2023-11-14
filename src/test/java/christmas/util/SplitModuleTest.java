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

    @Override
    protected void runMain() {
        Application.main(new String[]{});
    }
}
