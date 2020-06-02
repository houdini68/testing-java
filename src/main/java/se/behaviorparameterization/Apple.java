package se.behaviorparameterization;

import java.util.Objects;

class Apple {
    Color color;

    Apple(Color color) {
        this.color = color;
    }

    Color getColor() {
        return color;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Apple apple = (Apple) o;
        return color == apple.color;
    }

    @Override
    public int hashCode() {
        return Objects.hash(color);
    }
}
