package binarysearch.weekly_38;

public class P_2 {

    static int n;
    static int[][] edges;
    static int[][] g;
    static boolean[] seen;
    static int[] count;

    public boolean solve(int[][] edges, int a, int b) {
        n = 0;
        for (int[] edge : edges) {
            n = Math.max(n, edge[0]);
            n = Math.max(n, edge[1]);
        }
        n++;
        //noinspection AccessStaticViaInstance
        this.edges = edges;
        g = packG();
        seen = new boolean[n];
        count = new int[n];
        dfs(a);
        seen = new boolean[n];
        dfs(b);
        for (int i = 0; i < n; i++) {
            if (count[i] == 2) {
                return true;
            }
        }
        return false;
    }

    private static void dfs(int u) {
        if (seen[u]) {
            return;
        }
        seen[u] = true;
        count[u]++;
        for (int v : g[u]) {
            dfs(v);
        }
    }

    private static int[][] packG() {
        final int[][] g = new int[n][];
        final int[] size = new int[n];
        for (int[] edge : edges) {
            ++size[edge[1]];
        }
        for (int i = 0; i < n; i++) {
            g[i] = new int[size[i]];
        }
        for (int[] edge : edges) {
            g[edge[1]][--size[edge[1]]] = edge[0];
        }
        return g;
    }
}
