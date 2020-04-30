package api.com.google.common.base;

import com.google.common.base.Function;
import com.google.common.base.Functions;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class FunctionsTest {

    private static final String KEY_1 = "key1";
    private static final String VALUE_1 = "value1";
    private static final String VALUE_1_AS_DEFAULT = VALUE_1;
    private static final String KEY_NOT_EXISTING = "key_not_existing";
    private static final String DEFAULT_VALUE = "value1";

    final Map<String, String> map = new HashMap<String, String>() {{
        put("key1", "value1");
        put("key2", "value2");
        put("key3", "value3");
    }};

    @Test
    public void givenKeyIsPresentInMap_thenOK() {
        Function<String, String> lookup = Functions.forMap(map);
        // The map is searched for "key1".
        String value = lookup.apply("key1");
        assertThat(value).isEqualTo(VALUE_1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void givenKeyIsNotPresentInMap_thenIllegalArgumentException() {
        Function<String, String> lookup = Functions.forMap(map);
        String value = lookup.apply(KEY_NOT_EXISTING);
        assertThat(value).isEqualTo("should_not_return_anything");
    }

    @Test
    public void givenKeyIsNotPresentInMapAndDefaultValue_thenOK() {
        Function<String, String> lookup = Functions.forMap(map, VALUE_1_AS_DEFAULT);
        String value = lookup.apply(KEY_NOT_EXISTING);
        assertThat(value).isEqualTo(VALUE_1);
    }
}
