package domain;

import java.util.Collections;
import java.util.List;

public class LottoRanks {

    private static final int MIN_RANK_FOR_PRIZE = 3;
    private static final int MAX_RANK_FOR_PRIZE = 6;
    private static final int PRIZE_FOR_RANK_3 = 5000;
    private static final int PRIZE_FOR_RANK_4 = 50000;
    private static final int PRIZE_FOR_RANK_5 = 150000;
    private static final int PRIZE_FOR_RANK_6 = 2000000000;

    private final List<LottoRank> lottoRanks;

    private LottoRanks(List<LottoRank> lottoRanks) {
        this.lottoRanks = lottoRanks;
    }

    public static LottoRanks of(List<LottoRank> lottoRanks) {
        return new LottoRanks(lottoRanks);
    }

    public Price getTotalPrize() {
        Price totalPrize = Price.from(0);
        for (int rank = MIN_RANK_FOR_PRIZE; rank <= MAX_RANK_FOR_PRIZE; rank++) {
            LottoRank lottoRank = LottoRank.from(rank);
            totalPrize = totalPrize.add(getNumberOfRank(lottoRank) * getPrizeOfRank(lottoRank));
        }
        return totalPrize;
    }

    public int getNumberOfRank(LottoRank rank) {
        return Collections.frequency(lottoRanks, rank);
    }

    public int getPrizeOfRank(LottoRank lottoRank) {
        if (lottoRank.getLottoRank() == 3) return PRIZE_FOR_RANK_3;
        if (lottoRank.getLottoRank() == 4) return PRIZE_FOR_RANK_4;
        if (lottoRank.getLottoRank() == 5) return PRIZE_FOR_RANK_5;
        if (lottoRank.getLottoRank() == 6) return PRIZE_FOR_RANK_6;
        return 0;
    }

    public List<LottoRank> getRanks() {
        return lottoRanks;
    }

}
