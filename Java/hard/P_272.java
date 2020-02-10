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
}
