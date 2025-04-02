package domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoNumberTest {

    @Test
    @DisplayName("로또 번호가 1보다 작으면 예외가 발생해야 한다")
    void testLottoNumberSmallerThanMinimumException() {
        int invalidNumber = 0;

        assertThatThrownBy(() -> LottoNumber.from(invalidNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("로또 번호는 1~45 사이의 값이어야 합니다.");
    }

    @Test
    @DisplayName("로또 번호가 45보다 크면 예외가 발생해야 한다")
    void testLottoNumberBiggerThanMaximumException() {
        int invalidNumber = 46;

        assertThatThrownBy(() -> LottoNumber.from(invalidNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("로또 번호는 1~45 사이의 값이어야 합니다.");
    }

    @Test
    @DisplayName("로또 번호 1이 로또 번호 1과 같은지 비교하면 참이 반환되어야 한다")
    void testLottoNumberIsEquals() {
        LottoNumber testNumber = LottoNumber.from(1);
        boolean expected = true;

        boolean actual = testNumber.equals(LottoNumber.from(1));

        assertThat(actual).isEqualTo(expected);
    }

    @Test
    @DisplayName("로또 번호 2가 로또 번호 1과 같은지 비교하면 거짓이 반환되어야 한다")
    void testLottoNumberIsNotEquals() {
        LottoNumber testNumber = LottoNumber.from(2);
        boolean expected = false;

        boolean actual = testNumber.equals(LottoNumber.from(1));

        assertThat(actual).isEqualTo(expected);
    }

}
