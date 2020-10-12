package leetcode.weekly_contests.weekly_17;

public class P_495 {

    public int findPoisonedDuration(int[] timeSeries, int duration) {
        if (timeSeries.length == 0) {
            return 0;
        }
        int res = duration;
        for (int i = 1; i < timeSeries.length; i++) {
            res += Math.min(timeSeries[i] - timeSeries[i - 1], duration);
        }
        return res;
    }
}
