package util;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class UtilTest {

    private static final String TRUE = "true";
    private static final String FALSE = "false";
    private static final String ZERO = "0";
    private static final String ONE = "1";
    private static final String DEFAULT_VALUE = "default_value";
    private static final String UNKNOWN_VALUE = "unknown value";

    Util util;

    @Before
    public void setUp() throws Exception {
        util = new Util();
    }

    @Test
    public void whenZero_thenFalse() {
        assertThat(util.mapToBoolean(ZERO, DEFAULT_VALUE)).isEqualTo(FALSE);
    }

    @Test
    public void whenOne_thenTrue() {
        assertThat(util.mapToBoolean(ONE, DEFAULT_VALUE)).isEqualTo(TRUE);
    }

    @Test
    public void whenFalse_thenFalse() {
        assertThat(util.mapToBoolean(FALSE, DEFAULT_VALUE)).isEqualTo(FALSE);
    }

    @Test
    public void whenTrue_thenTrue() {
        assertThat(util.mapToBoolean(TRUE, DEFAULT_VALUE)).isEqualTo(TRUE);
    }

    @Test
    public void whenMixedCaseAndSpacesTrue_thenTrue() {
        assertThat(util.mapToBoolean(" tRuE ", DEFAULT_VALUE)).isEqualTo(TRUE);
    }

    @Test
    public void whenZeroAndSpaced_thenFalse() {
        assertThat(util.mapToBoolean(" 0 ", DEFAULT_VALUE)).isEqualTo(FALSE);
    }

    @Test
    public void whenOneAndSpaces_thenTrue() {
        assertThat(util.mapToBoolean(" 1 ", DEFAULT_VALUE)).isEqualTo(TRUE);
    }

    @Test
    public void whenValueIsUnknown_thenDefaultValue() {
        assertThat(util.mapToBoolean(UNKNOWN_VALUE, DEFAULT_VALUE)).isEqualTo(DEFAULT_VALUE);
    }

    @Test
    public void whenValueIsNull_thenNPE() {
        assertThatThrownBy(() -> {
            util.mapToBoolean(null, DEFAULT_VALUE);
        }).isInstanceOf(NullPointerException.class);
    }

}
