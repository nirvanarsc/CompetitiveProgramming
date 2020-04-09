package weekly_contests.weekly_62;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

@SuppressWarnings("MethodParameterNamingConvention")
public class P_743 {

    public int networkDelayTime(int[][] times, int N, int K) {
        final PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        final boolean[] visited = new boolean[N + 1];
        final Map<Integer, List<int[]>> graph = new HashMap<>();
        for (int[] edge : times) {
            graph.computeIfAbsent(edge[0], v -> new ArrayList<>()).add(new int[] { edge[1], edge[2] });
        }
        pq.offer(new int[] { K, 0 });
        int res = 0;
        while (!pq.isEmpty()) {
            final int[] curr = pq.poll();
            if (!visited[curr[0]]) {
                visited[curr[0]] = true;
                res = curr[1];
                N--;
                for (int[] next : graph.getOrDefault(curr[0], Collections.emptyList())) {
                    pq.offer(new int[] { next[0], curr[1] + next[1] });
                }
            }
        }
        return N == 0 ? res : -1;
    }

    public int networkDelayTimeBF(int[][] times, int N, int K) {
        final int[] dist = new int[N + 1];
        Arrays.fill(dist, (int) 1e9);
        dist[K] = 0;
        int res = 0;
        for (int i = 1; i <= N; i++) {
            for (int[] edge : times) {
                final int u = edge[0];
                final int v = edge[1];
                final int w = edge[2];
                dist[v] = Math.min(dist[v], dist[u] + w);
            }
        }
        for (int i = 1; i <= N; i++) {
            res = Math.max(res, dist[i]);
        }
        return res == (int) 1e9 ? -1 : res;
    }
}
