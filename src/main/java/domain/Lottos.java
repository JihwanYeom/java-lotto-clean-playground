package domain;

import java.util.ArrayList;
import java.util.List;

public class Lottos {

    public static int PRICE_PER_LOTTO = 1000;

    private final List<Lotto> lottos;

    private Lottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public static Lottos buy(Price price, RandomNumberGenerator generator) {
        List<Lotto> lottoList = new ArrayList<>();
        for (int i = 0; i < price.divideBy(PRICE_PER_LOTTO); i++) {
            lottoList.add(Lotto.of(generator.generateRandomNumbers()));
        }
        return new Lottos(lottoList);
    }

    public static Lottos of(List<Lotto> lottos) {
        return new Lottos(lottos);
    }

    public int count() {
        return lottos.size();
    }

    public LottoRanks rankLottos(Lotto winningNumber) {
        List<LottoRank> ranks = new ArrayList<>();
        for (Lotto lotto : lottos) {
            ranks.add(lotto.getRank(winningNumber));
        }
        return LottoRanks.of(ranks);
    }

    public List<Lotto> getLottos() {
        return lottos;
    }

}
