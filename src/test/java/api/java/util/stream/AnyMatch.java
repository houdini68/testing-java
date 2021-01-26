package api.java.util.stream;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class AnyMatch {

    @Test
    public void givenString_whenNotDigitFound_thenContainsOnlyDigits() {
        String str = "12345";
        assertThat(!str.chars()
                .anyMatch(n -> !Character.isDigit(n)))
                .isTrue();
    }
}


