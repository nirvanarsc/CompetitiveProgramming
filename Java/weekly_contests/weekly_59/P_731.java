package weekly_contests.weekly_59;

import java.util.TreeMap;

import utils.IntervalSegmentTree;

public class P_731 {

    static class MyCalendarTwo {
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

    static class MyCalendarTwoST {
        IntervalSegmentTree st;

        MyCalendarTwoST() {
            st = new IntervalSegmentTree(0, (int) 1e9, 0);
        }

        public boolean book(int start, int end) {
            final int k = st.query(st, start, end - 1);
            if (k >= 2) {
                return false;
            }
            st.update(st, start, end - 1, 1);
            return true;
        }
    }
}
