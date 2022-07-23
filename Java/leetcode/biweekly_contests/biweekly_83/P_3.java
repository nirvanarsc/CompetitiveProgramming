package leetcode.biweekly_contests.biweekly_83;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

@SuppressWarnings({ "InnerClassMayBeStatic", "unused", "PublicConstructorInNonPublicClass" })
public class P_3 {

    class NumberContainers {

        Map<Integer, TreeSet<Integer>> map;
        Map<Integer, Integer> idx;

        public NumberContainers() {
            map = new HashMap<>();
            idx = new HashMap<>();
        }

        public void change(int index, int number) {
            final Integer v = idx.get(index);
            if (v != null) {
                map.get(v).remove(index);
            }
            map.computeIfAbsent(number, val -> new TreeSet<>()).add(index);
            idx.put(index, number);
        }

        public int find(int number) {
            final TreeSet<Integer> ts = map.get(number);
            return ts == null || ts.isEmpty() ? -1 : ts.first();
        }
    }
}
