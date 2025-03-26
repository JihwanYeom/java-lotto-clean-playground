package domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RandomLottoNumberGenerator implements LottoNumberGenerator {

    private static final int MIN_OF_LOTTO_NUMBERS = 1;
    private static final int MAX_OF_LOTTO_NUMBERS = 45;
    private static final int NUMBER_OF_LOTTO_NUMBERS = 6;

    private final List<LottoNumber> allLottoNumbers;

    public RandomLottoNumberGenerator() {
        this.allLottoNumbers = new ArrayList<>();
        for (int lottoNumber = MIN_OF_LOTTO_NUMBERS; lottoNumber <= MAX_OF_LOTTO_NUMBERS; lottoNumber++) {
            this.allLottoNumbers.add(LottoNumber.from(lottoNumber));
        }
    }

    @Override
    public List<LottoNumber> generateLottoNumbers() {
        Collections.shuffle(allLottoNumbers);
        List<LottoNumber> lottoNumber = new ArrayList<>(allLottoNumbers.subList(0, NUMBER_OF_LOTTO_NUMBERS));
        Collections.sort(lottoNumber);
        return lottoNumber;
    }

}
