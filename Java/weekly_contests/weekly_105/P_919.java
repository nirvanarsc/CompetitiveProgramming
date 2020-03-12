package weekly_contests.weekly_105;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.List;

import utils.DataStructures.TreeNode;

public class P_919 {

    static class CBTInserter {
        List<TreeNode> aL;

        CBTInserter(TreeNode root) {
            aL = new ArrayList<>();
            populateList(root, aL);
        }

        public int insert(int v) {
            final TreeNode newNode = new TreeNode(v);
            final int size = aL.size();
            if (size % 2 == 0) {
                aL.get((size - 1) / 2).right = newNode;
            } else {
                aL.get((size - 1) / 2).left = newNode;
            }
            aL.add(newNode);
            return aL.get((size - 1) / 2).val;
        }

        public TreeNode get_root() {
            return aL.get(0);
        }

        private static void populateList(TreeNode root, List<TreeNode> aL) {
            final Deque<TreeNode> q = new ArrayDeque<>(Collections.singleton(root));
            while (!q.isEmpty()) {
                final TreeNode treeNode = q.removeFirst();
                aL.add(treeNode);
                if (treeNode.left != null) { q.offerLast(treeNode.left); }
                if (treeNode.right != null) { q.offerLast(treeNode.right); }
            }
        }
    }
}


