public final class IslandPerimeter {

    public static void main(String[] args) {
        System.out.println(islandPerimeter(new int[][] {
                { 0, 1, 0, 0 },
                { 1, 1, 1, 0 },
                { 0, 1, 0, 0 },
                { 1, 1, 0, 0 }
        }));
    }

    public static int islandPerimeter(int[][] grid) {
        final int rows = grid.length;
        final int cols = grid[0].length;
        int perimeter = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 1) {
                    if (i == 0 || grid[i - 1][j] == 0) { perimeter++; }         // UP
                    if (j == 0 || grid[i][j - 1] == 0) { perimeter++; }         // LEFT
                    if (i == rows - 1 || grid[i + 1][j] == 0) { perimeter++; }  // DOWN
                    if (j == cols - 1 || grid[i][j + 1] == 0) { perimeter++; }  // RIGHT
                }
            }
        }
        return perimeter;
    }

    private IslandPerimeter() {}
}
