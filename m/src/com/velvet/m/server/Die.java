package com.velvet.m.server;

/**
 * A die that has a number of different sides. The user of this interface has
 * control over which object is represented on each side.
 * <p>
 * Rolling a Die will return one of the sides of the die. Every side of a Die
 * can be compared to each other.
 */
public interface Die<T extends Comparable<T>> {
    /**
     * Returns a side on this die.
     *
     * @return a side on this die
     */
    public T roll();

    /**
     * Returns the number of sides that can be rolled with this die.
     *
     * @return the number of sides on this die
     */
    public int getNumSides();

    /**
     * Returns the best side of this die.
     *
     * @return the best side of this die
     */
    public T getBestSide();

    /**
     * Returns the worst side of this die.
     *
     * @return the worst side of this die
     */
    public T getWorstSide();

}
