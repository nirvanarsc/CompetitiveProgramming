package utils;

public class IntervalSegmentTree {
    int l, r;
    int k, lazy;
    IntervalSegmentTree left, right;

    public IntervalSegmentTree(int l, int r, int k) {
        this.l = l;
        this.r = r;
        this.k = k;
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
            node.k += val;
            node.lazy += val;
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
                node.left = new IntervalSegmentTree(node.l, m, node.k);
                node.right = new IntervalSegmentTree(m + 1, node.r, node.k);
            } else if (node.lazy > 0) {
                node.left.k += node.lazy;
                node.left.lazy += node.lazy;
                node.right.k += node.lazy;
                node.right.lazy += node.lazy;
            }
        }
        node.lazy = 0;
    }
}
