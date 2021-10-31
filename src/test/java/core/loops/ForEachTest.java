package core.loops;

import org.assertj.core.api.Assertions;
import org.junit.Test;

import java.util.Collections;
import java.util.List;

public class ForEachTest {

    @Test
    public void whenEmptyList_thenLoopNotExecuted() {
        boolean flag = true;
        List<Integer> integers = Collections.emptyList();
        for (Integer i : integers) {
            flag = false;
        }
        Assertions.assertThat(flag).isTrue();
    }
}
