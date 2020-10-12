package leetcode.weekly_contests.weekly_46;

import java.util.ArrayList;
import java.util.List;

import utils.DataStructures.TreeNode;

public class P_663 {

    public boolean checkEqualTree(TreeNode root) {
        final List<Integer> sums = new ArrayList<>();
        final long total = dfs(root, sums);
        for (int i = 0; i < sums.size() - 1; i++) {
            if (2 * sums.get(i) == total) {
                return true;
            }
        }
        return false;
    }

    public int dfs(TreeNode node, List<Integer> sums) {
        if (node == null) {
            return 0;
        }
        final int curr = node.val + dfs(node.left, sums) + dfs(node.right, sums);
        sums.add(curr);
        return curr;
    }
}
