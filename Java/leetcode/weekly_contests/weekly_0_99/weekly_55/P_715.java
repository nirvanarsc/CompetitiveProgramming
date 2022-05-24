package leetcode.weekly_contests.weekly_0_99.weekly_55;

import java.util.TreeMap;

public class P_715 {

    static class RangeModule {
        TreeMap<Integer, Integer> intervals = new TreeMap<>();

        public void addRange(int left, int right) {
            final Integer start = intervals.floorKey(left);
            final Integer end = intervals.floorKey(right);
            if (start != null && intervals.get(start) >= left) {
                left = start;
            }
            if (end != null && intervals.get(end) > right) {
                right = intervals.get(end);
            }
            intervals.put(left, right);

            intervals.subMap(left, false, right, true).clear();
        }

        public boolean queryRange(int left, int right) {
            final Integer start = intervals.floorKey(left);
            return start != null && intervals.get(start) >= right;
        }

        public void removeRange(int left, int right) {
            final Integer start = intervals.floorKey(left);
            final Integer end = intervals.floorKey(right);

            if (end != null && intervals.get(end) > right) {
                intervals.put(right, intervals.get(end));
            }
            if (start != null && intervals.get(start) > left) {
                intervals.put(start, left);
            }
            intervals.subMap(left, true, right, false).clear();
        }
    }
}


