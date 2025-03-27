import static org.assertj.core.api.Assertions.assertThat;

import domain.LottoNumber;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoNumberTest {

    @DisplayName("로또 번호가 같은지 비교 테스트")
    @Test
    public void testEquals() {
        LottoNumber testNumber = LottoNumber.from(1);

        assertThat(testNumber.equals(LottoNumber.from(1))).isEqualTo(true);
        assertThat(testNumber.equals(LottoNumber.from(2))).isEqualTo(false);
    }
}
