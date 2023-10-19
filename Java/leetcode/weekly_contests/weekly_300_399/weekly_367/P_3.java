package leetcode.weekly_contests.weekly_300_399.weekly_367;

import java.util.Map;
import java.util.TreeMap;

public class P_3 {

    public int[] findIndices(int[] nums, int indexDifference, int valueDifference) {
        final TreeMap<Integer, Integer> tm = new TreeMap<>();
        final int n = nums.length;
        for (int i = indexDifference; i < n; i++) {
            tm.put(nums[i - indexDifference], i - indexDifference);
            final Map.Entry<Integer, Integer> u = tm.ceilingEntry(nums[i] + valueDifference);
            final Map.Entry<Integer, Integer> v = tm.floorEntry(nums[i] - valueDifference);
            if (u != null) {
                return new int[] { i, u.getValue() };
            }
            if (v != null) {
                return new int[] { i, v.getValue() };
            }
        }
        return new int[] { -1, -1 };
    }
}
