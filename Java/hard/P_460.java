package hard;

import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;

@SuppressWarnings("unused")
public class P_460 {

    static class LFUCache {
        Map<Integer, Integer> vals;
        Map<Integer, Integer> freq;
        Map<Integer, LinkedHashSet<Integer>> lists;
        int cap;
        int min;

        LFUCache(int capacity) {
            cap = capacity;
            vals = new HashMap<>();
            freq = new HashMap<>();
            lists = new HashMap<>(Collections.singletonMap(1, new LinkedHashSet<>()));
        }

        public int get(int key) {
            if (!vals.containsKey(key)) {
                return -1;
            }
            final int count = freq.merge(key, 1, Integer::sum);
            lists.get(count - 1).remove(key);
            if (count - 1 == min && lists.get(count - 1).isEmpty()) {
                min++;
            }
            lists.computeIfAbsent(count, v -> new LinkedHashSet<>()).add(key);
            return vals.get(key);
        }

        public void put(int key, int value) {
            if (cap <= 0) {
                return;
            }
            if (vals.containsKey(key)) {
                vals.put(key, value);
                get(key);
                return;
            }
            if (vals.size() == cap) {
                final int evict = lists.get(min).iterator().next();
                vals.remove(evict);
                freq.remove(evict);
                lists.get(min).remove(evict);
            }
            vals.put(key, value);
            freq.put(key, 1);
            lists.get(1).add(key);
            min = 1;
        }
    }
}
