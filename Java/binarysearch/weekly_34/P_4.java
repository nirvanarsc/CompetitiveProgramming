package binarysearch.weekly_34;

public class P_4 {

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

    public int solve(int[] nums, int pos) {
        if (nums[pos] < 0) {
            return nums[pos];
        }
        final int n = nums.length;
        final SegTree st = new SegTree(0, n - 1, nums);
        int res = (int) -1e9;
        int lo = 0, hi = n - 1;
        while (lo <= hi) {
            final int minIdx = st.query(lo, hi, nums);
            res = Math.max(res, (hi - lo + 1) * nums[minIdx]);
            if (minIdx < pos) {
                lo = minIdx + 1;
            } else if (minIdx > pos) {
                hi = minIdx - 1;
            } else {
                break;
            }
        }
        return res;
    }
}
