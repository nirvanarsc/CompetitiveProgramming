package leetcode.weekly_contests.weekly_204;

public class P_1567 {

    public int getMaxLen(int[] nums) {
        int firstNegative = -1;
        int lastZero = -1;
        int negativeCount = 0;
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < 0) {
                negativeCount++;
                if (firstNegative == -1) {
                    firstNegative = i;
                }
            } else if (nums[i] == 0) {
                firstNegative = -1;
                lastZero = i;
                negativeCount = 0;
            }
            res = Math.max(res, (negativeCount % 2 == 0) ? (i - lastZero) : (i - firstNegative));
        }
        return res;
    }
}
