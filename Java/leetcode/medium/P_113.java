package leetcode.medium;

import java.util.ArrayList;
import java.util.List;

import utils.DataStructures.TreeNode;

public class P_113 {

    static List<List<Integer>> res;
    static int sum;

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        res = new ArrayList<>();
        sum = targetSum;
        dfs(root, new ArrayList<>());
        return res;
    }

    private static void dfs(TreeNode node, List<Integer> curr) {
        if (node == null) {
            return;
        }
        curr.add(node.val);
        sum -= node.val;
        dfs(node.left, curr);
        fLeaf(node, curr);
        dfs(node.right, curr);
        curr.remove(curr.size() - 1);
        sum += node.val;
    }

    private static void fLeaf(TreeNode node, List<Integer> curr) {
        if (node.left == null && node.right == null && sum == 0) {
            res.add(new ArrayList<>(curr));
        }
    }
}
