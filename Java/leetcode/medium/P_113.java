package leetcode.medium;

import java.util.ArrayList;
import java.util.List;

import utils.DataStructures.TreeNode;

public class P_113 {

    static List<List<Integer>> res;
    static List<Integer> path;
    static int[] curr;

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        res = new ArrayList<>();
        path = new ArrayList<>();
        curr = new int[] { targetSum };
        dfs(root);
        return res;
    }

    private static void dfs(TreeNode node) {
        if (node == null) {
            return;
        }
        curr[0] -= node.val;
        path.add(node.val);
        if (node.left == null && node.right == null) {
            if (curr[0] == 0) {
                res.add(new ArrayList<>(path));
            }
        }
        dfs(node.left);
        dfs(node.right);
        curr[0] += node.val;
        path.remove(path.size() - 1);
    }
}
