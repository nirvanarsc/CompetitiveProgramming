package leetcode.biweekly_contests.biweekly_100_199.biweekly_114;

@SuppressWarnings("AccessStaticViaInstance")
public class P_4 {

    static int n;
    static int k;
    static int[][] edges;
    static int[][] g;
    static int[] f;
    static int res;

    public int maxKDivisibleComponents(int n, int[][] edges, int[] values, int k) {
        this.n = n;
        this.k = k;
        this.edges = edges;
        g = packG();
        f = values;
        res = 1;
        dfs(0, -1);
        return res;
    }

    private static void dfs(int u, int p) {
        f[u] %= k;
        for (int v : g[u]) {
            if (v != p) {
                dfs(v, u);
                f[u] = (f[u] + f[v]) % k;
                if (f[v] == 0) {
                    res++;
                }
            }
        }
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
