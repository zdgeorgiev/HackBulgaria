package palindromes;

public class Program {
    private static int palindromesFound = 0;

    public static void main(String[] args) {
        String word = "akawwaka";
        printAllPalindromes(word, 0);
    }

    private static void printAllPalindromes(String word, int splitIndex) {
        if (splitIndex == word.length()) {
            if (palindromesFound == 0) {
                System.out.println("NONE");
            }

            return;
        }

        StringBuilder rotation = new StringBuilder();
        rotation.append(word.substring(splitIndex));
        rotation.append(word.substring(0, splitIndex));

        if (isPalindrome(rotation.toString())) {
            System.out.println(rotation);
            palindromesFound++;
        }

        printAllPalindromes(rotation.toString(), ++splitIndex);
    }

    private static boolean isPalindrome(String word) {
        for (int i = 0; i < word.length() / 2; i++) {
            if (word.charAt(i) != word.charAt(word.length() - i - 1)) {
                return false;
            }
        }

        return true;
    }
}