package leetcode.weekly_contests.weekly_182;

import java.util.HashMap;
import java.util.Map;

public class P_1396 {

    static class Pair {
        String target;
        int t;

        Pair(String target, int t) {
            this.target = target;
            this.t = t;
        }
    }

    static class UndergroundSystem {
        Map<String, int[]> avg;
        Map<Integer, Pair> in;

        UndergroundSystem() {
            avg = new HashMap<>();
            in = new HashMap<>();
        }

        public void checkIn(int id, String stationName, int t) {
            in.put(id, new Pair(stationName, t));
        }

        public void checkOut(int id, String stationName, int t) {
            final Pair pair = in.get(id);
            final String key = pair.target + ',' + stationName;
            avg.putIfAbsent(key, new int[] { 0, 0 });
            avg.get(key)[0] += t - pair.t;
            avg.get(key)[1] += 1;
        }

        public double getAverageTime(String startStation, String endStation) {
            final int[] ints = avg.get(startStation + ',' + endStation);
            return ints[0] / (double) ints[1];
        }
    }
}

