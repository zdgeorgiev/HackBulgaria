package com.hackbulgaria.corejava;

public class FaultyProblem5 {
    
    public static long kthFac(int k, int n) {
        long res = 1;
        long limit = n;
        long nextLimit = limit;
        
        for (long i = 2; i <= nextLimit; i++) {
            res *= i;
            
            if (i == limit && k > 0) {
                k--;
                nextLimit = res;
            }
        }
        
        return res;
    }   
}