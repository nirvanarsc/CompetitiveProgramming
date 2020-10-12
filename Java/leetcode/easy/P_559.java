package leetcode.easy;

import java.util.List;

public class P_559 {

    private static class Node {
        public int val;
        public List<Node> children;

        Node(int val, List<Node> children) {
            this.val = val;
            this.children = children;
        }
    }

    public int maxDepth(Node root) {
        if (root == null) {
            return 0;
        }
        int res = 1;
        for (Node n : root.children) {
            res = Math.max(res, 1 + maxDepth(n));
        }
        return res;
    }
}
