package leetcode.medium;

import java.util.ArrayList;
import java.util.List;

import utils.DataStructures.TreeNode;

@SuppressWarnings("ConstantConditions")
public class P_113 {

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        final List<List<Integer>> res = new ArrayList<>();
        dfs(root, sum, new int[] { 0 }, new ArrayList<>(), res);
        return res;
    }

    private static void dfs(TreeNode node, int sum, int[] curr, List<Integer> path, List<List<Integer>> res) {
        if (node == null) {
            return;
        }
        path.add(node.val);
        curr[0] += node.val;
        dfs(node.left, sum, curr, path, res);
        if (node.left == null && node.right == null) {
            if (curr[0] == sum) {
                res.add(new ArrayList<>(path));
            }
        }
        dfs(node.right, sum, curr, path, res);
        curr[0] -= node.val;
        path.remove(path.size() - 1);
    }
}
