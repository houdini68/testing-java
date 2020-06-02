package api.java.util.stream;

import org.junit.Test;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.Arrays.asList;
import static org.junit.Assert.assertEquals;

public class FlatMapTest {

    @Test
    public void convertStringToUpperCaseStreams() {
        List<String> collected = Stream.of("a", "b", "hello") // Stream of String
                .map(String::toUpperCase) // Returns a stream consisting of the results of applying the given function to the elements of this stream.
                .collect(Collectors.toList());
        assertEquals(asList("A", "B", "HELLO"), collected);
    }

    @Test
    public void testflatMap() throws Exception {
        List<Integer> together = Stream.of(asList(1, 2), asList(3, 4)) // Stream of List<Integer>
                .flatMap(List::stream)
                .map(integer -> integer + 1)
                .collect(Collectors.toList());
        assertEquals(asList(2, 3, 4, 5), together);
    }
}
