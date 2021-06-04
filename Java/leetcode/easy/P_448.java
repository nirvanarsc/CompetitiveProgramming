package leetcode.easy;

import java.util.ArrayList;
import java.util.List;

public class P_448 {

    public List<Integer> findDisappearedNumbers(int[] nums) {
        final int n = nums.length;
        final boolean[] seen = new boolean[n];
        for (int num : nums) {
            seen[num - 1] = true;
        }
        final List<Integer> res = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (!seen[i]) {
                res.add(i + 1);
            }
        }
        return res;
    }
}
