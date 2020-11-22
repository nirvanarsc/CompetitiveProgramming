package leetcode.weekly_contests.weekly_216;

import java.util.Arrays;

@SuppressWarnings("SubtractionInCompareTo")
public class P_4 {

    public int minimumEffort(int[][] tasks) {
        Arrays.sort(tasks, (a, b) -> -Integer.compare(a[1] - a[0], b[1] - b[0]));
        int res = 0;
        int curr = 0;
        for (int[] task : tasks) {
            final int diff = task[1] - curr;
            if (diff > 0) {
                res += diff;
                curr += diff;
            }
            curr -= task[0];
        }
        return res;
    }
}
