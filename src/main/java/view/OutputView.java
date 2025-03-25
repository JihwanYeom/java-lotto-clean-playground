package view;

import domain.Lotto;
import java.util.List;

public class OutputView {

    public static void printResult(List<Lotto> lottoList) {
        System.out.println(lottoList.size() +"개를 구매했습니다.");

        for(Lotto lotto : lottoList) {
            System.out.println(lotto.getLottoNumbers());
        }
    }
}
