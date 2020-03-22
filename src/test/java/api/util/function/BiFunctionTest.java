package api.util.function;

import org.junit.Test;

import java.util.Objects;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;

import static org.assertj.core.api.Assertions.assertThat;

public class BiFunctionTest {

    /**
     * A Consumer can mutate a reference to an object.
     * A consummer does consume two objects.
     */

    @Test
    public void biConsumerMuteTwoObjectsPerson() {
        BiConsumer<Person, Person> biConsumer = (p1, p2) -> {
            p1.setName("p1");
            p2.setName("p2");
        };
        Person p1 = new Person(); // no name
        Person p2 = new Person(); // no name
        biConsumer.accept(p1, p2); // p1 is mutated and p2 are mutated
        assertThat(p1).isEqualTo(new Person("p1"));
        assertThat(p2).isEqualTo(new Person("p2"));
    }

    @Test
    public void biFunctionSumIntegers() {
        BiFunction<Integer, Integer, Integer> biFunction = (i1, i2) -> i1 + i2;
        assertThat(biFunction.apply(1, 2)).isEqualTo(3);
    }

    class Person {
        String name;

        public Person() {
        }

        public Person(String name) {
            this.name = name;
        }

        String getName() {
            return name;
        }

        void setName(String name) {
            this.name = name;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Person person = (Person) o;
            return name.equals(person.name);
        }

        @Override
        public int hashCode() {
            return Objects.hash(name);
        }
    }
}
