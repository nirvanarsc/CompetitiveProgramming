package weekly_contests.weekly_175;

import java.util.HashMap;
import java.util.Map;

public class P_1346 {

    public boolean checkIfExist(int[] arr) {
        final Map<Integer, Integer> hashMap = new HashMap<>();
        for (int value : arr) {
            hashMap.merge(value, 1, Integer::sum);
        }
        for (int value : arr) {
            if (value == 0 && hashMap.get(0) >= 2) {
                return true;
            } else if (value != 0 && hashMap.containsKey(value * 2)) {
                return true;
            }
        }
        return false;
    }
}
