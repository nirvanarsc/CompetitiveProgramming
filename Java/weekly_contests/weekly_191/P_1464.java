package weekly_contests.weekly_191;

import java.util.Arrays;

public class P_1464 {

    public int maxProduct(int[] nums) {
        Arrays.sort(nums);
        final int n = nums.length;
        return (nums[n - 1] - 1) * (nums[n - 2] - 1);
    }
}
