package leetcode.biweekly_contests.biweekly_100_199.biweekly_100;

import java.util.TreeSet;

public class P_3 {

    public long findScore(int[] nums) {
        final int n = nums.length;
        final TreeSet<Integer> ts = new TreeSet<>((a, b) -> nums[a] == nums[b]
                                                            ? Integer.compare(a, b)
                                                            : Integer.compare(nums[a], nums[b]));
        for (int i = 0; i < n; i++) {
            ts.add(i);
        }
        long res = 0;
        while (!ts.isEmpty()) {
            //noinspection ConstantConditions
            final int u = ts.pollFirst();
            if (u > 0) {
                ts.remove(u - 1);
            }
            if (u < n - 1) {
                ts.remove(u + 1);
            }
            res += nums[u];
        }
        return res;
    }
}
