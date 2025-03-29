package controller;

import domain.Lotto;
import domain.LottoRanks;
import domain.Lottos;
import domain.Price;
import domain.RandomNumberGenerator;
import java.util.ArrayList;
import java.util.List;
import view.InputView;
import view.OutputView;

public class LottoController {

    private static final RandomNumberGenerator generator = new RandomNumberGenerator();
    private static final int PRICE_PER_LOTTO = 1000;

    public void run() {
        final Price price = Price.from(InputView.inputPrice());
        final Lottos lottos = buyLottos(price);
        OutputView.printLottos(lottos);

        final Lotto winningNumbers = Lotto.of(InputView.inputWinningNumbers());
        LottoRanks lottoRanks = lottos.rankLottos(winningNumbers);

        final Price totalPrize = lottoRanks.getTotalPrize();
        OutputView.printRankResult(lottoRanks);
        OutputView.printRateOfReturn(totalPrize, price);
    }

    public Lottos buyLottos(Price price) {
        List<Lotto> lottoList = new ArrayList<>();
        for (int i = 0; i < price.getPrice() / PRICE_PER_LOTTO; i++) {
            lottoList.add(Lotto.of(generator.generateRandomNumbers()));
        }
        return Lottos.of(lottoList);
    }

}
