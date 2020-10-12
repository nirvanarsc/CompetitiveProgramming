package leetcode.hard;

import java.util.TreeMap;

@SuppressWarnings({ "unused", "InnerClassMayBeStatic" })
public class P_732 {

    class MyCalendarThree {
        TreeMap<Integer, Integer> tm;

        MyCalendarThree() {
            tm = new TreeMap<>();
        }

        public int book(int start, int end) {
            tm.merge(start, 1, Integer::sum);
            tm.merge(end, -1, Integer::sum);
            int active = 0;
            int sum = 0;
            for (int d : tm.values()) {
                active = Math.max(active, sum);
                sum += d;
            }
            return active;
        }
    }

    class MyCalendarThreeST {
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

        MyCalendarThreeST() {
            st = new SegTree(0, (int) 1e9);
        }

        public int book(int start, int end) {
            st.add(start, end - 1, 1);
            return (int) st.query(0, (int) 1e9);
        }
    }
}
