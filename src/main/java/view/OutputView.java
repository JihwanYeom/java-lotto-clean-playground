package view;

import domain.Lotto;
import domain.LottoRank;
import domain.LottoRanks;
import domain.Lottos;
import domain.Money;
import domain.ProfitRate;

public class OutputView {

    public static void printLottos(Lottos lottos) {
        System.out.println(lottos.count() +"개를 구매했습니다.");

        for(Lotto lotto : lottos.getLottos()) {
            System.out.println(lotto.getIntegerNumbers());
        }
    }

    public static void printRankResult(LottoRanks lottoRanks) {
        System.out.println("당첨 통계\n---------");
        for(LottoRank lottoRank : LottoRank.ranks()) {
            System.out.println( lottoRank.toString() + lottoRanks.getNumberOfRank(lottoRank) +"개");
        }
    }

    public static void printProfitRate(ProfitRate profitRate) {
        System.out.println("총 수익률은 " + profitRate.getProfitRate() + "입니다.");
    }

}
