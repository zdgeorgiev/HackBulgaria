package com.hackbulgaria.corejava;

import java.util.Arrays;
import java.util.Stack;

public class Problems2Impl implements Problems2 {

    @Override
    public boolean isOdd(int number) {
        return number % 2 == 0 ? false : true;
    }

    @Override
    public boolean isPrime(int number) {
        int sqrtNumber = (int) Math.sqrt(number);
        
        for(int i = 2; i <= sqrtNumber; i++) {
            if(number % i == 0)
                return false;
        }
        
        return true;
    }

    @Override
    public int min(int... array) {
        int minNumber = Integer.MAX_VALUE;
        
        for(int i = 0; i < array.length; i++) {
            if(minNumber > array[i])
                minNumber = array[i];
        }
        
        return minNumber;
    }

    @Override
    public int kthMin(int k, int[] array) {
        for(int i = 0; i < k; i++) {
            int minNumber = i;

            for(int j = i + 1; j < array.length; j++){
                if(array[minNumber] > array[j])
                    minNumber = j;
            }
            
            if (minNumber != i){
                int temp = array[minNumber];
                array[minNumber] = array[i];
                array[i] = temp;
            }
        }
        
        return array[k - 1];
    }

    @Override
    public float getAverage(int[] array) {
        float average = 0;
        
        for(int i = 0; i < array.length; i++)
            average += (float)array[i];
        
        return average / array.length;
    }

    @Override
    public long getSmallestMultiple(int upperBound) {
        for(int i = 1; i < Long.MAX_VALUE; i++){
            Boolean isValid = true;
            
            for(int j = 2; j <= upperBound; j++){
                if(i % j != 0){
                    isValid = false;
                    break;
                }
            }
            
            if(isValid)
                return i;
        }
        
        return -1;
    }

    @Override
    public long getLargestPalindrome(long N) {
        for(long i = N; i >= 0; i--){
            Boolean isValid = true;
            char[] asString = String.valueOf(i).toCharArray();
            
            for(int j = 0; j <= asString.length / 2; j++){
                if(asString[j] != asString[asString.length - j - 1]){
                    isValid = false;
                    break;
                }
            }
            
            if(isValid)
                return i;
        }
        
        return 0;
    }

    @Override
    public int[] histogram(short[][] image) {
        int[] hist = new int[256];
        
        for(int i = 0; i < image.length; i++){
            for(int j = 0; j < image[0].length; j++){
                hist[image[i][j]]++;
            }
        }
        
        return hist;
    }

    @Override
    public long doubleFac(int n) {
        long firstFact = 1;
        
        for(int i = 2; i <= n; i++){
            firstFact *= i;
        }
        
        long secondFact = firstFact;
        
        for(int i = 2; i < secondFact; i++){
            firstFact *= i;
        }
        
        return firstFact;
    }

    @Override
    public long kthFac(int k, int n) {
        int currentNumb = n;
        
        for(int i = 0; i < k; i++){
            int currentNumbCpy = currentNumb;
            
            for(int j = 2; j < currentNumbCpy; j++){
                currentNumb *= j;
            }
        }
        
        return currentNumb;
    }

    @Override
    public int getOddOccurrence(int[] array) {
        Boolean[] digits = new Boolean[10];
        
        for(int i = 0; i < digits.length; i++){
            digits[i] = false;
        }

        for(int i = 0; i < array.length - 1; i++){
            if(digits[array[i]])
                continue;
            
            int count = 1;
            
            for(int j = i + 1; j < array.length; j++){
                if(array[i] == array[j])
                    count++;
            }
            
            if(count % 2 == 1)
                return i;
            
            digits[array[i]] = true;
        }
        
        return -1;
    }

    @Override
    public long pow(int a, int b) {
        int result = 1;

        while (b != 0){
            if ((b&1) != 0){
                result *= a;
            }
            
            b >>=1 ;
            a *= a;
        }

        return result;
    }

    @Override
    public long maximalScalarSum(int[] a, int[] b) {
        Arrays.sort(a);
        Arrays.sort(b);
        
        long sum = 0;
        
        for(int i = 0; i < a.length; i++){
            sum += a[i] * b[i];
        }
        
        return sum;
    }

    @Override
    public int maxSpan(int[] array) {
        int maxSpan = Integer.MIN_VALUE;
        
        for(int i = 0; i < array.length - 1; i++){
            int currentNumber = array[i];
            
            for(int j = array.length - 1; j >= 0; j--){
                if(array[j] == currentNumber && j - i + 1 > maxSpan)
                    maxSpan = j - i + 1;
            }
        }
        
        return maxSpan;
    }

    @Override
    public boolean canBalance(int[] array) {
        for(int i = 0; i < array.length; i++){
            int leftHalf = 0;
            
            //Left half
            for(int k = 0; k < i; k++){
                leftHalf += array[k];
            }
            
            int rightHalf = 0;
            
            //Right half
            for(int j = i; j < array.length; j++){
                rightHalf += array[j];
            }
            
            if(rightHalf == leftHalf)
                return true;
        }
        
        return false;
    }

    @Override
    public int[][] rescale(int[][] original, int newWidth, int newHeight) {
        int rescaledRows = original.length / newWidth;
        int rescaledCols = original[0].length / newHeight;
        
        int[][] rescaled = new int[rescaledRows][rescaledCols];
        
        int rescaledRowIndex = 0;
        
        for(int i = 0; i < original.length; i += rescaledRows){
            int rescaledColIndex = 0;
            
            for(int j = 0; j < original[0].length; j += rescaledCols){
                rescaled[rescaledRowIndex][rescaledColIndex] = original[i][j];
                rescaledColIndex++;
            }
            
            rescaledRowIndex++;
        }
        
        return rescaled;
    }

    @Override
    public String reverseMe(String argument) {
        StringBuilder reversed = new StringBuilder();
        char[] argAsArray = argument.toCharArray();
        
        for(int i = argAsArray.length - 1; i >= 0 ; i--){
            reversed.append(argAsArray[i]);
        }
        
        return reversed.toString();
    }

    @Override
    public String copyEveryChar(String input, int k) {
        StringBuilder output = new StringBuilder();
        
        for(int i = 0; i < input.length(); i++){
            char currentChar = input.charAt(i);
            
            for(int j = 0; j < k; j++)
                output.append(currentChar);
        }
        
        return output.toString();
    }

    @Override
    public String reverseEveryWord(String arg){
        String[] words = arg.split(" ");
        StringBuilder reversed = new StringBuilder();
    
        for(int i = 0; i < words.length; i++){
            String currentWord = words[i];
            
            for(int j = currentWord.length() - 1; j >= 0; j--){
                reversed.append(currentWord.charAt(j));
            }
            
            //Don't add additional space in the end
            if(i + 1 < words.length)
                reversed.append(" ");
        }
        
        return reversed.toString();
    }

    @Override
    public boolean isPalindrome(String argument) {
        for(int i = 0; i <= argument.length() / 2; i++){
            if(argument.charAt(i) != argument.charAt(argument.length() - i - 1))
                return false;
        }
        
        return true;
    }

    @Override
    public boolean isPalindrome(int number) {
        Stack<Integer> digits = new Stack<Integer>();
        int numberCpy = number;
        
        while(numberCpy != 0){
            digits.push(numberCpy % 10);
            numberCpy /= 10;
        }
        
        while(!digits.empty()){
            if(digits.pop() != number % 10)
                return false;
            
            number /= 10;
        }
        
        return true;
    }

    @Override
    public int getPalindromeLength(String input) {
        String[] rawData = input.split("\\*");
        
        int index = 0;
        
        while(index < rawData[0].length() && index < rawData[1].length()){
            if(rawData[0].charAt(rawData[0].length() - 1 - index) !=
                    rawData[1].charAt(index))
                break;
            
            index++;
        }
        
        return index;
    }

    @Override
    public int countOcurrences(String needle, String haystack) {
        int count = 0;
        int index = 0;
        
        while(true){
            int nextPosition = haystack.indexOf(needle, index);
            
            if(nextPosition == -1)
                return count;
            
            count++;
            index = nextPosition + needle.length();
        }
    }

    @Override
    public String decodeURL(String input) {
        String inputCpy = input;
        
        inputCpy = inputCpy.replaceAll("%20", " ");
        inputCpy = inputCpy.replaceAll("%3A", ":");
        inputCpy = inputCpy.replaceAll("%3D", "?");
        inputCpy = inputCpy.replaceAll("%2F", "/");
        
        return inputCpy;
    }

    @Override
    public int sumOfNumbers(String input) {
        int sum = 0;
        
        for(int i = 0; i < input.length(); i++){
            Boolean positive = true;
            
            if(input.charAt(i) == '-') {
                positive = false;
                i++;
            }
            
            if(input.charAt(i) < '0' && input.charAt(i) > '9')
                continue;
            
            StringBuilder currentNumber = new StringBuilder();
            
            while(i < input.length() &&
                    input.charAt(i) >= '0' && input.charAt(i) <= '9'){
                currentNumber.append(input.charAt(i));
                i++;
            }
            
            if(!currentNumber.toString().isEmpty()){
                int number = Integer.parseInt(currentNumber.toString());
                number = positive ? number : number * -1;
                sum += number;
            }
        }
        
        return sum;
    }

    @Override
    public boolean areAnagrams(String A, String B) {
        int[] allLetters = new int[25];
        String aCpyLower = A.toLowerCase();
        String bCpyLower = B.toLowerCase();
        
        for(int i = 0; i < aCpyLower.length(); i++) {
            if(Character.isAlphabetic(aCpyLower.charAt(i)))
                allLetters[aCpyLower.charAt(i) - 97]++;
        }
        
        for(int i = 0; i < bCpyLower.length(); i++) {
            if(Character.isAlphabetic(bCpyLower.charAt(i)))
                allLetters[bCpyLower.charAt(i) - 97]--;
        }
        
        for(int i = 0; i < allLetters.length; i++)
            if(allLetters[i] != 0)
                return false;
        
        return true;
    }

    @Override
    public boolean hasAnagramOf(String string, String string2) {
        int[] allLetters = new int[25];
        String stringCpyLower = string.toLowerCase();
        String string2CpyLower = string2.toLowerCase();
        
        for(int i = 0; i < stringCpyLower.length(); i++) {
            if(Character.isAlphabetic(stringCpyLower.charAt(i)))
                allLetters[stringCpyLower.charAt(i) - 97]++;
        }
        
        //Find first letter index
        int startIndex = string2CpyLower.indexOf(stringCpyLower.charAt(0));
        allLetters[stringCpyLower.charAt(0) - 97]--;
        Boolean canGoLeft = true;
        Boolean canGoRight = true;
        
        for(int i = 1; i < string2CpyLower.length(); i++) {
            if(canGoLeft && startIndex - i >= 0) {
                char leftChar = string2CpyLower.charAt(startIndex - i);
                
                if(stringCpyLower.indexOf(leftChar) == -1
                        || allLetters[leftChar - 97] == 0)
                    break;
                else
                    allLetters[leftChar - 97]--;
            }
        }

        for(int i = 1; i < string2CpyLower.length(); i++) {
            if(canGoRight && startIndex + i < string2CpyLower.length()) {
                char rightChar = string2CpyLower.charAt(startIndex - i);
            
                if(stringCpyLower.indexOf(rightChar) == -1 
                        || allLetters[rightChar - 97] == 0)
                    break;
                else
                    allLetters[rightChar - 97]--;
            }
        }
        
        for(int i = 0; i < allLetters.length; i++)
            if(allLetters[i] != 0)
                return false;
        
        return true;
    }
}