package leetcode.hard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import utils.DataStructures.BIT;

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
    public List<Integer> countSmaller(int[] nums) {
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
    public List<Integer> countSmallerBIT(int[] nums) {
        final int[] tmp = nums.clone();
        Arrays.sort(tmp);
        for (int i = 0; i < nums.length; i++) {
            nums[i] = Arrays.binarySearch(tmp, nums[i]) + 1;
        }
        final BIT bit = new BIT(nums.length);
        final Integer[] ans = new Integer[nums.length];
        for (int i = nums.length - 1; i >= 0; i--) {
            ans[i] = bit.query(nums[i] - 1);
            bit.add(nums[i], 1);
        }
        return Arrays.asList(ans);
    }
}
