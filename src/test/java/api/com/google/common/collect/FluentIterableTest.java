package api.com.google.common.collect;

import com.google.common.base.Joiner;
import com.google.common.collect.FluentIterable;
import com.google.common.collect.Lists;
import model.v1.Person;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class FluentIterableTest {
    Person person1;
    Person person2;
    Person person3;
    Person person4;
    List<Person> persons;

    @Before
    public void setUp() {
        person1 = new Person("Wilma", "Flintstone", 30, "F", "1");
        person3 = new Person("Betty", "Rubble", 31, "F", "3");
        person2 = new Person("Fred", "Flintstone", 32, "M", "2");
        person4 = new Person("Barney", "Rubble", 33, "M", "4");
        persons = Lists.newArrayList(person1, person2, person3, person4);
    }

    @Test
    public void givenFluentIterableOnPerson_whenFilterOnAge_thenExpect2Items() {
        Iterable<Person> personsFilteredByAge
                = FluentIterable
                .from(persons)
                .filter(input -> input.getAge() > 31);
        assertThat(personsFilteredByAge).hasSize(2);
    }

    @Test
    public void givenFuentIterableOnPersons_whenTransform_thenExpectListOfStrings() {
        List<String> transformedPersonList =
                FluentIterable
                        .from(persons)
                        .filter(p -> p.getFirstName().equals("Fred") && p.getLastName().equals("Flintstone"))
                        .transform(input -> Joiner.on('#')
                                .join(input.getLastName(), input.getFirstName(), input.getAge()))
                        .toList();
        assertThat(transformedPersonList.get(0)).isEqualTo("Flintstone#Fred#32");
    }
}
