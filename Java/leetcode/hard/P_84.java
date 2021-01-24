package leetcode.hard;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Collections;
import java.util.Deque;

public class P_84 {

    public int largestRectangleArea(int[] heights) {
        final Deque<Integer> stack = new ArrayDeque<>(Collections.singleton(-1));
        int res = 0;
        for (int i = 0; i <= heights.length; i++) {
            while (stack.size() > 1 && (i == heights.length || heights[stack.getFirst()] > heights[i])) {
                final int top = stack.removeFirst();
                final int area = heights[top] * (i - stack.getFirst() - 1);
                res = Math.max(res, area);
            }
            stack.addFirst(i);
        }
        return res;
    }

    public int largestRectangleAreaNew(int[] heights) {
        final int n = heights.length;
        final int[] ls = new int[n];
        final int[] rs = new int[n];
        final Deque<int[]> dq = new ArrayDeque<>();
        dq.addFirst(new int[] { -1, -1 });
        for (int i = 0; i < n; i++) {
            while (dq.getFirst()[0] >= heights[i]) {
                dq.removeFirst();
            }
            ls[i] = dq.getFirst()[1];
            dq.addFirst(new int[] { heights[i], i });
        }
        dq.clear();
        dq.addFirst(new int[] { -1, n });
        for (int i = n - 1; i >= 0; i--) {
            while (dq.getFirst()[0] >= heights[i]) {
                dq.removeFirst();
            }
            rs[i] = dq.getFirst()[1];
            dq.addFirst(new int[] { heights[i], i });
        }
        int res = 0;
        for (int i = 0; i < n; i++) {
            res = Math.max(res, heights[i] * (rs[i] - ls[i] - 1));
        }
        return res;
    }

    private static class SegTree {
        int leftMost, rightMost;
        SegTree left, right;
        int minIdx;
        int val;

        SegTree(int leftMost, int rightMost, int[] arr) {
            this.leftMost = leftMost;
            this.rightMost = rightMost;
            if (leftMost == rightMost) {
                minIdx = leftMost;
                val = arr[leftMost];
            } else {
                final int mid = leftMost + rightMost >>> 1;
                left = new SegTree(leftMost, mid, arr);
                right = new SegTree(mid + 1, rightMost, arr);
                minIdx = arr[left.minIdx] < arr[right.minIdx] ? left.minIdx : right.minIdx;
            }
        }

        private int query(int l, int r, int[] arr) {
            if (l > rightMost || r < leftMost) {
                return -1;
            }
            if (l <= leftMost && rightMost <= r) {
                return minIdx;
            }
            final int ll = left.query(l, r, arr);
            final int rr = right.query(l, r, arr);
            if (ll == -1) {
                return rr;
            }
            if (rr == -1) {
                return ll;
            }
            return arr[ll] < arr[rr] ? ll : rr;
        }
    }

    public int largestRectangleAreaST(int[] heights) {
        final SegTree segTree = new SegTree(0, heights.length - 1, heights);
        return dfs(segTree, heights, 0, heights.length - 1);
    }

    private static int dfs(SegTree root, int[] heights, int start, int end) {
        if (start > end) {
            return -1;
        }
        if (start == end) {
            return heights[start];
        }
        final int minIndex = root.query(start, end, heights);
        final int leftMax = dfs(root, heights, start, minIndex - 1);
        final int rightMax = dfs(root, heights, minIndex + 1, end);
        final int minMax = heights[minIndex] * (end - start + 1);
        return Math.max(Math.max(leftMax, rightMax), minMax);
    }

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
            } else {
                parent[rootP] = rootQ;
                size[rootQ] += size[rootP];
            }
            count--;
        }

        public int count() { return count; }

        public int[] size() { return size; }
    }

    public int largestRectangleAreaUF(int[] heights) {
        final int n = heights.length;
        final UnionFind uf = new UnionFind(n);
        final int[][] pairs = new int[n][2];
        for (int i = 0; i < n; i++) {
            pairs[i] = new int[] { heights[i], i };
        }
        Arrays.sort(pairs, (a, b) -> Integer.compare(b[0], a[0]));
        int res = 0;
        for (int i = 0; i < n; i++) {
            final int h = pairs[i][0];
            final int idx = pairs[i][1];
            if (idx > 0 && heights[idx - 1] >= h) {
                uf.union(idx, idx - 1);
            }
            if (idx < (n - 1) && heights[idx + 1] >= h) {
                uf.union(idx, idx + 1);
            }
            res = Math.max(res, uf.size()[uf.find(idx)] * h);
        }
        return res;
    }
}
