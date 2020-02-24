package weekly_contests.weekly_169;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

import utils.DataStructures.TreeNode;

public class P_1305 {

    static class BSTIterator {
        private final Deque<TreeNode> stack;

        BSTIterator(TreeNode root) {
            stack = new LinkedList<>();
            traverseLeft(root);
        }

        public boolean hasNext() {
            return !stack.isEmpty();
        }

        public int peek() {
            return stack.peekFirst().val;
        }

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

    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        final List<Integer> res = new ArrayList<>();
        final BSTIterator r1 = new BSTIterator(root1);
        final BSTIterator r2 = new BSTIterator(root2);
        while (r1.hasNext() && r2.hasNext()) {
            if (r1.peek() < r2.peek()) {
                res.add(r1.next());
            } else {
                res.add(r2.next());
            }
        }
        while (r1.hasNext()) {
            res.add(r1.next());
        }
        while (r2.hasNext()) {
            res.add(r2.next());
        }
        return res;
    }
}
