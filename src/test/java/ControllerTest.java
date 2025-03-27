import static org.assertj.core.api.Assertions.assertThat;

import controller.LottoController;
import domain.Lottos;
import domain.Price;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ControllerTest {

    @DisplayName("로또 구매 테스트")
    @Test
    public void testBuyLottos() {
        LottoController testController = new LottoController();
        Price testPrice = Price.from(3000);
        Lottos testLottos = testController.buyLottos(testPrice);

        assertThat(testLottos.getLottos().size()).isEqualTo(3);
    }

}
