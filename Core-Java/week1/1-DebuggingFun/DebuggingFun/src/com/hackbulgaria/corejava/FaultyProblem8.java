package com.hackbulgaria.corejava;

public class FaultyProblem8 {
    
    public int getNumberOfDigits(int n) {
        int digits = 0;
        
        while(n != 0) {
            digits++;
            n /= 10;
        }
        
        return digits;
    }
}