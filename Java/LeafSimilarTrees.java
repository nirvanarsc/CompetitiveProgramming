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
