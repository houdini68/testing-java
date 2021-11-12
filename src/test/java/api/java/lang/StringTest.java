package api.java.lang;

import org.assertj.core.api.Assertions;
import org.junit.Test;

import static org.assertj.core.api.Assertions.*;

public class StringTest {

    public static final String ID_ON_12 = "830012918511";

    @Test
    public void givenIntegerString_whenLeftPaddingWith0SizeIs13_thenPaddTo13() {
        String exid = ID_ON_12;
        assertThat(String.format("%013d", Long.valueOf(exid))).isEqualTo("0" + ID_ON_12);
    }
}
