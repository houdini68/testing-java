package api.com.google.common.collect;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Maps;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ImmutableMapTest {

    @Test
    public void givenBuilderOnImmutable_thenImmutableMapIsReturned() {
        ImmutableMap<Character, Integer> immutableMap
                = ImmutableMap.<Character, Integer>builder()
                .put('a', 1)
                .put('b', 2)
                .put('c', 3)
                .build();
        assertThat(immutableMap)
                .contains(Maps.immutableEntry('a', 1))
                .contains(Maps.immutableEntry('b', 2))
                .contains(Maps.immutableEntry('c', 3))
                .hasSize(3);
    }
}
