package domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Lotto {

    private final List<LottoNumber> lottoNumbers;

    private Lotto(List<LottoNumber> lottoNumbers) {
        this.lottoNumbers = lottoNumbers;
    }

    public static Lotto of(List<Integer> numbers) {
        List<LottoNumber> lotto = numbers.stream()
                .map(LottoNumber::from)
                .collect(Collectors.toList());
        return new Lotto(lotto);
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
