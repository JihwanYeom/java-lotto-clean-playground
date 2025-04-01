package controller;

import domain.Lotto;
import domain.LottoNumber;
import domain.LottoRank;
import domain.LottoRankEvaluator;
import domain.LottoRanks;
import domain.Lottos;
import domain.Money;
import domain.LottoNumberGenerator;
import domain.ProfitRate;
import view.InputView;
import view.OutputView;

public class LottoController {

    private static final LottoNumberGenerator generator = new LottoNumberGenerator();

    public void run() {
        final Money price = Money.from(InputView.inputPrice());
        final Lottos lottos = Lottos.buy(price, generator);
        OutputView.printLottos(lottos);

        final Lotto winningNumbers = Lotto.of(InputView.inputWinningNumbers());
        final LottoNumber bonusNumber = LottoNumber.from(InputView.inputBonusNumber());
        LottoRanks lottoRanks = LottoRanks.of(LottoRankEvaluator.evaluate(lottos, winningNumbers, bonusNumber));
        ProfitRate profitRate = ProfitRate.of(price, lottoRanks.getTotalPrize());

        final Money totalPrize = lottoRanks.getTotalPrize();
        OutputView.printRankResult(lottoRanks);
        OutputView.printProfitRate(profitRate);
    }

}
