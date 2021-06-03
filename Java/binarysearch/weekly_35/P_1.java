package binarysearch.weekly_35;

public class P_1 {

    public int[] solve(int n, int lower, int upper) {
        final int L = upper - lower + 1;
        if (n >= 2 * L) {
            //noinspection ZeroLengthArrayAllocation
            return new int[0];
        }
        final int down = Math.min(n - 1, L);
        final int up = n - down;
        final int[] res = new int[n];
        int idx = 0;
        for (int i = upper - up, j = 0; j < up; j++, i++) {
            res[idx++] = i;
        }
        for (int i = 0; i < down; i++) {
            res[idx++] = upper--;
        }
        return res;
    }
}
