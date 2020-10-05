package api.java.util.function;

import org.junit.Test;

import java.util.Objects;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;

import static org.assertj.core.api.Assertions.assertThat;

public class BiFunctionTest {

    @Test
    public void givenBiFunctionSumIntegers_thenReturnSumOfIntegers() {
        BiFunction<Integer, Integer, Integer> biFunction = (i1, i2) -> i1 + i2;
        // the generic type has 2 input, T and U and 1 output R
        // R = apply(T,U)
        assertThat(biFunction.apply(1, 2)).isEqualTo(3);
    }
}
