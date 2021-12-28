package leetcode.weekly_contests.weekly_273;

public class P_2 {

    private static final int[][] DIRS = { { 0, -1 }, { -1, 0 }, { 0, 1 }, { 1, 0 } };
    private static final String idx = "LURD";

    public int[] executeInstructions(int n, int[] startPos, String s) {
        final int m = s.length();
        final char[] w = s.toCharArray();
        final int[] res = new int[m];
        for (int i = 0; i < m; i++) {
            int curr = 0;
            int x = startPos[0];
            int y = startPos[1];
            for (int j = i; j < m; j++) {
                final int dd = idx.indexOf(w[j]);
                final int nx = x + DIRS[dd][0];
                final int ny = y + DIRS[dd][1];
                if (0 <= nx && nx < n && 0 <= ny && ny < n) {
                    x = nx;
                    y = ny;
                    curr++;
                } else {
                    break;
                }
            }
            res[i] = curr;
        }
        return res;
    }
}
