package com.velvet.m.server;

import org.junit.Test;

import static org.junit.Assert.*;

public class GenericDieTest {
    static Integer[] sides = {1, 2, 3, 4};
    static GenericDie<Integer> die = new GenericDie<>(sides);
    static GenericDie<Integer> equalDie = new GenericDie<>(1, 2, 3, 4);
    static GenericDie<Integer> anotherDie = new GenericDie<>(2, 3, 4, 5);

    @Test
    public void testRoll_valueRange() {
        int numChecks = 100;
        for (int i = 0; i < numChecks; i++) {
            int value = die.roll();
            if (value < die.getWorstSide() || value > die.getBestSide()) {
                fail("Die6 rolled invalid value: " + value);
            }
        }
    }

    @Test
    public void testEquals_sameSidesDifferentInstancesEquals() {
        assertTrue(die.equals(equalDie));
    }

    @Test
    public void testEquals_differentSidesDontEquals() {
        assertFalse(die.equals(anotherDie));
    }

    @Test
    public void testHashCode_equalsHasSameHashCode() {
        assertTrue(die.hashCode() == equalDie.hashCode());
    }
}
