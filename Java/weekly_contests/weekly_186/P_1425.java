package weekly_contests.weekly_186;

import utils.IntervalSegmentTree;

public class P_1425 {

    public int constrainedSubsetSum(int[] nums, int k) {
        final int n = nums.length;
        final IntervalSegmentTree st = new IntervalSegmentTree(0, (int) 1e9, 0, "MAX");
        int max = Integer.MIN_VALUE;
        for (int i = 1; i <= n; i++) {
            final int next = Math.max(0, st.query(st, Math.max(0, i - k), i)) + nums[i - 1];
            max = Math.max(max, next);
            st.update(st, i, i, next);
        }
        return max;
    }
}
