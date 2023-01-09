package leetcode.medium;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

import utils.DataStructures.TreeNode;

public class P_144 {

    public List<Integer> preorderTraversal(TreeNode root) {
        final List<Integer> res = new ArrayList<>();
        final Deque<TreeNode> dq = new LinkedList<>();
        TreeNode curr = root;
        while (!dq.isEmpty() || curr != null) {
            if (curr != null) {
                dq.addFirst(curr);
                res.add(curr.val);
                curr = curr.left;
            } else {
                curr = dq.removeFirst();
                curr = curr.right;
            }
        }
        return res;
    }
}
