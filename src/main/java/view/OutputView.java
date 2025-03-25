package view;

import domain.Lotto;
import domain.LottoNumber;
import domain.Lottos;
import java.util.List;
import java.util.stream.Collectors;

public class OutputView {

    public static void printLottos(Lottos lottos) {
        System.out.println(lottos.count() +"개를 구매했습니다.");

        for(Lotto lotto : lottos.getLottos()) {
            System.out.println(lotto.getLottoNumbers()
                    .stream()
                    .map(LottoNumber::getLottoNumber)
                    .collect(Collectors.toList()));
        }
    }

}
