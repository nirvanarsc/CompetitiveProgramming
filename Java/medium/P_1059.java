package medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class P_1059 {

    enum State {
        PROCESSING, PROCESSED
    }

    public boolean leadsToDestination(int n, int[][] edges, int src, int dest) {
        final Map<Integer, List<Integer>> g = new HashMap<>();
        for (int[] e : edges) {
            g.computeIfAbsent(e[0], v -> new ArrayList<>()).add(e[1]);
        }
        return leadsToDest(g, src, dest, new State[n]);
    }

    private static boolean leadsToDest(Map<Integer, List<Integer>> g, int node, int dest, State[] states) {
        if (states[node] != null) { return states[node] == State.PROCESSED; }
        if (!g.containsKey(node)) { return node == dest; }
        states[node] = State.PROCESSING;
        for (int next : g.get(node)) {
            if (!leadsToDest(g, next, dest, states)) {
                return false;
            }
        }
        states[node] = State.PROCESSED;
        return true;
    }
}
