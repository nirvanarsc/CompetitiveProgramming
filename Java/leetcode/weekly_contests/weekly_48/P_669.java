package leetcode.weekly_contests.weekly_48;

import utils.DataStructures.TreeNode;

@SuppressWarnings({ "MethodParameterNamingConvention", "ConstantConditions", "TailRecursion", "ReturnOfNull" })
public class P_669 {

    public TreeNode trimBST(TreeNode root, int L, int R) {
        if (root == null) {
            return null;
        }
        if (root.val < L) {
            return trimBST(root.right, L, R);
        }
        if (root.val > R) {
            return trimBST(root.left, L, R);
        }
        root.left = trimBST(root.left, L, R);
        root.right = trimBST(root.right, L, R);
        return root;
    }
}
