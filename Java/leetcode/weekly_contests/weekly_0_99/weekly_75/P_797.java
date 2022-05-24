package leetcode.weekly_contests.weekly_0_99.weekly_75;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.List;

public class P_797 {

    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        final int n = graph.length;
        final List<List<Integer>> res = new ArrayList<>();
        final Deque<List<Integer>> dq = new ArrayDeque<>();
        dq.offerLast(Collections.singletonList(0));
        while (!dq.isEmpty()) {
            final List<Integer> curr = dq.removeFirst();
            for (int u : graph[curr.get(curr.size() - 1)]) {
                final List<Integer> next = new ArrayList<>(curr);
                next.add(u);
                dq.offerLast(next);
            }
            if (curr.get(curr.size() - 1) == n - 1) {
                res.add(curr);
            }
        }
        return res;
    }

    public List<List<Integer>> allPathsSourceTargetDfs(int[][] graph) {
        final List<List<Integer>> res = new ArrayList<>();
        dfs(graph, 0, new ArrayList<>(Collections.singleton(0)), res);
        return res;
    }

    private static void dfs(int[][] g, int curr, List<Integer> path, List<List<Integer>> res) {
        if (curr == g.length - 1) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int n : g[curr]) {
            path.add(n);
            dfs(g, n, path, res);
            path.remove(path.size() - 1);
        }
    }
}
