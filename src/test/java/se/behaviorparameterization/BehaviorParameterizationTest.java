package se.behaviorparameterization;

import com.google.common.collect.ImmutableList;
import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static se.behaviorparameterization.Color.GREEN;
import static se.behaviorparameterization.Color.RED;

public class BehaviorParameterizationTest {

    List<Apple> apples;

    Apple green;
    Apple red;
    FilterApple filterApple;

    @Before
    public void setUp() {
        green = new Apple(GREEN);
        red = new Apple(RED);
        apples = ImmutableList.of(green, red);
        filterApple = new FilterApple();
    }

    @Test
    public void filterGreenApplesFirstAttempt() {
        List<Apple> result = filterApple.filterGreenApplesFirstAttempt(apples);
        Assertions.assertThat(result).contains(green);
        Assertions.assertThat(result).doesNotContain(red);
    }

}

