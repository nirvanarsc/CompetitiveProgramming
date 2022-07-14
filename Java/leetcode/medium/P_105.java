package leetcode.medium;

import java.util.HashMap;
import java.util.Map;

import utils.DataStructures.TreeNode;

@SuppressWarnings({ "ConstantConditions", "ReturnOfNull" })
public class P_105 {

    static Map<Integer, Integer> in;
    static int idx;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        in = new HashMap<>();
        idx = 0;
        for (int i = 0; i < inorder.length; i++) {
            in.put(inorder[i], i);
        }
        return dfs(preorder, 0, inorder.length - 1);
    }

    private static TreeNode dfs(int[] preorder, int l, int r) {
        if (l > r) {
            return null;
        }
        final int root = preorder[idx++];
        final TreeNode res = new TreeNode(root);
        final int idx = in.get(root);
        res.left = dfs(preorder, l, idx - 1);
        res.right = dfs(preorder, idx + 1, r);
        return res;
    }
}
