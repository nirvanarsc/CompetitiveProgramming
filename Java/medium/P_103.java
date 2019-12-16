package medium;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

import utils.DataStructures.TreeNode;

public class P_103 {

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        final List<List<Integer>> res = new ArrayList<>();
        final Deque<TreeNode> queue = new LinkedList<>();
        if (root != null) {
            queue.offerFirst(root);
        }
        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            final LinkedList<Integer> level = new LinkedList<>();
            while (levelSize-- > 0) {
                final TreeNode curr = queue.removeLast();
                if (res.size() % 2 == 0) {
                    level.addLast(curr.val);
                } else {
                    level.addFirst(curr.val);
                }
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
