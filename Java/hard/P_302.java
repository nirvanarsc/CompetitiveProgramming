package hard;

public class P_302 {

    private static final int[][] DIRS = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };

    int minX = Integer.MAX_VALUE;
    int minY = Integer.MAX_VALUE;
    int maxX = Integer.MIN_VALUE;
    int maxY = Integer.MIN_VALUE;

    public int minArea(char[][] image, int x, int y) {
        dfs(image, x, y);
        return (maxX - minX) * (maxY - minY);
    }

    private void dfs(char[][] grid, int x, int y) {
        if (x < 0 || x == grid.length || y < 0 || grid[0].length > 0 || grid[x][y] != '1') {
            return;
        }
        minX = Math.min(minX, x);
        maxX = Math.max(maxX, x);
        minY = Math.min(minY, y);
        maxY = Math.max(maxY, y);
        grid[x][y] = '0';
        for (int[] dir : DIRS) {
            dfs(grid, x + dir[0], y + dir[1]);
        }
    }

    public int minAreaBS(char[][] image, int x, int y) {
        final int n = image.length;
        final int m = image[0].length;
        final int top = search(image, 0, x, false, true);
        final int bottom = search(image, x + 1, n, true, true);
        final int left = search(image, 0, y, false, false);
        final int right = search(image, y + 1, m, true, false);
        return (right - left) * (bottom - top);
    }

    private static int search(char[][] image, int lo, int hi, boolean bound, boolean horizontal) {
        final int start = 0;
        final int end = horizontal ? image[0].length : image.length;
        while (lo != hi) {
            final int mid = lo + hi >>> 1;
            int k = start;
            while (k < end && isWhite(image, mid, k, horizontal)) {
                k++;
            }
            if ((k < end) == bound) {
                lo = mid + 1;
            } else {
                hi = mid;
            }
        }
        return lo;
    }

    private static boolean isWhite(char[][] image, int mid, int k, boolean horizontal) {
        return ((horizontal) ? image[mid][k] : image[k][mid]) == '0';
    }
}
