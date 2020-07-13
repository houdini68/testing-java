package se.behaviorparameterization;

import java.util.Objects;

class Apple {
    final Color color;
    final int weight;

    Apple(final Color color, final int weight) {
        this.color = color;
        this.weight = weight;
    }

    Color getColor() {
        return color;
    }

    public int getWeight() {
        return weight;
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
