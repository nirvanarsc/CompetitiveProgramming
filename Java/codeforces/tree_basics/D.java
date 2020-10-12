package codeforces.tree_basics;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.TreeSet;

public final class D {

    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        final TreeSet<Integer> ts = new TreeSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (!ts.add(nums[i])) {
                return true;
            }
            final Integer higher = ts.higher(nums[i]);
            final Integer lower = ts.lower(nums[i]);
            if (higher != null && Math.abs(higher - nums[i]) <= t) {
                return true;
            }
            if (lower != null && Math.abs(lower - nums[i]) <= t) {
                return true;
            }
            if (ts.size() > k) {
                ts.remove(nums[i - k]);
            }
        }
        return false;
    }

    public static void main(String[] args) {
        final FastScanner fs = new FastScanner();
        final PrintWriter pw = new PrintWriter(System.out);
        final int n = fs.nextInt();
        final int m = fs.nextInt();
        final Map<Integer, List<int[]>> g = new HashMap<>();
        for (int i = 0; i < m; i++) {
            final int l = fs.nextInt() - 1;
            final int r = fs.nextInt() - 1;
            final int w = fs.nextInt();
            g.computeIfAbsent(l, v -> new ArrayList<>()).add(new int[] { r, w });
            g.computeIfAbsent(r, v -> new ArrayList<>()).add(new int[] { l, w });
        }
        final int[] parents = new int[n];
        final int[] depth = new int[n];
        final int[] costs = new int[n];
        dfs(g, 0, -1, 0, parents, depth, costs);
        final TreeAncestor ta = new TreeAncestor(n, parents, costs);
        final int q = fs.nextInt();
        for (int i = 0; i < q; i++) {
            final int a = fs.nextInt() - 1;
            final int b = fs.nextInt() - 1;
            pw.println(ta.getMin(a, b, depth));
        }
        pw.flush();
    }

    private static void dfs(Map<Integer, List<int[]>> g, int u, int v, int d,
                            int[] parents,
                            int[] depth,
                            int[] costs) {
        parents[u] = v;
        depth[u] = d;
        for (int[] next : g.getOrDefault(u, Collections.emptyList())) {
            if (next[0] != v) {
                costs[next[0]] = next[1];
                dfs(g, next[0], u, d + 1, parents, depth, costs);
            }
        }
    }

    private static final class TreeAncestor {
        int h;
        int[][] parents;
        int[][] minLift;

        private TreeAncestor(int n, int[] parent, int[] costs) {
            h = (int) (Math.log(n) / Math.log(2));
            parents = new int[h + 1][n];
            minLift = new int[h + 1][n];
            minLift[0] = costs;
            parents[0] = parent;
            for (int i = 1; i <= h; i++) {
                for (int j = 0; j < n; j++) {
                    final int nodeParent = parents[i - 1][j];
                    if (nodeParent != -1) {
                        parents[i][j] = parents[i - 1][nodeParent];
                        minLift[i][j] = Math.min(minLift[i - 1][j], minLift[i - 1][nodeParent]);
                    } else {
                        parents[i][j] = -1;
                    }
                }
            }
        }

        public int getKthAncestor(int node, int k, int[] ans) {
            for (int i = 0; i <= h; i++) {
                if ((k & (1 << i)) != 0) {
                    ans[0] = Math.min(ans[0], minLift[i][node]);
                    node = parents[i][node];
                    if (node == -1) {
                        return -1;
                    }
                }
            }
            return node;
        }

        public int getMin(int u, int v, int[] depth) {
            final int[] ans = { (int) 1e9 };
            if (depth[u] < depth[v]) {
                v = getKthAncestor(v, depth[v] - depth[u], ans);
            } else {
                u = getKthAncestor(u, depth[u] - depth[v], ans);
            }
            if (u == v) {
                return ans[0];
            }
            for (int i = h; i >= 0; i--) {
                if (parents[i][u] != parents[i][v]) {
                    ans[0] = Math.min(ans[0], minLift[i][u]);
                    ans[0] = Math.min(ans[0], minLift[i][v]);
                    u = parents[i][u];
                    v = parents[i][v];
                }
            }
            ans[0] = Math.min(ans[0], minLift[0][u]);
            ans[0] = Math.min(ans[0], minLift[0][v]);
            return ans[0];
        }
    }

    static class FastScanner {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer("");

        String next() {
            while (!st.hasMoreTokens()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    //noinspection CallToPrintStackTrace
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        int[] readArray(int n) {
            final int[] a = new int[n];
            for (int i = 0; i < n; i++) { a[i] = nextInt(); }
            return a;
        }

        long nextLong() {
            return Long.parseLong(next());
        }
    }
}
