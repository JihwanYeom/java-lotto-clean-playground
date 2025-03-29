package domain;

public class LottoNumber implements Comparable<LottoNumber> {

    private final int lottoNumber;

    private LottoNumber(int lottoNumber) {
        this.lottoNumber = lottoNumber;
    }

    public static LottoNumber from(int lottoNumber) {
        return new LottoNumber(lottoNumber);
    }

    public int getLottoNumber() {
        return lottoNumber;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null || getClass() != obj.getClass())
            return false;

        final LottoNumber lottoNumber = (LottoNumber) obj;
        return this.lottoNumber == lottoNumber.getLottoNumber();
    }

    @Override
    public int compareTo(LottoNumber lottoNumber) {
        return this.lottoNumber - lottoNumber.lottoNumber;
    }

}
