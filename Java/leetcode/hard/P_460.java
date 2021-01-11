package leetcode.hard;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

@SuppressWarnings("unused")
public class P_460 {

    static class LFUCache {
        Map<Integer, Integer> cache = new HashMap<>();
        Map<Integer, Integer> freq1 = new HashMap<>();
        Map<Integer, Set<Integer>> freq2 = new HashMap<>();
        int cap;
        int min;

        LFUCache(int capacity) {
            cap = capacity;
        }

        public int get(int key) {
            if (cache.containsKey(key)) {
                final int oldFreq = freq1.merge(key, 1, Integer::sum) - 1;
                if (oldFreq > 0) {
                    freq2.get(oldFreq).remove(key);
                    if (freq2.get(oldFreq).isEmpty()) {
                        freq2.remove(oldFreq);
                        if (min == oldFreq) {
                            min = oldFreq + 1;
                        }
                    }
                }
                freq2.computeIfAbsent(oldFreq + 1, val -> new LinkedHashSet<>()).add(key);
            }
            return cache.getOrDefault(key, -1);
        }

        public void put(int key, int value) {
            if (cap == 0) {
                return;
            }
            if (cache.containsKey(key)) {
                get(key);
            } else {
                if (cache.size() == cap) {
                    final Iterator<Integer> iterator = freq2.get(min).iterator();
                    final int removeKey = iterator.next();
                    iterator.remove();
                    cache.remove(removeKey);
                    freq1.remove(removeKey);
                    if (freq2.get(min).isEmpty()) {
                        freq2.remove(min);
                    }
                }
                freq1.merge(key, 1, Integer::sum);
                freq2.computeIfAbsent(1, val -> new LinkedHashSet<>()).add(key);
                min = 1;
            }
            cache.put(key, value);
        }
    }
}
