package leetcode.weekly_contests.weekly_400_499.weekly_442;

public class P_3 {

    public long minTime(int[] skill, int[] mana) {
        final int n = skill.length;
        final long[] dp = new long[n];
        for (int currMana : mana) {
            long time = 0;
            long maxDiff = 0;
            for (int i = 0; i < n; i++) {
                maxDiff = Math.max(maxDiff, dp[i] - time);
                time += skill[i] * (long) currMana;
                dp[i] = time;
            }
            for (int i = 0; i < n; i++) {
                dp[i] += maxDiff;
            }
        }
        return dp[n - 1];
    }
}
