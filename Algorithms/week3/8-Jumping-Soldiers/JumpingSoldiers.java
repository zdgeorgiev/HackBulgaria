import java.util.ArrayList;
import java.util.Scanner;

public class JumpingSoldiers {

    private static final int MAX_VALUE = 10000;

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        int cols = s.nextInt();
        int rows = s.nextInt();

        BinaryIndexedTree tree;

        int maxSize = Integer.MIN_VALUE;
        int minCount = Integer.MAX_VALUE;
        int rowIndexWithBiggestSum = 0;

        for (int i = 0; i < rows; i++) {
            tree = new BinaryIndexedTree(new ArrayList<Integer>(), MAX_VALUE);

            int currentCount = 0;
            int currentSize = 0;

            for (int j = 0; j < cols; j++) {
                int number = s.nextInt();
                tree.add(number, 1);
                int numbersBiggerBefore = tree.data[0] - tree.count(number + 1);

                currentSize += number;
                currentCount += numbersBiggerBefore;
            }

            if (currentCount > maxSize) {
                maxSize = currentCount;
                rowIndexWithBiggestSum = i + 1;
            } else if (currentCount == maxSize) {
                if currentSize < minCount) {
                    rowIndexWithBiggestSum = i + 1;
                }
            }
        }

        System.out.println(rowIndexWithBiggestSum);
    }
}
