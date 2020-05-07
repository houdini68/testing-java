package springframework;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = Config.class)
public class HelloSpringTest {
    @Autowired
    Hello helloWorld;

    @Test
    public void givenHelloWorld_returnStringHello() {
        Assertions.assertThat(helloWorld.sayHello()).isEqualTo("Hello world!");
    }
}

class Hello {
    String sayHello() {
        return "Hello world!";
    }
}

class Config {
    @Bean
    public Hello helloBean() {
        return new Hello();
    }
}