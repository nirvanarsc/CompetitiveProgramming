package leetcode.weekly_contests.weekly_100_199.weekly_175;

public class P_1349 {

    public int maxStudentsSmart(char[][] seats) {
        final int n = seats.length;
        final int m = seats[0].length;
        final int[] rows = new int[n];
        for (int i = 0; i < n; i++) {
            int curr = 0;
            for (int j = 0; j < m; j++) {
                curr = curr * 2 + ((seats[i][j] == '.') ? 1 : 0);
            }
            rows[i] = curr;
        }
        return dfs(rows, 0, -1, 1 << m, new Integer[n][1 << m]);
    }

    private static int dfs(int[] rows, int row, int mask, int max, Integer[][] dp) {
        if (row == rows.length) {
            return Integer.bitCount(mask);
        }
        if (mask != -1 && dp[row][mask] != null) {
            return dp[row][mask];
        }
        int res = 0;
        for (int nextMask = 0; nextMask < max; nextMask++) {
            if ((nextMask & rows[row]) == nextMask && ((nextMask & (nextMask >> 1)) == 0)) {
                if (mask == -1) {
                    res = Math.max(res, dfs(rows, row + 1, nextMask, max, dp));
                } else if ((mask & (nextMask >> 1)) == 0 && (mask & (nextMask << 1)) == 0) {
                    res = Math.max(res, Integer.bitCount(mask) + dfs(rows, row + 1, nextMask, max, dp));
                }
            }
        }
        if (mask != -1) {
            dp[row][mask] = res;
        }
        return res;
    }

    public int maxStudents(char[][] seats) {
        final int n = seats.length;
        final int m = seats[0].length;
        return dfs(seats, 0, 0, 0, -1, new Integer[n][m][1 << m][1 << m]);
    }

    private static int dfs(char[][] seats, int row, int col, int currMask, int prevMask, Integer[][][][] dp) {
        if (row == seats.length) {
            return 0;
        }
        if (prevMask != -1 && dp[row][col][currMask][prevMask] != null) {
            return dp[row][col][currMask][prevMask];
        }
        int res = 0;
        if (col == seats[row].length - 1) {
            res = Math.max(res, dfs(seats, row + 1, 0, 0, currMask, dp));
            if (seats[row][col] == '.' && checkMasks(seats[row].length, col, currMask, prevMask)) {
                res = Math.max(res, 1 + dfs(seats, row + 1, 0, 0, currMask | (1 << col), dp));
            }
        } else {
            res = Math.max(res, dfs(seats, row, col + 1, currMask, prevMask, dp));
            if (seats[row][col] == '.' && checkMasks(seats[row].length, col, currMask, prevMask)) {
                res = Math.max(res, 1 + dfs(seats, row, col + 1, currMask | (1 << col), prevMask, dp));
            }
        }
        if (prevMask != -1) {
            dp[row][col][currMask][prevMask] = res;
        }
        return res;
    }

    private static boolean checkMasks(int colLength, int col, int currMask, int prevMask) {
        if (col != 0) {
            if ((currMask & (1 << (col - 1))) != 0) {
                return false;
            }
            if (prevMask != -1 && (prevMask & (1 << (col - 1))) != 0) {
                return false;
            }
        }
        if (col != colLength - 1) {
            if ((currMask & (1 << (col + 1))) != 0) {
                return false;
            }
            return prevMask == -1 || (prevMask & (1 << (col + 1))) == 0;
        }
        return true;
    }
}
