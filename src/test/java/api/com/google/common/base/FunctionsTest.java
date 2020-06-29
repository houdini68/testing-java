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
    private static final String KEY_NOT_EXISTING = "key_not_existing";
    private static final String DEFAULT_VALUE = "default_value";

    final Map<String, String> map = new HashMap<String, String>() {{
        put("key1", "value1");
        put("key2", "value2");
        put("key3", "value3");
    }};

    @Test
    public void givenKeyIsPresentInMap_thenOK() {
        Function<String, String> lookup = Functions.forMap(map);
        assertThat(lookup.apply(KEY_1)).isEqualTo(VALUE_1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void givenKeyIsNotPresentInMap_thenIllegalArgumentException() {
        Function<String, String> lookup = Functions.forMap(map);
        assertThat(lookup.apply(KEY_NOT_EXISTING)).isEqualTo("IllegalArgumentException is thrown!");
    }

    @Test
    public void givenKeyIsNotPresentInMapAndDefaultValue_thenOK() {
        Function<String, String> lookup = Functions.forMap(map, DEFAULT_VALUE);
        assertThat(lookup.apply(KEY_NOT_EXISTING)).isEqualTo(DEFAULT_VALUE);
    }
}
