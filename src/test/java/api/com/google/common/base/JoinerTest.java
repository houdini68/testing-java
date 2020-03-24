package api.com.google.common.base;

import com.google.common.base.Joiner;
import com.google.common.collect.Maps;
import org.junit.Test;

import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class JoinerTest {
    @Test
    public void joinerOnStrings() {

        assertThat(Joiner.on("|")
                .join("a", "b", "c"))
                .isEqualTo("a|b|c");

        assertThat(Joiner.on("|")
                .skipNulls()
                .join("a", "b", null, "c"))
                .isEqualTo("a|b|c");

        assertThat(Joiner.on("|")
                .useForNull("replacedNull")
                .join("a", "b", null, "c"))
                .isEqualTo("a|b|replacedNull|c");
    }

    @Test(expected = UnsupportedOperationException.class)
    public void joinerImmutable() {
        Joiner joiner = Joiner.on("|").skipNulls();
        joiner.useForNull("not_used_because_joiner_is_immutable");
        assertThat(joiner
                .join("a", "c", null))
                .isEqualTo("a|b");
    }

    @Test
    public void joinerOnStringBuilder() {
        StringBuilder stringBuilder = new StringBuilder();
        Joiner joiner = Joiner.on("|").skipNulls();
        joiner.appendTo(stringBuilder, "a", "b", "c", null);
        assertThat(stringBuilder.toString())
                .isNotEmpty()
                .isEqualTo(("a|b|c"));
    }

    @Test
    public void joinerOnMap() {
        String expected = "key1=value1" +
                "#key2=value2" +
                "#key3=value3" +
                "#key4=value4";
        Map<String, String> map = Maps.newLinkedHashMap();
        map.put("key1", "value1");
        map.put("key2", "value2");
        map.put("key3", "value3");
        map.put("key4", "value4");
        String actual
                = Joiner.on("#")
                .withKeyValueSeparator("=")
                .join(map);
        assertThat(actual)
                .isEqualTo(expected);
    }
}
