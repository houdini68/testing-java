package se.behaviorparameterization;

import se.behaviorparameterization.formatter.AppleFancyFormatter;
import se.behaviorparameterization.formatter.AppleSimpleFormatter;

import java.util.Objects;

public class Apple {
    private final Color color;
    private final int weight;

    public Apple(final Color color, final int weight) {
        this.color = color;
        this.weight = weight;
    }

    public Color getColor() {
        return color;
    }

    public int getWeight() {
        return weight;
    }

    String printApple() {
        return new AppleSimpleFormatter().accept(this);
    }

    String prettyPrintApple() {
        return new AppleFancyFormatter().accept(this);
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final Apple apple = (Apple) o;
        return weight == apple.weight &&
                color == apple.color;
    }

    @Override
    public int hashCode() {
        return Objects.hash(color, weight);
    }

    @Override
    public String toString() {
        return "Apple{" +
                "color=" + color +
                ", weight=" + weight +
                '}';
    }
}
