package leetcode.weekly_contests.weekly_200_299.weekly_205;

public class P_1578 {

    public int minCost(String colors, int[] neededTime) {
        final char[] w = colors.toCharArray();
        final int n = colors.length();
        int res = 0;
        for (int i = 1; i < n; i++) {
            if (w[i] == w[i - 1]) {
                int maxCost = neededTime[i - 1];
                int total = neededTime[i - 1];
                int j = i;
                while (j < n && w[j] == w[i]) {
                    maxCost = Math.max(maxCost, neededTime[j]);
                    total += neededTime[j];
                    j++;
                }
                res += total - maxCost;
                i = j - 1;
            }
        }
        return res;
    }
}
