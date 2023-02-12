package leetcode.weekly_contests.weekly_300_399.weekly_332;

public class P_1 {

    public long findTheArrayConcVal(int[] nums) {
        long res = 0;
        int i = 0;
        int j = nums.length - 1;
        while (i < j) {
            final long curr = Long.parseLong(nums[i] + String.valueOf(nums[j]));
            res += curr;
            i++;
            j--;
        }
        if (i == j) {
            res += nums[i];
        }
        return res;
    }
}
