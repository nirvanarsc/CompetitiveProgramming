package leetcode.weekly_contests.weekly_300_399.weekly_304;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;

public class P_3 {

    static int n;
    static List<int[]> e;
    static int[][] g;

    public int closestMeetingNode(int[] edges, int node1, int node2) {
        n = edges.length;
        e = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (edges[i] != -1) {
                e.add(new int[] { i, edges[i] });
            }
        }
        g = packG();
        final int[] d1 = bfs(node1);
        final int[] d2 = bfs(node2);
        int res = (int) 1e9;
        int idx = -1;
        for (int i = 0; i < n; i++) {
            if (d1[i] != (int) 1e9 && d2[i] != (int) 1e9) {
                final int curr = Math.max(d1[i], d2[i]);
                if (res > curr) {
                    res = curr;
                    idx = i;
                }
            }
        }
        return res == (int) 1e9 ? -1 : idx;
    }

    private static int[] bfs(int s) {
        final int[] d = new int[n];
        Arrays.fill(d, (int) 1e9);
        d[s] = 0;
        final Deque<Integer> dq = new ArrayDeque<>();
        dq.offerLast(s);
        for (int level = 0; !dq.isEmpty(); level++) {
            for (int size = dq.size(); size > 0; size--) {
                final int u = dq.removeFirst();
                if (d[u] < level) {
                    continue;
                }
                for (int v : g[u]) {
                    if (d[v] > d[u] + 1) {
                        d[v] = d[u] + 1;
                        dq.offerLast(v);
                    }
                }
            }
        }
        return d;
    }

    private static int[][] packG() {
        final int[][] g = new int[n][];
        final int[] size = new int[n];
        for (int[] edge : e) {
            ++size[edge[0]];
        }
        for (int i = 0; i < n; i++) {
            g[i] = new int[size[i]];
        }
        for (int[] edge : e) {
            g[edge[0]][--size[edge[0]]] = edge[1];
        }
        return g;
    }
}
