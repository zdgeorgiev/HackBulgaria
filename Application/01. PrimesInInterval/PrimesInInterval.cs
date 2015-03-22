using System;
using System.Collections.Generic;
using System.Text;

class PrimesInInterval
{
    static List<int> PrimesInAnInterval(int from, int to)
    {
        List<int> primes = new List<int>();

        for (int i = from; i <= to; i++)
        {
            int lastDivider = (int)Math.Sqrt(i);
            bool isPrime = true;

            for (int j = 2; j <= lastDivider; j++)
            {
                if (i % j == 0)
                {
                    isPrime = false;
                    break;
                }
            }

            if (isPrime)
                primes.Add(i);
        }

        return primes;
    }

    static void Main(string[] args)
    {
        Console.Write("Enter from: ");
        int from = int.Parse(Console.ReadLine());

        Console.Write("Enter to: ");
        int to = int.Parse(Console.ReadLine());

        if (from < 0 || to < 0)
        {
            Console.WriteLine("from({0}) and to({1}) must be positive numbers", from, to);
            return;
        }
        else if (from >= to)
        {
            Console.WriteLine("from({0}) should be smaller than to({1})", from, to);
            return;
        }

        List<int> primes = PrimesInAnInterval(from, to);

        if (primes.Count == 0)
        {
            Console.WriteLine("Theres no prime numbers in range [{0} - {1}]", from, to);
        }
        else
        {
            StringBuilder output = new StringBuilder();
            output.Append("Primes - [");

            foreach (var number in primes)
            {
                output.Append(number + ", ");
            }

            output.Length -= 2;
            output.Append("]");

            Console.WriteLine(output.ToString());
        }
    }
}