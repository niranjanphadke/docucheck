package org.junit.jupiter.api;

/**
 * Minimal subset of JUnit's {@code Assertions} used for simple tests.
 */
public final class Assertions {

    private Assertions() {
    }

    public static void assertTrue(boolean condition) {
        if (!condition) {
            throw new AssertionError("Assertion failed");
        }
    }
}
