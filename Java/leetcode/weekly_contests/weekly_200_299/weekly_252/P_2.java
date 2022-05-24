package leetcode.weekly_contests.weekly_200_299.weekly_252;

import java.util.Arrays;

public class P_2 {

    public long numberOfWeeks(int[] milestones) {
        Arrays.sort(milestones);
        long lower = 0;
        final int n = milestones.length;
        for (int i = 0; i < n - 1; i++) {
            lower += milestones[i];
        }
        if (lower >= milestones[n - 1]) {
            return lower + milestones[n - 1];
        }
        return (lower * 2) + 1;
    }
}
