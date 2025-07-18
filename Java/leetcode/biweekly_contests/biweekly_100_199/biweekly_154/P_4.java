package leetcode.biweekly_contests.biweekly_100_199.biweekly_154;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SuppressWarnings("AccessStaticViaInstance")
public class P_4 {

    private static int n;
    private static int time;
    private static int[][] edges;
    private static int[][][] g;
    private static int[] in;
    private static int[] out;
    private static int[] sum;

    private static final class BIT {
        private final long[] tree;
        private final int size;

        private BIT(int size) {
            this.size = size;
            tree = new long[size + 1];
        }

        public void add(int index, long delta) {
            index++;
            while (index <= size) {
                tree[index] += delta;
                index += index & -index;
            }
        }

        public long query(int index) {
            index++;
            long sum = 0;
            while (index > 0) {
                sum += tree[index];
                index -= index & -index;
            }
            return sum;
        }
    }

    public int[] treeQueries(int n, int[][] edges, int[][] queries) {
        this.n = n;
        this.edges = edges;
        time = 0;
        g = packG();
        in = new int[n];
        out = new int[n];
        sum = new int[n];
        dfs(0, -1);
        final List<Integer> res = new ArrayList<>();
        final BIT bit = new BIT(n);
        final Map<Long, Integer> edgeMap = new HashMap<>();
        for (int j = 0; j < edges.length; j++) {
            int u = edges[j][0] - 1;
            int v = edges[j][1] - 1;
            if (u > v) {
                final int temp = u;
                u = v;
                v = temp;
            }
            edgeMap.put(((long) u << 32) | v, j);
        }
        for (final int[] query : queries) {
            final int type = query[0];
            if (type == 1) {
                final int u = query[1] - 1;
                final int v = query[2] - 1;
                final int newWeight = query[3];
                final int keyU = Math.min(u, v);
                final int keyV = Math.max(u, v);
                final int edgeIdx = edgeMap.get(((long) keyU << 32) | keyV);
                final int oldWeight = edges[edgeIdx][2];
                final long delta = newWeight - oldWeight;
                edges[edgeIdx][2] = newWeight;

                final int child = isAncestor(u, v) ? v : u;
                bit.add(in[child], delta);
                if (out[child] < n) {
                    bit.add(out[child], -delta);
                }
            } else {
                final int x = query[1] - 1;
                final long initialSum = sum[x];
                final long accumulatedDelta = bit.query(in[x]);
                res.add((int) (initialSum + accumulatedDelta));
            }
        }
        return res.stream().mapToInt(Integer::intValue).toArray();
    }

    private static void dfs(int u, int p) {
        in[u] = time++;
        for (int[] v : g[u]) {
            if (v[0] != p) {
                sum[v[0]] = sum[u] + v[1];
                dfs(v[0], u);
            }
        }
        out[u] = time;
    }

    private static boolean isAncestor(int u, int v) {
        return in[u] <= in[v] && out[v] <= out[u];
    }

    private static int[][][] packG() {
        final int[][][] g = new int[n][][];
        final int[] size = new int[n];
        for (int[] edge : edges) {
            ++size[edge[0] - 1];
            ++size[edge[1] - 1];
        }
        for (int i = 0; i < n; i++) {
            g[i] = new int[size[i]][2];
        }
        for (int[] edge : edges) {
            g[edge[0] - 1][--size[edge[0] - 1]] = new int[] { edge[1] - 1, edge[2] };
            g[edge[1] - 1][--size[edge[1] - 1]] = new int[] { edge[0] - 1, edge[2] };
        }
        return g;
    }
}
