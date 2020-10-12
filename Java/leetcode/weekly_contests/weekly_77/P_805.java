package leetcode.weekly_contests.weekly_77;

@SuppressWarnings("MethodParameterNamingConvention")
public class P_805 {

    public boolean splitArraySameAverage(int[] A) {
        final int n = A.length;
        int sum = 0;
        for (int num : A) {
            sum += num;
        }
        for (int i = 1; i <= n / 2; i++) {
            if (sum * i % n == 0 && dfs(A, sum * i / n, 0, i)) {
                return true;
            }
        }
        return false;
    }

    private static boolean dfs(int[] nums, int target, int idx, int k) {
        if (k == 0) {
            return target == 0;
        }
        for (int i = idx; i < nums.length; i++) {
            if (i > idx && nums[i] == nums[i - 1]) { continue; }
            if (dfs(nums, target - nums[i], i + 1, k - 1)) {
                return true;
            }
        }
        return false;
    }
}
