package leetcode.easy;

import java.util.HashSet;
import java.util.Set;

public class P_219 {

    public boolean containsNearbyDuplicate(int[] nums, int k) {
        final Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (!set.add(nums[i])) {
                return true;
            }
            if (set.size() > k) {
                set.remove(nums[i - k]);
            }
        }
        return false;
    }
}
