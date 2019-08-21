import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class N_aryTreeLevelOrder {
    static class Node {
        public int val;
        public List<Node> children;

        Node() {}

        Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }

    public List<List<Integer>> levelOrder(Node root) {
        final List<List<Integer>> res = new ArrayList<>();

        if (root == null) { return res; }

        res.add(Collections.singletonList(root.val));
        Queue<Node> q1 = new LinkedList<>();
        Queue<Node> q2 = new LinkedList<>();
        q1.offer(root);

        while (!q1.isEmpty()) {
            final Node curr = q1.poll();
            for (Node n : curr.children) {
                q2.offer(n);
            }
            if (q1.isEmpty() && !q2.isEmpty()) {
                final List<Integer> newLevel = new ArrayList<>();
                for (Node n : q2) {
                    newLevel.add(n.val);
                }
                res.add(newLevel);
                final Queue<Node> t = q1;
                q1 = q2;
                q2 = t;
            }
        }

        return res;
    }

    public List<List<Integer>> levelOrder2(Node root) {
        final List<List<Integer>> res = new ArrayList<>();

        if (root == null) { return res; }

        final Queue<Node> queue = new LinkedList<>();

        queue.offer(root);

        while (!queue.isEmpty()) {
            final List<Integer> currLevel = new ArrayList<>();
            final int len = queue.size();
            for (int i = 0; i < len; i++) {
                final Node curr = queue.poll();
                currLevel.add(curr.val);
                for (Node c : curr.children) { queue.offer(c); }
            }
            res.add(currLevel);
        }

        return res;
    }
}
