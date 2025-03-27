import static org.assertj.core.api.Assertions.assertThat;

import domain.LottoRank;
import domain.LottoRanks;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoRanksTest {

    @DisplayName("순위에 따른 총 상금 계산 테스트")
    @Test
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

    @DisplayName("순위에 따른 총 상금 계산 테스트")
    @Test
    public void testGetNumberOfRank() {
        List<LottoRank> rankList = new ArrayList<>();
        rankList.add(LottoRank.from(3));
        rankList.add(LottoRank.from(4));
        rankList.add(LottoRank.from(5));
        rankList.add(LottoRank.from(6));
        LottoRanks testLottoRanks = LottoRanks.of(rankList);

        assertThat(testLottoRanks.getNumberOfRank(LottoRank.from(3))).isEqualTo(1);
        assertThat(testLottoRanks.getNumberOfRank(LottoRank.from(4))).isEqualTo(1);
        assertThat(testLottoRanks.getNumberOfRank(LottoRank.from(5))).isEqualTo(1);
        assertThat(testLottoRanks.getNumberOfRank(LottoRank.from(6))).isEqualTo(1);
    }

}
