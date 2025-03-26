package domain;

public class LottoRank {

    private final int lottoRank;

    private LottoRank(int lottoRank) {
        this.lottoRank = lottoRank;
    }

    public static LottoRank from(int lottoRank) {
        return new LottoRank(lottoRank);
    }

    public int getLottoRank() {
        return lottoRank;
    }
}
