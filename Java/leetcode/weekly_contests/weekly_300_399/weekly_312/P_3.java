package leetcode.weekly_contests.weekly_300_399.weekly_312;

import java.util.ArrayList;
import java.util.List;

public class P_3 {

    public List<Integer> goodIndices(int[] nums, int k) {
        final int n = nums.length;
        final int[] nonInc = new int[n];
        final int[] nonDec = new int[n];
        for (int i = 1; i < n; i++) {
            nonInc[i] = nonInc[i - 1] + (nums[i - 1] < nums[i] ? 1 : 0);
            nonDec[i] = nonDec[i - 1] + (nums[i - 1] > nums[i] ? 1 : 0);
        }
        final List<Integer> res = new ArrayList<>();
        for (int i = k; i < n - k; i++) {
            if (nonInc[i - 1] - nonInc[i - k] == 0 && nonDec[i + k] - nonDec[i + 1] == 0) {
                res.add(i);
            }
        }
        return res;
    }
}
