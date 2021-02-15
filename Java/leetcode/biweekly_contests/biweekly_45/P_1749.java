package leetcode.biweekly_contests.biweekly_45;

public class P_1749 {

    public int maxAbsoluteSum(int[] nums) {
        final int[] neg = nums.clone();
        for (int i = 0; i < nums.length; i++) {
            neg[i] = -neg[i];
        }
        return Math.max(maxSubArray(neg), maxSubArray(nums));
    }

    public int maxSubArray(int[] nums) {
        int minSum = 0, sum = 0, maxSum = 0, max = Integer.MIN_VALUE;
        for (int num : nums) {
            sum += num;
            max = Math.max(max, num);
            minSum = Math.min(minSum, sum);
            maxSum = Math.max(maxSum, sum - minSum);
        }
        return max < 0 ? max : maxSum;
    }

    private static class SegTree {
        int leftMost, rightMost;
        SegTree left, right;
        long[] max = new long[4];
        long[] min = new long[4];

        SegTree(int leftMost, int rightMost, int[] arr) {
            this.leftMost = leftMost;
            this.rightMost = rightMost;
            if (leftMost == rightMost) {
                max[0] = max[1] = max[2] = arr[leftMost];
                max[3] = arr[leftMost];
                min[0] = min[1] = min[2] = arr[leftMost];
                min[3] = arr[leftMost];
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
            max = mergeMax(left.max, right.max);
            min = mergeMin(left.min, right.min);
        }

        private static long[] mergeMax(long[] left, long[] right) {
            final long newSum = left[0] + right[0];
            final long newPrefix = Math.max(left[0] + right[1], left[1]);
            final long newSuffix = Math.max(right[0] + left[2], right[2]);
            final long newRes = Math.max(Math.max(left[3], right[3]), left[2] + right[1]);
            return new long[] { newSum, newPrefix, newSuffix, newRes };
        }

        private static long[] mergeMin(long[] left, long[] right) {
            final long newSum = left[0] + right[0];
            final long newPrefix = Math.min(left[0] + right[1], left[1]);
            final long newSuffix = Math.min(right[0] + left[2], right[2]);
            final long newRes = Math.min(Math.min(left[3], right[3]), left[2] + right[1]);
            return new long[] { newSum, newPrefix, newSuffix, newRes };
        }

        private long[][] query(int l, int r) {
            final long v1 = (long) -1e9;
            final long v2 = (long) 1e9;
            if (r < leftMost || l > rightMost) {
                return new long[][] {
                        { 0, v1, v1, v1 },
                        { 0, v2, v2, v2 }
                };
            }
            if (l <= leftMost && rightMost <= r) {
                return new long[][] { max, min };
            }
            final long[][] leftRes = left.query(l, r);
            final long[][] rightRes = right.query(l, r);
            final long[] max = mergeMax(leftRes[0], rightRes[0]);
            final long[] min = mergeMin(leftRes[1], rightRes[1]);
            return new long[][] { max, min };
        }

        private void update(int idx, int val) {
            if (leftMost == rightMost) {
                max[0] = max[1] = max[2] = val;
                max[3] = val;
                min[0] = min[1] = min[2] = val;
                min[3] = val;
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

    public int maxAbsoluteSumST(int[] nums) {
        final SegTree st = new SegTree(0, nums.length - 1, nums);
        return (int) Math.max(Math.abs(st.max[3]), Math.abs(st.min[3]));
    }
}
