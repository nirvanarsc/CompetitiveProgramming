package leetcode.medium;

import java.util.HashMap;
import java.util.Map;

import utils.DataStructures.TreeNode;

@SuppressWarnings({ "ConstantConditions", "ReturnOfNull" })
public class P_106 {

    public TreeNode buildTreeOld(int[] inorder, int[] postorder) {
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

    static int idx;
    static Map<Integer, Integer> inMap;

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        final int n = inorder.length;
        inMap = new HashMap<>();
        idx = n - 1;
        for (int i = 0; i < n; i++) {
            inMap.put(inorder[i], i);
        }
        return dfs(postorder, 0, n - 1);
    }

    private static TreeNode dfs(int[] postorder, int start, int end) {
        if (start > end) {
            return null;
        }
        final TreeNode root = new TreeNode(postorder[idx--]);
        final int newEnd = inMap.get(root.val);
        root.right = dfs(postorder, newEnd + 1, end);
        root.left = dfs(postorder, start, newEnd - 1);
        return root;
    }
}
