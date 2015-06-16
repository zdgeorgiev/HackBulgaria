package roots;

public class Program {

    public static void main(String[] args) {
        System.out.println(squareRoot(50));
        System.out.println(squareRoot(100));
    }

    private static double squareRoot(int number) {

        return binarySearch(0.00001, number);
    }

    private static double binarySearch(double precision, int number) {

        double start = 0;
        double end = number / 2;

        for (int j = 0; j <= precision + 1; j++) {

            while (Math.abs(start - end) > precision) {
                double middle = start + ((end - start) / 2);
                double middleSquare = middle * middle;

                if (middleSquare > number) {
                    end = middle - precision;
                } else if (middleSquare < number) {
                    start = middle + precision;
                }
            }
        }

        return start;
    }
}