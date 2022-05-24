package leetcode.weekly_contests.weekly_100_199.weekly_122;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;
import java.util.stream.Collectors;

import utils.DataStructures.TreeNode;

public class P_987 {

    public List<List<Integer>> verticalTraversal(TreeNode root) {
        final TreeMap<Integer, List<int[]>> map = new TreeMap<>();
        dfs(root, 0, 0, map);
        return map.values()
                  .stream()
                  .map(value -> value
                          .stream()
                          .sorted((a, b) -> a[1] == b[1] ? Integer.compare(a[0], b[0])
                                                         : Integer.compare(a[1], b[1]))
                          .map(t -> t[0])
                          .collect(Collectors.toList()))
                  .collect(Collectors.toList());
    }

    private static void dfs(TreeNode root, int d, int depth, TreeMap<Integer, List<int[]>> map) {
        if (root == null) {
            return;
        }
        map.computeIfAbsent(d, v -> new ArrayList<>()).add(new int[] { root.val, depth });
        dfs(root.left, d - 1, depth + 1, map);
        dfs(root.right, d + 1, depth + 1, map);
    }
}
