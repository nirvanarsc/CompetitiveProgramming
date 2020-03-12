package weekly_contests.weekly_104;

import java.util.HashMap;
import java.util.Map;

public class P_914 {

    public static int gcd(int a, int b) {
        return b > 0 ? gcd(b, a % b) : a;
    }

    public boolean hasGroupsSizeX(int[] deck) {
        final Map<Integer, Integer> map = new HashMap<>();
        int res = 0;
        for (int num : deck) {
            map.merge(num, 1, Integer::sum);
        }
        for (int count : map.values()) {
            res = gcd(res, count);
        }
        return res > 1;
    }
}
