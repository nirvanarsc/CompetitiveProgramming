package weekly_contests.weekly_46;

public class P_661 {

    private static final int[][] DIRS = {
            { 0, -1 }, { 0, 1 }, { 1, 0 }, { -1, 0 }, { 1, 1 }, { 1, -1 }, { -1, 1 }, { -1, -1 }
    };

    @SuppressWarnings("MethodParameterNamingConvention")
    public int[][] imageSmoother(int[][] M) {
        final int n = M.length;
        final int m = M[0].length;
        final int[][] ints = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int count = M[i][j];
                int cells = 1;
                for (int[] dir : DIRS) {
                    final int nx = i + dir[0];
                    final int ny = j + dir[1];
                    if (0 <= nx && nx < n && 0 <= ny && ny < m) {
                        cells++;
                        count += M[nx][ny];
                    }
                }
                ints[i][j] = count / cells;
            }
        }
        return ints;
    }
}
