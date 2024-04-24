package leetcode.weekly_contests.weekly_300_399.weekly_376;

public class P_1 {

    public int[] findMissingAndRepeatedValues(int[][] grid) {
        final int n = grid.length;
        final boolean[] seen = new boolean[(n * n) + 1];
        int diff = (n * n * ((n * n) + 1)) / 2;
        int dup = -1;
        for (int[] row : grid) {
            for (int i = 0; i < n; i++) {
                if (seen[row[i]]) {
                    dup = row[i];
                }
                seen[row[i]] = true;
                diff -= row[i];
            }
        }
        return new int[] { dup, dup + diff };
    }
}
