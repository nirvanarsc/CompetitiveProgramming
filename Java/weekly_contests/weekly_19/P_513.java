package weekly_contests.weekly_19;

import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Deque;

import utils.DataStructures.TreeNode;

public class P_513 {

    public int findBottomLeftValue(TreeNode root) {
        final Deque<TreeNode> queue = new ArrayDeque<>(Collections.singleton(root));
        int res = -1;
        while (!queue.isEmpty()) {
            final int levelSize = queue.size();
            for (int k = 0; k < levelSize; k++) {
                final TreeNode curr = queue.removeFirst();
                if (k == 0) { res = curr.val; }
                if (curr.left != null) { queue.offerLast(curr.left); }
                if (curr.right != null) { queue.offerLast(curr.right); }
            }
        }
        return res;
    }
}
