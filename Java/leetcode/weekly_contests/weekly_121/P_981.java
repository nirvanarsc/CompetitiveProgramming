package leetcode.weekly_contests.weekly_121;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class P_981 {

    static class TimeMap {
        Map<String, TreeMap<Integer, String>> map;

        TimeMap() {
            map = new HashMap<>();
        }

        public void set(String key, String value, int timestamp) {
            map.computeIfAbsent(key, v -> new TreeMap<>()).put(timestamp, value);
        }

        public String get(String key, int timestamp) {
            if (!map.containsKey(key)) {
                return "";
            }
            final Map.Entry<Integer, String> entry = map.get(key).floorEntry(timestamp);
            if (entry == null) {
                return "";
            }
            return entry.getValue();
        }
    }
}
