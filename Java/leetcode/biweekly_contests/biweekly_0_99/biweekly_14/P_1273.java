package leetcode.biweekly_contests.biweekly_0_99.biweekly_14;

import java.util.ArrayList;
import java.util.List;

public class P_1273 {

    public int deleteTreeNodes(int n, int[] parent, int[] value) {
        final List<List<Integer>> graph = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int i = 0; i < n; i++) {
            if (parent[i] != -1) {
                graph.get(parent[i]).add(i);
            }
        }
        return dfs(graph, value, 0)[1];
    }

    private static int[] dfs(List<List<Integer>> graph, int[] value, int root) {
        int sum = value[root];
        int cntRemainNodes = 1;
        for (int child : graph.get(root)) {
            final int[] temp = dfs(graph, value, child);
            sum += temp[0];
            cntRemainNodes += temp[1];
        }
        if (sum == 0) {
            cntRemainNodes = 0;
        }
        return new int[] { sum, cntRemainNodes };
    }
}
