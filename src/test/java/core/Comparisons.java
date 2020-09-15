package core;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class Comparisons {

    @Test
    public void extra_parenthesis_not_needed() {
        String string = "not equal to string1";
        // most of the time developers add extra not needed parentheses
        assertThat(!"string1".equals(string) && !"string2".equals(string)).isTrue();
        string = "string1";
        assertThat(!"string1".equals(string) && !"string2".equals(string)).isFalse();
        string = "string2";
        assertThat(!"string1".equals(string) && !"string2".equals(string)).isFalse();
    }
}
