import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class BinaryTreeInorderTraversal {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) { val = x; }
    }

    public List<Integer> inorderTraversal(TreeNode root) {
        final List<Integer> res = new ArrayList<>();
        final Deque<TreeNode> s = new LinkedList<>();
        TreeNode curr = root;

        while (!s.isEmpty() || curr != null) {
            if (curr != null) {
                s.addFirst(curr);
                curr = curr.left;
            } else {
                curr = s.removeFirst();
                res.add(curr.val);
                curr = curr.right;
            }
        }

        return res;
    }
}
