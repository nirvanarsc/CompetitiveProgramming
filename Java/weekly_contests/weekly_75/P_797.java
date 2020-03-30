package weekly_contests.weekly_75;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class P_797 {

    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
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
