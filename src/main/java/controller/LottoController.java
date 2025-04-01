package controller;

import domain.Lotto;
import domain.LottoNumber;
import domain.LottoRankEvaluator;
import domain.LottoRanks;
import domain.Lottos;
import domain.Money;
import domain.ProfitRate;
import view.InputView;
import view.OutputView;

public class LottoController {

    public void run() {
        final Money price = Money.from(InputView.inputPrice());
        final Lottos lottos = purchase(price);

        final Lotto winningNumbers = Lotto.of(InputView.inputWinningNumbers());
        final LottoNumber bonusNumber = LottoNumber.from(InputView.inputBonusNumber());
        LottoRanks lottoRanks = LottoRanks.of(LottoRankEvaluator.evaluate(lottos, winningNumbers, bonusNumber));
        ProfitRate profitRate = ProfitRate.of(price, lottoRanks.getTotalPrize());

        OutputView.printRankResult(lottoRanks);
        OutputView.printProfitRate(profitRate);
    }

    private Lottos purchase(Money price) {
        int manualLottoCount = InputView.inputManualLottoCount();
        Lottos lottos = Lottos.buy(price, InputView.inputManualLottoNumbers(manualLottoCount));
        OutputView.printLottoCount(manualLottoCount, lottos.getCount() - manualLottoCount);
        OutputView.printLottos(lottos);
        return lottos;
    }

}
