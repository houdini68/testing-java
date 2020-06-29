package api.java.lang;

import org.junit.Test;

public class BoxingUnboxingTest {

    @Test (expected = NullPointerException.class)
    public void givenIntegerObjectAssignedNull_whenUnboxingToPrimitive_ThenNullPointerException() {
        Integer integerObject = null;
        int integerPrimitive = integerObject; // a primitive cannot be assigned a null value
    }
}
