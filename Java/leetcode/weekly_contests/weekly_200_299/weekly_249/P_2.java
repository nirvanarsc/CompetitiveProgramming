package leetcode.weekly_contests.weekly_200_299.weekly_249;

import java.util.Arrays;

public class P_2 {

    private static class SegTree {
        int leftMost, rightMost;
        SegTree left, right;
        int mask;

        SegTree(int leftMost, int rightMost, int[] arr) {
            this.leftMost = leftMost;
            this.rightMost = rightMost;
            if (leftMost == rightMost) {
                mask = arr[leftMost];
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
            mask = left.mask | right.mask;
        }

        private int query(int l, int r) {
            if (r < leftMost || l > rightMost) {
                return 0;
            }
            if (l <= leftMost && rightMost <= r) {
                return mask;
            }
            return left.query(l, r) | right.query(l, r);
        }

        private void update(int idx, int val) {
            if (leftMost == rightMost) {
                mask = val;
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

    public int countPalindromicSubsequence(String s) {
        final char[] w = s.toCharArray();
        final int n = s.length();
        final int[] arr = new int[n];
        final int[] first = new int[26];
        final int[] last = new int[26];
        Arrays.fill(first, (int) 2e5);
        Arrays.fill(last, -1);
        for (int i = 0; i < n; i++) {
            arr[i] = 1 << (w[i] - 'a');
            first[w[i] - 'a'] = Math.min(first[w[i] - 'a'], i);
            last[w[i] - 'a'] = Math.max(last[w[i] - 'a'], i);
        }
        final SegTree st = new SegTree(0, n - 1, arr);
        int res = 0;
        for (int i = 0; i < 26; i++) {
            if (first[i] + 1 >= last[i]) {
                continue;
            }
            res += Integer.bitCount(st.query(first[i] + 1, last[i] - 1));
        }
        return res;
    }
}
