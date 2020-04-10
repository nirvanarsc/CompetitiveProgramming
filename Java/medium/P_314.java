package medium;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Deque;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import utils.DataStructures.TreeNode;

public class P_314 {

    public List<List<Integer>> verticalOrder(TreeNode root) {
        final Map<Integer, List<int[]>> g = new HashMap<>();
        dfs(root, 0, 0, g);
        return g.entrySet()
                .stream()
                .sorted(Comparator.comparingInt(Map.Entry::getKey))
                .map(t -> t.getValue().stream().sorted(Comparator.comparingInt(v -> v[1])).map(v -> v[0])
                           .collect(Collectors.toList()))
                .collect(Collectors.toList());
    }

    private static void dfs(TreeNode node, int d, int l, Map<Integer, List<int[]>> g) {
        if (node == null) {
            return;
        }
        dfs(node.left, d - 1, l + 1, g);
        g.computeIfAbsent(d, v -> new ArrayList<>()).add(new int[] { node.val, l });
        dfs(node.right, d + 1, l + 1, g);
    }

    static class Pair {
        TreeNode node;
        int w;

        Pair(TreeNode node, int w) {
            this.node = node;
            this.w = w;
        }
    }

    public List<List<Integer>> verticalOrderBFS(TreeNode root) {
        final List<List<Integer>> res = new ArrayList<>();
        final Deque<Pair> q = new ArrayDeque<>();
        final Map<Integer, List<Integer>> map = new HashMap<>();
        int min = 0;
        if (root != null) {
            q.offerLast(new Pair(root, 0));
        }
        while (!q.isEmpty()) {
            final Pair curr = q.removeFirst();
            map.computeIfAbsent(curr.w, v -> new ArrayList<>()).add(curr.node.val);
            if (curr.node.left != null) {
                q.offerLast(new Pair(curr.node.left, curr.w - 1));
            }
            if (curr.node.right != null) {
                q.offerLast(new Pair(curr.node.right, curr.w + 1));
            }
            min = Math.min(min, curr.w);
        }
        while (map.containsKey(min)) {
            res.add(map.get(min++));
        }
        return res;
    }
}
