package dp.singleton;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class EnumSingletonTest {

    @Test
    public void givenEnumSingleton_thenOK() {
        EnumSingleton enumSingleton1 = EnumSingleton.INSTANCE.getInstance();
        EnumSingleton enumSingleton2 = EnumSingleton.INSTANCE.getInstance();
        enumSingleton2.setInfo("New enum info");
        assertThat(enumSingleton1 == enumSingleton2).isTrue();
        assertThat(enumSingleton1.getInfo()).isEqualTo(enumSingleton2.getInfo());
    }
}
