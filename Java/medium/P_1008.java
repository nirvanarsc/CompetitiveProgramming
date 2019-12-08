package medium;

import utils.DataStructures.TreeNode;

public class P_1008 {

    public TreeNode bstFromPreorder(int[] preorder) {
        return recurse(preorder, 0, preorder.length - 1);
    }

    public TreeNode recurse(int[] arr, int start, int end) {
        if (start > end) {
            return null;
        }

        final int rootVal = arr[start];
        int splitIdx = start + 1;
        while (splitIdx <= end && arr[splitIdx] < rootVal) {
            splitIdx++;
        }

        final TreeNode root = new TreeNode(rootVal);
        root.left = recurse(arr, start + 1, splitIdx - 1);
        root.right = recurse(arr, splitIdx, end);
        return root;
    }
}
