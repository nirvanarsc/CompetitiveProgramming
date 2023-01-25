package leetcode.weekly_contests.weekly_300_399.weekly_329;

import java.util.Arrays;

public class P_2 {

    public int[][] sortTheStudents(int[][] score, int k) {
        final int n = score.length;
        final int m = score[0].length;
        final int[][] sorted = new int[n][2];
        for (int i = 0; i < n; i++) {
            sorted[i] = new int[] { score[i][k], i };
        }
        Arrays.sort(sorted, (a, b) -> Integer.compare(b[0], a[0]));
        final int[][] res = new int[n][m];
        for (int i = 0; i < n; i++) {
            res[i] = score[sorted[i][1]];
        }
        return res;
    }
}
