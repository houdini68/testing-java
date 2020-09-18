package api.java.util.optional.absenceofvaluebynull;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class AbsenceOfValueByNullTest {

    private static final String UNKNOWN = "Unknown";

    @Test(expected = NullPointerException.class)
    public void givenNullObjects_thenNullPointerException() {
        Person person = null;
        assertThat(person.getCar().getInsurance().getName()).isEqualTo("not tested because of null!");
    }

    @Test
    public void givenCarIsNullAndGetInsuranceName_whenDefensiveChecking_thenOK() {
        Person person = new Person();
        assertThat(person.getCarInsuranceName()).isEqualTo(UNKNOWN);
    }

    @Test
    public void givenPersonIsNull_whenDefensiveCheckingAndAvoidNestedBlocks_thenOK() {
        Person person = new Person();
        assertThat(person.getCarInsuranceNameAvoidNestedBlocks()).isEqualTo(UNKNOWN);
    }
}
