package leetcode.weekly_contests.weekly_104;

import java.util.HashMap;
import java.util.Map;

public class P_914 {

    public int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
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
