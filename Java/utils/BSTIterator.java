package utils;

import java.util.ArrayDeque;
import java.util.Deque;

import utils.DataStructures.TreeNode;

public class BSTIterator {

    private final Deque<TreeNode> stack;
    private final boolean isForward;

    public BSTIterator(TreeNode root, boolean flag) {
        isForward = flag;
        stack = new ArrayDeque<>();
        TreeNode node = root;
        while (node != null) {
            stack.addFirst(node);
            node = isForward ? node.left : node.right;
        }
    }

    public boolean hasNext() {
        return !stack.isEmpty();
    }

    public int peek() {
        return stack.getFirst().val;
    }

    public int next() {
        TreeNode node = stack.removeFirst();
        final int val = node.val;
        node = isForward ? node.right : node.left;
        while (node != null) {
            stack.addFirst(node);
            node = isForward ? node.left : node.right;
        }
        return val;
    }
}
