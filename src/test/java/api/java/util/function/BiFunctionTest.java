package api.java.util.function;

import org.junit.Test;

import java.util.Objects;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;

import static org.assertj.core.api.Assertions.assertThat;

public class BiFunctionTest {

    @Test
    public void biFunctionSumIntegers() {
        // Look at the syntax of a BiFunction.
        // There are 3 parameters.
        // 2 input parameters and 1 output parameter.
        BiFunction<Integer, Integer, Integer> biFunction = (i1, i2) -> i1 + i2;
        assertThat(biFunction.apply(1, 2)).isEqualTo(3);
    }

//    class Person {
//        String name;
//
//        public Person() {
//        }
//
//        public Person(String name) {
//            this.name = name;
//        }
//
//        String getName() {
//            return name;
//        }
//
//        void setName(String name) {
//            this.name = name;
//        }
//
//        @Override
//        public boolean equals(Object o) {
//            if (this == o) return true;
//            if (o == null || getClass() != o.getClass()) return false;
//            Person person = (Person) o;
//            return name.equals(person.name);
//        }
//
//        @Override
//        public int hashCode() {
//            return Objects.hash(name);
//        }
//    }
}
