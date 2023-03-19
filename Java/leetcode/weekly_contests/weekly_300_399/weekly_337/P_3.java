package leetcode.weekly_contests.weekly_300_399.weekly_337;

public class P_3 {

    public int beautifulSubsets(int[] nums, int k) {
        int res = 0;
        final int n = nums.length;
        for (int mask = 1; mask < 1 << n; mask++) {
            final boolean[] seen = new boolean[1005];
            int ok = 1;
            for (int i = 0; i < n; i++) {
                if ((mask & (1 << i)) != 0) {
                    seen[nums[i]] = true;
                    if (nums[i] - k >= 0 && seen[nums[i] - k]) {
                        ok = 0;
                        break;
                    }
                    if (nums[i] + k < 1005 && seen[nums[i] + k]) {
                        ok = 0;
                        break;
                    }
                }
            }
            res += ok;
        }
        return res;
    }
}
