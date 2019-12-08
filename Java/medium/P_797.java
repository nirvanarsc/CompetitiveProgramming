package medium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class P_797 {

    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        final List<List<Integer>> res = new ArrayList<>();
        dfsSearch(graph, 0, res, new ArrayList<>(Collections.singletonList(0)));
        return res;
    }

    private static void dfsSearch(int[][] graph, int node, List<List<Integer>> res, List<Integer> path) {
        if (node == graph.length - 1) {
            res.add(new ArrayList<>(path));
            return;
        }

        for (int nextNode : graph[node]) {
            path.add(nextNode);
            dfsSearch(graph, nextNode, res, path);
            path.remove(path.size() - 1);
        }
    }
}
