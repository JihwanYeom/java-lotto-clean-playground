package domain;

import static org.assertj.core.api.Assertions.assertThat;

import controller.LottoController;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottosTest {

    @Test
    @DisplayName("3000원으로 로또를 구매하면 로또를 3개 구매할 수 있어야 한다")
    public void testBuyLottos() {
        LottoController testController = new LottoController();
        int expected = 3;

        Money testMoney = Money.from(3000);
        Lottos testLottos = Lottos.buy(testMoney, new LottoNumberGenerator());
        int actual = testLottos.getLottos().size();

        assertThat(actual).isEqualTo(expected);
    }

    @Test
    @DisplayName("당첨 번호와 비교했을 때 당첨 번호와 일치하는 로또 번호의 갯수를 구하여 저장해야 한다")
    public void testRankLottos() {
        List<Lotto> testLottoList = new ArrayList<>();

        testLottoList.add(Lotto.of(createNumbersByString("1,2,3,4,5,6")));
        testLottoList.add(Lotto.of(createNumbersByString("2,3,4,5,6,7")));
        Lottos testLottos = Lottos.of(testLottoList);

        Lotto testWinningNumber = Lotto.of(createNumbersByString("1,2,3,4,5,6"));

        assertThat(LottoRankEvaluator.evaluate(testLottos, testWinningNumber))
                .containsOnly(LottoRank.FIRST_PRIZE, LottoRank.SECOND_PRIZE);
    }

    private List<Integer> createNumbersByString(String string) {
        List<Integer> testLottoNumbers = new ArrayList<>();
        String[] testStringNumberList = string.split(",");
        for (String stringNumber : testStringNumberList) {
            testLottoNumbers.add(Integer.parseInt(stringNumber));
        }
        return testLottoNumbers;
    }

}
