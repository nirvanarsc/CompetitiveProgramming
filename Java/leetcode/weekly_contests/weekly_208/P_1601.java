package leetcode.weekly_contests.weekly_208;

import java.util.Arrays;

public class P_1601 {

    // O((m + n) * 2^m)
    public int maximumRequests(int n, int[][] requests) {
        final int m = requests.length;
        int res = 0;
        for (int mask = 0; mask < (1 << m); mask++) {
            final int[] inDeg = new int[n];
            final int[] outDeg = new int[n];
            for (int i = 0; i < m; i++) {
                if ((mask & (1 << i)) != 0) {
                    outDeg[requests[i][0]]++;
                    inDeg[requests[i][1]]++;
                }
            }
            if (Arrays.equals(inDeg, outDeg)) {
                res = Math.max(res, Integer.bitCount(mask));
            }
        }
        return res;
    }
}
