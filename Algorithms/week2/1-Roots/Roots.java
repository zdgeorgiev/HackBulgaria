public class Roots {

    public static void main(String[] args) {
        System.out.println(new Roots().squareRoot(50));
        System.out.println(new Roots().squareRoot(100));
    }

    // Finds the square root of a number using binary search.
    private double squareRoot(int number) {

        return binarySearch(0.00001, number);
    }

    private double binarySearch(double precision, int number) {

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