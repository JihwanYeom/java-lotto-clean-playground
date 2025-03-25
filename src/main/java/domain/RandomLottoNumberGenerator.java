package domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RandomLottoNumberGenerator implements LottoNumberGenerator {

    private static final int NUMBER_OF_ALL_LOTTO_NUMBERS = 45;

    private final List<LottoNumber> allLottoNumbers;

    public RandomLottoNumberGenerator() {
        this.allLottoNumbers = new ArrayList<>();
        for(int i = 1; i <=  NUMBER_OF_ALL_LOTTO_NUMBERS; i++)
            this.allLottoNumbers.add(LottoNumber.from(i));
    }

    @Override
    public List<LottoNumber> generateLottoNumbers() {
        Collections.shuffle(allLottoNumbers);
        List<LottoNumber> lottoNumber = new ArrayList<>(allLottoNumbers.subList(0, 6));
        Collections.sort(lottoNumber);
        return lottoNumber;
    }

}
