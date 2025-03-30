package domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoNumberTest {

    @Test
    @DisplayName("로또 번호 1이 로또 번호 1과 같은지 비교하면 true가 반환되어야 한다")
    public void testLottoNumberIsEquals() {
        LottoNumber testNumber = LottoNumber.from(1);
        boolean expected = true;

        boolean actual = testNumber.equals(LottoNumber.from(1));

        assertThat(actual).isEqualTo(expected);
    }

    @Test
    @DisplayName("로또 번호 2가 로또 번호 1과 같은지 비교하면 false가 반환되어야 한다")
    public void testLottoNumberIsNotEquals() {
        LottoNumber testNumber = LottoNumber.from(2);
        boolean expected = false;

        boolean actual = testNumber.equals(LottoNumber.from(1));

        assertThat(actual).isEqualTo(expected);
    }

}
