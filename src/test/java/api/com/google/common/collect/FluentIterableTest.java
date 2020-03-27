package api.com.google.common.collect;

import com.google.common.collect.FluentIterable;
import com.google.common.collect.Lists;
import model.Person;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class FluentIterableTest {
    Person person1;
    Person person2;
    Person person3;
    Person person4;
    List<Person> personList;

    @Before
    public void setUp() {
        person1 = new Person("Wilma", "Flintstone", 30, "F", "1");
        person2 = new Person("Fred", "Flintstone", 32, "M", "2");
        person3 = new Person("Betty", "Rubble", 31, "F", "3");
        person4 = new Person("Barney", "Rubble", 33, "M", "4");
        personList = Lists.newArrayList(person1, person2, person3, person4);
    }

    @Test
    public void when_fluent_iterable_on_age_expect_2_items() {
        Iterable<Person> personsFilteredByAge
                = FluentIterable
                        .from(personList)
                        .filter(input -> input.getAge() > 31);
        assertThat(personsFilteredByAge).hasSize(2);
    }
}
