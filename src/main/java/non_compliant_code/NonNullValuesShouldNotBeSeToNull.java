package non_compliant_code;

import javax.annotation.Nonnull;

/**
 * The Nonnull annotation is used by the code analysis.
 */
public class NonNullValuesShouldNotBeSeToNull {

    @Nonnull
    private String primary;
    private String secondary;

    public NonNullValuesShouldNotBeSeToNull(String color) {
        if (color != null) {
            secondary = null;
        }
        primary = color; // Non compliant; "primary" is Nonnull but could be set to null here
    }

    public NonNullValuesShouldNotBeSeToNull() {
        // Noncompliant; "primary" Nonnull" but is not initialized in this constructor
    }

    @Nonnull
    public String indirectMix() {
        String mix = null;
        return mix; // Noncompliant; return value is Nonnull, but null is returned.
    }
}