package domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoRanksTest {

    @Test
    @DisplayName("맞은 개수에 해당하는 상금을 전부 더하여 총 상금을 구해야 한다")
    public void testGetTotalPrize() {
        List<LottoRank> rankList = new ArrayList<>();
        rankList.add(LottoRank.from(3));
        rankList.add(LottoRank.from(4));
        rankList.add(LottoRank.from(5));
        rankList.add(LottoRank.from(6));
        LottoRanks testLottoRanks = LottoRanks.of(rankList);

        assertThat(testLottoRanks.getTotalPrize().getPrice())
                .isEqualTo(5000 + 50000 + 150000 + 2000000000);
    }

    @Test
    @DisplayName("맞은 숫자 개수에 해당하는 로또의 개수를 세어 반환해야 한다")
    public void testGetNumberOfRank() {
        List<LottoRank> rankList = new ArrayList<>();
        rankList.add(LottoRank.from(3));
        rankList.add(LottoRank.from(3));
        rankList.add(LottoRank.from(5));
        rankList.add(LottoRank.from(6));

        LottoRanks testLottoRanks = LottoRanks.of(rankList);

        assertSoftly(soft -> {
            soft.assertThat(testLottoRanks.getNumberOfRank(LottoRank.from(3))).isEqualTo(2);
            soft.assertThat(testLottoRanks.getNumberOfRank(LottoRank.from(5))).isEqualTo(1);
            soft.assertThat(testLottoRanks.getNumberOfRank(LottoRank.from(6))).isEqualTo(1);
        });
    }

}
