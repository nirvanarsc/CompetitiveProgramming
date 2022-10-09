package leetcode.weekly_contests.weekly_0_99.weekly_44;

import java.util.ArrayList;
import java.util.List;

import utils.DataStructures.TreeNode;

public class P_653 {

    static List<Integer> list;

    public boolean findTarget(TreeNode root, int k) {
        list = new ArrayList<>();
        dfs(root);
        int lo = 0;
        int hi = list.size() - 1;
        while (lo < hi) {
            final int curr = list.get(lo) + list.get(hi);
            if (curr == k) {
                return true;
            }
            if (curr < k) {
                lo++;
            } else {
                hi--;
            }
        }
        return false;
    }

    private static void dfs(TreeNode node) {
        if (node == null) {
            return;
        }
        dfs(node.left);
        list.add(node.val);
        dfs(node.right);
    }
}
