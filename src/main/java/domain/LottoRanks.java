package domain;

import java.util.Collections;
import java.util.List;

public class LottoRanks {

    private final List<LottoRank> lottoRanks;

    private LottoRanks(List<LottoRank> lottoRanks) {
        this.lottoRanks = lottoRanks;
    }

    public static LottoRanks of(List<LottoRank> lottoRanks) {
        return new LottoRanks(lottoRanks);
    }

    public Money getTotalPrize() {
        Money totalPrize = Money.from(0);
        for (LottoRank lottoRank : lottoRanks) {
            totalPrize = totalPrize.add(lottoRank.getPrize());
        }
        return totalPrize;
    }

    public int getNumberOfRank(LottoRank rank) {
        return Collections.frequency(lottoRanks, rank);
    }

}
