package weekly_contests.weekly_173;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class P_1334 {

    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        final Map<Integer, List<int[]>> graph = new HashMap<>();
        final List<List<Integer>> res = new ArrayList<>();
        final Comparator<List<Integer>> bySizeAndIndex = (c1, c2) -> {
            if (c1.size() == c2.size()) {
                return Integer.compare(c2.get(0), c1.get(0));
            }
            return Integer.compare(c1.size(), c2.size());
        };
        for (int[] e : edges) {
            graph.putIfAbsent(e[0], new ArrayList<>());
            graph.get(e[0]).add(new int[] { e[1], e[2] });
            graph.putIfAbsent(e[1], new ArrayList<>());
            graph.get(e[1]).add(new int[] { e[0], e[2] });
        }
        for (int i = 0; i < n; i++) {
            final boolean[] visited = new boolean[n];
            final List<Integer> cities = new ArrayList<>();
            cities.add(i);
            visited[i] = true;
            final PriorityQueue<int[]> q = new PriorityQueue<>(Comparator.comparingInt(a -> a[2] - a[0]));
            for (int[] neighbour : graph.getOrDefault(i, Collections.emptyList())) {
                q.add(new int[] { distanceThreshold, neighbour[0], neighbour[1] });
            }
            while (!q.isEmpty()) {
                for (int j = 0; j < q.size(); j++) {
                    final int[] curr = q.poll();
                    if (curr[0] - curr[2] >= 0 && !visited[curr[1]]) {
                        visited[curr[1]] = true;
                        cities.add(curr[1]);
                        if (curr[0] - curr[2] > 0) {
                            for (int[] neighbour : graph.getOrDefault(curr[1], Collections.emptyList())) {
                                q.add(new int[] { curr[0] - curr[2], neighbour[0], neighbour[1] });
                            }
                        }
                    }
                }
            }
            res.add(cities);
        }
        res.sort(bySizeAndIndex);
        return res.get(0).get(0);
    }
}
