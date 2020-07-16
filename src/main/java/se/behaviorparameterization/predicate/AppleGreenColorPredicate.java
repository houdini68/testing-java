package se.behaviorparameterization.predicate;

import se.behaviorparameterization.Apple;

import static se.behaviorparameterization.Color.GREEN;

public class AppleGreenColorPredicate implements ApplePredicate {

    @Override
    public boolean test(Apple apple) {
        return GREEN.equals(apple.getColor());
    }
}
