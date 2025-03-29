package domain;

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
        int rankNumber =
                (int) lottoNumbers.stream()
                .filter(winningNumbers::contains)
                .count();
        return LottoRank.from(rankNumber);
    }

    private boolean contains(LottoNumber lottoNumber) {
        return lottoNumbers.contains(lottoNumber);
    }

    public List<Integer> getNumbers() {
        return lottoNumbers.stream()
                .map(LottoNumber::getLottoNumber)
                .collect(Collectors.toList());
    }

}
