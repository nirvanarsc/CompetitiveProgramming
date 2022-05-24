package leetcode.weekly_contests.weekly_200_299.weekly_205;

public class P_1578 {

    public int minCost(String s, int[] cost) {
        int res = 0;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == s.charAt(i - 1)) {
                int maxCost = cost[i - 1];
                int total = cost[i - 1];
                int end = i;
                while (end < s.length() && s.charAt(end) == s.charAt(i)) {
                    maxCost = Math.max(maxCost, cost[end]);
                    total += cost[end];
                    end++;
                }
                res += total - maxCost;
                i = end - 1;
            }
        }
        return res;
    }
}
