package medium;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class P_220 {

    public boolean containsNearbyAlmostDuplicateBST(int[] nums, int k, int t) {
        final TreeSet<Integer> set = new TreeSet<>();
        for (int i = 0; i < nums.length; ++i) {
            final Integer s = set.ceiling(nums[i]);
            if (s != null && s <= nums[i] + t) {
                return true;
            }
            final Integer g = set.floor(nums[i]);
            if (g != null && nums[i] <= g + t) {
                return true;
            }
            set.add(nums[i]);
            if (set.size() > k) {
                set.remove(nums[i - k]);
            }
        }
        return false;
    }

    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if (t <= 0) { return t == 0 ? containsNearbyDuplicate(nums, k) : false; }
        final Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            final int m = Math.floorDiv(nums[i], t);
            if (map.containsKey(m)
                || (map.containsKey(m - 1) && Math.abs(nums[i] - map.get(m - 1)) <= t)
                || (map.containsKey(m + 1) && Math.abs(nums[i] - map.get(m + 1)) <= t)) {
                return true;
            }
            map.put(m, nums[i]);
            if (i >= k) {
                map.remove(Math.floorDiv(nums[i - k], t));
            }
        }
        return false;
    }

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
