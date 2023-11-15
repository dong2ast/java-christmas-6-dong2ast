package christmas.domain;

import christmas.Enum.Menu;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


public class OrderTest {
    List<String> menuName = List.of("크리스마스파스타", "초코케이크", "아이스크림", "레드와인");
    List<Integer> count = List.of(2, 1, 1, 1);
    List<Menu> menu = List.of(Menu.CHRISTMAS_PASTA, Menu.CHOCO_CAKE, Menu.ICE_CREAM, Menu.RED_WINE);
    Order order;


    @BeforeEach
    void beforeEach() {
        this.order = new Order(menuName, count);
    }

    @DisplayName("Order 생성 테스트")
    @Test
    public void Create_Order() {
        // given&when
        List<Integer> orderCount = menu.stream().map(Menu::getOrderCount).toList();

        //then
        Assertions.assertThat(orderCount).usingRecursiveComparison().isEqualTo(count);
    }

}
