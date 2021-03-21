package leetcode.weekly_contests.weekly_233;

public class P_1800 {

    public int maxAscendingSum(int[] nums) {
        int best = 0;

        for (int i = 0; i < nums.length; i++) {
            int j = i + 1;
            int curr = nums[i];
            while (j < nums.length && nums[j - 1] < nums[j]) {
                curr += nums[j];
                j++;
            }
            i = j - 1;
            best = Math.max(best, curr);

        }
        return best;
    }
}
