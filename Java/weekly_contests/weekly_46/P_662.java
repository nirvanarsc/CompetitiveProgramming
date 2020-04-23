package weekly_contests.weekly_46;

import java.util.HashMap;
import java.util.Map;

import utils.DataStructures.TreeNode;

public class P_662 {

    public int widthOfBinaryTree(TreeNode root) {
        final int[] ans = { 0 };
        dfs(root, 0, 0, new HashMap<>(), ans);
        return ans[0];
    }

    public void dfs(TreeNode root, int depth, int pos, Map<Integer, Integer> left, int[] ans) {
        if (root == null) {
            return;
        }
        left.putIfAbsent(depth, pos);
        ans[0] = Math.max(ans[0], pos - left.get(depth) + 1);
        dfs(root.left, depth + 1, 2 * pos, left, ans);
        dfs(root.right, depth + 1, 2 * pos + 1, left, ans);
    }
}
