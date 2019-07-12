import java.util.Arrays;

public class SquaresSortedArray {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(sortedSquares(new int[] { -4, -1, 0, 3, 10 })));
        System.out.println(Arrays.toString(sortedSquares2(new int[] { -4, -1, 0, 3, 10 })));
    }

    // In place but SLOW
    private static int[] sortedSquares(int[] A) {
        return Arrays.stream(A)
                     .boxed()
                     .map(x -> x * x)
                     .sorted()
                     .mapToInt(i -> i)
                     .toArray();
    }

    // 2 pointers - FAST
    private static int[] sortedSquares2(int[] A) {
        int n = A.length;
        int[] result = new int[n];
        int i = 0, j = n - 1;
        for (int p = n - 1; p >= 0; p--) {
            if (Math.abs(A[i]) > Math.abs(A[j])) {
                result[p] = A[i] * A[i];
                i++;
            } else {
                result[p] = A[j] * A[j];
                j--;
            }
        }
        return result;
    }
}
