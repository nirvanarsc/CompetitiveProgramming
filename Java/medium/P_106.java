package medium;

import java.util.HashMap;
import java.util.Map;

import utils.DataStructures.TreeNode;

public class P_106 {

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        final Map<Integer, Integer> inMap = new HashMap<>();
        for (int i = 0; i < postorder.length; i++) {
            inMap.put(inorder[i], i);
        }
        return helper(postorder, 0, inorder.length - 1, 0, postorder.length - 1, inMap);
    }

    private static TreeNode helper(int[] postorder, int inStart, int inEnd, int postStart, int postEnd,
                                   Map<Integer, Integer> inMap) {
        if (postStart > postEnd) {
            return null;
        }
        final TreeNode root = new TreeNode(postorder[postEnd]);
        final int i = inMap.get(root.val);
        root.left = helper(postorder, inStart, i - 1, postStart, postStart + i - inStart - 1, inMap);
        root.right = helper(postorder, i + 1, inEnd, postStart + i - inStart, postEnd - 1, inMap);
        return root;
    }
}
