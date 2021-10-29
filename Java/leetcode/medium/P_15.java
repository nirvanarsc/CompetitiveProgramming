package leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class P_15 {

    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        final List<List<Integer>> res = new ArrayList<>();
        final int n = nums.length;
        for (int i = 0; i < n - 2; i++) {
            if (i > 0 && nums[i - 1] == nums[i]) { continue; }
            int start = i + 1;
            int end = n - 1;
            final int target = -nums[i];
            while (start < end) {
                if (nums[start] + nums[end] < target) {
                    start++;
                } else if (nums[start] + nums[end] > target) {
                    end--;
                } else {
                    res.add(Arrays.asList(nums[i], nums[start], nums[end]));
                    while (start < end && nums[start + 1] == nums[start]) { start++; }
                    while (start < end && nums[end - 1] == nums[end]) { end--; }
                    start++;
                    end--;
                }
            }
        }
        return res;
    }
}
