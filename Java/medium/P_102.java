package medium;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

import utils.DataStructures.TreeNode;

public class P_102 {

    public List<List<Integer>> levelOrder(TreeNode root) {
        final List<List<Integer>> res = new ArrayList<>();
        final Deque<TreeNode> queue = new LinkedList<>();
        if (root != null) {
            queue.offerFirst(root);
        }
        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            final List<Integer> level = new ArrayList<>();
            while (levelSize-- > 0) {
                final TreeNode curr = queue.removeLast();
                level.add(curr.val);
                if (curr.left != null) {
                    queue.offerFirst(curr.left);
                }
                if (curr.right != null) {
                    queue.offerFirst(curr.right);
                }
            }
            res.add(level);
        }

        return res;
    }
}
