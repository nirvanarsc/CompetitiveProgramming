package weekly_176;

public class P_1351 {

    public int countNegatives(int[][] grid) {
        int res = 0;
        for (int[] row : grid) {
            res += bs(row);
        }
        return res;
    }

    private static int bs(int[] row) {
        int lo = 0, hi = row.length;
        while (lo < hi) {
            final int mid = lo + hi >>> 1;
            if (row[mid] < 0) {
                hi = mid;
            } else {
                lo = mid + 1;
            }
        }
        return row.length - lo;
    }
}
