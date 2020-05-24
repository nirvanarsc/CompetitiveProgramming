package weekly_contests.weekly_190;

import java.util.HashMap;
import java.util.Map;

import utils.DataStructures.TreeNode;

public class P_1457 {

    public int pseudoPalindromicPaths(TreeNode root) {
        final int[] res = { 0 };
        final int[] mask = { 0 };
        dfs(root, mask, res);
        return res[0];
    }

    @SuppressWarnings("ConstantConditions")
    private static void dfs(TreeNode node, int[] mask, int[] res) {
        if (node == null) {
            return;
        }
        mask[0] ^= 1 << node.val;
        if (node.left == null && node.right == null) {
            if (Integer.bitCount(mask[0]) <= 1) {
                res[0]++;
            }
        }
        dfs(node.left, mask, res);
        dfs(node.right, mask, res);
        mask[0] ^= 1 << node.val;
    }

    public int pseudoPalindromicPathsMap(TreeNode root) {
        final int[] res = { 0 };
        dfs(root, new HashMap<>(), res);
        return res[0];
    }

    @SuppressWarnings("ConstantConditions")
    private static void dfs(TreeNode node, Map<Integer, Integer> freq, int[] res) {
        if (node == null) {
            return;
        }
        freq.merge(node.val, 1, Integer::sum);
        if (node.left == null && node.right == null) {
            if (freq.values().stream().filter(x -> x % 2 != 0).count() <= 1) {
                res[0]++;
            }
        }
        dfs(node.left, freq, res);
        dfs(node.right, freq, res);
        freq.merge(node.val, -1, Integer::sum);
    }
}
