package leetcode.weekly_contests.weekly_200_299.weekly_299;

public class P_1 {

    public boolean checkXMatrix(int[][] grid) {
        final int n = grid.length;
        int i = 0;
        int j = 0;
        while (i < n && j < n) {
            if (grid[i][j] == 0) {
                return false;
            }
            i++;
            j++;
        }
        i = 0;
        j = n - 1;
        while (i < n && j >= 0) {
            if (grid[i][j] == 0) {
                return false;
            }
            i++;
            j--;
        }
        i = 0;
        j = 0;
        while (i < n && j < n) {
            grid[i][j] = 0;
            i++;
            j++;
        }
        i = 0;
        j = n - 1;
        while (i < n && j >= 0) {
            grid[i][j] = 0;
            i++;
            j--;
        }
        for (int[] ints : grid) {
            for (int l = 0; l < n; l++) {
                if (ints[l] != 0) {
                    return false;
                }
            }
        }
        return true;
    }
}
