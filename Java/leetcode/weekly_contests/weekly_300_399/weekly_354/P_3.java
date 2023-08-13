package leetcode.weekly_contests.weekly_300_399.weekly_354;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class P_3 {

    public int minimumIndex(List<Integer> nums) {
        final Map<Integer, Integer> f = new HashMap<>();
        int mostD = -1;
        int dCount = -1;
        for (int num : nums) {
            final int nc = f.merge(num, 1, Integer::sum);
            if (dCount < nc) {
                dCount = nc;
                mostD = num;
            }
        }
        final int n = nums.size();
        final int[] pre = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            pre[i] = pre[i - 1] + (nums.get(i - 1) == mostD ? 1 : 0);
        }
        for (int i = 0; i < n; i++) {
            if (f(i + 1, pre[i + 1]) && f(n - i - 1, pre[n] - pre[i + 1])) {
                return i;
            }
        }
        return -1;
    }

    private static boolean f(int len, int count) {
        return 2 * count > len;
    }
}
