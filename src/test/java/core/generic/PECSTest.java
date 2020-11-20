package core.generic;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class PECSTest {

    @Test
    public void producerExtends() {
        double sum = readFromList(listOfIntegers()) + readFromList(listOfDoubles());
        // We don't make usage of a different method to read a List<Integer> and a List<Double>!
        assertThat(sum).isEqualTo(30);
    }

    int readFromList(List<? extends Number> numbers) {

        // You can't add any object to List<? extends T> because you can't guarantee what kind of List it is really pointing to,
        // so you can't guarantee that the object is allowed in that List.
        // The only "guarantee" is that you can only read from it and you'll get a T or subclass of T.

        // YOU READ FROM THE GENERIC LIST! NOTHING ELSE!
        // numbers.add(Integer.valueOf(0)); // Required type: capture of ? extends Number. You can't add an Integer.

        int sum = 0;

        for (Number number : numbers) {
            sum += number.intValue();
        }

        return sum;
    }

    List<Integer> listOfIntegers() {
        return Arrays.asList(1, 2, 3, 4, 5);
    }

    List<Double> listOfDoubles() {
        return Arrays.asList(1.0, 2.0, 3.0, 4.0, 5.0);
    }
}
