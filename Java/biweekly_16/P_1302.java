package biweekly_16;

import java.util.Deque;
import java.util.LinkedList;

import utils.DataStructures.TreeNode;

public class P_1302 {

    public int deepestLeavesSum(TreeNode root) {
        final Deque<TreeNode> queue = new LinkedList<>();
        int res = 0;
        if (root != null) {
            queue.offerLast(root);
        }
        while (!queue.isEmpty()) {
            res = 0;
            final int size = queue.size();
            for (int i = 0; i < size; i++) {
                final TreeNode curr = queue.removeFirst();
                res += curr.val;
                if (curr.left != null) {
                    queue.offerLast(curr.left);
                }
                if (curr.right != null) {
                    queue.offerLast(curr.right);
                }
            }
        }
        return res;
    }
}
