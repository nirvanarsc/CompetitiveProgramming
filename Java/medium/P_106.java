package medium;

import java.util.HashMap;
import java.util.Map;

import medium.P_284.PeekingIterator;
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

    int idx;

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        final Map<Integer, Integer> inMap = new HashMap<>();
        for (int i = 0; i < postorder.length; i++) {
            inMap.put(inorder[i], i);
        }
        idx = postorder.length - 1;
        return dfs(postorder, inMap, 0, postorder.length - 1);
    }

    private TreeNode dfs(int[] postorder, Map<Integer, Integer> inMap, int start, int end) {
        if (start > end) {
            return null;
        }
        final TreeNode root = new TreeNode(postorder[idx--]);
        final int newEnd = inMap.get(root.val);
        root.right = dfs(postorder, inMap, newEnd + 1, end);
        root.left = dfs(postorder, inMap, start, newEnd - 1);
        return root;
    }
}
