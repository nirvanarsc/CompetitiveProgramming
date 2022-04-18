package leetcode.weekly_contests.weekly_289;

public class P_4 {

    static int n;
    static int[][] edges;
    static int[][] g;
    static char[] l;
    static int curr;
    static boolean[] seen;

    public int longestPath(int[] parent, String s) {
        n = parent.length;
        edges = new int[n - 1][2];
        for (int i = 1; i < n; i++) {
            edges[i - 1] = new int[] { i, parent[i] };
        }
        g = packG();
        l = s.toCharArray();
        int res = 0;
        seen = new boolean[n];
        for (int i = 0; i < n; i++) {
            if (!seen[i]) {
                curr = 0;
                dfs(i, -1);
                res = Math.max(res, curr);
            }
        }
        return res;
    }

    private static void dfs(int u, int p) {
        seen[u] = true;
        curr++;
        for (int v : g[u]) {
            if (l[u] != l[v] && v != p) {
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
