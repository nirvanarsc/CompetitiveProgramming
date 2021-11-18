package leetcode.easy;

import java.util.ArrayList;
import java.util.List;

public class P_448 {

    public List<Integer> findDisappearedNumbers(int[] nums) {
        final List<Integer> res = new ArrayList<>();
        final int n = nums.length;
        for (int i = 0; i < n; i++) {
            final int idx = Math.abs(nums[i]) - 1;
            if (nums[idx] > 0) {
                nums[idx] = -nums[idx];
            }
        }
        for (int i = 0; i < n; i++) {
            if (nums[i] > 0) {
                res.add(i + 1);
            }
        }
        return res;
    }
}
