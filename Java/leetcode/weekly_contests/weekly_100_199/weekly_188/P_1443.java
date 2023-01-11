package leetcode.weekly_contests.weekly_100_199.weekly_188;

import java.util.List;

@SuppressWarnings("AccessStaticViaInstance")
public class P_1443 {

    static int res;
    static int n;
    static int[][] edges;
    static int[][] g;
    static List<Boolean> hasApple;

    public int minTime(int n, int[][] edges, List<Boolean> hasApple) {
        res = 0;
        this.n = n;
        this.edges = edges;
        g = packG();
        this.hasApple = hasApple;
        dfs(0, -1);
        return res;
    }

    private static boolean dfs(int u, int par) {
        boolean take = hasApple.get(u);
        for (int v : g[u]) {
            if (v != par) {
                take |= dfs(v, u);
            }
        }
        if (take && u != 0) {
            res += 2;
        }
        return take;
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
