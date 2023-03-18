package leetcode.biweekly_contests.biweekly_0_99.biweekly_79;

import java.util.Arrays;

public class P_3 {

    public long maximumImportance(int n, int[][] roads) {
        final int[] inDeg = new int[n];
        for (int[] e : roads) {
            inDeg[e[0]]++;
            inDeg[e[1]]++;
        }
        long res = 0;
        Arrays.sort(inDeg);
        for (int i = 0; i < n; i++) {
            res += (long) inDeg[i] * (i + 1);
        }
        return res;
    }
}
