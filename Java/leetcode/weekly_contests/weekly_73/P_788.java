package leetcode.weekly_contests.weekly_73;

import java.util.HashMap;
import java.util.Map;

public class P_788 {

    @SuppressWarnings("MethodParameterNamingConvention")
    public int rotatedDigits(int N) {
        final Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 0);
        map.put(1, 1);
        map.put(8, 8);
        map.put(2, 5);
        map.put(5, 2);
        map.put(6, 9);
        map.put(9, 6);
        int res = 0;
        for (int i = 1; i <= N; i++) {
            if (rotate(i, map)) {
                res++;
            }
        }
        return res;
    }

    private static boolean rotate(int num, Map<Integer, Integer> map) {
        final int compare = num;
        int res = 0;
        int mul = 10;
        while (num > 0) {
            if (!map.containsKey(num % 10)) {
                return false;
            }
            res += mul * map.get(num % 10);
            num /= 10;
            mul *= 10;
        }
        return res == compare;
    }
}
