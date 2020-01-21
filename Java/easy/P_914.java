package easy;

import java.util.HashMap;
import java.util.Map;

public class P_914 {

    public boolean hasGroupsSizeX(int[] deck) {
        final Map<Integer, Integer> count = new HashMap<>();
        int res = 0;
        for (int i : deck) { count.merge(i, 1, Integer::sum); }
        for (int i : count.values()) { res = gcd(i, res); }
        return res > 1;
    }

    public int gcd(int a, int b) {
        return b > 0 ? gcd(b, a % b) : a;
    }
}
