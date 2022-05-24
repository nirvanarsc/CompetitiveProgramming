package leetcode.weekly_contests.weekly_100_199.weekly_182;

import java.util.HashMap;
import java.util.Map;

public class P_1394 {

    public int findLucky(int[] arr) {
        final Map<Integer, Integer> map = new HashMap<>();
        for (int num : arr) {
            map.merge(num, 1, Integer::sum);
        }
        return map.entrySet()
                  .stream()
                  .filter(a -> a.getKey().equals(a.getValue()))
                  .min((a, b) -> a.getValue().equals(b.getValue())
                                 ? Integer.compare(b.getKey(), a.getKey())
                                 : Integer.compare(b.getValue(), a.getValue()))
                  .orElse(Map.entry(-1, -1))
                  .getKey();
    }
}
