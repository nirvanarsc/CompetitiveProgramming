package weekly_contests.weekly_60;

public class P_733 {

    private static final int[][] DIRS = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };

    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        if (image[sr][sc] != newColor) {
            fill(image, sr, sc, image[sr][sc], newColor);
        }
        return image;
    }

    private static void fill(int[][] grid, int r, int c, int oldC, int newC) {
        if (r < 0 || r >= grid.length || c < 0 || c >= grid[0].length || grid[r][c] != oldC) {
            return;
        }
        grid[r][c] = newC;
        for (int[] dir : DIRS) {
            fill(grid, r + dir[0], c + dir[1], oldC, newC);
        }
    }
}
