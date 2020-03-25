package api.com.google.common.collect;

import com.google.common.base.Predicate;
import com.google.common.collect.FluentIterable;
import com.google.common.collect.Lists;
import org.junit.Before;
import org.junit.Test;

import java.util.List;
import java.util.Objects;

import static org.assertj.core.api.Assertions.assertThat;

public class FluentIterableTest {
    Person person1;
    Person person2;
    Person person3;
    Person person4;
    List<Person> personList;

    @Before
    public void setUp() throws Exception {
        person1 = new Person("Wilma", "Flintstone", 30, "F", "1");
        person2 = new Person("Fred", "Flintstone", 32, "M", "2");
        person3 = new Person("Betty", "Rubble", 31, "F", "3");
        person4 = new Person("Barney", "Rubble", 33, "M", "4");
        personList = Lists.newArrayList(person1, person2, person3, person4);
    }

    @Test
    public void when_fluent_iterable_on_age_expect_2_items() {
        Iterable<Person> personsFilteredByAge =
                FluentIterable
                        .from(personList)
                        .filter(input -> input.getAge() > 31);
        assertThat(personsFilteredByAge).hasSize(2);
    }

    class Person {
        private String firstName;
        private String lastName;
        private int age;
        private String sex;
        private String nrn;

        private Person() {
        }

        private Person(String firstName, String lastName, int age, String sex, String nrn) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.age = age;
            this.sex = sex;
            this.nrn = nrn;
        }

        private String getFirstName() {
            return firstName;
        }

        private void setFirstName(String firstName) {
            this.firstName = firstName;
        }

        private String getLastName() {
            return lastName;
        }

        private void setLastName(String lastName) {
            this.lastName = lastName;
        }

        private int getAge() {
            return age;
        }

        private void setAge(int age) {
            this.age = age;
        }

        private String getSex() {
            return sex;
        }

        private void setSex(String sex) {
            this.sex = sex;
        }

        private String getNrn() {
            return nrn;
        }

        private void setNrn(String nrn) {
            this.nrn = nrn;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }
            Person person = (Person) o;
            return nrn.equals(person.nrn);
        }

        @Override
        public int hashCode() {
            return Objects.hash(firstName, lastName, sex, nrn);
        }

        @Override
        public String toString() {
            return "Person{" + "firstName='" + firstName + '\'' + ", lastName='" + lastName + '\'' + ", age=" + age + ", sex='" + sex + '\'' + ", nrn='" + nrn + '\'' + '}';
        }
    }

}
