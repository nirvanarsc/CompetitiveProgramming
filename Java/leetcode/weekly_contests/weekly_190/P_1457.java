package leetcode.weekly_contests.weekly_190;

import java.util.HashMap;
import java.util.Map;

import utils.DataStructures.TreeNode;

public class P_1457 {

    public int pseudoPalindromicPaths(TreeNode root) {
        final int[] res = { 0 };
        final int[] mask = { 0 };
        dfs(root, res, mask);
        return res[0];
    }

    private static void dfs(TreeNode node, int[] res, int[] mask) {
        if (node == null) {
            return;
        }
        mask[0] ^= 1 << node.val;
        dfs(node.left, res, mask);
        if (node.left == null && node.right == null) {
            if (Integer.bitCount(mask[0]) < 2) {
                res[0]++;
            }
        }
        dfs(node.right, res, mask);
        mask[0] ^= 1 << node.val;
    }

    public int pseudoPalindromicPathsMap(TreeNode root) {
        final int[] res = { 0 };
        dfs(root, new HashMap<>(), res);
        return res[0];
    }

    private static void dfs(TreeNode node, Map<Integer, Integer> freq, int[] res) {
        if (node == null) {
            return;
        }
        freq.merge(node.val, 1, Integer::sum);
        dfs(node.left, freq, res);
        if (node.left == null && node.right == null) {
            if (freq.values().stream().filter(x -> x % 2 != 0).count() < 2) {
                res[0]++;
            }
        }
        dfs(node.right, freq, res);
        freq.merge(node.val, -1, Integer::sum);
    }
}
