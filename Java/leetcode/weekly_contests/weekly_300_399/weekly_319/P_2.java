package leetcode.weekly_contests.weekly_300_399.weekly_319;

import java.util.ArrayList;
import java.util.List;

public class P_2 {

    private static class SegTree {
        int leftMost, rightMost;
        SegTree left, right;
        int lcm;

        SegTree(int leftMost, int rightMost, int[] arr) {
            this.leftMost = leftMost;
            this.rightMost = rightMost;
            if (leftMost == rightMost) {
                lcm = arr[leftMost];
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
            lcm = lcm(left.lcm, right.lcm);
        }

        private int query(int l, int r) {
            if (r < leftMost || l > rightMost) {
                return 1;
            }
            if (l <= leftMost && rightMost <= r) {
                return lcm;
            }
            return lcm(left.query(l, r), right.query(l, r));
        }

        private static int lcm(int a, int b) {
            return (a * b) / gcd(a, b);
        }

        private static int gcd(int a, int b) {
            return b == 0 ? a : gcd(b, a % b);
        }
    }

    public int subarrayLCM(int[] nums, int k) {
        final List<List<Integer>> lists = new ArrayList<>();
        final List<Integer> curr = new ArrayList<>();
        for (int num : nums) {
            if (k % num != 0) {
                if (!curr.isEmpty()) {
                    lists.add(new ArrayList<>(curr));
                }
                curr.clear();
            } else {
                curr.add(num);
            }
        }
        if (!curr.isEmpty()) {
            lists.add(new ArrayList<>(curr));
        }
        int res = 0;
        for (List<Integer> list : lists) {
            res += f(list, k);
        }
        return res;
    }

    private static int f(List<Integer> list, int k) {
        final int[] arr = list.stream().mapToInt(Integer::intValue).toArray();
        final int n = arr.length;
        final SegTree st = new SegTree(0, n - 1, arr);
        int res = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                if (st.query(i, j) == k) {
                    res++;
                }
            }
        }
        return res;
    }
}
