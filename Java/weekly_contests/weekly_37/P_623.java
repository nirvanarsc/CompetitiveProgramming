package weekly_contests.weekly_37;

import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Deque;

import utils.DataStructures.TreeNode;

public class P_623 {

    public TreeNode addOneRow(TreeNode root, int v, int d) {
        if (d == 1) {
            final TreeNode newRoot = new TreeNode(v);
            newRoot.left = root;
            return newRoot;
        }
        final Deque<TreeNode> q = new ArrayDeque<>(Collections.singleton(root));
        for (int i = 1; i < d; i++) {
            for (int j = q.size(); j > 0; j--) {
                final TreeNode curr = q.removeFirst();
                if (d - 1 == i) {
                    final TreeNode t1 = curr.left;
                    curr.left = new TreeNode(v);
                    curr.left.left = t1;
                    final TreeNode t2 = curr.right;
                    curr.right = new TreeNode(v);
                    curr.right.right = t2;
                } else {
                    if (curr.left != null) { q.offerLast(curr.left); }
                    if (curr.right != null) { q.offerLast(curr.right); }
                }
            }
        }
        return root;
    }
}
