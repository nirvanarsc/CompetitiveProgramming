package leetcode.biweekly_contests.biweekly_0_99.biweekly_86;

import java.util.HashSet;
import java.util.Set;

public class P_1 {

    public boolean findSubarrays(int[] nums) {
        final int n = nums.length;
        final Set<Integer> seen = new HashSet<>();
        for (int i = 0; i < n - 1; i++) {
            if (!seen.add(nums[i] + nums[i + 1])) {
                return true;
            }
        }
        return false;
    }
}
