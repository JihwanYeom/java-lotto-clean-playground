import static org.assertj.core.api.Assertions.assertThat;

import domain.Lotto;
import domain.LottoNumber;
import domain.LottoRank;
import domain.Lottos;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottosTest {

    @DisplayName("모든 로또들의 순위를 잘 매기는지 테스트")
    @Test
    public void testRankLottos() {
        List<Lotto> testLottoList = new ArrayList<>();

        testLottoList.add(createLottoByString("1,2,3,4,5,6"));
        testLottoList.add(createLottoByString("2,3,4,5,6,7"));
        Lottos testLottos = Lottos.of(testLottoList);

        Lotto testWinningNumber = createLottoByString("1,2,3,4,5,6");

        assertThat(testLottos.rankLottos(testWinningNumber).getRanks())
                .containsOnly(LottoRank.from(6), LottoRank.from(5));
    }

    private Lotto createLottoByString(String string) {
        List<LottoNumber> testLottoNumbers = new ArrayList<>();
        String[] testStringNumberList = string.split(",");
        for (String stringNumber : testStringNumberList) {
            testLottoNumbers.add(LottoNumber.from(Integer.parseInt(stringNumber)));
        }
        return Lotto.of(testLottoNumbers);
    }

}
