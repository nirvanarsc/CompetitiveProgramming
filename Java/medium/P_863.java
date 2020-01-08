package medium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import utils.DataStructures.TreeNode;

public class P_863 {

    public List<Integer> distanceK(TreeNode root, TreeNode target, int K) {
        if (root == null || K < 0) {
            return Collections.emptyList();
        }

        final List<Integer> res = new ArrayList<>();
        final Map<TreeNode, List<TreeNode>> childParentMap = new HashMap<>();
        buildMap(root, null, childParentMap);
        if (!childParentMap.containsKey(target)) {
            return res;
        }
        final Set<TreeNode> visited = new HashSet<>();
        final Deque<TreeNode> queue = new LinkedList<>();
        queue.add(target);
        visited.add(target);
        while (K > 0) {
            final int size = queue.size();
            for (int i = 0; i < size; i++) {
                final TreeNode node = queue.removeFirst();
                for (TreeNode next : childParentMap.get(node)) {
                    if (!visited.contains(next)) {
                        visited.add(next);
                        queue.add(next);
                    }
                }
            }
            K--;
        }

        for (TreeNode n : queue) {
            res.add(n.val);
        }
        return res;
    }

    private static void buildMap(TreeNode node, TreeNode parent, Map<TreeNode, List<TreeNode>> map) {
        if (node == null) {
            return;
        }
        if (!map.containsKey(node)) {
            map.put(node, new ArrayList<>());
            if (parent != null) {
                map.get(node).add(parent);
                map.get(parent).add(node);
            }
            buildMap(node.left, node, map);
            buildMap(node.right, node, map);
        }
    }

    List<Integer> ans;
    TreeNode target;
    int K;

    public List<Integer> distanceKDFS(TreeNode root, TreeNode target, int K) {
        ans = new ArrayList<>();
        this.target = target;
        this.K = K;
        dfs(root);
        return ans;
    }

    public int dfs(TreeNode node) {
        if (node == null) {
            return -1;
        } else if (node == target) {
            addSubtree(node, 0);
            return 1;
        } else {
            final int L = dfs(node.left);
            final int R = dfs(node.right);
            if (L != -1) {
                if (L == K) {
                    ans.add(node.val);
                }
                addSubtree(node.right, L + 1);
                return L + 1;
            } else if (R != -1) {
                if (R == K) {
                    ans.add(node.val);
                }
                addSubtree(node.left, R + 1);
                return R + 1;
            } else {
                return -1;
            }
        }
    }

    public void addSubtree(TreeNode node, int dist) {
        if (node == null) {
            return;
        }
        if (dist == K) {
            ans.add(node.val);
        } else {
            addSubtree(node.left, dist + 1);
            addSubtree(node.right, dist + 1);
        }
    }
}
