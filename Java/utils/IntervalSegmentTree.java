package utils;

public class IntervalSegmentTree {
    int l, r;
    int k, lazy;
    IntervalSegmentTree left, right;
    String strategy;

    public IntervalSegmentTree(int l, int r, int k, String strategy) {
        this.l = l;
        this.r = r;
        this.k = k;
        this.strategy = strategy;
    }

    public int query(IntervalSegmentTree node, int i, int j) {
        if (i > j || node == null || i > node.r || j < node.l) {
            return 0;
        }
        if (i <= node.l && node.r <= j) {
            return node.k;
        }
        normalize(node);
        return Math.max(query(node.left, i, j), query(node.right, i, j));
    }

    public void update(IntervalSegmentTree node, int i, int j, int val) {
        if (i > j || node == null || i > node.r || j < node.l) {
            return;
        }
        if (i <= node.l && node.r <= j) {
            apply(node, val);
            return;
        }
        normalize(node);
        update(node.left, i, j, val);
        update(node.right, i, j, val);
        node.k = Math.max(node.left.k, node.right.k);
    }

    private static void normalize(IntervalSegmentTree node) {
        if (node.l < node.r) {
            if (node.left == null || node.right == null) {
                final int m = node.l + node.r >>> 1;
                node.left = new IntervalSegmentTree(node.l, m, node.k, node.strategy);
                node.right = new IntervalSegmentTree(m + 1, node.r, node.k, node.strategy);
            } else if (node.lazy > 0) {
                apply(node.left, node.lazy);
                apply(node.right, node.lazy);
            }
        }
        node.lazy = 0;
    }

    private static void apply(IntervalSegmentTree node, int lazy) {
        switch (node.strategy) {
            case "MAX":
                node.k = Math.max(node.k, lazy);
                node.lazy = Math.max(node.lazy, lazy);
                break;
            case "SUM":
                node.k += lazy;
                node.lazy += lazy;
                break;
        }
    }
}
