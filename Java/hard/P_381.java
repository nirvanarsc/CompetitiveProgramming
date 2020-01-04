package hard;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;

public class P_381 {

    public static class RandomizedCollection {
        List<Integer> nums;
        Map<Integer, Set<Integer>> map;
        Random r;

        public RandomizedCollection() {
            nums = new ArrayList<>();
            map = new HashMap<>();
            r = new Random();
        }

        public boolean insert(int val) {
            if (!map.containsKey(val)) {
                map.put(val, new LinkedHashSet<>());
            }
            map.get(val).add(nums.size());
            nums.add(val);
            return true;
        }

        public boolean remove(int val) {
            if (!map.containsKey(val)) {
                return false;
            }
            final int currIdx = map.get(val).iterator().next();
            map.get(val).remove(currIdx);
            if (currIdx < nums.size() - 1) {
                final int last = nums.get(nums.size() - 1);
                nums.set(currIdx, last);
                map.get(last).remove(nums.size() - 1);
                map.get(last).add(currIdx);
            }
            nums.remove(nums.size() - 1);

            if (map.get(val).isEmpty()) { map.remove(val); }
            return true;
        }

        public int getRandom() {
            return nums.get(r.nextInt(nums.size()));
        }
    }
}
