import java.util.Arrays;

public final class SquaresSortedArray {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(sortedSquares(new int[] { -4, -1, 0, 3, 10 })));
        System.out.println(Arrays.toString(sortedSquares2(new int[] { -4, -1, 0, 3, 10 })));
    }

    // In place but SLOW
    private static int[] sortedSquares(int[] a) {
        return Arrays.stream(a)
                     .boxed()
                     .map(x -> x * x)
                     .sorted()
                     .mapToInt(i -> i)
                     .toArray();
    }

    // 2 pointers - FAST
    private static int[] sortedSquares2(int[] a) {
        final int n = a.length;
        final int[] result = new int[n];
        int i = 0, j = n - 1;
        for (int p = n - 1; p >= 0; p--) {
            if (Math.abs(a[i]) > Math.abs(a[j])) {
                result[p] = a[i] * a[i];
                i++;
            } else {
                result[p] = a[j] * a[j];
                j--;
            }
        }
        return result;
    }
}
