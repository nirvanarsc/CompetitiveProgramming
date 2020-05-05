package weekly_contests.weekly_26;

import java.util.HashSet;
import java.util.Set;

public class P_548 {

    public boolean splitArray(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            nums[i] += nums[i - 1];
        }
        final int n = nums.length;
        for (int j = 3; j < nums.length - 3; j++) {
            final Set<Integer> seen = new HashSet<>();
            for (int i = 1; i < j - 1; i++) {
                if (nums[i - 1] == nums[j - 1] - nums[i]) {
                    seen.add(nums[i - 1]);
                }
            }
            for (int k = j + 1; k < nums.length - 1; k++) {
                if (nums[n - 1] - nums[k] == nums[k - 1] - nums[j] &&
                    seen.contains(nums[k - 1] - nums[j])) {
                    return true;
                }
            }
        }
        return false;
    }
}
