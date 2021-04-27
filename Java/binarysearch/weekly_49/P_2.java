package binarysearch.weekly_49;

public class P_2 {

    public int solve(int[] a, int[] b) {
        int res = 0;
        int i = 0;
        int j = 0;
        while (i < a.length && j < b.length) {
            final int min = Math.min(a[i], b[j]);
            a[i] -= min;
            b[j] -= min;
            res += a[i + 1] * b[j + 1] * min;
            if (a[i] == 0) {
                i += 2;
            }
            if (b[j] == 0) {
                j += 2;
            }
        }
        return res;
    }
}
