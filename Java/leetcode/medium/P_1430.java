package leetcode.medium;

import utils.DataStructures.TreeNode;

public class P_1430 {

    public boolean isValidSequence(TreeNode root, int[] arr) {
        return check(root, arr, 0);
    }

    private static boolean check(TreeNode node, int[] arr, int i) {
        if (node == null || i == arr.length) {
            return false;
        }
        if (node.left == null && node.right == null && arr[i] == node.val && i == arr.length - 1) {
            return true;
        }
        return node.val == arr[i] && (check(node.left, arr, i + 1) || check(node.right, arr, i + 1));
    }
}
