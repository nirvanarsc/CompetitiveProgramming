package medium;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

import utils.DataStructures.TreeNode;

public class P_103 {

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        final List<List<Integer>> res = new ArrayList<>();
        final Deque<TreeNode> q = new ArrayDeque<>();
        if (root != null) {
            q.offerLast(root);
        }
        for (int i = 0; !q.isEmpty(); i++) {
            final LinkedList<Integer> level = new LinkedList<>();
            for (int size = q.size(); size > 0; size--) {
                final TreeNode curr = q.removeFirst();
                if (i % 2 != 0) {
                    level.addFirst(curr.val);
                } else {
                    level.addLast(curr.val);
                }
                if (curr.left != null) {
                    q.offerLast(curr.left);
                }
                if (curr.right != null) {
                    q.offerLast(curr.right);
                }
            }
            res.add(level);
        }
        return res;
    }
}
