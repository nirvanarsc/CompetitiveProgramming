package medium;

import java.util.ArrayList;
import java.util.List;

public class P_163 {

    public List<String> findMissingRanges(int[] nums, int lower, int upper) {
        final List<String> list = new ArrayList<>();
        if (nums.length == 0) {
            helper((long) lower - 1, (long) upper + 1, list);
            return list;
        }
        for (int i = 0; i < nums.length + 1; i++) {
            if (i == 0) {
                helper((long) lower - 1, nums[0], list);
            } else if (i == nums.length) {
                helper(nums[nums.length - 1], (long) upper + 1, list);
            } else {
                helper(nums[i - 1], nums[i], list);
            }
        }
        return list;
    }

    public void helper(long a, long b, List<String> list) {
        if (b <= a + 1) {
            return;
        }
        if (b == a + 2) {
            list.add(String.valueOf(a + 1));
        } else {
            list.add((a + 1) + "->" + (b - 1));
        }
    }
}
