package leetcode.weekly_contests.weekly_200_299.weekly_216;

import java.util.Arrays;

public class P_1665 {

    public int minimumEffort(int[][] tasks) {
        final int n = tasks.length;
        final int[][] pairs = new int[n][2];
        for (int i = 0; i < n; i++) {
            pairs[i] = new int[] { tasks[i][1] - tasks[i][0], i };
        }
        Arrays.sort(pairs, (a, b) -> Integer.compare(b[0], a[0]));
        int res = 0;
        int curr = 0;
        for (int[] pair : pairs) {
            final int idx = pair[1];
            final int diff = tasks[idx][1] - curr;
            if (diff > 0) {
                res += diff;
                curr += diff;
            }
            curr -= tasks[idx][0];
        }
        return res;
    }
}
