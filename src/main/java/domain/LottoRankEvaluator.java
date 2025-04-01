package domain;

import java.util.List;
import java.util.stream.Collectors;

public class LottoRankEvaluator {

    public static final int MIN_MATCH_NUMBER_FOR_PRIZE = 3;

    public static List<LottoRank> evaluate(Lottos lottos, Lotto winningNumbers) {
        List<Lotto> lottoList = lottos.getLottos();

        return lottoList.stream()
                .map(lotto -> lotto.matchNumbers(winningNumbers))
                .filter(matchNumber -> matchNumber >= MIN_MATCH_NUMBER_FOR_PRIZE)
                .map(LottoRank::valueOfMatch)
                .collect(Collectors.toList());
    }

}
