package com.hackbulgaria.corejava;

public class FaultyProblem3 {
    
    public String reverseEveryWordInString(String sentence){
        String[] words = sentence.split(" ");
        StringBuilder reversed = new StringBuilder();
        
        for (String word: words) {
            reversed.append(reverse(word) + " ");
        }
        
        return reversed.toString().trim();
    }

    private CharSequence reverse(String word) {
        return Utils.reverseMe(word);
    }
}