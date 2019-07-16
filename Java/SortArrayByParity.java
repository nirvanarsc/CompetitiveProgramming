import java.util.Arrays;
import java.util.Comparator;

public final class SortArrayByParity {

    public static void main(String[] args) {
        final int[] a = { 3, 1, 2, 4 };

        for (int value : sortArrayByParity(a)) { System.out.println(value); }
        System.out.println();
        for (int value : sortArrayByParity2(a)) { System.out.println(value); }
        System.out.println();
        for (int value : sortArrayByParity3(a)) { System.out.println(value); }
    }

    // In place 98.56% for memory, but SLOW
    private static int[] sortArrayByParity(int[] a) {
        final Comparator<Integer> byParity = Comparator.comparingInt(o -> o % 2);

        System.arraycopy(Arrays.stream(a)
                               .boxed()
                               .sorted(byParity)
                               .mapToInt(i -> i)
                               .toArray(), 0, a, 0, a.length);

        return a;
    }

    /*
    Runtime: 1 ms, faster than 100.00% of Java online submissions for Sort Array By Parity.
    Memory Usage: 40.6 MB, less than 91.03% of Java online submissions for Sort Array By Parity.
     */
    private static int[] sortArrayByParity2(int[] a) {
        final int[] res = new int[a.length];
        int even = 0;
        int odd = a.length - 1;
        for (int value : a) {
            if (value % 2 == 0) {
                res[even++] = value;
            } else { res[odd--] = value; }
        }

        return res;
    }

    // Same runtime & memory as above, but in place
    private static int[] sortArrayByParity3(int[] a) {
        for (int i = 0, j = 0; j < a.length; j++) {
            if (a[j] % 2 == 0) {
                final int tmp = a[i];
                a[i++] = a[j];
                a[j] = tmp;
            }
        }
        return a;
    }

    private SortArrayByParity() {}
}
