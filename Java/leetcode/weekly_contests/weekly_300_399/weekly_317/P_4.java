package leetcode.weekly_contests.weekly_300_399.weekly_317;

import utils.DataStructures.TreeNode;

public class P_4 {

    private static class SegTree {
        int leftMost, rightMost;
        SegTree left, right;
        int max;

        SegTree(int leftMost, int rightMost, int[] arr) {
            this.leftMost = leftMost;
            this.rightMost = rightMost;
            if (leftMost == rightMost) {
                max = arr[leftMost];
            } else {
                final int mid = leftMost + rightMost >>> 1;
                left = new SegTree(leftMost, mid, arr);
                right = new SegTree(mid + 1, rightMost, arr);
                recalc();
            }
        }

        private void recalc() {
            if (leftMost == rightMost) {
                return;
            }
            max = Math.max(left.max, right.max);
        }

        private int query(int l, int r) {
            if (r < leftMost || l > rightMost) {
                return (int) -1e9;
            }
            if (l <= leftMost && rightMost <= r) {
                return max;
            }
            return Math.max(left.query(l, r), right.query(l, r));
        }

        private void update(int idx, long val) {
            if (leftMost == rightMost) {
                max += val;
            } else {
                final int mid = leftMost + rightMost >>> 1;
                if (idx <= mid) {
                    left.update(idx, val);
                } else {
                    right.update(idx, val);
                }
                recalc();
            }
        }
    }

    static int time;
    static int n;
    static int[] in;
    static int[] out;
    static int[] map;
    static int[] depth;

    public int[] treeQueries(TreeNode root, int[] queries) {
        time = 0;
        n = 0;
        dfs(root);
        in = new int[n];
        out = new int[n];
        map = new int[n];
        depth = new int[n];
        dfs2(root, 0);
        final SegTree st = new SegTree(0, n - 1, depth);
        final int q = queries.length;
        final int[] res = new int[q];
        for (int i = 0; i < q; i++) {
            final int u = map[queries[i] - 1];
            final int l = in[u];
            final int r = out[u];
            res[i] = Math.max(st.query(0, l - 1), st.query(r, n - 1));
        }
        return res;
    }

    private static void dfs(TreeNode node) {
        if (node == null) {
            return;
        }
        n++;
        dfs(node.left);
        dfs(node.right);
    }

    private static void dfs2(TreeNode node, int d) {
        if (node == null) {
            return;
        }
        final int u = map[node.val - 1] = time;
        in[u] = time++;
        depth[u] = d;
        dfs2(node.left, d + 1);
        dfs2(node.right, d + 1);
        out[u] = time;
    }
}
