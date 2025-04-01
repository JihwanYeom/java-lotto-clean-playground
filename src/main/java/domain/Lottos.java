package domain;

import java.util.ArrayList;
import java.util.List;

public class Lottos {

    public static int PRICE_PER_LOTTO = 1000;
    public static LottoNumberGenerator lottoNumberGenerator = new LottoNumberGenerator();

    private final List<Lotto> lottos;

    private Lottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public static Lottos buy(Money money, LottoNumberGenerator generator) {
        List<Lotto> lottoList = new ArrayList<>();
        for (int i = 0; i < money.divideBy(PRICE_PER_LOTTO); i++) {
            lottoList.add(Lotto.of(lottoNumberGenerator.generate()));
        }
        return new Lottos(lottoList);
    }

    public static Lottos of(List<Lotto> lottos) {
        return new Lottos(lottos);
    }

    public int count() {
        return lottos.size();
    }

    public List<Lotto> getLottos() {
        return lottos;
    }

}
