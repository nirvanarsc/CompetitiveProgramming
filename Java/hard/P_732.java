package hard;

import java.util.TreeMap;

import utils.IntervalSegmentTree;

public class P_732 {

    static class MyCalendarThree {
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

    static class MyCalendarThreeST {
        IntervalSegmentTree st;

        MyCalendarThreeST() {
            st = new IntervalSegmentTree(0, (int) 1e9, 0);
        }

        public int book(int start, int end) {
            st.update(st, start, end - 1, 1);
            return st.query(st, 0, (int) 1e9);
        }
    }
}
