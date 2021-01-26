package api.java.util.regex;

import org.assertj.core.api.Assertions;
import org.junit.Test;

public class RegexTest {

    @Test
    public void givenString_whenMatches_thenContainsOnlyDigits() {
        String str = "12345";
        Assertions
                .assertThat(
                    str.matches("[0-9]+")
                ).isTrue();
    }
}
