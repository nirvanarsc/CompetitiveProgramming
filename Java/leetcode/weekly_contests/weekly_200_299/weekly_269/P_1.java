package leetcode.weekly_contests.weekly_200_299.weekly_269;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class P_1 {

    public List<Integer> targetIndices(int[] nums, int target) {
        final List<Integer> res = new ArrayList<>();
        final int n = nums.length;
        Arrays.sort(nums);
        for (int i = 0; i < n; i++) {
            if (nums[i] == target) {
                res.add(i);
            }
        }
        return res;
    }
}
