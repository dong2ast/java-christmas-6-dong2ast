package christmas.util;

import camp.nextstep.edu.missionutils.Console;
import christmas.Enum.common.ErrorStatus;

public class InputView {
    public int readDate() throws IllegalArgumentException{
        System.out.println("12월 중 식당 예상 방문 날짜는 언제인가요? (숫자만 입력해 주세요!)");
        Integer date = checkParseIntException(Console.readLine());
        checkNumBoundary(date);
        return date;
    }

    private Integer checkParseIntException(String consoleRead) throws IllegalArgumentException{
        try {
            return Integer.parseInt(consoleRead);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorStatus.PARSE_INT_ERROR.getMessage());
        }
    }

    private void checkNumBoundary(Integer num) throws IllegalArgumentException{
        if (num < 1 || num > 31) {
            throw new IllegalArgumentException(ErrorStatus.DATE_BOUNDARY_ERROR.getMessage());
        }
    }
}
