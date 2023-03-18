package leetcode.biweekly_contests.biweekly_0_99.biweekly_39;

public class P_1655 {

    public boolean canDistribute(int[] nums, int[] quantity) {
        final int[] freq = new int[1005];
        int uniq = 0;
        for (int num : nums) {
            if (freq[num]++ == 0) {
                uniq++;
            }
        }
        int idx = 0;
        final int[] count = new int[uniq];
        for (int num : freq) {
            if (num > 0) {
                count[idx++] = num;
            }
        }
        final int target = 1 << quantity.length;
        final int[] sums = new int[target];
        for (int mask = 0; mask < sums.length; mask++) {
            int sum = 0;
            for (int j = 0; j < quantity.length; j++) {
                if ((mask & (1 << j)) != 0) {
                    sum += quantity[j];
                }
            }
            sums[mask] = sum;
        }
        return dfs(count, 0, 0, target - 1, sums, new Boolean[count.length][target]);
    }

    private static boolean dfs(int[] count, int idx, int mask, int end, int[] sums, Boolean[][] dp) {
        if (idx == count.length) {
            return mask == end;
        }
        if (dp[idx][mask] != null) {
            return dp[idx][mask];
        }
        boolean res = false;
        for (int subMask = 0; subMask <= end; subMask++) {
            if (count[idx] >= sums[subMask]) {
                if (dfs(count, idx + 1, mask | subMask, end, sums, dp)) {
                    res = true;
                    break;
                }
            }
        }
        return dp[idx][mask] = res;
    }
}
