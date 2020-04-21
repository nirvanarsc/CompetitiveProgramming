package weekly_contests.weekly_48;

import utils.DataStructures.TreeNode;

public class P_671 {

    public int findSecondMinimumValue(TreeNode root) {
        final Integer[] res = { root.val, null };
        dfs(root, res);
        return res[1] == null ? -1 : res[1];
    }

    private static void dfs(TreeNode node, Integer[] res) {
        if (node == null) {
            return;
        }
        if (res[1] == null && node.val != res[0]) {
            res[1] = node.val;
        } else if (node.val != res[0]) {
            res[1] = Math.min(res[1], node.val);
        }
        dfs(node.left, res);
        dfs(node.right, res);
    }
}
