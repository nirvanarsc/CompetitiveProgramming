package leetcode.weekly_contests.weekly_59;

import java.util.TreeMap;

@SuppressWarnings({ "unused", "InnerClassMayBeStatic" })
public class P_731 {

    class MyCalendarTwo {
        TreeMap<Integer, Integer> tm;

        MyCalendarTwo() {
            tm = new TreeMap<>();
        }

        public boolean book(int start, int end) {
            tm.merge(start, 1, Integer::sum);
            tm.merge(end, -1, Integer::sum);

            int active = 0;
            for (int d : tm.values()) {
                active += d;
                if (active >= 3) {
                    tm.merge(start, -1, Integer::sum);
                    tm.merge(end, +1, Integer::sum);
                    return false;
                }
            }
            return true;
        }
    }

    class MyCalendarTwoST {
        private class SegTree {
            int leftMost, rightMost;
            SegTree left, right;
            long max;
            long operation;

            SegTree(int leftMost, int rightMost) {
                this.leftMost = leftMost;
                this.rightMost = rightMost;
            }

            private long operation(long a, long b) {
                if (b == Long.MAX_VALUE) {
                    return a;
                }
                if (a == Long.MAX_VALUE) {
                    return b;
                }
                return b + a;
            }

            private void propagate() {
                if (leftMost == rightMost) {
                    return;
                }
                if (left == null || right == null) {
                    final int mid = leftMost + rightMost >>> 1;
                    left = new SegTree(leftMost, mid);
                    right = new SegTree(mid + 1, rightMost);
                }
                left.operation = operation(left.operation, operation);
                right.operation = operation(right.operation, operation);
                left.max = operation(left.max, operation);
                right.max = operation(right.max, operation);
                operation = Long.MAX_VALUE;
            }

            private long query(int l, int r) {
                propagate();
                if (r < leftMost || l > rightMost) {
                    return 0;
                }
                if (l <= leftMost && rightMost <= r) {
                    return max;
                }
                return Math.max(left.query(l, r), right.query(l, r));
            }

            private void add(int l, int r, int v) {
                propagate();
                if (r < leftMost || l > rightMost) {
                    return;
                }
                if (l <= leftMost && rightMost <= r) {
                    max = operation(max, v);
                    operation = operation(operation, v);
                    return;
                }
                left.add(l, r, v);
                right.add(l, r, v);
                max = Math.max(left.max, right.max);
            }
        }

        SegTree st;

        MyCalendarTwoST() {
            st = new SegTree(0, (int) 1e9);
        }

        public boolean book(int start, int end) {
            if (st.query(start, end - 1) >= 2) {
                return false;
            }
            st.add(start, end - 1, 1);
            return true;
        }
    }
}
