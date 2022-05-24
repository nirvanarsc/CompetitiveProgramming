package leetcode.weekly_contests.weekly_200_299.weekly_290;

import java.util.ArrayList;
import java.util.List;

public class P_1 {

    public List<Integer> intersection(int[][] nums) {
        final int[] f = new int[1005];
        final int n = nums.length;
        for (int[] row : nums) {
            final int[] curr = new int[1005];
            for (int num : row) {
                curr[num]++;
            }
            for (int j = 0; j < curr.length; j++) {
                f[j] += curr[j] > 0 ? 1 : 0;
            }
        }
        final List<Integer> res = new ArrayList<>();
        for (int i = 0; i < f.length; i++) {
            if (f[i] == n) {
                res.add(i);
            }
        }
        return res;
    }
}
