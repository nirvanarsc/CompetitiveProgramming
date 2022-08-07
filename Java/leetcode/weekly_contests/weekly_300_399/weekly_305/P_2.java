package leetcode.weekly_contests.weekly_300_399.weekly_305;

@SuppressWarnings("AccessStaticViaInstance")
public class P_2 {

    static int n;
    static int[][] edges;
    static int[][] g;
    static boolean[] banned;
    static int res;

    public int reachableNodes(int n, int[][] edges, int[] restricted) {
        this.n = n;
        this.edges = edges;
        g = packG();
        banned = new boolean[n];
        for (int u : restricted) {
            banned[u] = true;
        }
        res = 0;
        dfs(0, -1);
        return res;
    }

    private static void dfs(int u, int p) {
        res++;
        for (int v : g[u]) {
            if (v != p && !banned[v]) {
                dfs(v, u);
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
