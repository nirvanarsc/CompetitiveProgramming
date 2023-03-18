package leetcode.biweekly_contests.biweekly_0_99.biweekly_89;

public class P_4 {

    static int n;
    static int[] val;
    static int[][] e;
    static int[][] g;

    public int componentValue(int[] nums, int[][] edges) {
        n = nums.length;
        val = nums;
        e = edges;
        g = packG();
        int s = 0;
        for (int num : nums) {
            s += num;
        }
        int res = 0;
        for (int p = 1; p * p <= s; p++) {
            if (s % p == 0) {
                if (dfs(0, -1, s / p) == 0) {
                    res = Math.max(res, p - 1);
                }
                if (dfs(0, -1, p) == 0) {
                    res = Math.max(res, (s / p) - 1);
                }
            }
        }
        return res;
    }

    private static int dfs(int u, int p, int sum) {
        int add = val[u];
        for (int v : g[u]) {
            if (v != p) {
                final int curr = dfs(v, u, sum);
                if (curr == -1) {
                    return -1;
                }
                add += curr;
            }
        }
        if (add > sum) { return -1; }
        if (add == sum) { return 0; }
        return add;
    }

    private static int[][] packG() {
        final int[][] g = new int[n][];
        final int[] size = new int[n];
        for (int[] edge : e) {
            ++size[edge[0]];
            ++size[edge[1]];
        }
        for (int i = 0; i < n; i++) {
            g[i] = new int[size[i]];
        }
        for (int[] edge : e) {
            g[edge[0]][--size[edge[0]]] = edge[1];
            g[edge[1]][--size[edge[1]]] = edge[0];
        }
        return g;
    }
}
