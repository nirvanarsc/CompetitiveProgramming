package leetcode.weekly_contests.weekly_300_399.weekly_319;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Deque;

import utils.DataStructures.TreeNode;

public class P_3 {

    private static final class UnionFind {
        private final int[] parent;
        private final int[] size;
        private int count;

        private UnionFind(int n) {
            parent = new int[n];
            size = new int[n];
            count = n;
            for (int i = 0; i < n; i++) {
                parent[i] = i;
                size[i] = 1;
            }
        }

        public int find(int p) {
            // path compression
            while (p != parent[p]) {
                parent[p] = parent[parent[p]];
                p = parent[p];
            }
            return p;
        }

        public void union(int p, int q) {
            final int rootP = find(p);
            final int rootQ = find(q);
            if (rootP == rootQ) {
                return;
            }
            // union by size
            if (size[rootP] > size[rootQ]) {
                parent[rootQ] = rootP;
                size[rootP] += size[rootQ];
                size[rootQ] = 0;
            } else {
                parent[rootP] = rootQ;
                size[rootQ] += size[rootP];
                size[rootP] = 0;
            }
            count--;
        }

        public int count() { return count; }

        public int[] size() { return size; }
    }

    public int minimumOperations(TreeNode root) {
        int res = 0;
        final Deque<TreeNode> dq = new ArrayDeque<>();
        dq.offerLast(root);
        while (!dq.isEmpty()) {
            final int n = dq.size();
            int idx = 0;
            final int[] curr = new int[n];
            for (int size = n; size > 0; size--) {
                final TreeNode u = dq.removeFirst();
                curr[idx++] = u.val;
                if (u.left != null) {
                    dq.offerLast(u.left);
                }
                if (u.right != null) {
                    dq.offerLast(u.right);
                }
            }
            final int[][] sorted = new int[n][2];
            for (int i = 0; i < n; i++) {
                sorted[i] = new int[] { curr[i], i };
            }
            Arrays.sort(sorted, Comparator.comparingInt(a -> a[0]));
            final UnionFind uf = new UnionFind(n);
            for (int i = 0; i < n; i++) {
                uf.union(i, sorted[i][1]);
            }
            for (int i = 0; i < n; i++) {
                if (uf.find(i) == i) {
                    res += uf.size[i] - 1;
                }
            }
        }
        return res;
    }
}
