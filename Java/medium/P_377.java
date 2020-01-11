package medium;

import java.util.Arrays;

public final class P_377 {

    public static int combinationSum4(int[] candidates, int target) {
        Arrays.sort(candidates);
        final Integer[] dp = new Integer[target + 1];
        dp[0] = 1;
        return recurse(candidates, target, dp);
    }

    private static int recurse(int[] candidates, int target, Integer[] dp) {
        if (dp[target] != null) {
            return dp[target];
        }

        int res = 0;
        for (int i = 0; i < candidates.length && target >= candidates[i]; i++) {
            res += recurse(candidates, target - candidates[i], dp);
        }
        return dp[target] = res;
    }

    public static void main(String[] args) {
        System.out.println(combinationSum4(new int[] { 1, 2, 3 }, 4));
        System.out.println(combinationSum4(new int[] { 2, 1, 3 }, 35));
        System.out.println(combinationSum4(new int[] { 3, 33, 333 }, 10000));
    }

    private P_377() {}
}
