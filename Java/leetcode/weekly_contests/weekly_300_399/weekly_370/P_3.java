package leetcode.weekly_contests.weekly_300_399.weekly_370;

@SuppressWarnings("AccessStaticViaInstance")
public class P_3 {

    static int n;
    static int[] values;
    static int[][] edges;
    static int[][] g;

    public long maximumScoreAfterOperations(int[][] edges, int[] values) {
        n = edges.length + 1;
        this.edges = edges;
        this.values = values;
        g = packG();
        return dfs(0, -1)[0];
    }

    private static long[] dfs(int u, int p) {
        long take = 0;
        long leave = 0;
        for (int v : g[u]) {
            if (v != p) {
                final long[] next = dfs(v, u);
                take += next[0];
                leave += next[1];
            }
        }
        take += leave != 0 ? Math.max(leave, values[u]) : 0;
        leave = leave != 0 ? Math.min(leave, values[u]) : values[u];
        return new long[] { take, leave };
    }

    private static int[][] packG() {
        final int[][] g = new int[n][];
        final int[] size = new int[n];
        for (int[] edge : edges) {
            ++size[edge[0]];
            ++size[edge[1]];
        }
        for (int i = 0; i < n; i++) {
            g[i] = new int[size[i]];
        }
        for (int[] edge : edges) {
            g[edge[0]][--size[edge[0]]] = edge[1];
            g[edge[1]][--size[edge[1]]] = edge[0];
        }
        return g;
    }
}
