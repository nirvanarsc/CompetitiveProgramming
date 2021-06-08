package leetcode.medium;

import java.util.HashMap;
import java.util.Map;

import utils.DataStructures.TreeNode;

@SuppressWarnings({ "ConstantConditions", "ReturnOfNull" })
public class P_105 {

    static Map<Integer, Integer> inIdx;
    static int n;

    public TreeNode buildTreeOld(int[] preorder, int[] inorder) {
        inIdx = new HashMap<>();
        n = inorder.length;
        for (int i = 0; i < n; i++) {
            inIdx.put(inorder[i], i);
        }
        return dfs(0, n - 1, 0, preorder);
    }

    private static TreeNode dfs(int l, int r, int inL, int[] pre) {
        if (l > r) {
            return null;
        }
        final TreeNode root = new TreeNode(pre[l]);
        final int mid = inIdx.get(pre[l]);
        final int L = mid - inL + 1;
        root.left = dfs(l + 1, l + L - 1, inL, pre);
        root.right = dfs(l + L, r, mid + 1, pre);
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
        final int idx = in.get(root);
        res.left = dfs(preorder, in, l, idx - 1);
        res.right = dfs(preorder, in, idx + 1, r);
        return res;
    }
}
