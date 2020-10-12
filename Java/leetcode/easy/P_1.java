package leetcode.easy;

import java.util.HashMap;
import java.util.Map;

public class P_1 {

    public static final int[] INTS = new int[0];

    public int[] twoSum(int[] nums, int target) {
        final Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                return new int[] { i, map.get(target - nums[i]) };
            }
            map.put(nums[i], i);
        }
        return INTS;
    }
}
