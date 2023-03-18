package leetcode.biweekly_contests.biweekly_0_99.biweekly_98;

import java.util.ArrayList;
import java.util.List;

public class P_4 {

    private static class SegTree {
        int leftMost, rightMost;
        SegTree left, right;
        long operation = Long.MAX_VALUE;
        int sum;

        SegTree(int leftMost, int rightMost, int[] arr) {
            this.leftMost = leftMost;
            this.rightMost = rightMost;
            if (leftMost != rightMost) {
                final int mid = leftMost + rightMost >>> 1;
                left = new SegTree(leftMost, mid, arr);
                right = new SegTree(mid + 1, rightMost, arr);
                sum = left.sum + right.sum;
            } else {
                sum = arr[leftMost];
            }
        }

        private static long operation(long a, long b) {
            if (b == Long.MAX_VALUE) {
                return a;
            }
            if (a == Long.MAX_VALUE) {
                return b;
            }
            return a + b;
        }

        private void propagate() {
            if (leftMost == rightMost) {
                return;
            }
            left.operation = operation(left.operation, operation);
            right.operation = operation(right.operation, operation);
            if (operation != Long.MAX_VALUE && operation % 2 != 0) {
                final int ll = left.rightMost - left.leftMost + 1;
                final int rr = right.rightMost - right.leftMost + 1;
                left.sum = ll - left.sum;
                right.sum = rr - right.sum;
            }
            operation = Long.MAX_VALUE;
        }

        private long query(int l, int r) {
            propagate();
            if (r < leftMost || l > rightMost) {
                return 0;
            }
            if (l <= leftMost && rightMost <= r) {
                return sum;
            }
            return left.query(l, r) + right.query(l, r);
        }

        private void add(int l, int r, int v) {
            propagate();
            if (r < leftMost || l > rightMost) {
                return;
            }
            if (l <= leftMost && rightMost <= r) {
                operation = v;
                sum = (rightMost - leftMost + 1) - sum;
                return;
            }
            left.add(l, r, v);
            right.add(l, r, v);
            sum = left.sum + right.sum;
        }
    }

    public long[] handleQuery(int[] nums1, int[] nums2, int[][] queries) {
        final List<Long> res = new ArrayList<>();
        final int n = nums1.length;
        final SegTree st = new SegTree(0, n - 1, nums1);
        long sum = 0;
        for (int num : nums2) {
            sum += num;
        }
        for (int[] q : queries) {
            if (q[0] == 1) {
                st.add(q[1], q[2], 1);
            } else if (q[0] == 2) {
                sum += st.query(0, n - 1) * q[1];
            } else {
                res.add(sum);
            }
        }
        return res.stream().mapToLong(Long::longValue).toArray();
    }
}
