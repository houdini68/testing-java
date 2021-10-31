package api.java.lang;

import org.assertj.core.api.Assertions;
import org.junit.Test;

public class StringTest {

    public static final String EXID_ON_12 = "830012918511";

    @Test
    public void givenIntegerString_whenLeftPaddingWith0SizeIs13_thenPaddTo13() {
        String exid = EXID_ON_12;
        Assertions.assertThat(String.format("%013d", Long.valueOf(exid))).isEqualTo("0" + EXID_ON_12);
    }
}
