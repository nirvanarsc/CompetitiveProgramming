package leetcode.medium;

import java.util.Deque;
import java.util.LinkedList;

import utils.DataStructures.TreeNode;

public class P_230 {

    static class BSTIterator {
        Deque<TreeNode> stack;

        BSTIterator(TreeNode root) {
            stack = new LinkedList<>();
            traverseLeft(root);
        }

        int next() {
            final TreeNode treeNode = stack.removeFirst();
            traverseLeft(treeNode.right);
            return treeNode.val;
        }

        void traverseLeft(TreeNode curr) {
            while (curr != null) {
                stack.addFirst(curr);
                curr = curr.left;
            }
        }
    }

    public int kthSmallest(TreeNode root, int k) {
        final BSTIterator bstIterator = new BSTIterator(root);
        for (int i = 1; i < k; i++) {
            bstIterator.next();
        }
        return bstIterator.next();
    }
}
