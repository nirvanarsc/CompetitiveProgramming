package medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class P_380 {

    public static class RandomizedSet {
        List<Integer> nums;
        Map<Integer, Integer> map;
        Random r;

        public RandomizedSet() {
            nums = new ArrayList<>();
            map = new HashMap<>();
            r = new Random();
        }

        public boolean insert(int val) {
            if (map.containsKey(val)) {
                return false;
            }
            map.put(val, nums.size());
            nums.add(val);
            return true;
        }

        public boolean remove(int val) {
            if (!map.containsKey(val)) {
                return false;
            }
            final int currIdx = map.get(val);
            if (currIdx < nums.size() - 1) {
                final int last = nums.get(nums.size() - 1);
                nums.set(currIdx, last);
                map.put(last, currIdx);
            }
            map.remove(val);
            nums.remove(nums.size() - 1);
            return true;
        }

        public int getRandom() {
            return nums.get(r.nextInt(nums.size()));
        }
    }
}
