package leetcode.weekly_contests.weekly_59;

import java.util.Map;
import java.util.TreeMap;

@SuppressWarnings({ "unused", "InnerClassMayBeStatic", "PublicConstructorInNonPublicClass" })
public class P_729 {

    class MyCalendarTM {
        TreeMap<Integer, Integer> tm;

        MyCalendarTM() {
            tm = new TreeMap<>();
        }

        public boolean book(int start, int end) {
            final Map.Entry<Integer, Integer> lo = tm.floorEntry(start);
            final Map.Entry<Integer, Integer> hi = tm.ceilingEntry(start);
            if (lo != null && lo.getValue() >= start) {
                return false;
            }
            if (hi != null && hi.getKey() < end) {
                return false;
            }
            tm.put(start, end - 1);
            return true;
        }
    }

    class MyCalendar {

        private class SegTree {
            int leftMost, rightMost;
            SegTree left, right;
            long add;
            long max;

            SegTree(int leftMost, int rightMost) {
                this.leftMost = leftMost;
                this.rightMost = rightMost;
            }

            private void createChildren() {
                if (left == null || right == null) {
                    final int mid = leftMost + rightMost >>> 1;
                    left = new SegTree(leftMost, mid);
                    right = new SegTree(mid + 1, rightMost);
                }
            }

            private void recalc() {
                max = Math.max(apply(left), apply(right));
            }

            private void propagate() {
                createChildren();
                left.compose(add);
                right.compose(add);
                add = 0;
            }

            private void compose(long add) {
                this.add += add;
            }

            private long apply(SegTree st) {
                return st.max + st.add;
            }

            private long query(int l, int r) {
                if (l > rightMost || r < leftMost) {
                    return (long) -1e18;
                }
                if (l <= leftMost && rightMost <= r) {
                    return apply(this);
                }
                propagate();
                recalc();
                return Math.max(left.query(l, r), right.query(l, r));
            }

            private void update(int l, int r, long add) {
                if (l > rightMost || r < leftMost) {
                    return;
                }
                if (l <= leftMost && rightMost <= r) {
                    compose(add);
                    return;
                }
                propagate();
                left.update(l, r, add);
                right.update(l, r, add);
                recalc();
            }
        }

        SegTree st;

        public MyCalendar() {
            st = new SegTree(0, (int) 1e9);
        }

        public boolean book(int start, int end) {
            if (st.query(start, end - 1) > 0) {
                return false;
            }
            st.update(start, end - 1, 1);
            return true;
        }
    }
}
