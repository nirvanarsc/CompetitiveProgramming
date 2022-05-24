package leetcode.weekly_contests.weekly_100_199.weekly_182;

import java.util.HashMap;
import java.util.Map;

@SuppressWarnings({ "InnerClassMayBeStatic", "unused" })
public class P_1396 {

    class UndergroundSystem {
        private class Pair {
            String target;
            int t;

            Pair(String target, int t) {
                this.target = target;
                this.t = t;
            }
        }

        private final Map<String, int[]> avg;
        private final Map<Integer, Pair> in;

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
            final int[] other = avg.get(key);
            if (other == null) {
                avg.put(key, new int[] { t - pair.t, 1 });
            } else {
                avg.put(key, new int[] { other[0] + t - pair.t, other[1] + 1 });
            }
        }

        public double getAverageTime(String startStation, String endStation) {
            final int[] ints = avg.get(startStation + ',' + endStation);
            return ints[0] / (double) ints[1];
        }
    }
}

