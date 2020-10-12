package leetcode.weekly_contests.weekly_44;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import utils.DataStructures.TreeNode;

public class P_653 {

    Set<Integer> set = new HashSet<>();

    public boolean findTarget(TreeNode root, int k) {
        if (root == null) {
            return false;
        }
        if (set.contains(k - root.val)) {
            return true;
        }
        set.add(root.val);
        return findTarget(root.left, k) || findTarget(root.right, k);
    }

    public boolean findTargetList(TreeNode root, int k) {
        final List<Integer> list = new ArrayList<>();
        inOrder(root, list);
        int lo = 0;
        int hi = list.size() - 1;
        while (lo < hi) {
            if (list.get(lo) + list.get(hi) > k) {
                hi--;
            } else if (list.get(lo) + list.get(hi) < k) {
                lo++;
            } else {
                return true;
            }
        }
        return false;
    }

    private static void inOrder(TreeNode node, List<Integer> l) {
        if (node == null) {
            return;
        }
        inOrder(node.left, l);
        l.add(node.val);
        inOrder(node.right, l);
    }
}
