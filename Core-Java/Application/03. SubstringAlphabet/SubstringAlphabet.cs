using System;

class SubstringAlphabet
{
    static void Main(string[] args)
    {
        string input = Console.ReadLine();

        SmallestSubstringContainingTheAlphabet(input.ToLower());
    }

    private static bool CheckIfContainsAllLetter(bool[] letters)
    {
        for (int i = 0; i < letters.Length; i++)
        {
            if (!letters[i])
            {
                return false;
            }
        }

        return true;
    }

    private static void SmallestSubstringContainingTheAlphabet(string input)
    {
        int minLength = int.MaxValue;
        int inputLength = input.Length;
        int startIndex = -1;

        if (inputLength < 26)
        {
            Console.WriteLine("Theres no substring which contains the alphabet");
            return;
        }

        for (int i = 0; i < inputLength - 1; i++)
        {
            char currentChar = input[i];
            bool[] letters = new bool[26];
            int currentLength = 1;

            if (currentChar >= 'a' && currentChar <= 'z')
                letters[currentChar - 97] = true;

            for (int j = i + 1; j < inputLength; j++)
            {
                char nextChar = input[j];

                if (nextChar >= 'a' && nextChar <= 'z')
                    letters[nextChar - 97] = true;

                currentLength++;

                //If the string doesnt check atleast 26 letters
                //its pointless to check if all letters exists
                if (currentLength >= 26)
                {
                    if (CheckIfContainsAllLetter(letters))
                    {
                        if (currentLength < minLength)
                        {
                            minLength = currentLength;
                            startIndex = i;
                        }
                    }
                }
            }
        }

        if (startIndex != -1)
            Console.WriteLine(input.Substring(startIndex, minLength));
        else
            Console.WriteLine("Doesnt contains the alphabet");
    }
}