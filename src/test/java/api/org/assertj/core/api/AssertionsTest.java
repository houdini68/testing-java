package api.org.assertj.core.api;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

import static api.org.assertj.core.api.Race.*;
import static org.assertj.core.api.Assertions.*;

public class AssertionsTest {

    private TolkienCharacter frodo;
    private TolkienCharacter sauron;
    private TolkienCharacter sam;
    private TolkienCharacter boromir;
    private TolkienCharacter legolas;
    private TolkienCharacter aragorn;
    private List<TolkienCharacter> fellowshipOfTheRing;

    @Before
    public void setUp() throws Exception {
        frodo = new TolkienCharacter("Frodo", 32, Hobbit);
        sauron = new TolkienCharacter("Sauron", 33, Elf);
        sam = new TolkienCharacter("Sam", 38, Hobbit);
        boromir = new TolkienCharacter("Boromir", 37, Man);
        legolas = new TolkienCharacter("Legolas", 1000, Elf);
        aragorn = new TolkienCharacter("Aragorn", 1000, Elf);
        fellowshipOfTheRing = Arrays.asList(frodo, sam, boromir, legolas, aragorn);
    }

    @Test
    public void assertThatTest() {

        assertThat(frodo.getName()).isEqualTo("Frodo");

        assertThat(frodo).isNotEqualTo(sauron);

        assertThat(frodo.getName()).startsWith("Fro")
                .endsWith("do")
                .isEqualToIgnoringCase("frodo");

        assertThat(fellowshipOfTheRing).hasSize(5)
                .contains(frodo, sam)
                .doesNotContain(sauron); // sauron 

        assertThat(frodo.getAge())
                .as("check %s's age", frodo.getName()) // custom assert failure message
                .isEqualTo(32);

        assertThat(fellowshipOfTheRing)
                .extracting(TolkienCharacter::getName)
                .doesNotContain("Sauron", "Elrond"); //

        assertThat(fellowshipOfTheRing)
                .extracting("name", "age", "race.name")
                .contains(tuple("Boromir", 37, "Man"),
                        tuple("Sam", 38, "Hobbit"),
                        tuple("Legolas", 1000, "Elf"));

        assertThat(fellowshipOfTheRing)
                .filteredOn(character -> character.getName().contains("o"))
                .containsOnly(aragorn, frodo, legolas, boromir);

        assertThat(fellowshipOfTheRing)
                .filteredOn(character -> character.getName().contains("g"))
                .containsOnly(aragorn, legolas);

        assertThat(fellowshipOfTheRing)
                .filteredOn(character -> character.getName().contains("o"))
                .containsOnly(aragorn, frodo, legolas, boromir)
                .extracting(character -> character.getRace())
                .contains(Hobbit, Elf, Man);
    }

    @Test
    public void assertThatThrownByTest() {
        assertThatThrownBy(() -> {
            throw new Exception("boom!");
        })
                .hasMessage("boom!");
    }

    @Test
    public void catchTrowableTest() {
        Throwable thrown = catchThrowable(() -> {
            throw new Exception("boom!");
        });
        assertThat(thrown).hasMessageContaining("boom");
    }
}

enum Race {
    Hobbit, Elf, Man
}

class TolkienCharacter {
    String name;
    int age;
    Race race;

    TolkienCharacter(String name, int age, Race race) {
        this.name = name;
        this.age = age;
        this.race = race;
    }

    String getName() {
        return name;
    }

    void setName(String name) {
        this.name = name;
    }

    int getAge() {
        return age;
    }

    void setAge(int age) {
        this.age = age;
    }

    Race getRace() {
        return race;
    }

    void setRace(Race race) {
        this.race = race;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        TolkienCharacter character = (TolkienCharacter) o;
        return age == character.age && name.equals(character.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }

    @Override
    public String toString() {
        return "TolkienCharacter{" + "name='" + name + '\'' + ", age=" + age + ", race=" + race + '}';
    }
}