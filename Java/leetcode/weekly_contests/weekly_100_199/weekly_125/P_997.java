package leetcode.weekly_contests.weekly_100_199.weekly_125;

public class P_997 {

    public int findJudge(int n, int[][] trust) {
        final int[][] g = new int[n][2];
        for (int i = 0; i < n; i++) {
            g[i] = new int[2];
        }
        for (int[] t : trust) {
            g[t[0] - 1][1]++;
            g[t[1] - 1][0]++;
        }
        for (int i = 0; i < n; i++) {
            if (g[i][0] == n - 1 && g[i][1] == 0) {
                return i + 1;
            }
        }
        return -1;
    }
}
