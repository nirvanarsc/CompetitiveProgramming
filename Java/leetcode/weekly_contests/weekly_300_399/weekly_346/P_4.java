package leetcode.weekly_contests.weekly_300_399.weekly_346;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class P_4 {

    public static final int[][] EMPTY = new int[0][0];
    static List<List<Integer>> g;
    static List<int[]> undeterminedEdges;
    static long[][] edgeWeights;
    static long[] d;
    static int start;
    static int end;
    static PriorityQueue<long[]> pq;

    public int[][] modifiedGraphEdges(int n, int[][] edges, int source, int destination, int target) {
        g = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            g.add(new ArrayList<>());
        }
        undeterminedEdges = new ArrayList<>();
        final List<int[]> validEdges = new ArrayList<>();
        edgeWeights = new long[n][n];
        for (long[] edge : edgeWeights) {
            Arrays.fill(edge, (long) 1e18);
        }
        d = new long[n];
        start = source;
        end = destination;
        pq = new PriorityQueue<>(Comparator.comparingLong(a -> a[1]));
        for (int[] edge : edges) {
            final int u = edge[0];
            final int v = edge[1];
            final int w = edge[2] == -1 ? target + 1 : edge[2];
            g.get(u).add(v);
            g.get(v).add(u);
            edgeWeights[u][v] = w;
            edgeWeights[v][u] = w;
            validEdges.add(new int[] { u, v });
            if (edge[2] == -1) {
                undeterminedEdges.add(new int[] { u, v });
            }
        }
        if (f(0, target - 1) || !f(undeterminedEdges.size(), target)) {
            return EMPTY;
        }
        int lo = 0;
        int hi = undeterminedEdges.size() - 1;
        while (lo < hi) {
            final int mid = lo + hi + 1 >>> 1;
            if (f(mid, target)) {
                hi = mid - 1;
            } else {
                lo = mid;
            }
        }
        f(lo + 1, target);
        if (lo != undeterminedEdges.size()) {
            final int u = undeterminedEdges.get(lo)[0];
            final int v = undeterminedEdges.get(lo)[1];
            edgeWeights[u][v] = 1L + (target - d[destination]);
        }
        return validEdges
                .stream()
                .map(edge -> new int[] { edge[0], edge[1], (int) edgeWeights[edge[0]][edge[1]] })
                .toArray(int[][]::new);
    }

    private static boolean f(int mid, long target) {
        for (int i = 0; i < undeterminedEdges.size(); i++) {
            final long w = i < mid ? 1L : target + 1L;
            final int u = undeterminedEdges.get(i)[0];
            final int v = undeterminedEdges.get(i)[1];
            edgeWeights[u][v] = w;
            edgeWeights[v][u] = w;
        }
        Arrays.fill(d, (long) 1e18);
        d[start] = 0;
        pq.add(new long[] { start, d[start] });
        while (!pq.isEmpty()) {
            final long[] curr = pq.remove();
            final int u = (int) curr[0];
            final long w = curr[1];
            if (d[u] < w) {
                continue;
            }
            for (int v : g.get(u)) {
                final long nw = w + edgeWeights[u][v];
                if (nw < d[v]) {
                    d[v] = nw;
                    pq.offer(new long[] { v, nw });
                }
            }
        }
        return d[end] <= target;
    }
}
