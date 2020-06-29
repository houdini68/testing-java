package api.org.apache.commons.lang3;

import org.apache.commons.lang.StringUtils;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class StringUtilsTest {

    private static final String SPACE = " ";

    @Test
    public void givenNullString_whenDeletingZerosLeft_thenNullString() {
        assertThat(StringUtils.stripStart(null,"0")).isNull();
    }

    @Test
    public void givenEmptyString_whenDeletingZerosLeft_thenEmptyString() {
        assertThat(StringUtils.stripStart("","0")).isEmpty();
    }
    @Test
    public void givenOneSpace_whenDeletingZerosLeft_thenOneSpace() {
        assertThat(StringUtils.stripStart(SPACE, "0")).isEqualTo(SPACE);
    }

    @Test
    public void givenAllZeroString_whenDeletingZerosLeft_thenEmptyString() {
        assertThat(StringUtils.stripStart("00000", "0")).isEmpty();
    }

    @Test
    public void givenStringNumberOneWithNonSignZeros_whenDeletingZerosLeft_thenStringNumberOne() {
        assertThat(StringUtils.stripStart("000001", "0")).isEqualTo("1");
    }
}
