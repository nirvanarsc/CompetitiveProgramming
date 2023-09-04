package leetcode.weekly_contests.weekly_300_399.weekly_361;

@SuppressWarnings("AccessStaticViaInstance")
public class P_4 {

    private static class SegTree {
        int leftMost, rightMost;
        SegTree left, right;
        int[] f = new int[26];

        SegTree(int leftMost, int rightMost, int[] arr) {
            this.leftMost = leftMost;
            this.rightMost = rightMost;
            if (leftMost == rightMost) {
                f[arr[leftMost]]++;
            } else {
                final int mid = leftMost + rightMost >>> 1;
                left = new SegTree(leftMost, mid, arr);
                right = new SegTree(mid + 1, rightMost, arr);
                recalc();
            }
        }

        private void recalc() {
            if (leftMost == rightMost) {
                return;
            }
            f = merge(left.f, right.f);
        }

        private int[] query(int l, int r) {
            if (r < leftMost || l > rightMost) {
                return new int[26];
            }
            if (l <= leftMost && rightMost <= r) {
                return f;
            }
            return merge(left.query(l, r), right.query(l, r));
        }

        private static int[] merge(int[] l, int[] r) {
            final int[] res = new int[26];
            for (int i = 0; i < 26; i++) {
                res[i] = l[i] + r[i];
            }
            return res;
        }
    }

    static int n;
    static int h;
    static int labelTime;
    static int time;
    static int[][] parents;
    static int[][] edges;
    static int[][][] g;
    static int[] parent;
    static int[] depth;
    static int[] size;
    static int[] heavy;
    static int[] label;
    static int[] topChain;
    static int[] in;
    static int[] out;
    static SegTree st;

    public int[] minOperationsQueries(int n, int[][] edges, int[][] queries) {
        if (n == 1) {
            return new int[queries.length];
        }
        this.n = n;
        this.edges = edges;
        labelTime = 0;
        time = 0;
        h = 18;
        g = packG();
        parent = new int[n];
        depth = new int[n];
        size = new int[n];
        heavy = new int[n];
        label = new int[n];
        topChain = new int[n];
        in = new int[n];
        out = new int[n];
        dfs1(0, 0);
        initParents();
        dfs2(0, 0);
        final int[] stArr = new int[n];
        for (int[] edge : edges) {
            stArr[Math.max(label[edge[0]], label[edge[1]])] = edge[2] - 1;
        }
        st = new SegTree(0, n - 1, stArr);
        final int q = queries.length;
        final int[] res = new int[q];
        for (int i = 0; i < q; i++) {
            final int u = queries[i][0];
            final int v = queries[i][1];
            final int lca = getLca(u, v);
            final int[] curr = st.merge(queryChain(u, lca), queryChain(v, lca));
            final int dist = depth[u] + depth[v] - 2 * depth[lca];
            int max = 0;
            for (int j = 0; j < 26; j++) {
                max = Math.max(max, curr[j]);
            }
            res[i] = dist - max;
        }
        return res;
    }

    private static int[] queryChain(int u, int v) {
        int[] res = new int[26];
        while (depth[v] < depth[u]) {
            int top = topChain[u];
            if (depth[top] <= depth[v]) {
                final int diff = depth[u] - depth[v];
                top = getKthAncestor(u, diff - 1);
            }
            res = st.merge(res, st.query(label[top], label[u]));
            u = parent[top];
        }
        return res;
    }

    private static void dfs1(int u, int v) {
        size[u] = 1;
        parent[u] = v;
        in[u] = time++;
        int max = g[u][0][0];
        for (int[] next : g[u]) {
            if (next[0] != v) {
                depth[next[0]] = depth[u] + 1;
                dfs1(next[0], u);
                size[u] += size[next[0]];
                if (size[max] < size[next[0]]) {
                    max = next[0];
                }
            }
        }
        out[u] = time;
        heavy[u] = max;
    }

    private static void dfs2(int u, int v) {
        label[u] = labelTime++;
        if (heavy[u] != v) {
            topChain[heavy[u]] = topChain[u];
            dfs2(heavy[u], u);
        }
        for (int[] next : g[u]) {
            if (next[0] != v && next[0] != heavy[u]) {
                topChain[next[0]] = next[0];
                dfs2(next[0], u);
            }
        }
    }

    private static void initParents() {
        parents = new int[h + 1][n];
        parents[0] = parent;
        for (int i = 1; i <= h; i++) {
            for (int u = 0; u < n; u++) {
                final int nodeParent = parents[i - 1][u];
                parents[i][u] = parents[i - 1][nodeParent];
            }
        }
    }

    private static int getKthAncestor(int u, int k) {
        for (int i = 0; i <= h; i++) {
            if ((k & (1 << i)) != 0) {
                u = parents[i][u];
            }
        }
        return u;
    }

    private static boolean isAncestor(int u, int v) {
        return in[u] <= in[v] && out[v] <= out[u];
    }

    private static int getLca(int u, int v) {
        if (isAncestor(u, v)) { return u; }
        if (isAncestor(v, u)) { return v; }
        for (int i = h; i >= 0; i--) {
            if (!isAncestor(parents[i][u], v)) {
                u = parents[i][u];
            }
        }
        return parents[0][u];
    }

    private static int[][][] packG() {
        final int[][][] g = new int[n][][];
        final int[] size = new int[n];
        for (int[] edge : edges) {
            ++size[edge[0]];
            ++size[edge[1]];
        }
        for (int i = 0; i < n; i++) {
            g[i] = new int[size[i]][2];
        }
        for (int[] edge : edges) {
            g[edge[0]][--size[edge[0]]] = new int[] { edge[1], edge[2] };
            g[edge[1]][--size[edge[1]]] = new int[] { edge[0], edge[2] };
        }
        return g;
    }
}
