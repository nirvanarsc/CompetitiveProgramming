package medium;

import java.util.HashMap;
import java.util.Map;
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
        if (t < 0) { return false; }
        final Map<Long, Long> map = new HashMap<>();
        final long w = (long) t + 1;
        for (int i = 0; i < nums.length; ++i) {
            final long m = Math.floorDiv(nums[i], w);
            if (map.containsKey(m)) {
                return true;
            }
            if (map.containsKey(m - 1) && Math.abs(nums[i] - map.get(m - 1)) < w) {
                return true;
            }
            if (map.containsKey(m + 1) && Math.abs(nums[i] - map.get(m + 1)) < w) {
                return true;
            }
            map.put(m, (long) nums[i]);
            if (i >= k) {
                map.remove(Math.floorDiv(nums[i - k], w));
            }
        }
        return false;
    }
}
