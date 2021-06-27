package leetcode.weekly_contests.weekly_247;

public class P_4 {

    static int[] size;
    static int[][] edges;
    static int[][] g;
    static int n;

    private static final int MOD = (int) (1e9 + 7);

    public int waysToBuildRooms(int[] prevRoom) {
        n = prevRoom.length;
        size = new int[n];
        edges = new int[n - 1][2];
        int idx = 0;
        for (int v = 0; v < n; v++) {
            final int u = prevRoom[v];
            if (u != -1) {
                edges[idx++] = new int[] { u, v };
            }
        }
        g = packG();
        dfs(0, -1);
        long up = 1L;
        long down = 1L;
        for (int i = 0; i < n; i++) {
            up = (up * (i + 1)) % MOD;
            down = (down * size[i]) % MOD;
        }
        final long inv = modPow(down, MOD - 2);
        return (int) ((up * inv) % MOD);
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

    private static long modPow(long a, long n) {
        long res = 1;
        while (n > 0) {
            if (n % 2 != 0) {
                res = res * a % MOD;
            }
            a = a * a % MOD;
            n /= 2;
        }
        return res;
    }

    private static void dfs(int u, int p) {
        size[u] = 1;
        for (int v : g[u]) {
            if (v != p) {
                dfs(v, u);
                size[u] += size[v];
            }
        }
    }
}
