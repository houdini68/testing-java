package se.behaviorparameterization;

import com.google.common.collect.ImmutableList;
import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;
import se.behaviorparameterization.filter.FilterApple;

import java.util.List;

import static se.behaviorparameterization.Color.GREEN;
import static se.behaviorparameterization.Color.RED;

public class AppleTest {

    Apple greenApple;
    Apple redApple;

    @Before
    public void setUp() {
        greenApple = new Apple(GREEN, 20);
        redApple = new Apple(RED, 35);
    }

    @Test
    public void printApple() {
        Assertions.assertThat(greenApple.printApple()).isEqualTo("An apple of 20g");
        Assertions.assertThat(redApple.printApple()).isEqualTo("An apple of 35g");
    }

    @Test
    public void prettyPrintApple() {
        Assertions.assertThat(greenApple.prettyPrintApple()).isEqualTo("A light GREEN apple");
        Assertions.assertThat(redApple.prettyPrintApple()).isEqualTo("A heavy RED apple");
    }

}