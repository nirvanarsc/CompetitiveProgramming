package leetcode.biweekly_contests.biweekly_100_199.biweekly_120;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

@SuppressWarnings("AccessStaticViaInstance")
public class P_4 {

    static class Node {
        PriorityQueue<Integer> neg = new PriorityQueue<>(Comparator.reverseOrder());
        PriorityQueue<Integer> pos = new PriorityQueue<>();

        long f() {
            final int n = pos.size() + neg.size();
            if (n < 3) {
                return 1;
            }
            final long[] arr = new long[n];
            int i = 0;
            for (long num : neg) {
                arr[i++] = num;
            }
            for (long num : pos) {
                arr[i++] = num;
            }
            Arrays.sort(arr);
            long res = 0;
            res = Math.max(res, arr[0] * arr[1] * arr[n - 1]);
            res = Math.max(res, arr[n - 1] * arr[n - 2] * arr[n - 3]);
            return res;
        }

        static void merge(PriorityQueue<Integer> l, PriorityQueue<Integer> r) {
            while (!r.isEmpty()) {
                add(l, r.remove());
            }
        }

        static void add(PriorityQueue<Integer> pq, int add) {
            pq.add(add);
            if (pq.size() > 3) {
                pq.remove();
            }
        }
    }

    static int n;
    static int[][] edges;
    static int[] v;
    static int[][] g;
    static long[] res;

    public long[] placedCoins(int[][] edges, int[] cost) {
        n = edges.length + 1;
        this.edges = edges;
        v = cost;
        g = packG();
        res = new long[n];
        dfs(0, -1);
        return res;
    }

    private static Node dfs(int u, int p) {
        final Node curr = new Node();
        for (int v : g[u]) {
            if (v != p) {
                final Node c = dfs(v, u);
                curr.merge(curr.neg, c.neg);
                curr.merge(curr.pos, c.pos);
            }
        }
        if (v[u] < 0) { Node.add(curr.neg, v[u]); } else { Node.add(curr.pos, v[u]); }
        res[u] = curr.f();
        return curr;
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
