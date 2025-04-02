package domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoRankTest {

    @Test
    @DisplayName("일치한 당첨 번호 개수와 보너스 번호 일치 여부에 따라 알맞게 순위를 매겨야 한다.")
    void testLottoRankMatch() {
        assertThat(LottoRank.matchRank(6, false)).isEqualTo(LottoRank.FIRST_PRIZE);
        assertThat(LottoRank.matchRank(5, true)).isEqualTo(LottoRank.SECOND_PRIZE);
        assertThat(LottoRank.matchRank(3, false)).isEqualTo(LottoRank.FIFTH_PRIZE);
        assertThat(LottoRank.matchRank(2, false)).isEqualTo(LottoRank.NO_PRIZE);
    }

}
