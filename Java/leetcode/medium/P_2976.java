package leetcode.medium;

public class P_2976 {

    public long minimumCost(String source, String target, char[] original, char[] changed, int[] cost) {
        final int n = 26;
        final int m = original.length;
        final long[][] g = new long[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i != j) {
                    g[i][j] = (long) 1e18;
                }
            }
        }
        for (int i = 0; i < m; i++) {
            final int u = original[i] - 'a';
            final int v = changed[i] - 'a';
            g[u][v] = Math.min(g[u][v], cost[i]);
        }
        final long[][] fw = floydWarshall(g, n);
        long res = 0;
        final char[] s = source.toCharArray();
        final char[] t = target.toCharArray();
        for (int i = 0; i < s.length; i++) {
            if (fw[s[i] - 'a'][t[i] - 'a'] == (long) 1e18) {
                return -1;
            }
            res += fw[s[i] - 'a'][t[i] - 'a'];
        }
        return res;
    }

    private static long[][] floydWarshall(long[][] graph, int n) {
        final long[][] dist = graph.clone();
        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
                }
            }
        }
        return dist;
    }
}
