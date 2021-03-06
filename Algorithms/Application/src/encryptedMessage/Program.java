package encryptedMessage;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class Program {

    public static void main(String[] args) {
        String encoded = "o?uin uw?stutnfwat?~413~orwa? thfuisnnrsiu";

        String originalMessage = getOriginalMessage(encoded);
        System.out.println(originalMessage);
    }

    private static String getOriginalMessage(String encoded) {
        // Encoded message split in the half and then rotated
        StringBuilder normalizeMessage = new StringBuilder();
        normalizeMessage.append(encoded.substring(encoded.length() / 2));
        normalizeMessage.append(encoded.substring(0, encoded.length() / 2));

        String alphabet = getAlphabet(normalizeMessage.toString());
        String key = getKey(normalizeMessage.toString());
        String encryptedContent = getContent(normalizeMessage.toString(), alphabet.length(), key.length());
        key = changeTheKey(key, encryptedContent.length());

        HashMap<Character, Integer> alphabetIndexes = new HashMap<Character, Integer>();
        for (int i = 0; i < alphabet.length(); i++) {
            alphabetIndexes.put(alphabet.charAt(i), i);
        }

        ArrayList<Integer> keyAsIndexes = asCharIndexes(key, alphabetIndexes);
        ArrayList<Integer> contentAsIndexes = asCharIndexes(encryptedContent, alphabetIndexes);

        // System.out.println("Key as indexes - \t" + keyAsIndexes);
        // System.out.println("Content as indexes - \t" + contentAsIndexes);

        return getOriginalMessage(keyAsIndexes, contentAsIndexes, alphabet);
    }

    private static String getOriginalMessage(ArrayList<Integer> keyIndexes, ArrayList<Integer> contentIndexes,
            String alphabet) {
        ArrayList<Integer> originalMessageIndexes = new ArrayList<Integer>();

        Iterator<Integer> i1 = keyIndexes.iterator();
        Iterator<Integer> i2 = contentIndexes.iterator();

        while (i1.hasNext() && i2.hasNext()) {
            Integer keyIndex = i1.next();
            Integer contentIndex = i2.next();

            if (contentIndex > keyIndex) {
                originalMessageIndexes.add(contentIndex - keyIndex);
            } else if (contentIndex < keyIndex) {
                originalMessageIndexes.add(alphabet.length() + contentIndex - keyIndex);
            } else {
                originalMessageIndexes.add(0);
            }
        }

        // System.out.println("Original indexes - \t" + originalMessageIndexes);
        return convertIndexesToChars(originalMessageIndexes, alphabet);
    }

    private static String convertIndexesToChars(ArrayList<Integer> originalMessageIndexes, String alphabet) {
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < originalMessageIndexes.size(); i++) {
            result.append(alphabet.charAt(originalMessageIndexes.get(i)));
        }

        return result.toString();
    }

    private static ArrayList<Integer> asCharIndexes(String content, HashMap<Character, Integer> alphabet) {
        ArrayList<Integer> result = new ArrayList<Integer>();

        for (int i = 0; i < content.length(); i++) {
            result.add(alphabet.get(content.charAt(i)));
        }

        return result;
    }

    private static String changeTheKey(String key, int requiredLen) {
        StringBuilder newKey = new StringBuilder();
        boolean isCompleted = false;

        while (!isCompleted) {
            for (int i = 0; i < key.length(); i++) {
                newKey.append(key.charAt(i));

                if (newKey.length() == requiredLen) {
                    isCompleted = true;
                    break;
                }
            }
        }

        // System.out.println("New key - [" + newKey + "]");
        return newKey.toString();
    }

    private static String getContent(String encoded, int alphabetLen, int keyLen) {
        StringBuilder content = new StringBuilder();

        int startIndex = encoded.indexOf("~") + alphabetLen;
        int endIndex = encoded.lastIndexOf("~") - keyLen;

        for (int i = 0; i < endIndex - startIndex - 1; i++) {
            content.append(encoded.charAt(startIndex + 1 + i));
        }

        // System.out.println("Content - [" + content + "]");
        return content.toString();
    }

    private static String getKey(String encoded) {
        StringBuilder key = new StringBuilder();
        StringBuilder keyLengthAsString = new StringBuilder();

        int indexOfLastTilda = encoded.lastIndexOf("~");

        for (int i = indexOfLastTilda + 1; i < encoded.length(); i++) {
            keyLengthAsString.append(encoded.charAt(i));
        }

        int keyLen = Integer.parseInt(keyLengthAsString.toString());

        for (int i = 0; i < keyLen; i++) {
            key.append(encoded.charAt(indexOfLastTilda - keyLen + i));
        }

        // System.out.println("Key - [" + key.toString() + "]");
        return key.toString();
    }

    private static String getAlphabet(String encoded) {
        StringBuilder alphaBet = new StringBuilder();
        StringBuilder alphaBetLengthAsString = new StringBuilder();

        int indexOfTilda = encoded.indexOf("~");

        for (int i = 0; i < indexOfTilda; i++) {
            alphaBetLengthAsString.append(encoded.charAt(i));
        }

        int alphaBetLen = Integer.parseInt(alphaBetLengthAsString.toString());

        for (int i = 0; i < alphaBetLen; i++) {
            alphaBet.append(encoded.charAt(indexOfTilda + 1 + i));
        }

        // System.out.println("Alphabet - [" + alphaBet + "]");
        return alphaBet.toString();
    }
}