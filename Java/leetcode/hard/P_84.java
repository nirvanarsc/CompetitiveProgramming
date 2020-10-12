package leetcode.hard;

import java.util.ArrayDeque;
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
        if (heights.length == 0) {
            return 0;
        }
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
}
