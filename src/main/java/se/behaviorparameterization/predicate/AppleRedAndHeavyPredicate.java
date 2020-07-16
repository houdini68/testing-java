package se.behaviorparameterization.predicate;

import se.behaviorparameterization.Apple;

import static se.behaviorparameterization.Color.RED;

public class AppleRedAndHeavyPredicate implements ApplePredicate {

    @Override
    public boolean test(Apple apple) {
        return RED.equals(apple.getColor())
                && apple.getWeight() > 30;
    }
}
