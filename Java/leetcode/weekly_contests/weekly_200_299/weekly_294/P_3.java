package leetcode.weekly_contests.weekly_200_299.weekly_294;

import java.util.Arrays;

public class P_3 {

    private static int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }

    public int minimumLines(int[][] stockPrices) {
        final int n = stockPrices.length;
        Arrays.sort(stockPrices, (a, b) -> a[0] == b[0] ? Integer.compare(a[1], b[1])
                                                        : Integer.compare(a[0], b[0]));
        String prev = "-1";
        int res = 0;
        for (int i = 1; i < n; i++) {
            int dx = stockPrices[i][0] - stockPrices[i - 1][0];
            int dy = stockPrices[i][1] - stockPrices[i - 1][1];
            final int gcd = gcd(Math.abs(dx), Math.abs(dy));
            dx /= gcd;
            dy /= gcd;
            final String curr = dx + "," + dy;
            if (!prev.equals(curr)) {
                res++;
            }
            prev = curr;
        }
        return res;
    }
}
