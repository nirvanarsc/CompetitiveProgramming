package medium;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

import utils.DataStructures.TreeNode;

public class P_173 {

    public static class BSTIterator {
        List<Integer> res = new ArrayList<>();
        int idx;

        public BSTIterator(TreeNode root) {
            helper(root, res);
        }

        private static void helper(TreeNode n, List<Integer> l) {
            if (n == null) {
                return;
            }

            helper(n.left, l);
            l.add(n.val);
            helper(n.right, l);
        }

        /** @return the next smallest number */
        public int next() {
            return res.get(idx++);
        }

        /** @return whether we have a next smallest number */
        public boolean hasNext() {
            return idx != res.size();
        }
    }

    public static class BSTIteratorSpace {
        private final Deque<TreeNode> stack;

        public BSTIteratorSpace(TreeNode root) {
            stack = new LinkedList<>();
            traverseLeft(root);
        }

        /** @return whether we have a next smallest number */
        public boolean hasNext() {
            return !stack.isEmpty();
        }

        /** @return the next smallest number */
        public int next() {
            final TreeNode node = stack.pop();
            traverseLeft(node.right);
            return node.val;
        }

        private void traverseLeft(TreeNode root) {
            TreeNode curr = root;
            while (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }
        }
    }
}
