package christmas.domain;

import christmas.Enum.Menu;
import christmas.Enum.MenuType;
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

    @DisplayName("할인 전 총 주문금액 계산 테스트")
    @Test
    public void Discount_Before_Price() {
        //given
        int totalPrice = 0;
        for (int i = 0; i < menu.size(); i++) {
            totalPrice += count.get(i) * menu.get(i).getPrice();
        }

        //when
        int calculateDiscountBeforePrice = order.calculateDiscountBeforePrice();

        //then
        Assertions.assertThat(calculateDiscountBeforePrice).isEqualTo(totalPrice);
    }

    @DisplayName("주문 메뉴 출력 테스트")
    @Test
    public void Print_Order_Menu() {
        //given
        List<String> target = menu.stream().map(m -> m.getName() + " " + m.getOrderCount() + "개").toList();

        //when
        List<String> orderMenu = order.printOrderMenu();

        //then
        Assertions.assertThat(orderMenu).isEqualTo(target);
    }

    @DisplayName("디저트 메뉴 개수 계산 테스트")
    @Test
    public void Dessert_Count() {
        //given
        int target = menu.stream().filter(m -> m.getMenuType().equals(MenuType.DESSERT))
                .map(Menu::getOrderCount).mapToInt(Integer::intValue).sum();

        //when
        int dessertCount = order.getDessertCount();

        //then
        Assertions.assertThat(dessertCount).isEqualTo(target);
    }

    @DisplayName("메인 메뉴 개수 계산 테스트")
    @Test
    public void Main_Count() {
        //given
        int target = menu.stream().filter(m -> m.getMenuType().equals(MenuType.MAIN))
                .map(Menu::getOrderCount).mapToInt(Integer::intValue).sum();

        //when
        int mainCount = order.getMainCount();

        //then
        Assertions.assertThat(mainCount).isEqualTo(target);
    }
}
