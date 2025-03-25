package controller;

import domain.Lotto;
import domain.RandomLottoNumberGenerator;
import java.util.ArrayList;
import java.util.List;
import view.InputView;
import view.OutputView;

public class LottoController {

    private static final RandomLottoNumberGenerator generator = new RandomLottoNumberGenerator();

    public void run() {
        //구매금액 입력
        final Integer price = InputView.readPrice();
        final Integer lottoCount = price/1000;

        //결과 출력
        List<Lotto> lottoList = new ArrayList<>();
        for (int i = 0; i < lottoCount; i++) {
            lottoList.add(new Lotto(generator));
        }

        OutputView.printResult(lottoList);

    }
}
