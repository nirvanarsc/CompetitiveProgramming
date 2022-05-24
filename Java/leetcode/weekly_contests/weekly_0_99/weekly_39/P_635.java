package leetcode.weekly_contests.weekly_0_99.weekly_39;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

@SuppressWarnings("unused")
public class P_635 {

    static class LogSystem {
        TreeMap<Long, Integer> map;
        Map<String, Integer> units = new HashMap<>();

        LogSystem() {
            final String[] strings = { "Year", "Month", "Day", "Hour", "Minute", "Second" };
            for (int i = 0; i < strings.length; i++) {
                units.put(strings[i], i);
            }
            map = new TreeMap<>();
        }

        public void put(int id, String timestamp) {
            map.put(getHash(timestamp, -1, false), id);
        }

        private static long getHash(String timestamp, int end, boolean upper) {
            long hash = 0;
            long f = (long) 1e10;
            final String[] timestamps = timestamp.split(":");
            for (int i = 0; i < timestamps.length; i++, f /= 100) {
                hash += Integer.valueOf(timestamps[i]) * f;
                if (i == end) {
                    hash += upper ? f : 0;
                    break;
                }
            }
            return hash;
        }

        public List<Integer> retrieve(String s, String e, String gra) {
            final int end = units.get(gra);
            return new ArrayList<>(map.subMap(getHash(s, end, false), getHash(e, end, true)).values());
        }
    }
}

