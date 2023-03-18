package leetcode.biweekly_contests.biweekly_0_99.biweekly_86;

public class P_3 {

    public int maximumRows(int[][] mat, int cols) {
        final int m = mat[0].length;
        int res = 0;
        for (int mask = 0; mask < 1 << m; mask++) {
            final int bits = Integer.bitCount(mask);
            if (bits != cols) {
                continue;
            }
            int curr = 0;
            for (int[] row : mat) {
                boolean ok = true;
                for (int i = 0; i < m; i++) {
                    if (row[i] == 1 && (mask & (1 << i)) == 0) {
                        ok = false;
                        break;
                    }
                }
                if (ok) {
                    curr++;
                }
            }
            res = Math.max(res, curr);
        }
        return res;
    }
}
