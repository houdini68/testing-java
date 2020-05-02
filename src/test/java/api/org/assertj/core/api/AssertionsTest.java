package api.org.assertj.core.api;

import org.junit.Before;
import org.junit.Test;

import java.util.Objects;

import static org.assertj.core.api.Assertions.assertThat;

public class AssertionsTest {

    Character frodo;

    @Before
    public void setUp() throws Exception {
        frodo = new Character("Frodo");
    }

    @Test
    public void assertThatTest() {
        assertThat(frodo.getName()).isEqualTo("Frodo");
    }
}

class Character {
    String name;

    String getName() {
        return name;
    }

    Character(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Character character = (Character) o;
        return name.equals(character.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}