package leetcode.weekly_contests.weekly_200_299.weekly_221;

public class P_1706 {

    public int[] findBall(int[][] grid) {
        final int[] res = new int[grid[0].length];
        outer:
        for (int i = 0; i < res.length; i++) {
            int r = 0;
            int c = i;
            while (r < grid.length) {
                if (grid[r][c] == 1) {
                    if (c == res.length - 1 || grid[r][c + 1] == -1) {
                        res[i] = -1;
                        continue outer;
                    }
                    r += 1;
                    c += 1;
                } else {
                    if (c == 0 || grid[r][c - 1] == 1) {
                        res[i] = -1;
                        continue outer;
                    }
                    r += 1;
                    c -= 1;
                }
            }
            res[i] = c;
        }
        return res;
    }
}
