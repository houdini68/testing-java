package api.java.lang;

import org.assertj.core.api.Assertions;
import org.junit.Test;

public class IntegerTest {

    @Test
    public void givenNumericStringHavingZeroNotSignificant_whenParseInt_thenOK() {
        Assertions.assertThat(Integer.parseInt("00000")).isEqualTo(0);
    }
}
