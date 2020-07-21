package medium;

import java.util.HashMap;
import java.util.Map;

import utils.DataStructures.TreeNode;

@SuppressWarnings({ "ConstantConditions", "ReturnOfNull" })
public class P_105 {

    public TreeNode buildTreeOld(int[] preorder, int[] inorder) {
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

    int idx;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        final Map<Integer, Integer> idx = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            idx.put(inorder[i], i);
        }
        return dfs(preorder, idx, 0, inorder.length - 1);
    }

    private TreeNode dfs(int[] preorder, Map<Integer, Integer> in, int l, int r) {
        if (l > r) {
            return null;
        }
        final int root = preorder[idx++];
        final TreeNode res = new TreeNode(root);
        res.left = dfs(preorder, in, l, in.get(root) - 1);
        res.right = dfs(preorder, in, in.get(root) + 1, r);
        return res;
    }
}
