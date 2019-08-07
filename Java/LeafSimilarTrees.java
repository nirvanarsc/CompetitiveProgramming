import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class LeafSimilarTrees {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) { val = x; }
    }

    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        return dfs(root1).equals(dfs(root2));
    }

    public boolean leafSimilar2(TreeNode root1, TreeNode root2) {
        final Stack<TreeNode> s1 = new Stack<>();
        final Stack<TreeNode> s2 = new Stack<>();
        s1.push(root1);
        s2.push(root2);
        while (!s1.empty() && !s2.empty()) {
            if (dfs(s1) != dfs(s2)) { return false; }
        }
        return s1.empty() && s2.empty();
    }

    public int dfs(Stack<TreeNode> s) {
        while (true) {
            final TreeNode node = s.pop();
            if (node.right != null) { s.push(node.right); }
            if (node.left != null) { s.push(node.left); }
            if (node.left == null && node.right == null) { return node.val; }
        }
    }

    List<Integer> dfs(TreeNode root) {
        final Stack<TreeNode> stack = new Stack<>();
        final List<Integer> res = new ArrayList<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            final TreeNode node = stack.pop();
            if (node.right != null) { stack.push(node.right); }
            if (node.left != null) { stack.push(node.left); }
            if (node.right == null && node.left == null) { res.add(node.val); }
        }
        return res;
    }
}
