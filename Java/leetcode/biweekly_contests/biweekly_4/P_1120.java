package leetcode.biweekly_contests.biweekly_4;

import utils.DataStructures.TreeNode;

public class P_1120 {

    static class Pair {
        int nodes;
        int sum;

        Pair(int nodes, int sum) {
            this.nodes = nodes;
            this.sum = sum;
        }
    }

    public double maximumAverageSubtree(TreeNode root) {
        final double[] res = { 0.0 };
        postOrder(root, res);
        return res[0];
    }

    private static Pair postOrder(TreeNode node, double[] res) {
        if (node == null) {
            return new Pair(0, 0);
        }
        final Pair left = postOrder(node.left, res);
        final Pair right = postOrder(node.right, res);
        res[0] = Math.max(res[0], (double) (node.val + left.sum + right.sum) / (1 + left.nodes + right.nodes));
        return new Pair(1 + left.nodes + right.nodes, node.val + left.sum + right.sum);
    }
}
