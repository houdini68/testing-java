package api.java.util.optional;

import api.java.util.optional.absenceofvaluebyopt.Car;
import api.java.util.optional.absenceofvaluebyopt.Insurance;
import org.junit.Test;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

public class OptionalTest {

    private static final String INSURANCE_NAME = "insurance_name";

    @Test
    public void givenEmptyOptional_whenEmpty_thenIsNotPresent() {
        Optional<Car> optCar = Optional.empty();
        assertThat(optCar.isPresent()).isFalse();
    }

    @Test
    public void givenCar_whenOptionalOf_thenCarIsPresent() {
        Car car = new Car();
        Optional<Car> anotherCar = Optional.of(car);
        assertThat(anotherCar.isPresent()).isTrue();
    }

    @Test(expected = NullPointerException.class)
    public void givenNullCar_whenOptionalOf_thenNPE() {
        Car car = null;
        Optional<Car> anotherCar = Optional.of(car);
        assertThat(anotherCar.isPresent()).isTrue();
    }

    @Test
    public void givenNullCar_whenOptionalOfNullable_thenCarIsNotPresent() {
        Car car = null;
        Optional<Car> anotherCar = Optional.ofNullable(car);
        assertThat(anotherCar.isPresent()).isFalse();
    }

    @Test
    public void givenInsurance_whenExtractingOldWay_thenOK() {
        Insurance insurance = new Insurance(INSURANCE_NAME);
        String name = null;
        if (insurance != null) {
            name = insurance.getName();
        }
        assertThat(name).isEqualTo(INSURANCE_NAME);
    }

    @Test
    public void givenOptionalInsurance_whenExtractingNewWayUsingMap_thenOK() {
        Insurance insurance = new Insurance(INSURANCE_NAME);
        Optional<Insurance> optInsurance = Optional.ofNullable(insurance);
        Optional<String> nameLambda = optInsurance.map(i -> i.getName()); // map using a lambda
        if (nameLambda.isPresent()) {
            assertThat(nameLambda.get()).isEqualTo(INSURANCE_NAME);
        }
        Optional<String> nameMethodRef = optInsurance.map(Insurance::getName); // map using a method reference returning a string
        if (nameMethodRef.isPresent()) {
            assertThat(nameMethodRef.get()).isEqualTo(INSURANCE_NAME);
        }
        insurance = null;
        optInsurance = Optional.ofNullable(insurance);
        nameLambda = optInsurance.map(i1 -> i1.getName()); // map using a lambda
        assertThat(nameLambda.isPresent()).isFalse();
    }

//    @Test
//    public void Chaining_Optional_objects_with_flatMap() {
//        Person person = new Person();
//        Optional<Person> optPerson = Optional.of(person);
//        Optional<String> name =
//                optPerson.map(Person::getCar)
//                        .map(Car::getInsurance)
//                        .map(Insurance::getName);
//    }
}


