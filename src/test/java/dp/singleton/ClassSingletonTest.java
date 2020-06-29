package dp.singleton;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.*;

public class ClassSingletonTest {
    @Test
    public void givenClassSingleton_thenOK() {
        ClassSingleton classSingleton1 = ClassSingleton.getInstance();
        ClassSingleton classSingleton2 = ClassSingleton.getInstance();
        classSingleton2.setInfo("New class info");

        assertThat(classSingleton1 == classSingleton2).isTrue();
        assertThat(classSingleton1.getInfo()).isEqualTo(classSingleton2.getInfo());
    }
}