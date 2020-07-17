package se.behaviorparameterization;

import com.google.common.collect.ImmutableList;
import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;
import se.behaviorparameterization.filter.FilterApple;
import se.behaviorparameterization.predicate.AppleGreenColorPredicate;
import se.behaviorparameterization.predicate.AppleHeavyWeightPredicate;
import se.behaviorparameterization.predicate.ApplePredicate;
import se.behaviorparameterization.predicate.AppleRedAndHeavyPredicate;

import java.util.List;

import static se.behaviorparameterization.Color.GREEN;
import static se.behaviorparameterization.Color.RED;

public class FilterAppleTest {

    List<Apple> apples;

    Apple greenApple;
    Apple redApple;
    FilterApple filterApple;

    @Before
    public void setUp() {
        greenApple = new Apple(GREEN, 20);
        redApple = new Apple(RED, 35);
        apples = ImmutableList.of(greenApple, redApple);
        filterApple = new FilterApple();
    }

    @Test
    public void filterGreenApplesAttempt1() {
        List<Apple> result = filterApple.filterGreenApplesAttempt1(apples);
        Assertions.assertThat(result).contains(greenApple);
        Assertions.assertThat(result).doesNotContain(redApple);
    }

    @Test
    public void filterApplesByColorAttempt2() {
        List<Apple> result = filterApple.filterApplesByColorAttempt2(apples, GREEN);
        Assertions.assertThat(result).contains(greenApple);
        Assertions.assertThat(result).doesNotContain(redApple);
    }

    @Test
    public void filterApplesByWeightAttempt2() {
        List<Apple> result = filterApple.filterApplesByWeightAttempt2(apples, 30);
        Assertions.assertThat(result).doesNotContain(greenApple);
        Assertions.assertThat(result).contains(redApple);
    }

    @Test
    public void filterApplesByColorOrWeightAttempt3() {
        List<Apple> result = filterApple.filterApplesByColorOrWeightAttempt3(apples, GREEN, -1, true);
        Assertions.assertThat(result).contains(greenApple);
        Assertions.assertThat(result).doesNotContain(redApple);
        result = filterApple.filterApplesByColorOrWeightAttempt3(apples, GREEN, 30, false); // UGLY/HORRIBLE/DON'T DO THIS!!!
        Assertions.assertThat(result).doesNotContain(greenApple);
        Assertions.assertThat(result).contains(redApple);
    }

    @Test
    public void filterApplesByPredicateAttempt4() {
        List<Apple> result = filterApple.filterApplesByPredicate(apples, new AppleGreenColorPredicate()); // behavior is passed
        Assertions.assertThat(result).contains(greenApple);
        Assertions.assertThat(result).doesNotContain(redApple);
        result = filterApple.filterApplesByPredicate(apples, new AppleHeavyWeightPredicate()); // behavior is passed
        Assertions.assertThat(result).doesNotContain(greenApple);
        Assertions.assertThat(result).contains(redApple);
        result = filterApple.filterApplesByPredicate(apples, new AppleRedAndHeavyPredicate()); // behavior is passed
        Assertions.assertThat(result).doesNotContain(greenApple);
        Assertions.assertThat(result).contains(redApple);
    }

    @Test
    public void filterApplesByPredicateAnonymousClassAttempt5() {
        List<Apple> result = filterApple.filterApplesByPredicate(apples, new ApplePredicate() {
            @Override
            public boolean test(Apple apple) {
                return RED.equals(apple.getColor());
            }
        }); // behavior is passed
        Assertions.assertThat(result).doesNotContain(greenApple);
        Assertions.assertThat(result).contains(redApple);
    }
}