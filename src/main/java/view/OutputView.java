package view;

import domain.Lotto;
import domain.LottoRank;
import domain.LottoRanks;
import domain.Lottos;
import domain.Price;

public class OutputView {

    private static final int MIN_RANK_FOR_PRIZE = 3;
    private static final int MAX_RANK_FOR_PRIZE = 6;

    public static void printLottos(Lottos lottos) {
        System.out.println(lottos.count() +"개를 구매했습니다.");

        for(Lotto lotto : lottos.getLottos()) {
            System.out.println(lotto.getNumbers());
        }
    }

    public static void printRankResult(LottoRanks lottoRanks) {
        System.out.println("당첨 통계\n---------");
        for(int rank = MIN_RANK_FOR_PRIZE; rank <= MAX_RANK_FOR_PRIZE; rank++) {
            final LottoRank lottoRank = LottoRank.from(rank);
            System.out.println(rank+"개 일치 (" + lottoRanks.getPrizeOfRank(lottoRank)
                    + "원)- " + lottoRanks.getNumberOfRank(lottoRank) +"개");
        }
    }

    public static void printRateOfReturn(Price totalPrize, Price price) {
        System.out.println("총 수익률은 " + (double)totalPrize.getPrice()/(double)price.getPrice() + "입니다.");
    }

}
