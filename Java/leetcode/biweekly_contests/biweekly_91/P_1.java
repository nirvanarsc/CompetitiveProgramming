package leetcode.biweekly_contests.biweekly_91;

import java.util.Arrays;

public class P_1 {

    public int distinctAverages(int[] nums) {
        Arrays.sort(nums);
        final int n = nums.length;
        final boolean[] seen = new boolean[205];
        for (int i = 0; i < n / 2; i++) {
            final int u = nums[i] + nums[n - 1 - i];
            seen[u] = true;
        }
        int res = 0;
        for (int i = 0; i < 205; i++) {
            if (seen[i]) {
                res++;
            }
        }
        return res;
    }
}
