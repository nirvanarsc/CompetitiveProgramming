package medium;

import java.util.ArrayList;
import java.util.List;

import utils.DataStructures.TreeNode;

public class P_113 {

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        final List<List<Integer>> res = new ArrayList<>();
        dfs(root, sum, new ArrayList<>(), res);
        return res;
    }

    public void dfs(TreeNode node, int remainingSum, List<Integer> path, List<List<Integer>> res) {
        if (node == null) {
            return;
        }
        if (node.left == node.right && remainingSum == node.val) {
            path.add(node.val);
            res.add(new ArrayList<>(path));
            path.remove(path.size() - 1);
            return;
        }

        path.add(node.val);
        dfs(node.right, remainingSum - node.val, path, res);
        dfs(node.left, remainingSum - node.val, path, res);
        path.remove(path.size() - 1);
    }
}
