package api.java.lang;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class IntegerTest {

    @Test
    public void givenNumericStringHavingZeroNotSignificant_whenParseInt_thenOK() {
        assertThat(Integer.parseInt("00000")).isEqualTo(0);
    }
}
