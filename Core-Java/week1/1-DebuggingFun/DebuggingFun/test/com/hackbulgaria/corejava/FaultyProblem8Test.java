package com.hackbulgaria.corejava;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class FaultyProblem8Test {
    
    FaultyProblem8 f = new FaultyProblem8();
    
    @Test
    public void testNumberDigits() {
        assertEquals(5, f.getNumberOfDigits(21122));
        assertEquals(1, f.getNumberOfDigits(-1));
    }
}