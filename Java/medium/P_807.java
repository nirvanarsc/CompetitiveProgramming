package medium;

public final class P_807 {

    public static int maxIncreaseKeepingSkyline(int[][] grid) {
        final int[] colMax = new int[grid[0].length];
        final int[] rowMax = new int[grid.length];
        int res = 0;

        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[0].length; col++) {
                rowMax[row] = Math.max(rowMax[row], grid[row][col]);
                colMax[col] = Math.max(colMax[col], grid[row][col]);
            }
        }

        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[0].length; col++) {
                res += Math.min(rowMax[row], colMax[col]) - grid[row][col];
            }
        }

        return res;
    }

    public static void main(String[] args) {
        final int[][] grid = { { 3, 0, 8, 4 }, { 2, 4, 5, 7 }, { 9, 2, 6, 3 }, { 0, 3, 1, 0 } };
        System.out.println(maxIncreaseKeepingSkyline(grid));
    }

    private P_807() {}
}
