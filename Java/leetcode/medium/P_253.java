package leetcode.medium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class P_253 {

    /**
     * Note: this class has a natural ordering that is inconsistent with equals.
     */
    private static final class Endpoint implements Comparable<Endpoint> {
        int time;
        boolean isStart;

        private Endpoint(int time, boolean isStart) {
            this.time = time;
            this.isStart = isStart;
        }

        @Override
        public int compareTo(Endpoint e) {
            return time != e.time ? Integer.compare(time, e.time) : Boolean.compare(isStart, e.isStart);
        }
    }

    public int minMeetingRooms(int[][] intervals) {
        final List<Endpoint> endpoints = new ArrayList<>();
        for (int[] interval : intervals) {
            endpoints.add(new Endpoint(interval[0], true));
            endpoints.add(new Endpoint(interval[1], false));
        }

        Collections.sort(endpoints);

        int res = 0, curr = 0;
        for (Endpoint endpoint : endpoints) {
            if (endpoint.isStart) {
                ++curr;
                res = Math.max(curr, res);
            } else {
                --curr;
            }
        }
        return res;
    }
}
