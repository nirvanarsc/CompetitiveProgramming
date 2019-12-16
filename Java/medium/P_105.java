package medium;

import java.util.HashMap;
import java.util.Map;

import utils.DataStructures.TreeNode;

public class P_105 {

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        final Map<Integer, Integer> inMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            inMap.put(inorder[i], i);
        }
        return helper(preorder, 0, preorder.length - 1, 0, inorder.length - 1, inMap);
    }

    private static TreeNode helper(int[] preorder, int preStart, int preEnd, int inStart, int end,
                                   Map<Integer, Integer> map) {
        if (inStart > end) {
            return null;
        }

        final TreeNode root = new TreeNode(preorder[preStart]);
        final int i = map.get(root.val);
        root.left = helper(preorder, preStart + 1, preStart + i - inStart, inStart, i - 1, map);
        root.right = helper(preorder, preStart + (i - inStart) + 1, preEnd, i + 1, end, map);
        return root;
    }
}
