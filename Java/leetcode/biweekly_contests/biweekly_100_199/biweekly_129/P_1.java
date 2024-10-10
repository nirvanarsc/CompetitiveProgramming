package leetcode.biweekly_contests.biweekly_100_199.biweekly_129;

public class P_1 {

    public boolean canMakeSquare(char[][] grid) {
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                if (sum(grid, i, j) != 2) {
                    return true;
                }
            }
        }
        return false;
    }

    private static int sum(char[][] g, int r, int c) {
        return f(g[r][c]) + f(g[r][c + 1]) + f(g[r + 1][c]) + f(g[r + 1][c + 1]);
    }

    private static int f(char c) {
        return c == 'B' ? 1 : 0;
    }
}
