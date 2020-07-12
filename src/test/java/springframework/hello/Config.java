package springframework.hello;

import org.springframework.context.annotation.Bean;

public class Config {
    @Bean
    public Hello helloBean() {
        return new Hello();
    }
}
