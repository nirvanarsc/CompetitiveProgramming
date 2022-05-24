package leetcode.weekly_contests.weekly_0_99.weekly_16a;

import java.util.stream.IntStream;

public class P_484 {

    public int[] findPermutation(String s) {
        final int n = s.length();
        final int[] arr = IntStream.rangeClosed(1, s.length() + 1).toArray();
        for (int r = 0; r < n; r++) {
            if (s.charAt(r) == 'D') {
                final int l = r;
                while (r < n && s.charAt(r) == 'D') { r++; }
                reverse(l, r, arr);
            }
        }
        return arr;
    }

    private static void reverse(int from, int to, int[] arr) {
        for (int i = from; 2 * i < to + from; i++) {
            final int temp = arr[i];
            arr[i] = arr[to + from - i];
            arr[to + from - i] = temp;
        }
    }
}
