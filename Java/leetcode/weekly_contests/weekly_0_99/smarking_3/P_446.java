package leetcode.weekly_contests.weekly_0_99.smarking_3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class P_446 {

    public int numberOfArithmeticSlices(int[] nums) {
        final Map<Long, List<Integer>> map = new HashMap<>();
        final int n = nums.length;
        final int[][] dp = new int[n][n];
        int res = 0;
        for (int i = 0; i < n; i++) {
            map.computeIfAbsent((long) nums[i], v -> new ArrayList<>()).add(i);
            for (int j = 0; j < i; j++) {
                final long target = 2 * (long) nums[j] - nums[i];
                for (int k : map.getOrDefault(target, Collections.emptyList())) {
                    if (k < j) {
                        dp[i][j] += dp[j][k] + 1;
                    }
                }
                res += dp[i][j];
            }
        }
        return res;
    }

    public int numberOfArithmeticSlicesConcise(int[] nums) {
        final Map<Integer, Map<Integer, Integer>> map = new HashMap<>();
        final int length = nums.length;
        int res = 0;
        for (int i = 0; i < length; i++) {
            map.put(i, new HashMap<>());
            for (int j = 0; j < i; j++) {
                final long diff = (long) nums[i] - nums[j];
                if (diff <= Integer.MIN_VALUE || diff > Integer.MAX_VALUE) {
                    continue;
                }
                final int d = (int) diff;
                final int c1 = map.get(i).getOrDefault(d, 0);
                final int c2 = map.get(j).getOrDefault(d, 0);
                res += c2;
                map.get(i).put(d, c1 + c2 + 1);
            }
        }
        return res;
    }
}
