package leetcode.weekly_contests.weekly_59;

import java.util.TreeMap;

@SuppressWarnings({ "unused", "InnerClassMayBeStatic", "PublicConstructorInNonPublicClass" })
public class P_731 {

    class MyCalendarTwoTM {
        TreeMap<Integer, Integer> tm;

        MyCalendarTwoTM() {
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

    class MyCalendarTwo {

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

        public MyCalendarTwo() {
            st = new SegTree(0, (int) 1e9);
        }

        public boolean book(int start, int end) {
            if (st.query(start, end - 1) > 1) {
                return false;
            }
            st.update(start, end - 1, 1);
            return true;
        }
    }
}
