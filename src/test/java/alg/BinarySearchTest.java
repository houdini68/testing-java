package alg;

import org.assertj.core.api.Assertions;
import org.junit.Test;

import java.util.Arrays;

public class BinarySearchTest {

    @Test
    public void givenSortedArrayOfIntegers_whenBinarySearch_thenOK() {
        int[] whitelist = {19, 18, 17, 16, 15, 14, 13, 12, 11, 10};
        Arrays.sort(whitelist);
        Assertions.assertThat(new BinarySearch().rank(14, whitelist)).isEqualTo(4);
        Assertions.assertThat(new BinarySearch().rank(10, whitelist)).isEqualTo(0);
        Assertions.assertThat(new BinarySearch().rank(19, whitelist)).isEqualTo(9);
        Assertions.assertThat(new BinarySearch().rank(20, whitelist)).isEqualTo(-1);
    }
}
