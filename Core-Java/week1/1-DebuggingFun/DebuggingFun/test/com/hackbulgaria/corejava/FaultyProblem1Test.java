package com.hackbulgaria.corejava;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class FaultyProblem1Test {

    private FaultyProblem1 faultyProgram;

    @Before
    public void setUp(){
        this.faultyProgram = new FaultyProblem1();
    }
    
    @Test
    public void test() {
        assertEquals(1, faultyProgram.getLargestPalindrome(2));
        assertEquals(535, faultyProgram.getLargestPalindrome(544));
        assertEquals(121, faultyProgram.getLargestPalindrome(126));
        assertEquals(898, faultyProgram.getLargestPalindrome(908));
    }
}