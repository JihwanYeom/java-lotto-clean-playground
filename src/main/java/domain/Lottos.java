package domain;

import java.util.ArrayList;
import java.util.List;

public class Lottos {


    public static LottoNumberGenerator lottoNumberGenerator = new LottoNumberGenerator();

    private final List<Lotto> lottos;

    private Lottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public static Lottos buyLottos(List<List<Integer>> numbers, int autoLottoCount) {
        List<Lotto> lottoList = new ArrayList<>();
        for(List<Integer> number: numbers)
            lottoList.add(Lotto.of(number));
        for (int i = 0; i < autoLottoCount; i++) {
            lottoList.add(Lotto.of(lottoNumberGenerator.generate()));
        }
        return new Lottos(lottoList);
    }

    public static Lottos of(List<Lotto> lottos) {
        return new Lottos(lottos);
    }

    public List<Lotto> getLottos() {
        return lottos;
    }

}
