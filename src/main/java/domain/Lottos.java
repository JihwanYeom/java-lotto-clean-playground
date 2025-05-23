package domain;

import java.util.ArrayList;
import java.util.List;

public class Lottos {

    private final List<Lotto> lottos;

    private Lottos(List<Lotto> lottos) {
        this.lottos = lottos;
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
