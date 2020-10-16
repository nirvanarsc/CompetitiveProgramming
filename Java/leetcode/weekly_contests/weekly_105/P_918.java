package leetcode.weekly_contests.weekly_105;

@SuppressWarnings("MethodParameterNamingConvention")
public class P_918 {

    public int maxSubarraySumCircular(int[] A) {
        int maxSub = -30000;
        int currMax = -30000;
        int minSub = 30000;
        int currMinSub = 30000;
        int sum = 0;
        for (int value : A) {
            currMax = Math.max(currMax + value, value);
            maxSub = Math.max(maxSub, currMax);
            currMinSub = Math.min(currMinSub + value, value);
            minSub = Math.min(minSub, currMinSub);
            sum += value;
        }
        if (maxSub < 0) {
            return maxSub;
        }
        return Math.max(sum - minSub, maxSub);
    }
}
