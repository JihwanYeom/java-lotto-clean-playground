package domain;

import java.util.Collections;
import java.util.List;

public class Lotto {

    private final List<LottoNumber> lottoNumbers;

    private Lotto(List<LottoNumber> lottoNumbers) {
        this.lottoNumbers = lottoNumbers;
    }

    public static Lotto of(List<LottoNumber> lottoNumbers) {
        return new Lotto(lottoNumbers);
    }

    public LottoRank getRank(Lotto winningNumbers) {
        final int rankNumber =
                (int) lottoNumbers.stream()
                .filter(lottoNumber -> winningNumbers.getLottoNumbers().contains(lottoNumber))
                .count();
        return LottoRank.from(rankNumber);
    }

    public List<LottoNumber> getLottoNumbers() {
        return Collections.unmodifiableList(lottoNumbers);
    }

}
