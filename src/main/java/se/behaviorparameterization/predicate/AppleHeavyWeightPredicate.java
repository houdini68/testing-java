package se.behaviorparameterization.predicate;

import se.behaviorparameterization.Apple;

public class AppleHeavyWeightPredicate implements ApplePredicate {

    @Override
    public boolean test(Apple apple) {
        return apple.getWeight() > 30;
    }
}