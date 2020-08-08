package hard;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

import utils.DataStructures.TreeNode;

public class P_272 {

    public List<Integer> closestKValuesCollect(TreeNode root, double target, int k) {
        final LinkedList<Integer> res = new LinkedList<>();
        inorder(root, target, k, res);
        return res;
    }

    private static void inorder(TreeNode root, double target, int k, LinkedList<Integer> res) {
        if (root == null) {
            return;
        }
        inorder(root.left, target, k, res);
        if (res.size() == k) {
            if (Math.abs(res.getFirst() - target) > Math.abs(root.val - target)) {
                res.pollFirst();
            } else {
                return;
            }
        }
        res.addLast(root.val);
        inorder(root.right, target, k, res);
    }

    public List<Integer> closestKValues(TreeNode root, double target, int k) {
        final Deque<Integer> deque = new ArrayDeque<>();
        inorder(root, deque);
        while (deque.size() > k) {
            if (Math.abs(deque.getFirst() - target) > Math.abs(deque.getLast() - target)) {
                deque.pollFirst();
            } else {
                deque.pollLast();
            }
        }
        return new ArrayList<>(deque);
    }

    public void inorder(TreeNode root, Deque<Integer> dq) {
        if (root == null) {
            return;
        }
        inorder(root.left, dq);
        dq.add(root.val);
        inorder(root.right, dq);
    }

    // O(k + log n)
    public List<Integer> closestKValuesOptimized(TreeNode root, double target, int k) {
        final List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }

        // step 1: find the closet value and save the path
        final Deque<TreeNode> lowerStack = new ArrayDeque<>();
        final Deque<TreeNode> upperStack = new ArrayDeque<>();

        TreeNode p = root;
        while (p != null) {
            if (p.val < target) {
                lowerStack.addFirst(p);
                p = p.right;
            } else {
                upperStack.addFirst(p);
                p = p.left;
            }
        }

        for (int i = 0; i < k; i++) {
            if (lowerStack.isEmpty()) {
                final TreeNode top = upperStack.pop();
                res.add(top.val);
                goUpperNext(top.right, upperStack);
            } else if (upperStack.isEmpty()) {
                final TreeNode top = lowerStack.pop();
                res.add(top.val);
                goLowerNext(top.left, lowerStack);
            } else if (upperStack.getFirst().val - target <= target - lowerStack.getFirst().val) {
                final TreeNode top = upperStack.pop();
                res.add(top.val);
                goUpperNext(top.right, upperStack);
            } else {
                final TreeNode top = lowerStack.pop();
                res.add(top.val);
                goLowerNext(top.left, lowerStack);
            }
        }

        return res;
    }

    private static void goUpperNext(TreeNode node, Deque<TreeNode> stack) {
        TreeNode p = node;
        while (p != null) {
            stack.addFirst(p);
            p = p.left;
        }
    }

    private static void goLowerNext(TreeNode node, Deque<TreeNode> stack) {
        TreeNode p = node;
        while (p != null) {
            stack.addFirst(p);
            p = p.right;
        }
    }
}
