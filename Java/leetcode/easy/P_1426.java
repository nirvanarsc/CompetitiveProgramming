package leetcode.easy;

import java.util.HashMap;
import java.util.Map;

public class P_1426 {
    public int countElements(int[] arr) {
        final Map<Integer, Integer> map = new HashMap<>();
        for (int num : arr) {
            map.merge(num, 1, Integer::sum);
        }
        int res = 0;
        for (Map.Entry<Integer, Integer> e : map.entrySet()) {
            if (map.containsKey(e.getKey() + 1)) {
                res += e.getValue();
            }
        }
        return res;
    }
}
