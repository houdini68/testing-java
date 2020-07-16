package se.behaviorparameterization.filter;

import se.behaviorparameterization.Apple;
import se.behaviorparameterization.Color;
import se.behaviorparameterization.predicate.ApplePredicate;

import java.util.ArrayList;
import java.util.List;

import static se.behaviorparameterization.Color.GREEN;

public class FilterApple {

    public List<Apple> filterGreenApplesAttempt1(List<Apple> inventory) {
        List<Apple> result = new ArrayList<>();
        for (Apple apple : inventory) { // foreach loop - imperative code
            if (GREEN.equals(apple.getColor())) { // GREEN is hardcoded
                result.add(apple);
            }
        }
        return result;
    }

    public List<Apple> filterApplesByColorAttempt2(List<Apple> inventory,
                                                   Color color) {
        List<Apple> result = new ArrayList<>();
        for (Apple apple : inventory) { // if more filters have to be created the loop is duplicated
            if (apple.getColor().equals(color)) { // color is a parameter
                result.add(apple);
            }
        }
        return result;
    }

    public List<Apple> filterApplesByWeightAttempt2(List<Apple> inventory,
                                                    int weight) {
        List<Apple> result = new ArrayList<>();
        for (Apple apple : inventory) { // if more filters have to be created the loop is duplicated
            if (apple.getWeight() > weight) { // weight is a parameter
                result.add(apple);
            }
        }
        return result;
    }

    public List<Apple> filterApplesByColorOrWeightAttempt3(List<Apple> inventory,
                                                           Color color,
                                                           int weight,
                                                           boolean flag) {
        List<Apple> result = new ArrayList<>();
        for (Apple apple : inventory) {
            if ((flag && apple.getColor().equals(color))
                    || (!flag && apple.getWeight() > weight)) { // UGLY/HORRIBLE/DON'T DO THIS!!!
                result.add(apple);
            }
        }
        return result;
    }

    public List<Apple> filterApplesByPredicateAttempt4(List<Apple> inventory,
                                                       ApplePredicate p) {
        List<Apple> result = new ArrayList<>();
        for (Apple apple : inventory) {
            if (p.test(apple)) {
                result.add(apple);
            }
        }
        return result;
    }
}
