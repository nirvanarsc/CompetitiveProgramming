package leetcode.hard;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

import utils.DataStructures.TreeNode;

public class P_145 {

    public List<Integer> postorderTraversal(TreeNode root) {
        final LinkedList<Integer> res = new LinkedList<>();
        final Deque<TreeNode> s = new LinkedList<>();
        if (root != null) {
            s.addFirst(root);
        }
        while (!s.isEmpty()) {
            final TreeNode curr = s.removeFirst();
            if (curr != null) {
                res.addFirst(curr.val);
                s.addFirst(curr.left);
                s.addFirst(curr.right);
            }
        }

        return res;
    }
}
