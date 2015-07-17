import java.util.ArrayList;
import java.util.Scanner;

public class Quadruplets {
    private static HashMap map = new HashMap();

    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);
        int n = s.nextInt();

        ArrayList<Integer> first = new ArrayList<Integer>();
        for (int i = 0; i < n; i++) {
            first.add(s.nextInt());
        }

        ArrayList<Integer> second = new ArrayList<Integer>();
        for (int i = 0; i < n; i++) {
            second.add(s.nextInt());
        }

        ArrayList<Integer> third = new ArrayList<Integer>();
        for (int i = 0; i < n; i++) {
            third.add(s.nextInt());
        }

        ArrayList<Integer> fourth = new ArrayList<Integer>();
        for (int i = 0; i < n; i++) {
            fourth.add(s.nextInt());
        }

        // permutationSum(first, second);
        permutationSum(third, fourth);

        // int count = 0;
        //
        // for (int i = 0; i < third.size(); i++) {
        // for (int j = 0; j < fourth.size(); j++) {
        // int currentNumber = (third.get(i) + fourth.get(j)) * -1;
        //
        // if (map.contains(currentNumber)) {
        // count += map.getValue(currentNumber);
        // }
        // }
        // }
        //
        // System.out.println(count);

        // int[] sum1 = permutationSum2(first, second);
        int[] sum1 = permutationSum2(third, fourth);

        for (int i = 0; i < sum1.length; i++) {
            if (sum1[i] != 0) {
                if (map.getValue(i) != sum1[i]) {
                    System.out.println(i);
                }
            }
        }

    }

    private static void permutationSum(ArrayList<Integer> a, ArrayList<Integer> b) {

        for (int i = 0; i < a.size(); i++) {
            for (int j = 0; j < b.size(); j++) {
                map.add(a.get(i) + b.get(j));
            }
        }
    }

    private static int[] permutationSum2(ArrayList<Integer> a, ArrayList<Integer> b) {

        int[] arr = new int[1000];

        for (int i = 0; i < a.size(); i++) {
            for (int j = 0; j < b.size(); j++) {
                arr[Math.abs(a.get(i) + b.get(j))]++;
            }
        }

        return arr;
    }
}