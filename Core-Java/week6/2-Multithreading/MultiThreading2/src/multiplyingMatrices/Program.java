package multiplyingMatrices;

public class Program {
    public static void main(String[] args) {
        int[][] first = new int[][] {
                { 2, 1, 6, 8, 2, 1, 6, 8, 2, 1, 6, 8, 2, 1, 6, 8, 2, 1, 6, 8, 2, 1, 6, 8, 2, 1, 6, 8, 2, 1, 6, 8 },
                { 2, 1, 6, 8, 2, 1, 6, 8, 2, 1, 6, 8, 2, 1, 6, 8, 2, 1, 6, 8, 2, 1, 6, 8, 2, 1, 6, 8, 2, 1, 6, 8 },
                { 2, 1, 6, 8, 2, 1, 6, 8, 2, 1, 6, 8, 2, 1, 6, 8, 2, 1, 6, 8, 2, 1, 6, 8, 2, 1, 6, 8, 2, 1, 6, 8 },
                { 2, 1, 6, 8, 2, 1, 6, 8, 2, 1, 6, 8, 2, 1, 6, 8, 2, 1, 6, 8, 2, 1, 6, 8, 2, 1, 6, 8, 2, 1, 6, 8 },
                { 2, 1, 6, 8, 2, 1, 6, 8, 2, 1, 6, 8, 2, 1, 6, 8, 2, 1, 6, 8, 2, 1, 6, 8, 2, 1, 6, 8, 2, 1, 6, 8 },
                { 2, 1, 6, 8, 2, 213, 6, 8, 2, 1, 6, 8, 2, 1, 6, 8, 2, 1, 6, 8, 2, 1, 6, 8, 2, 1, 6, 8, 2, 1, 6, 8 },
                { 2, 1, 6, 8, 2, 1, 6, 8, 2, 1, 6, 8, 2, 1, 6, 8, 2, 1, 6, 8, 2, 1, 6, 8, 2, 1, 6, 8, 2, 1, 6, 8 },
                { 2, 1, 6, 8, 2, 1, 6, 8, 2, 1, 6, 8, 2, 1, 6, 8, 2, 1, 6, 8, 2, 1, 6, 8, 2, 1, 6, 8, 2, 1, 6, 8 },
                { 2, 1, 6, 8, 2, 1, 6, 8, 2, 1, 6, 8, 2, 1, 6, 8, 2, 1, 6, 8, 2, 1, 6, 8, 2, 1, 6, 8, 2, 1, 6, 8 },
                { 2, 1, 6, 8, 2, 1, 6, 8, 2, 1, 6, 8, 2, 1, 6, 8, 2, 1, 6, 8, 2, 1, 6, 8, 2, 1, 6, 8, 2, 1, 6, 8 },
                { 2, 1, 6, 8, 2, 1, 6, 8, 2, 1, 6, 5354, 2, 1, 6, 8, 2, 1, 6, 8, 2, 1, 6, 8, 2, 1, 6, 8, 2, 1, 6, 8 },
                { 2, 1, 6, 8, 2, 1, 6, 8, 2, 1, 6, 8, 2, 1, 6, 8, 2, 1, 6, 8, 2, 1, 6, 8, 2, 1, 6, 8, 2, 1, 6, 8 },
                { 2, 1, 6, 8, 2, 1, 6, 8, 2, 1, 6, 8, 2, 1, 6, 8, 2, 1, 6, 8, 2, 1, 6, 8, 2, 1, 6, 8, 2, 1, 6, 8 },
                { 2, 1, 6, 8, 2, 1, 6, 8, 2, 1, 6, 8, 2, 1, 6, 8, 2, 1, 6, 8, 2, 123312, 6, 8, 2, 1, 6, 8, 2, 1, 6, 8 },
                { 2, 1, 6, 8, 2, 1, 6, 8, 2, 1, 6, 8, 2, 1, 6, 8, 2, 1, 6, 8, 2, 1, 6, 8, 2, 1, 6, 8, 2, 1, 6, 8 },
                { 2, 1, 6, 8, 2, 1, 6, 8, 2, 1, 6, 8, 2, 1, 6, 8, 2, 1, 6, 8, 2, 1, 6, 8, 2, 1, 6, 8, 2, 1, 6, 8 },
                { 2, 1, 6, 8, 2, 1, 312, 8, 2, 1, 6, 8, 2, 1, 6, 8, 2, 1, 6, 8, 2, 1, 6, 8, 2, 1, 6, 8, 2, 1, 6, 8 },
                { 2, 1, 6, 8, 2, 1, 6, 8, 2, 1, 6, 8, 2, 1, 6, 8, 2, 1, 6, 8, 2, 1, 6, 8, 2, 1, 6, 8, 2, 1, 6, 8 },
                { 2, 1, 6, 8, 2, 1, 6, 8, 2, 1, 6, 8, 2, 1, 6, 8, 2, 1, 6, 8, 2, 1, 6, 8, 2, 1, 6, 8, 2, 1, 6, 8 },
                { 2, 1, 6, 8, 2, 1, 6, 8, 2, 1, 6, 8, 2, 1, 6, 8, 2, 1, 6, 8, 2, 1, 6, 8, 2, 1, 6, 8, 2, 1, 6, 8 },
                { 2, 1, 6, 8, 2, 1, 6, 8, 2, 1, 6, 8, 2, 1, 6, 8, 2, 1, 6, 8, 2, 1, 6, 8, 2, 1, 6, 8, 2, 1, 6, 8 },
                { 2, 1, 6, 8, 2, 1, 6, 8, 2, 1, 6, 8, 2, 1, 6, 8, 2, 1, 6, 8, 2, 1, 6, 8, 2, 1, 6, 8, 2, 1, 6, 8 },
                { 2, 1, 6, 8, 2, 1, 6, 8, 2, 1, 6, 8, 2, 1, 6, 8, 2, 1, 6, 8, 2, 1, 6, 8, 2, 1, 6, 8, 2, 1, 6, 8 } };

        int[][] second = new int[][] { { 1, 3, 6, 315, 13, 5 }, { 1, 3, 6, 315, 13, 5 }, { 1, 3, 6, 315, 13, 5 },
                { 1, 3, 6, 315, 13, 5 }, { 1, 3, 6, 315, 13, 5 }, { 1, 3, 6, 315, 13, 5 }, { 1, 3, 6, 315, 13, 5 },
                { 1, 3, 6, 315, 13, 5 }, { 1, 3, 6, 315, 13, 5 }, { 1, 3, 6, 315, 13, 5 }, { 1, 3, 6, 315, 13, 5 },
                { 1, 3, 6, 315, 13, 5 }, { 1, 3, 6, 315, 13, 5 }, { 1, 3, 6, 315, 13, 5 }, { 1, 3, 6, 315, 13, 5 },
                { 1, 3, 6, 315, 13, 5 }, { 1, 3, 6, 315, 13, 5 }, { 1, 3, 6, 315, 13, 5 }, { 1, 3, 6, 315, 13, 5 },
                { 1, 3, 6, 315, 13, 5 }, { 1, 3, 6, 315, 13, 5 }, { 1, 3, 6, 315, 13, 5 }, { 1, 3, 6, 315, 13, 5 },
                { 1, 3, 6, 315, 13, 5 }, { 1, 3, 6, 315, 13, 5 }, { 1, 3, 6, 315, 13, 5 }, { 1, 3, 6, 315, 13, 5 },
                { 1, 3, 6, 315, 13, 5 }, { 1, 3, 6, 315, 13, 5 }, { 1, 3, 6, 315, 13, 5 }, { 1, 3, 6, 315, 13, 5 },
                { 1, 3, 6, 315, 13, 5 }, { 1, 3, 6, 315, 13, 5 }, { 1, 3, 6, 315, 13, 5 }, { 1, 3, 6, 315, 13, 5 },
                { 1, 3, 6, 315, 13, 5 }, { 1, 3, 6, 315, 13, 5 }, { 1, 3, 6, 315, 13, 5 }, { 1, 3, 6, 315, 13, 5 },
                { 1, 3, 6, 315, 13, 5 }, { 1, 3, 6, 315, 13, 5 }, { 1, 3, 6, 315, 13, 5 }, { 1, 3, 6, 315, 13, 5 },
                { 1, 3, 6, 315, 13, 5 }, { 1, 3, 6, 315, 13, 5 }, { 1, 3, 6, 315, 13, 5 }, { 1, 3, 6, 315, 13, 5 },
                { 1, 3, 6, 315, 13, 5 }, { 1, 3, 6, 315, 13, 5 }, { 1, 3, 6, 315, 13, 5 }, { 1, 3, 6, 315, 13, 5 },
                { 1, 3, 6, 315, 13, 5 }, { 1, 3, 6, 315, 13, 5 }, { 1, 3, 6, 315, 13, 5 }, { 1, 3, 6, 315, 13, 5 },
                { 1, 3, 6, 315, 13, 5 }, { 1, 3, 6, 315, 13, 5 }, { 1, 3, 6, 315, 13, 5 }, { 1, 3, 6, 315, 13, 5 },
                { 1, 3, 6, 315, 13, 5 }, { 1, 3, 6, 315, 13, 5 }, { 1, 3, 6, 315, 13, 5 }, { 1, 3, 6, 315, 13, 5 },
                { 1, 3, 6, 315, 13, 5 }, { 1, 3, 6, 315, 13, 5 }, { 1, 3, 6, 315, 13, 5 }, { 1, 3, 6, 315, 13, 5 } };

        ParallelMatricesMultiplier multiplier = new ParallelMatricesMultiplier(first, second);
        long start = System.currentTimeMillis();
        multiplier.multiply();
        System.out.println(System.currentTimeMillis() - start);
    }
}
