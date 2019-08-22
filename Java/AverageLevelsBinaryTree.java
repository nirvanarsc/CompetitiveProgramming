import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class AverageLevelsBinaryTree {

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) { val = x; }
    }

    public List<Double> averageOfLevels(TreeNode root) {
        final List<Double> res = new ArrayList<>();
        if (root == null) { return res; }

        final Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            final int len = queue.size();
            double levelSum = 0;
            for (int i = 0; i < len; i++) {
                final TreeNode curr = queue.poll();
                levelSum += curr.val;
                if (curr.left != null) { queue.offer(curr.left); }
                if (curr.right != null) { queue.offer(curr.right); }
            }
            res.add(levelSum / len);
        }
        return res;
    }
}
