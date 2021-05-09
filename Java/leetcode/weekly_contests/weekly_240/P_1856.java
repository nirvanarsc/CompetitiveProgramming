package leetcode.weekly_contests.weekly_240;

public class P_1856 {

    private static class SegTree {
        int leftMost, rightMost;
        SegTree left, right;
        int min;

        SegTree(int leftMost, int rightMost, int[] arr) {
            this.leftMost = leftMost;
            this.rightMost = rightMost;
            if (leftMost == rightMost) {
                min = arr[leftMost];
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
            min = Math.min(left.min, right.min);
        }

        // rightMost index that is < r and where arr[idx] < k
        private int query1(int k, int r) {
            if (min >= k || leftMost >= r) {
                return -1;
            }
            if (leftMost == rightMost) {
                return leftMost;
            }
            final int resR = right.query1(k, r);
            return resR != -1 ? resR : left.query1(k, r);
        }

        // leftMost index that is > l and where arr[idx] < k
        private int query2(int k, int l) {
            if (min >= k || rightMost <= l) {
                return -1;
            }
            if (leftMost == rightMost) {
                return leftMost;
            }
            final int resL = left.query2(k, l);
            return resL != -1 ? resL : right.query2(k, l);
        }

        private void update(int idx, int val) {
            if (leftMost == rightMost) {
                min = val;
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

    private static class SegTreeS {
        int leftMost, rightMost;
        SegTreeS left, right;
        long sum;

        SegTreeS(int leftMost, int rightMost, int[] arr) {
            this.leftMost = leftMost;
            this.rightMost = rightMost;
            if (leftMost == rightMost) {
                sum = arr[leftMost];
            } else {
                final int mid = leftMost + rightMost >>> 1;
                left = new SegTreeS(leftMost, mid, arr);
                right = new SegTreeS(mid + 1, rightMost, arr);
                recalc();
            }
        }

        private void recalc() {
            if (leftMost == rightMost) {
                return;
            }
            sum = left.sum + right.sum;
        }

        private long query(int l, int r) {
            if (r < leftMost || l > rightMost) {
                return 0;
            }
            if (l <= leftMost && rightMost <= r) {
                return sum;
            }
            return left.query(l, r) + right.query(l, r);
        }

        private void update(int idx, long val) {
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

    private static final int MOD = (int) (1e9 + 7);

    public int maxSumMinProduct(int[] nums) {
        final int n = nums.length;
        final SegTree st1 = new SegTree(0, n - 1, nums);
        final SegTreeS st2 = new SegTreeS(0, n - 1, nums);
        long max = 0;
        for (int i = 0; i < nums.length; i++) {
            final int num = nums[i];
            final int ll = st1.query1(nums[i], i);
            int rr = st1.query2(nums[i], i);
            if (rr == -1) {
                rr = n;
            }
            max = Math.max(max, st2.query(ll + 1, rr - 1) * num);
        }
        return (int) (max % MOD);
    }
}
