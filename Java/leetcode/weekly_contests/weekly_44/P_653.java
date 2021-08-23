package leetcode.weekly_contests.weekly_44;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import utils.DataStructures.TreeNode;

public class P_653 {

    Set<Integer> set = new HashSet<>();

    public boolean findTargetSet(TreeNode root, int k) {
        if (root == null) {
            return false;
        }
        if (set.contains(k - root.val)) {
            return true;
        }
        set.add(root.val);
        return findTarget(root.left, k) || findTarget(root.right, k);
    }

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
