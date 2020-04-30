package api.java.util.function;

import model.PersonV1;
import org.junit.Test;

import java.util.Objects;
import java.util.function.BiConsumer;

import static org.assertj.core.api.Assertions.assertThat;


public class BiConsumerTest {

    /**
     * A Consumer can mutate a reference to an object.
     * A consummer does consume two objects and returns nothing.
     */

    @Test
    public void givenBiConsumer_whenObjectsPersonMuted_thenObjectsPersonMuted() {
        BiConsumer<PersonV1, PersonV1> biConsumer = (p1, p2) -> {
            p1.setFirstName("fn1"); p1.setLastName("ln1"); p1.setAge(25); p1.setSex("m"); p1.setNrn("nrn1");
            p2.setFirstName("fn2"); p2.setLastName("ln2"); p2.setAge(30); p2.setSex("f"); p2.setNrn("nrn2");
        };
        PersonV1 p1 = new PersonV1(); // empty object;
        PersonV1 p2 = new PersonV1(); // empty object;
        biConsumer.accept(p1, p2); // p1 is mutated and p2 are mutated
        assertThat(p1).isEqualTo(new PersonV1("fn1", "ln1", 25, "m", "nrn1"));
        assertThat(p2).isEqualTo(new PersonV1("fn2", "ln2", 30, "f", "nrn2"));
    }
}
