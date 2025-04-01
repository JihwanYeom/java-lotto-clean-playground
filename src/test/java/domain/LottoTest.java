package domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;

public class LottoTest {

    @Test
    public void testMatchNumbers() {
        Lotto lotto = Lotto.of(createNumbersByString("1,2,3,4,5,6"));
        Lotto win = Lotto.of(createNumbersByString("1,2,3,4,7,8"));
        int expected = 4;

        int actual = lotto.matchNumbers(lotto);
        assertThat(actual).isEqualTo(expected);
    }

    private List<Integer> createNumbersByString(String string) {
        List<Integer> testLottoNumbers = new ArrayList<>();
        String[] testStringNumberList = string.split(",");
        for (String stringNumber : testStringNumberList) {
            testLottoNumbers.add(Integer.parseInt(stringNumber));
        }
        return testLottoNumbers;
    }

}
