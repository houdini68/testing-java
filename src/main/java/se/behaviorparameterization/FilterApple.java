package se.behaviorparameterization;

import java.util.ArrayList;
import java.util.List;

import static se.behaviorparameterization.Color.GREEN;

public class FilterApple {

    public List<Apple> filterGreenApplesFirstAttempt(List<Apple> inventory) {
        List<Apple> result = new ArrayList<>();
        for (Apple apple : inventory) { // foreach loop - imperative code
            if (GREEN.equals(apple.getColor())) {
                result.add(apple);
            }
        }
        return result;
    }


}
