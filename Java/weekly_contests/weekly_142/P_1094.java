package weekly_contests.weekly_142;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class P_1094 {

    /**
     * Note: this class has a natural ordering that is inconsistent with equals.
     */
    private static final class Endpoint implements Comparable<Endpoint> {
        int passengers;
        int time;
        boolean isStart;

        private Endpoint(int passengers, int time, boolean isStart) {
            this.passengers = passengers;
            this.time = time;
            this.isStart = isStart;
        }

        @Override
        public int compareTo(Endpoint e) {
            return time != e.time ? Integer.compare(time, e.time) : Boolean.compare(isStart, e.isStart);
        }
    }

    public boolean carPooling(int[][] trips, int capacity) {
        final List<Endpoint> endpoints = new ArrayList<>();
        for (int[] trip : trips) {
            endpoints.add(new Endpoint(trip[0], trip[1], true));
            endpoints.add(new Endpoint(trip[0], trip[2], false));
        }

        Collections.sort(endpoints);

        int curr = 0;
        for (Endpoint endpoint : endpoints) {
            if (endpoint.isStart) {
                curr += endpoint.passengers;
                if (curr > capacity) {
                    return false;
                }
            } else {
                curr -= endpoint.passengers;
            }
        }
        return true;
    }
}
