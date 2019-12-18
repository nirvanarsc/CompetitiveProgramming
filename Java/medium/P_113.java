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
        final int val = remainingSum - node.val;
        path.add(node.val);

        if (node.left == node.right && val == 0) {
            res.add(new ArrayList<>(path));
        } else {
            dfs(node.right, val, path, res);
            dfs(node.left, val, path, res);
        }

        path.remove(path.size() - 1);
    }
}
