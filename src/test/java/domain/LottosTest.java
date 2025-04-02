package domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottosTest {

    @Test
    @DisplayName("5000원으로 로또를 사면 5장을 살 수 있다")
    void testBuyLottosCount() {
        Money price = Money.from(5000);
        List<List<Integer>> manuelNumbers = List.of(
                List.of(1, 2, 3, 4, 5, 6)
        );
        Lottos lottos = Lottos.buy(price, manuelNumbers);
        int expected = 5;

        int actual = lottos.getCount();

        assertThat(actual).isEqualTo(expected);
    }

    @Test
    @DisplayName("구매 금액이 로또 가격으로 나누어 떨어지지 않을 경우 예외가 발생해야 한다")
    void testPriceNotDividableException() {
        Money invalidPrice = Money.from(2500);

        assertThatThrownBy(() -> Lottos.buy(invalidPrice, List.of()))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("구입 금액은 로또 가격(1000)의 배수여야 합니다.");
    }

    @Test
    @DisplayName("수동으로 로또를 구매 금액보다 많이 구매한 경우 예외가 발생해야 한다")
    void testManuelPriceBiggerThanTotalPriceException() {
        Money price = Money.from(2000);
        List<List<Integer>> manuelNumbers = List.of(
                List.of(1, 2, 3, 4, 5, 6),
                List.of(1, 2, 3, 4, 5, 6),
                List.of(1, 2, 3, 4, 5, 6)
        );

        assertThatThrownBy(() -> Lottos.buy(price, manuelNumbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("수동으로 구매할 로또 구입 금액이 총 구입 금액보다 큽니다.");
    }

}
