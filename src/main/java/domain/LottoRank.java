package domain;

public class LottoRank {

    private final int lottoRank;

    private LottoRank(int lottoRank) {
        this.lottoRank = lottoRank;
    }

    public static LottoRank from(int lottoRank) {
        return new LottoRank(lottoRank);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null || getClass() != obj.getClass())
            return false;

        final LottoRank lottoRank = (LottoRank) obj;
        return this.lottoRank == lottoRank.getLottoRank();
    }

    public int getLottoRank() {
        return lottoRank;
    }
    
}
