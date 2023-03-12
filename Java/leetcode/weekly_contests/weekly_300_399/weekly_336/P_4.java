package leetcode.weekly_contests.weekly_300_399.weekly_336;

public class P_4 {

    public int findMinimumTime(int[][] tasks) {
        int res = 0;
        for (int t = 1; t <= 2000; t++) {
            int chosen = 0;
            for (int[] c : tasks) {
                if (c[2] + t > c[1] && c[0] <= t && t <= c[1]) {
                    chosen = 1;
                    break;
                }
            }
            res += chosen;
            if (chosen == 1) {
                for (int[] c : tasks) {
                    if (c[0] <= t && t <= c[1] && c[2] >= 0) {
                        c[2]--;
                    }
                }
            }
        }
        return res;
    }
}
