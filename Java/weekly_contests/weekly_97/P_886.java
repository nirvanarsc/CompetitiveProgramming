package weekly_contests.weekly_97;

@SuppressWarnings("MethodParameterNamingConvention")
public class P_886 {

    public boolean possibleBipartition(int N, int[][] dislikes) {
        final boolean[][] g = new boolean[N][N];
        for (int[] d : dislikes) {
            g[d[0] - 1][d[1] - 1] = true;
            g[d[1] - 1][d[0] - 1] = true;
        }
        final int[] colors = new int[N];
        for (int i = 0; i < N; i++) {
            if (colors[i] == 0 && !paint(i, 1, colors, g)) {
                return false;
            }
        }
        return true;
    }

    private static boolean paint(int u, int color, int[] colors, boolean[][] g) {
        if (colors[u] != 0) {
            return colors[u] == color;
        }
        colors[u] = color;
        for (int v = 0; v < colors.length; v++) {
            if (g[u][v] && !paint(v, -color, colors, g)) {
                return false;
            }
        }
        return true;
    }
}
