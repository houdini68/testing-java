package api.com.google.common.collect;

import com.google.common.base.Joiner;
import com.google.common.collect.FluentIterable;
import com.google.common.collect.Lists;
import model.PersonV1;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class FluentIterableTest {
    PersonV1 person1;
    PersonV1 person2;
    PersonV1 person3;
    PersonV1 person4;
    List<PersonV1> persons;

    @Before
    public void setUp() {
        person1 = new PersonV1("Wilma", "Flintstone", 30, "F", "1");
        person3 = new PersonV1("Betty", "Rubble", 31, "F", "3");
        person2 = new PersonV1("Fred", "Flintstone", 32, "M", "2");
        person4 = new PersonV1("Barney", "Rubble", 33, "M", "4");
        persons = Lists.newArrayList(person1, person2, person3, person4);
    }

    @Test
    public void givenFluentIterableOnPerson_whenFilterOnAge_thenExpect2Items() {
        Iterable<PersonV1> personsFilteredByAge
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
                        .transform(input -> Joiner.on('#')
                                                .join(input.getLastName(), input.getFirstName(), input.getAge()))
                        .toList();
        assertThat(transformedPersonList.get(1)).isEqualTo("Flintstone#Fred#32");
    }
}
