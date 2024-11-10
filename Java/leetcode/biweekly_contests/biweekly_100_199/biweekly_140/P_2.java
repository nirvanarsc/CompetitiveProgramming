package leetcode.biweekly_contests.biweekly_100_199.biweekly_140;

import java.util.Arrays;

public class P_2 {

    public long maximumTotalSum(int[] maximumHeight) {
        Arrays.sort(maximumHeight);
        final int n = maximumHeight.length;
        int curr = maximumHeight[n - 1];
        long res = 0;
        for (int i = n - 1; i >= 0; i--) {
            int u = maximumHeight[i];
            u = Math.min(u, curr);
            res += u;
            curr = u - 1;
        }
        return curr < 0 ? -1 : res;
    }
}
