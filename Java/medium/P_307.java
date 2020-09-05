package medium;

@SuppressWarnings({ "InnerClassMayBeStatic", "unused" })
public class P_307 {

    class NumArrayBIT {
        private class BIT {
            private final int[] bit;

            BIT(int n) {
                bit = new int[n + 1];
            }

            public void add(int i, int val) {
                while (i < bit.length) {
                    bit[i] += val;
                    i += lsb(i);
                }
            }

            public int query(int i) {
                int ans = 0;
                while (i > 0) {
                    ans += bit[i];
                    i -= lsb(i);
                }
                return ans;
            }

            private int lsb(int i) {
                return i & -i;  // zeroes all the bits except the least significant one
            }
        }

        BIT bit;
        int[] nums;

        NumArrayBIT(int[] nums) {
            bit = new BIT(nums.length);
            for (int i = 0; i < nums.length; i++) {
                bit.add(i + 1, nums[i]);
            }
            this.nums = nums;
        }

        public void update(int i, int val) {
            bit.add(i + 1, val - nums[i]);
            nums[i] = val;
        }

        public int sumRange(int i, int j) {
            return bit.query(j + 1) - bit.query(i);
        }
    }

    class NumArray {
        private class SegTree {
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
                }
                recalc();
            }

            private void recalc() {
                if (leftMost == rightMost) {
                    return;
                }
                sum = left.sum + right.sum;
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

            private int query(int l, int r) {
                if (r < leftMost || l > rightMost) {
                    return 0;
                }
                if (l <= leftMost && rightMost <= r) {
                    return sum;
                }
                return left.query(l, r) + right.query(l, r);
            }
        }

        SegTree st;

        NumArray(int[] nums) {
            if (nums.length > 0) {
                st = new SegTree(0, nums.length - 1, nums);
            }
        }

        public void update(int i, int val) {
            st.update(i, val);
        }

        public int sumRange(int i, int j) {
            return st.query(i, j);
        }
    }
}
