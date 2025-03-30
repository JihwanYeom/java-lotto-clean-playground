package domain;

import java.util.Objects;

public class LottoRank {

    private final int lottoRank;

    private LottoRank(int lottoRank) {
        this.lottoRank = lottoRank;
    }

    public static LottoRank from(int lottoRank) {
        return new LottoRank(lottoRank);
    }

    @Override
    public boolean equals(Object object) {
        if (object == null || getClass() != object.getClass())
            return false;

        LottoRank lottoRank = (LottoRank) object;
        return this.lottoRank == lottoRank.getLottoRank();
    }

    @Override
    public int hashCode() {
        return Objects.hash(lottoRank);
    }

    public int getLottoRank() {
        return lottoRank;
    }
    
}
