package leetcode.hard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class P_315 {

    private static class SegTree {
        int leftMost, rightMost;
        SegTree left, right;
        int sum;

        SegTree(int leftMost, int rightMost, int[] arr) {
            this.leftMost = leftMost;
            this.rightMost = rightMost;
            if (leftMost == rightMost) {
                sum = arr[leftMost];
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
            sum = left.sum + right.sum;
        }

        private int query(int l, int r) {
            if (l > rightMost || r < leftMost) {
                return 0;
            }
            if (l <= leftMost && rightMost <= r) {
                return sum;
            }
            return left.query(l, r) + right.query(l, r);
        }

        private void update(int idx, int val) {
            if (leftMost == rightMost) {
                sum = val;
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

    // Segment Tree
    public List<Integer> countSmallerST(int[] nums) {
        final int max = (int) 1e5;
        final int[] counter = new int[max];
        final SegTree st = new SegTree(0, max - 1, counter);
        final List<Integer> res = new ArrayList<>(Collections.nCopies(nums.length, 0));
        for (int i = nums.length - 1; i >= 0; i--) {
            final int num = (int) (nums[i] + 1e4);
            res.set(i, st.query(0, num - 1));
            st.update(num, ++counter[num]);
        }
        return res;
    }

    // Binary Indexed Tree
    private static final class BIT {
        private final int n;
        private final int[] data;

        private BIT(int n) {
            this.n = n;
            data = new int[n + 1];
        }

        public void add(int idx, long val) {
            for (int i = idx + 1; i <= n; i += lsb(i)) {
                data[i] += val;
            }
        }

        public int sum(int l, int r) {
            return sum(r) - sum(l - 1);
        }

        private int sum(int idx) {
            int res = 0;
            for (int i = idx + 1; i > 0; i -= lsb(i)) {
                res += data[i];
            }
            return res;
        }

        private static int lsb(int i) {
            return i & -i;  // zeroes all the bits except the least significant one
        }

        // get k-th element
        public int getKth(int k) {
            int lo = 0;
            int hi = n;
            while (lo < hi) {
                final int mid = lo + hi >>> 1;
                if (k > sum(mid)) {
                    lo = mid + 1;
                } else {
                    hi = mid;
                }
            }
            return lo;
        }
    }

    public List<Integer> countSmaller(int[] nums) {
        final int n = nums.length;
        final int maxNeg = (int) 1e4;
        for (int i = 0; i < n; i++) {
            nums[i] += maxNeg;
        }
        final BIT bit = new BIT(2 * maxNeg + 10);
        final int[] res = new int[n];
        for (int i = n - 1; i >= 0; i--) {
            bit.add(nums[i], 1);
            res[i] = bit.sum(0, nums[i] - 1);
        }
        return Arrays.stream(res).boxed().collect(Collectors.toList());
    }
}
