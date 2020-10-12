package leetcode.medium;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Deque;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class P_207 {

    enum State {
        UNVISITED, VISITING, VISITED
    }

    // Topological sort - Kahn's algorithm
    public boolean canFinish(int numCourses, int[][] prerequisites) {
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
        int i;
        for (i = 0; !q.isEmpty(); i++) {
            final int curr = q.removeFirst();
            for (int next : g.getOrDefault(curr, Collections.emptyList())) {
                if (--inDegree[next] == 0) {
                    q.offerLast(next);
                }
            }
        }
        return i == numCourses;
    }

    public boolean canFinishDFS(int numCourses, int[][] prerequisites) {
        final Map<Integer, List<Integer>> g = new HashMap<>();
        for (int[] p : prerequisites) {
            g.computeIfAbsent(p[1], v -> new ArrayList<>()).add(p[0]);
        }
        final State[] state = new State[numCourses];
        Arrays.fill(state, State.UNVISITED);
        for (int i = 0; i < numCourses; i++) {
            if (state[i] == State.UNVISITED) {
                if (!dfs(state, g, i)) {
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean dfs(State[] state, Map<Integer, List<Integer>> g, int u) {
        if (state[u] == State.VISITED) {
            return true;
        }
        if (state[u] == State.VISITING) {
            return false;
        }
        state[u] = State.VISITING;
        for (int v : g.getOrDefault(u, Collections.emptyList())) {
            if (!dfs(state, g, v)) {
                return false;
            }
        }
        state[u] = State.VISITED;
        return true;
    }
}
