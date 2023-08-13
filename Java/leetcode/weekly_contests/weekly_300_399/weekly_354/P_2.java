package leetcode.weekly_contests.weekly_300_399.weekly_354;

import java.util.Arrays;

public class P_2 {

    public int maximumBeauty(int[] nums, int k) {
        final int n = nums.length;
        final int[][] intervals = new int[2 * n][2];
        for (int i = 0; i < n; i++) {
            intervals[2 * i] = new int[] { nums[i] - k, 1 };
            intervals[2 * i + 1] = new int[] { nums[i] + k, -1 };
        }
        Arrays.sort(intervals, (a, b) -> a[0] == b[0] ? Integer.compare(b[1], a[1])
                                                      : Integer.compare(a[0], b[0]));
        int open = 0;
        int res = 0;
        for (int[] interval : intervals) {
            open += interval[1];
            res = Math.max(res, open);
        }
        return res;
    }
}
