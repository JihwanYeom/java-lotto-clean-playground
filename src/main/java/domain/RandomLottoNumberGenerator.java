package domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RandomLottoNumberGenerator implements LottoNumberGenerator {

    private final List<Integer> allLottoNumbers;

    public RandomLottoNumberGenerator() {
        this.allLottoNumbers = new ArrayList<>();
        for(int i = 1; i < 46; i++)
            this.allLottoNumbers.add(i);
    }

    @Override
    public List<Integer> generate() {
        Collections.shuffle(allLottoNumbers);
        List<Integer> lottoNumber = new ArrayList<>(allLottoNumbers.subList(0, 6));
        Collections.sort(lottoNumber);
        return lottoNumber;
    }

}
