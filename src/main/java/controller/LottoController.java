package controller;

import domain.Lotto;
import domain.LottoNumber;
import domain.LottoRankEvaluator;
import domain.LottoRanks;
import domain.Lottos;
import domain.Money;
import domain.LottoNumberGenerator;
import domain.ProfitRate;
import view.InputView;
import view.OutputView;

public class LottoController {

    public static int PRICE_PER_LOTTO = 1000;

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
        int manuelLottoCount = InputView.inputManuelLottoCount();
        int autoLottoCount = (int) price
                .sub((long) manuelLottoCount * PRICE_PER_LOTTO)
                .divideBy(PRICE_PER_LOTTO);
        Lottos lottos = Lottos.buyLottos(InputView.inputManuelLottoNumbers(manuelLottoCount), autoLottoCount);
        OutputView.printLottoCount(manuelLottoCount, autoLottoCount);
        OutputView.printLottos(lottos);
        return lottos;
    }

}
