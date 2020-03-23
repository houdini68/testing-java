package api.java.util;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class MapTest {

    @Test
    public void computeSumKeyValue() {
        final Map<Integer, Integer> mapActual = new HashMap<Integer, Integer>() {{
            put(1, 1);
            put(2, 2);
            put(3, 3);
        }};
        final Map<Integer, Integer> mapExpected = new HashMap<Integer, Integer>() {{
            put(1, 2);
            put(2, 4);
            put(3, 6);
        }};
        // key is remapped into key + value
        mapActual.forEach((key, value) -> mapActual.compute(key, (key1, value1) -> key1 + value1));

        assertThat(mapActual)
                .isNotNull()
                .hasSize(3)
                .isEqualTo(mapExpected);
    }
}
