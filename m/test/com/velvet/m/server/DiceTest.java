package com.velvet.m.server;

import org.junit.Test;

import static org.junit.Assert.*;

public class DiceTest {
    @Test
    public void testDie6_rollValueRangeIsBetween1To6() {
        int numChecks = 100;
        for (int i = 0; i < numChecks; i++) {
            int value = Dice.die6().roll();
            if (value < 1 || value > 6) {
                fail("Die6 rolled invalid value: " + value);
            }
        }
    }

    @Test
    public void testDie6_sameObjectIsReused() {
        assertTrue(Dice.die6() == Dice.die6());
    }
}
