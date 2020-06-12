package medium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class P_380 {

    public static class RandomizedSet {
        List<Integer> list;
        Map<Integer, Integer> map;
        Random r;

        public RandomizedSet() {
            list = new ArrayList<>();
            map = new HashMap<>();
            r = new Random();
        }

        public boolean insert(int val) {
            if (map.containsKey(val)) {
                return false;
            }
            final int idx = list.size();
            list.add(val);
            map.put(val, idx);
            return true;
        }

        public boolean remove(int val) {
            if (!map.containsKey(val)) {
                return false;
            }
            final int idx = map.get(val);
            Collections.swap(list, idx, list.size() - 1);
            map.put(list.get(idx), idx);
            list.remove(list.size() - 1);
            map.remove(val);
            return true;
        }

        public int getRandom() {
            return list.get(r.nextInt(list.size()));
        }
    }
}
