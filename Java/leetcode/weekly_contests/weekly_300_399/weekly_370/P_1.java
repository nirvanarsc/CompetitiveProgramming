package leetcode.weekly_contests.weekly_300_399.weekly_370;

public class P_1 {

    public int findChampion(int[][] grid) {
        final int n = grid.length;
        final int[] inDeg = new int[n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i != j && grid[i][j] == 1) {
                    inDeg[j]++;
                }
            }
        }
        for (int i = 0; i < n; i++) {
            if (inDeg[i] == 0) {
                return i;
            }
        }
        return -1;
    }
}
