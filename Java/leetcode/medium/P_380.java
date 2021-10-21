package leetcode.medium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

@SuppressWarnings({ "InnerClassMayBeStatic", "unused", "PublicConstructorInNonPublicClass" })
public class P_380 {

    class RandomizedSet {
        List<Integer> list;
        Map<Integer, Integer> map;
        Random r;
        int idx;

        public RandomizedSet() {
            list = new ArrayList<>();
            map = new HashMap<>();
            r = new Random();
            idx = 0;
        }

        public boolean insert(int val) {
            if (map.containsKey(val)) {
                return false;
            }
            list.add(val);
            map.put(val, idx++);
            return true;
        }

        public boolean remove(int val) {
            final Integer prev = map.get(val);
            if (prev == null) {
                return false;
            }
            idx--;
            final int last = list.get(idx);
            Collections.swap(list, prev, idx);
            list.remove(idx);
            map.put(last, prev);
            map.remove(val);
            return true;
        }

        public int getRandom() {
            return list.get(r.nextInt(idx));
        }
    }
}
