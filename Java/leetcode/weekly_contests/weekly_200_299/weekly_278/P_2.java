package leetcode.weekly_contests.weekly_200_299.weekly_278;

import java.util.ArrayList;
import java.util.List;

public class P_2 {

    public List<Integer> maxScoreIndices(int[] nums) {
        final int n = nums.length;
        final int[] p1 = new int[n + 1];
        final int[] p0 = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            p1[i] = p1[i - 1] + nums[i - 1];
            p0[i] = p0[i - 1] + (1 ^ nums[i - 1]);
        }
        final List<Integer> res = new ArrayList<>();
        int max = 0;
        for (int i = 0; i <= n; i++) {
            max = Math.max(max, p0[i] + p1[n] - p1[i]);
        }
        for (int i = 0; i <= n; i++) {
            if (p0[i] + p1[n] - p1[i] == max) {
                res.add(i);
            }
        }
        return res;
    }
}
