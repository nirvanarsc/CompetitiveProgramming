package leetcode.weekly_contests.weekly_121;

import java.util.HashMap;
import java.util.Map;

public class P_982 {

    @SuppressWarnings("MethodParameterNamingConvention")
    public int countTriplets(int[] A) {
        int res = 0;
        final Map<Integer, Integer> map = new HashMap<>();
        for (int item : A) {
            for (int value : A) {
                map.merge(item & value, 1, Integer::sum);
            }
        }
        for (int value : A) {
            for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
                if ((value & entry.getKey()) == 0) {
                    res += entry.getValue();
                }
            }
        }
        return res;
    }
}
