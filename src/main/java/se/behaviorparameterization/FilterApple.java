package se.behaviorparameterization;

import java.util.ArrayList;
import java.util.List;

import static se.behaviorparameterization.Color.GREEN;

public class FilterApple {

    public static List<Apple> filterApplesByColorAttempt2(List<Apple> inventory,
                                                          Color color) {
        List<Apple> result = new ArrayList<>();
        for (Apple apple : inventory) {
            if (apple.getColor().equals(color)) { // color is a parameter
                result.add(apple);
            }
        }
        return result;
    }

    public static List<Apple> filterApplesByWeightAttempt2(List<Apple> inventory,
                                                           int weight) {
        List<Apple> result = new ArrayList<>();
        for (Apple apple : inventory) {
            if (apple.getWeight() > weight) {
                result.add(apple);
            }
        }
        return result;
    }

    public List<Apple> filterGreenApplesAttempt1(List<Apple> inventory) {
        List<Apple> result = new ArrayList<>();
        for (Apple apple : inventory) { // foreach loop - imperative code
            if (GREEN.equals(apple.getColor())) { // GREEN is hardcoded
                result.add(apple);
            }
        }
        return result;
    }
}
