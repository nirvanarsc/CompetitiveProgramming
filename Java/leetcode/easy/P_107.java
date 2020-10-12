package leetcode.easy;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

import utils.DataStructures.TreeNode;

public class P_107 {

    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        final Deque<TreeNode> queue = new LinkedList<>();
        final List<List<Integer>> res = new ArrayList<>();
        if (root != null) {
            queue.offerLast(root);
        }
        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            final List<Integer> level = new ArrayList<>();
            while (levelSize-- > 0) {
                final TreeNode curr = queue.removeFirst();
                level.add(curr.val);
                if (curr.left != null) {
                    queue.add(curr.left);
                }
                if (curr.right != null) {
                    queue.add(curr.right);
                }
            }
            res.add(0, level);
        }
        return res;
    }
}
