package com.hackbulgaria.corejava;

public class FaultyProblem4 {
    public static boolean areEqual(Integer e, Integer k) {
        return e.compareTo(k) == 0 ? true : false;
    }

    public static boolean areEqual(float a, float b) {
        return Math.abs(a - b) < 0.01 ? true : false;
    }

    /**
     * Return whether there is an index <b>i</b>,
     * such that a[i,a.length] equals b[i, a.length];
     * @param a
     * @param b
     * @return
     */
    public static boolean haveEqualSubstrings(String a, String b) {
        if(a.compareTo(b) == 0)
            return true;
        
        String bCpy = b;
        for (int i = 0; i < b.length() - a.length(); i++) {
            String substringB = bCpy.substring(i, a.length());
            if (a.equals(substringB)){
                return true;
            }
        }
        return false;
    }
}