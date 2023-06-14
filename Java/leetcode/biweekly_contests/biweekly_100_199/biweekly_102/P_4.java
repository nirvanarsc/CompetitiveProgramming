package leetcode.biweekly_contests.biweekly_100_199.biweekly_102;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

@SuppressWarnings({ "InnerClassMayBeStatic", "PublicConstructorInNonPublicClass", "unused" })
public class P_4 {

    class Graph {

        int n;
        Map<Integer, List<int[]>> g;

        public Graph(int n, int[][] edges) {
            this.n = n;
            g = new HashMap<>();
            for (int[] edge : edges) {
                addEdge(edge);
            }
        }

        public void addEdge(int[] edge) {
            g.computeIfAbsent(edge[0], val -> new ArrayList<>()).add(new int[] { edge[1], edge[2] });
        }

        public int shortestPath(int node1, int node2) {
            final int[] d = new int[n];
            Arrays.fill(d, (int) 1e9);
            d[node1] = 0;
            final PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
            pq.offer(new int[] { node1, d[node1] });
            while (!pq.isEmpty()) {
                final int[] curr = pq.remove();
                final int u = curr[0];
                final int w = curr[1];
                if (d[u] < w) {
                    continue;
                }
                for (int[] v : g.getOrDefault(u, Collections.emptyList())) {
                    if (d[v[0]] > d[u] + v[1]) {
                        d[v[0]] = d[u] + v[1];
                        pq.offer(new int[] { v[0], d[v[0]] });
                    }
                }
            }
            return d[node2] == (int) 1e9 ? -1 : d[node2];
        }
    }
}
