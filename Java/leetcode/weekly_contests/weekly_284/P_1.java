package leetcode.weekly_contests.weekly_284;

import java.util.ArrayList;
import java.util.List;

public class P_1 {

    public List<Integer> findKDistantIndices(int[] nums, int key, int k) {
        final List<Integer> res = new ArrayList<>();
        final int n = nums.length;
        for (int i = 0; i < n; i++) {
            for (int j = Math.max(0, i - k); j - i <= k && j < n; j++) {
                if (nums[j] == key) {
                    res.add(i);
                    break;
                }
            }
        }
        return res;
    }
}
