package weekly_contests.weekly_58;

import java.util.Arrays;

public class P_724 {

    public int pivotIndex(int[] nums) {
        int total = Arrays.stream(nums).sum();
        int curr = 0;
        for (int i = 0; i < nums.length; i++) {
            total -= nums[i];
            if (curr == total) {
                return i;
            }
            curr += nums[i];
        }
        return -1;
    }
}
