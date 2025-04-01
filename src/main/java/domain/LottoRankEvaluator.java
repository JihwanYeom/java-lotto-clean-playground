package domain;

import java.util.List;
import java.util.stream.Collectors;

public class LottoRankEvaluator {

    public static List<LottoRank> evaluate(Lottos lottos, Lotto winningNumbers, LottoNumber bonusNumber) {
        List<Lotto> lottoList = lottos.getLottos();

        return lottoList.stream()
                .map(lotto -> LottoRank.matchRank(lotto.matchNumbers(winningNumbers), lotto.hasBonusNumber(bonusNumber)))
                .collect(Collectors.toList());
    }

}
