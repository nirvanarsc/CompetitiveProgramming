package leetcode.weekly_contests.weekly_300_399.weekly_320;

public class P_3 {

    static int n;
    static int[][] edges;
    static int[][] g;
    static int[] size;
    static long res;

    public long minimumFuelCost(int[][] roads, int seats) {
        n = roads.length + 1;
        edges = roads;
        g = packG();
        size = new int[n];
        res = 0;
        dfs(0, -1, 0, seats);
        return res;
    }

    private static void dfs(int u, int p, int curr, int seats) {
        size[u] = 1;
        for (int v : g[u]) {
            if (v != p) {
                dfs(v, u, curr, seats);
                size[u] += size[v];
                res += (size[v] + seats - 1) / seats;
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
