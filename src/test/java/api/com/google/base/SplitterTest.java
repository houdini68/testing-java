package api.com.google.base;

import com.google.common.base.CharMatcher;
import com.google.common.base.Splitter;
import com.google.common.collect.Maps;
import org.junit.Ignore;
import org.junit.Test;

import java.util.Map;
import java.util.regex.Pattern;

import static org.assertj.core.api.Assertions.assertThat;

public class SplitterTest {
    @Test
    public void string_split_does_not_give_us_some_control() {
        String testString = "a,b,,c,d,,";
        String[] items = testString.split(",");
        assertThat(items)
                .containsExactly("a", "b", "", "c", "d");
        // missing item replaced by empty string
        // missing items at the end were removed
    }

    @Test
    public void splitter_some_items_missing() {
        assertThat(Splitter.on('|')
                .split("a|b||c|"))
                .containsExactly("a", "b", "", "c", "");
    }

    @Test
    public void splitter_based_on_regex() {
        Pattern digits = Pattern.compile("\\d+");
        assertThat(Splitter.on(digits)
                .omitEmptyStrings()
                .split("a90466449b712222543c"))
                .containsExactly("a", "b", "c");
    }

    @Test
    public void splitterOmitEmptyStrings() {
        assertThat(Splitter.on('|')
                .omitEmptyStrings()
                .split("a|b|c|||"))
                .containsExactly("a", "b", "c");
    }

    @Test
    public void testSplitter() {
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

//    @Test
//    public void test() {
//        Pattern spaces = Pattern.compile("\\s+");
//        assertThat(Splitter.on('|')
//                .trimResults(CharMatcher.is())
//                .split("a|b|c|||"))
//                .containsExactly("a", "b", "c");
//    }

}
