package leetcode.easy;

import java.util.HashMap;
import java.util.Map;

@SuppressWarnings("unused")
public class P_170 {

    static class TwoSum {
        Map<Integer, Integer> map;

        TwoSum() {
            map = new HashMap<>();
        }

        public void add(int number) {
            map.merge(number, 1, Integer::sum);
        }

        public boolean find(int value) {
            for (int num : map.keySet()) {
                if (map.containsKey(value - num)) {
                    return map.get(value - num) > 1 || 2 * num != value;
                }
            }
            return false;
        }
    }
}
