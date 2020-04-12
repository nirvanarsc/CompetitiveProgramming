package weekly_contests.weekly_59;

import java.util.Map;
import java.util.TreeMap;

import utils.IntervalSegmentTree;

public class P_729 {

    static class MyCalendar {
        TreeMap<Integer, Integer> tm;

        MyCalendar() {
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

    static class MyCalendarST {
        IntervalSegmentTree st;

        MyCalendarST() {
            st = new IntervalSegmentTree(0, (int) 1e9, 0);
        }

        public boolean book(int start, int end) {
            final int k = st.query(st, start, end - 1);
            if (k >= 1) {
                return false;
            }
            st.update(st, start, end - 1, 1);
            return true;
        }
    }
}
