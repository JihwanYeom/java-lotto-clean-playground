package domain;

public class LottoNumber implements Comparable<LottoNumber> {


    private static final int MINIMUM_LOTTO_NUMBER = 1;
    private static final int MAXIMUM_LOTTO_NUMBER = 45;

    private final int lottoNumber;

    private LottoNumber(int lottoNumber) {
        this.lottoNumber = lottoNumber;
    }

    public static LottoNumber from(int lottoNumber) {

        if (lottoNumber < MINIMUM_LOTTO_NUMBER || lottoNumber > MAXIMUM_LOTTO_NUMBER) {
            throw new IllegalArgumentException(
                    "로또 번호는 1~45 사이의 값이어야 합니다.");
        }
        return new LottoNumber(lottoNumber);
    }

    public int getLottoNumber() {
        return lottoNumber;
    }

    @Override
    public boolean equals(Object obj) {

        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }

        LottoNumber lottoNumber = (LottoNumber) obj;
        return this.lottoNumber == lottoNumber.getLottoNumber();
    }

    @Override
    public int compareTo(LottoNumber lottoNumber) {
        return this.lottoNumber - lottoNumber.lottoNumber;
    }

}
