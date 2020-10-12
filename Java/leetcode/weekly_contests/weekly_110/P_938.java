package leetcode.weekly_contests.weekly_110;

import utils.DataStructures.TreeNode;

public class P_938 {

    @SuppressWarnings({ "TailRecursion", "MethodParameterNamingConvention" })
    public int rangeSumBST(TreeNode root, int L, int R) {
        if (root == null) {
            return 0;
        }
        if (L <= root.val && root.val <= R) {
            return root.val + rangeSumBST(root.left, L, R) + rangeSumBST(root.right, L, R);
        } else if (root.val > R) {
            return rangeSumBST(root.left, L, R);
        } else {
            return rangeSumBST(root.right, L, R);
        }
    }
}
