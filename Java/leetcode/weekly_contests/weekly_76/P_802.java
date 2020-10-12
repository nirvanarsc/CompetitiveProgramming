package leetcode.weekly_contests.weekly_76;

import java.util.ArrayList;
import java.util.List;

public class P_802 {

    enum State {
        SAFE,
        UNSAFE
    }

    public List<Integer> eventualSafeNodes(int[][] graph) {
        final List<Integer> res = new ArrayList<>();
        final State[] states = new State[graph.length];
        for (int i = 0; i < graph.length; i++) {
            if (dfs(graph, i, states)) {
                res.add(i);
            }
        }
        return res;
    }

    private static boolean dfs(int[][] graph, int curr, State[] states) {
        if (states[curr] != null) {
            return states[curr] == State.SAFE;
        }
        states[curr] = State.UNSAFE;
        for (int next : graph[curr]) {
            if (!dfs(graph, next, states)) {
                return false;
            }
        }
        states[curr] = State.SAFE;
        return true;
    }
}
