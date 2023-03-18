package leetcode.biweekly_contests.biweekly_0_99.biweekly_26;

public class P_1449 {

    public String largestNumber(int[] cost, int target) {
        final String res = dfs(cost, target, new String[target + 1]);
        return "NO_SOLUTION".equals(res) ? "0" : res;
    }

    private static String dfs(int[] cost, int target, String[] dp) {
        if (target < 0) {
            return "NO_SOLUTION";
        }
        if (target == 0) {
            return "";
        }
        if (dp[target] != null) {
            return dp[target];
        }
        String res = "NO_SOLUTION";
        for (int i = 0; i < cost.length; i++) {
            final String curr = dfs(cost, target - cost[i], dp);
            if (!"NO_SOLUTION".equals(curr)) {
                final String newVal = (i + 1) + curr;
                if ("NO_SOLUTION".equals(res)
                    || res.length() < newVal.length()
                    || (res.length() == newVal.length() && res.compareTo(newVal) < 0)) {
                    res = newVal;
                }
            }
        }
        return dp[target] = res;
    }
}
