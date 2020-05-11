package corelanguage;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class SwitchTest {

    public static final String ONE = "one";
    public static final String TWO = "two";
    public static final String THREE = "three";
    public static final String FOUR = "four";
    public static final String DEFAULT = "default";

    @Test
    public void givenInt_whenNormalCase_thenOK() {
        int integer = 2;
        int result;
        switch (integer) {
            case 1:
                result = 1;
                break;
            case 2:
                result = 2;
                break;
            case 3:
                result = 3;
                break;
            default:
                result = 0;
        }
        assertThat(result).isEqualTo(2);
    }

    @Test
    public void givenInt_whenDefaultCase_thenOK() {
        int integer = 4;
        int result;
        switch (integer) {
            case 1:
                result = 1;
                break;
            case 2:
                result = 2;
                break;
            case 3:
                result = 3;
                break;
            default:
                result = 0;
        }
        assertThat(result).isEqualTo(0);
    }

    @Test
    public void givenString_whenNormalCase_thenOK() {
        String str = TWO;
        String result;
        switch (str) {
            case ONE:
                result = ONE;
                break;
            case TWO:
                result = TWO;
                break;
            case THREE:
                result = THREE;
                break;
            default:
                result = DEFAULT;
        }
        assertThat(result).isEqualTo(TWO);
    }

    @Test
    public void givenString_whenDefaultCase_thenOK() {
        String str = FOUR;
        String result;
        switch (str) {
            case ONE:
                result = ONE;
                break;
            case TWO:
                result = TWO;
                break;
            case THREE:
                result = THREE;
                break;
            default:
                result = DEFAULT;
        }
        assertThat(result).isEqualTo(DEFAULT);
    }
}
