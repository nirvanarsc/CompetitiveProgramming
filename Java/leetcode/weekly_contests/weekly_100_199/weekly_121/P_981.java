package leetcode.weekly_contests.weekly_100_199.weekly_121;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

@SuppressWarnings({ "InnerClassMayBeStatic", "unused", "PublicConstructorInNonPublicClass" })
public class P_981 {

    class TimeMap {
        Map<String, TreeMap<Integer, String>> map;

        public TimeMap() {
            map = new HashMap<>();
        }

        public void set(String key, String value, int timestamp) {
            map.computeIfAbsent(key, v -> new TreeMap<>()).put(timestamp, value);
        }

        public String get(String key, int timestamp) {
            final TreeMap<Integer, String> tm = map.getOrDefault(key, new TreeMap<>());
            final Map.Entry<Integer, String> entry = tm.floorEntry(timestamp);
            return entry == null ? "" : entry.getValue();
        }
    }
}
