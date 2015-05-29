package com.velvet.m.server;

/**
 * This class contains a static factory that provides dice.
 * <p>
 * Each die is immutable and thread-safe. This class uses a cache so that common
 * dice could be reused without constructing new ones.
 */
public final class Dice {
    private static Die<Integer> sDie6 = null;

    // Private constructor to prevent instantiation
    private Dice() {}

    /**
    * Obtains an instance of a six sided dice.
    * <p>
    * This returns a Die<Integer> with six sides numbered from one to six.
    * The returned die is thread-safe and immutable.
    *
    * @return a six sided die, not null
    */
    public static Die<Integer> die6() {
        if (sDie6 == null) {
            synchronized (Dice.class) {
                if (sDie6 == null) {
                    sDie6 = new GenericDie<>(1, 2, 3, 4, 5, 6);
                }
            }
        }

        return sDie6;
    }

}
