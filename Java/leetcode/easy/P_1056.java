package leetcode.easy;

import java.util.HashMap;
import java.util.Map;

public class P_1056 {

    public boolean confusingNumber(int n) {
        final Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 0);
        map.put(1, 1);
        map.put(6, 9);
        map.put(8, 8);
        map.put(9, 6);
        int res = 0;
        int copy = n;
        while (copy != 0) {
            if (!map.containsKey(copy % 10) || res > Integer.MAX_VALUE / 10) {
                return false;
            }
            res = res * 10 + map.get(copy % 10);
            copy /= 10;
        }
        return n != res;
    }
}
