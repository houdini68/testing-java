package api.com.google.common.base;

import com.google.common.base.Splitter;
import com.google.common.collect.Maps;
import org.junit.Test;

import java.util.Map;
import java.util.regex.Pattern;

import static org.assertj.core.api.Assertions.assertThat;

public class SplitterTest {
    @Test
    public void When_splitOfString_Expect_NoControl() {
        String testString = "a,b,,c,d,,";
        String[] items = testString.split(",");
        assertThat(items)
                .containsExactly("a", "b", "", "c", "d");
        // missing items replaced by empty string
        // missing items at the end were removed
    }

    @Test
    public void When_EmptyStrings() {
        assertThat(Splitter.on('|')
                .split("a|b||c|"))
                .containsExactly("a", "b", "", "c", "");
    }

    @Test
    public void When_Regex() {
        Pattern digits = Pattern.compile("\\d+");
        assertThat(Splitter.on(digits)
                .omitEmptyStrings()
                .split("a90466449b712222543c"))
                .containsExactly("a", "b", "c");
    }

    @Test
    public void When_omitEmptyStrings_Expect_EmptyStringsRemoved() {
        assertThat(Splitter.on('|')
                .omitEmptyStrings()
                .split("a|b|c|||"))
                .containsExactly("a", "b", "c");
    }

    @Test
    public void When_KeyValues_Expect_Map() {
        String keyValues = "key1=value1#key2=value2#key3=value3#key4=value4";
        Map<String, String> expectedMap = Maps.newLinkedHashMap();
        expectedMap.put("key1", "value1");
        expectedMap.put("key2", "value2");
        expectedMap.put("key3", "value3");
        expectedMap.put("key4", "value4");
        assertThat(Splitter.on("#")
                .withKeyValueSeparator("=")
                .split(keyValues))
                .isEqualTo(expectedMap);
    }
}
