package biweekly_contests.biweekly_10;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import utils.DataStructures.TreeNode;

public class P_1214 {

    public boolean twoSumBSTsSearch(TreeNode root1, TreeNode root2, int target) {
        if (root1 == null) {
            return false;
        }
        if (find(root2, target - root1.val)) {
            return true;
        } else {
            return twoSumBSTs(root1.left, root2, target) || twoSumBSTs(root1.right, root2, target);
        }
    }

    private static boolean find(TreeNode root, int target) {
        if (root == null) { return false; }
        if (root.val == target) {
            return true;
        } else if (root.val < target) {
            return find(root.right, target);
        } else {
            return find(root.left, target);
        }
    }

    public boolean twoSumBSTsRecursive(TreeNode root1, TreeNode root2, int target) {
        if (root1 == null || root2 == null) {
            return false;
        }
        final int sum = root1.val + root2.val;
        if (sum == target) {
            return true;
        } else if (sum > target) {
            return twoSumBSTsRecursive(root1.left, root2, target)
                   || twoSumBSTsRecursive(root1, root2.left, target);
        } else {
            return twoSumBSTsRecursive(root1.right, root2, target)
                   || twoSumBSTsRecursive(root1, root2.right, target);
        }
    }

    public boolean twoSumBSTs(TreeNode root1, TreeNode root2, int target) {
        final List<Integer> l1 = inOrder(root1);
        final List<Integer> l2 = inOrder(root2);
        for (int num : l1) {
            if (Collections.binarySearch(l2, target - num) >= 0) {
                return true;
            }
        }
        return false;
    }

    private static List<Integer> inOrder(TreeNode root) {
        final List<Integer> res = new ArrayList<>();
        recurse(root, res);
        return res;
    }

    private static void recurse(TreeNode node, List<Integer> res) {
        if (node == null) {
            return;
        }
        recurse(node.left, res);
        res.add(node.val);
        recurse(node.right, res);
    }
}
