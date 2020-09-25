package weekly_contests.weekly_19;

import java.util.Arrays;
import java.util.TreeMap;

public class P_493 {

    private static final class BIT {
        private final int[] bit;

        private BIT(int n) {
            bit = new int[n + 1];
        }

        public void add(int i) {
            while (i > 0) {
                bit[i] += 1;
                i -= lsb(i);
            }
        }

        public int query(int i) {
            int ans = 0;
            while (i < bit.length) {
                ans += bit[i];
                i += lsb(i);
            }
            return ans;
        }

        private static int lsb(int i) {
            return i & -i;  // zeroes all the bits except the least significant one
        }
    }

    public int reversePairs(int[] nums) {
        final int[] copy = nums.clone();
        Arrays.sort(copy);
        final BIT bit = new BIT(copy.length + 1);
        int res = 0;
        for (int ele : nums) {
            res += bit.query(lowerBound(copy, 2L * ele + 1));
            bit.add(lowerBound(copy, ele));
        }
        return res;
    }

    private static int lowerBound(int[] arr, long val) {
        int lo = 0, hi = arr.length;
        while (lo < hi) {
            final int m = lo + hi >>> 1;
            if (arr[m] < val) {
                lo = m + 1;
            } else {
                hi = m;
            }
        }
        return lo + 1;
    }

    public int reversePairsMS(int[] nums) {
        return mergeSort(nums, 0, nums.length - 1);
    }

    private static int mergeSort(int[] nums, int lo, int hi) {
        if (lo >= hi) {
            return 0;
        }
        final int mid = lo + hi >>> 1;
        int cnt = mergeSort(nums, lo, mid) + mergeSort(nums, mid + 1, hi);
        for (int i = lo, j = mid + 1; i <= mid; i++) {
            while (j <= hi && nums[i] > 2L * nums[j]) {
                j++;
            }
            cnt += j - (mid + 1);
        }
        Arrays.sort(nums, lo, hi + 1);
        return cnt;
    }

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
            if (r < leftMost || l > rightMost) {
                return 0;
            }
            if (l <= leftMost && rightMost <= r) {
                return sum;
            }
            return left.query(l, r) + right.query(l, r);
        }

        private void update(int idx, int val) {
            if (leftMost == rightMost) {
                sum += val;
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

    public int reversePairsST(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        final int n = nums.length;
        final int[] copy = nums.clone();
        Arrays.sort(copy);
        final TreeMap<Long, Integer> tm = new TreeMap<>();
        for (int i = 0; i < n; i++) {
            tm.put((long) copy[i], i);
        }
        final SegTree st = new SegTree(0, n - 1, new int[n]);
        int res = 0;
        for (int val : nums) {
            final Long k = tm.higherKey(2L * val);
            if (k != null) {
                res += st.query(tm.get(k), n);
            }
            st.update(tm.get((long) val), 1);
        }
        return res;
    }
}
