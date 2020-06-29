package core;

import org.assertj.core.api.Assertions;
import org.junit.Test;

public class Comparisons {

    @Test
    public void extra_parenthesis_not_needed() {
        String string = "not equal to string1";
        // most of the time developers add extra not needed parentheses
        Assertions.assertThat(!"string1".equals(string) && !"string2".equals(string)).isTrue();
        string = "string1";
        Assertions.assertThat(!"string1".equals(string) && !"string2".equals(string)).isFalse();
        string = "string2";
        Assertions.assertThat(!"string1".equals(string) && !"string2".equals(string)).isFalse();
    }
}
