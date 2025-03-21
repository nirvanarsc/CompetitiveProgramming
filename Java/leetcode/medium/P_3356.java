package leetcode.medium;

import java.util.Arrays;

public class P_3356 {

    public int minZeroArray(int[] nums, int[][] queries) {
        final int n = nums.length;
        final int q = queries.length;
        if (Arrays.equals(nums, new int[n])) {
            return 0;
        }
        int lo = 0;
        int hi = q;
        while (lo < hi) {
            final int mid = lo + hi >>> 1;
            final int[] curr = new int[n + 1];
            for (int i = 0; i <= mid; i++) {
                final int[] u = queries[i];
                curr[u[0]] += u[2];
                curr[u[1] + 1] -= u[2];
            }
            int u = 0;
            boolean ok = true;
            for (int i = 0; i < n; i++) {
                u += curr[i];
                if (nums[i] > u) {
                    ok = false;
                    break;
                }
            }
            if (!ok) {
                lo = mid + 1;
            } else {
                hi = mid;
            }
        }
        return lo == q ? -1 : (lo + 1);
    }
}
