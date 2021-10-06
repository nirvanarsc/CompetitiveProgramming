package leetcode.medium;

import java.util.ArrayList;
import java.util.List;

public class P_442 {

    public List<Integer> findDuplicates(int[] nums) {
        final List<Integer> res = new ArrayList<>();
        for (int num : nums) {
            final int abs = Math.abs(num);
            if (nums[abs - 1] < 0) {
                res.add(abs);
            }
            nums[abs - 1] = -nums[abs - 1];
        }
        return res;
    }
}
