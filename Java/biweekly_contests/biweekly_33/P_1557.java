package biweekly_contests.biweekly_33;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class P_1557 {

    public List<Integer> findSmallestSetOfVertices(int n, List<List<Integer>> edges) {
        final int[] inDegree = new int[n];
        final Map<Integer, List<Integer>> g = new HashMap<>();
        for (List<Integer> p : edges) {
            g.computeIfAbsent(p.get(0), v -> new ArrayList<>()).add(p.get(1));
            inDegree[p.get(1)]++;
        }
        final List<Integer> res = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (inDegree[i] == 0) {
                res.add(i);
            }
        }
        return res;
    }

    public List<Integer> findSmallestSetOfVerticesTS(int n, List<List<Integer>> edges) {
        final int[] inDegree = new int[n];
        final Map<Integer, List<Integer>> g = new HashMap<>();
        for (List<Integer> p : edges) {
            g.computeIfAbsent(p.get(0), v -> new ArrayList<>()).add(p.get(1));
            inDegree[p.get(1)]++;
        }
        final int[] topSort = topSort(n, g, inDegree);
        final List<Integer> res = new ArrayList<>();
        final boolean[] visited = new boolean[n];
        int seen = 0;
        for (int i = 0; i < n; i++) {
            res.add(topSort[i]);
            final Deque<Integer> q = new ArrayDeque<>(Collections.singletonList(topSort[i]));
            while (!q.isEmpty()) {
                final Integer curr = q.removeFirst();
                if (visited[curr]) {
                    continue;
                }
                visited[curr] = true;
                if (++seen == n) {
                    return res;
                }
                for (int next : g.getOrDefault(curr, Collections.emptyList())) {
                    if (!visited[next]) {
                        q.offerLast(next);
                    }
                }
            }
        }
        return res;
    }

    public static int[] topSort(int numCourses, Map<Integer, List<Integer>> g, int[] inDegree) {
        final Deque<Integer> q = new ArrayDeque<>();
        for (int i = 0; i < numCourses; i++) {
            if (inDegree[i] == 0) {
                q.offerLast(i);
            }
        }
        final int[] topSort = new int[numCourses];
        for (int i = 0; !q.isEmpty(); i++) {
            final int curr = q.removeFirst();
            topSort[i] = curr;
            for (int next : g.getOrDefault(curr, Collections.emptyList())) {
                if (--inDegree[next] == 0) {
                    q.offerLast(next);
                }
            }
        }
        return topSort;
    }
}
