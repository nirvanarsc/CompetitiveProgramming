package leetcode.weekly_contests.weekly_100_199.weekly_198;

@SuppressWarnings("AccessStaticViaInstance")
public class P_1519 {

    static int n;
    static int[][] edges;
    static int[][] g;
    static int[] res;
    static char[] w;

    public int[] countSubTrees(int n, int[][] edges, String labels) {
        this.n = n;
        this.edges = edges;
        g = packG();
        res = new int[n];
        w = labels.toCharArray();
        dfs(0, -1);
        return res;
    }

    private static int[] dfs(int u, int par) {
        final int[] count = new int[26];
        for (int v : g[u]) {
            if (v != par) {
                final int[] child = dfs(v, u);
                for (int i = 0; i < 26; i++) {
                    count[i] += child[i];
                }
            }
        }
        res[u] = ++count[w[u] - 'a'];
        return count;
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
