package core.collection;

import org.junit.Test;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class ListTest {

    @Test
    public void given3Lists_thenMergeLists() {
        List<String> list1 = Arrays.asList("item1", "item2", "item3");
        List<String> list2 = Arrays.asList("item4", "item5", "item6");
        List<String> list3 = Arrays.asList("item7", "item8", "item9");
        List<String> concatenation =
                Stream.of(list1, list2, list3)
                        .flatMap(Collection::stream)
                        .collect(Collectors.toList());
        assertThat(concatenation.size()).isEqualTo(list1.size() + list2.size() + list3.size());
        assertThat(concatenation.stream()).contains(
                "item1", "item2", "item3",
                "item4", "item5", "item6",
                "item7", "item8", "item9");
        assertThat(list1.size()).isEqualTo(3);
        assertThat(list1.stream()).contains("item1", "item2", "item3");
        assertThat(list2.size()).isEqualTo(3);
        assertThat(list2.stream()).contains("item4", "item5", "item6");
        assertThat(list3.size()).isEqualTo(3);
        assertThat(list3.stream()).contains("item7", "item8", "item9");
    }
}

