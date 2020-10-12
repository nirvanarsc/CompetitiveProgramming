package leetcode.medium;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class P_210 {

    public static final int[] EMPTY_ARRAY = {};

    // Topological sort - Kahn's algorithm
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        final int[] inDegree = new int[numCourses];
        final Map<Integer, List<Integer>> g = new HashMap<>();
        for (int[] p : prerequisites) {
            g.computeIfAbsent(p[1], v -> new ArrayList<>()).add(p[0]);
            inDegree[p[0]]++;
        }
        final Deque<Integer> q = new ArrayDeque<>();
        for (int i = 0; i < numCourses; i++) {
            if (inDegree[i] == 0) {
                q.offerLast(i);
            }
        }
        final int[] res = new int[numCourses];
        int i;
        for (i = 0; !q.isEmpty(); i++) {
            final int curr = q.removeFirst();
            res[i] = curr;
            for (int next : g.getOrDefault(curr, Collections.emptyList())) {
                if (--inDegree[next] == 0) {
                    q.offerLast(next);
                }
            }
        }
        return i == numCourses ? res : EMPTY_ARRAY;
    }
}
