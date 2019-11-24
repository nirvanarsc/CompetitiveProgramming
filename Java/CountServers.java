public final class CountServers {

    public static int countServers(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) { return 0; }
        final int numRows = grid.length;
        final int numCols = grid[0].length;
        final int[] rowCount = new int[numRows];
        final int[] colCount = new int[numCols];
        int totalServers = 0;
        for (int row = 0; row < numRows; row++) {
            for (int col = 0; col < numCols; col++) {
                if (grid[row][col] == 1) {
                    rowCount[row]++;
                    colCount[col]++;
                    totalServers++;
                }
            }
        }
        for (int row = 0; row < numRows; row++) {
            for (int col = 0; col < numCols; col++) {
                if (grid[row][col] == 1) {
                    if (rowCount[row] == 1 && colCount[col] == 1) {
                        totalServers--;
                    }
                }
            }
        }
        return totalServers;
    }

    public static void main(String[] args) {
        System.out.println(countServers(new int[][] { { 1, 0 }, { 0, 1 } }));
        System.out.println(countServers(new int[][] { { 1, 0 }, { 1, 1 } }));
        System.out.println(countServers(new int[][] {
                { 1, 1, 0, 0 },
                { 0, 0, 1, 0 },
                { 0, 0, 1, 0 },
                { 0, 0, 0, 1 }
        }));

    }

    private CountServers() {}
}
