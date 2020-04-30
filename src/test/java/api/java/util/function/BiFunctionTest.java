package api.java.util.function;

import org.junit.Test;

import java.util.Objects;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;

import static org.assertj.core.api.Assertions.assertThat;

public class BiFunctionTest {

    @Test
    public void givenBiFunctionSumIntegers_thenReturnSumOfIntegers() {
        // Look at the syntax of a BiFunction.
        // There are 3 parameters.
        // 2 input parameters and 1 output parameter.
        BiFunction<Integer, Integer, Integer> biFunction = (i1, i2) -> i1 + i2;
        assertThat(biFunction.apply(1, 2)).isEqualTo(3);
    }
}
