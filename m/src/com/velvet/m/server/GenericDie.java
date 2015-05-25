package com.velvet.m.server;

import java.util.Arrays;

/**
 * A generic implementation of the Die interface, allowing for any kind object
 * to be represent the sides of the die.
 * <p>
 * Rolling a GenericDie will randomly pick one side, where each side has an
 * an equal chance to be rolled.
 * <p>
 * As long as the objects used to represent the sides of a GenericDie are
 * immutable, then the GenericDie is also immutable and thread-safe.
 */
public final class GenericDie<T extends Comparable<T>> implements Die<T> {
    private T[] mSides = null;

    /**
     * Constructs a die with a side for each given object.
     *
     * @param sides the array containing each side of the die
     */
    @SafeVarargs
    public GenericDie(T... sides) {
        // Make a copy of sides, so that it can be kept immutable
        mSides = Arrays.copyOf(sides, sides.length);
    }

    /**
     * Returns a randomly selected side on this die.
     *
     * @return a side on this die
     */
    @Override
    public T roll() {
        final int index = (int)(Math.random() * mSides.length);
        return mSides[index];
    }

    /**
     * Returns the number of sides that can be rolled with this die.
     *
     * @return the number of sides on this die
     */
    @Override
    public int getNumSides() {
        return mSides.length;
    }

    /**
     * Returns the best side of this die.
     *
     * @return the best side of this die
     */
    @Override
    public T getBestSide() {
        T best = mSides[0];

        for (T side : mSides) {
            best = best.compareTo(side) > 0 ? best : side;
        }

        return best;
    }

    /**
     * Returns the worst side of this die.
     *
     * @return the worst side of this die
     */
    @Override
    public T getWorstSide() {
        T worst = mSides[0];

        for (T side : mSides) {
            worst = worst.compareTo(side) < 0 ? worst : side;
        }

        return worst;
    }

    /**
     * Returns a string representation of this die.
     * Containing each available side.
     *
     * @return a string representation of this die
     */
    @Override
    public String toString() {
        return Arrays.toString(mSides);
    }

    /**
     * Compares the specified object with this die for equality. Returns true
     * only if the specified object is also a GenericDie and they contain the
     * same sides.
     *
     * @param obj the object to be compared for equality with this die
     * @return true if the specified object is equal to this die
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if ((obj == null) || (obj.getClass() != this.getClass())) return false;

        GenericDie die = (GenericDie)obj;
        return Arrays.equals(mSides, die.mSides);
    }

    /**
     * Returns the hash code value for this die.
     *
     * @return the hash code value for this die
     */
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 31 * hash + Arrays.hashCode(mSides);
        return hash;
    }

}
